package com.hotelbeds.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNCancelRS;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNConfirmResponse;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNRepriceResponse;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.hotelbeds.AvailabilityRQ;
import com.bonton.utility.hotelbeds.AvailabilityRS;
import com.bonton.utility.hotelbeds.BookingCancellationRS;
import com.bonton.utility.hotelbeds.BookingRQ;
import com.bonton.utility.hotelbeds.BookingRS;
import com.bonton.utility.hotelbeds.CheckRateRQ;
import com.bonton.utility.hotelbeds.CheckRateRS;
import com.bonton.utility.processor.XmlProcessor;
import com.hotelbeds.util.HBClient;
import com.hotelbeds.util.HBDBConnection;
import com.hotelbeds.util.HBProperties;
import com.hotelbeds.util.HBUtility;

/**
 * Helper class - contains static methods for request and response mapping methods.
 * @author Tirath
 * @see HBService
 */
public class HBServiceHelper {
	private static Logger logger = LoggerFactory.getLogger(HBServiceHelper.class);
	
	private static final ExecutorService hbEs = Executors.newCachedThreadPool();
	
	/* Holds unique uuid and generated request-response list as key-value */
	private static final Map<String, List<? super Object>> reqResMap = new HashMap<String, List<? super Object>>();
	
	/** Holds unique uuid and combination of noOfRooms~adults~children as key-value. 
	 * 	Done to display 'recommended' attribute as part of rate element in the response. 
	 *  Resulting list would be like the below format - 
	 *  1~1~0|1~2~1| 
	 **/
	private static final Map<String, String> rtRcmndMap = new HashMap<String, String>();
	
	private static final String DFLTHOLDVALUE = "0";
	
	/** To get the rate response sorted on the basis of board code */
	public static final Comparator<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate> rateListCmptr = 
			new Comparator<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate> () {

				@Override
				public int compare(BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate r1, 
						BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate r2) {
					String brdOne = r1.getMealCode();
					String brdTwo = r2.getMealCode();
					return brdOne.compareTo(brdTwo);
				}};

	
	private HBServiceHelper() {
		/* Shouldn't be instantiated */
	}
	
	/**
	 * Used to map Bonton hotel availability RQ object to HotelBeds API
	 * specific RQ object.
	 * @param btnSearchRq Bonton specific search RQ object
	 * @param uuid Unique idenfier used to map RQ objects with their RS's.
	 * @return HotelBeds specific RQ object
	 * @author Tirath
	 */
	public static AvailabilityRQ searchBeanRQMapper(BTNSearchRequest btnSearchRq, String uuid) {
		logger.info("hotelbeds search request mapping started ---->");
		
		/** Preparing request-response map */
		List<? super Object> rqRsLst = new ArrayList<Object>();
		rqRsLst.add(btnSearchRq);
		reqResMap.put(uuid, rqRsLst);
		
		AvailabilityRQ availabilityRQ = new AvailabilityRQ();
		
		BTNSearchRequest.RequestDetails.SearchHotelPriceRequest btnSearchHotelPriceRQ = btnSearchRq.getRequestDetails().getSearchHotelPriceRequest();
		/* To fetch the daily price break down */
		availabilityRQ.setDailyRate(btnSearchHotelPriceRQ.isIncludePriceBreakdown());
		
		if (btnSearchHotelPriceRQ.getItemDestination() != null) {
			AvailabilityRQ.Destination destination = new AvailabilityRQ.Destination();
			destination.setCode(btnSearchHotelPriceRQ.getItemDestination().getDestinationCode());
			//destination.setZone(searchBean.getRequestDetails().getSearchHotelPriceRequest().getItemDestination().getDestinationType());
			
			availabilityRQ.setDestination(destination);
		}

		AvailabilityRQ.Filter filter = new AvailabilityRQ.Filter();
		if (HBUtility.isNotNullOrEmpty(btnSearchHotelPriceRQ.getMinRate())) {
			filter.setMinRate(btnSearchHotelPriceRQ.getMinRate());
		}
		if (HBUtility.isNotNullOrEmpty(btnSearchHotelPriceRQ.getMaxRate())) {
			filter.setMaxRate(btnSearchHotelPriceRQ.getMaxRate());
		}
		if (HBUtility.isNotNullOrEmpty(btnSearchHotelPriceRQ.getMaxNoRates())) {
			filter.setMaxRatesPerRoom(btnSearchHotelPriceRQ.getMaxNoRates());
		}
		
		/** Changed to bring in symetry with Desia API */
		if (HBUtility.isNotNullOrEmpty(btnSearchHotelPriceRQ.getMinStarRating()) 
				&& HBUtility.isNotNullOrEmpty(btnSearchHotelPriceRQ.getMaxStarRating())) {
			filter.setMinCategory(btnSearchHotelPriceRQ.getMinStarRating());
			filter.setMaxCategory(btnSearchHotelPriceRQ.getMaxStarRating());
		} else {
			if (HBUtility.isNotNullOrEmpty(btnSearchHotelPriceRQ.getMinStarRating())) {
				filter.setMinCategory(btnSearchHotelPriceRQ.getMinStarRating());
				filter.setMaxCategory(btnSearchHotelPriceRQ.getMinStarRating());
			} else if (HBUtility.isNotNullOrEmpty(btnSearchHotelPriceRQ.getMaxStarRating())) {
				filter.setMinCategory(btnSearchHotelPriceRQ.getMaxStarRating());
				filter.setMaxCategory(btnSearchHotelPriceRQ.getMaxStarRating());
			}
		}
		
		filter.setPackaging(btnSearchHotelPriceRQ.isPackaging());
		filter.setPaymentType(btnSearchHotelPriceRQ.getPaymentType());

		availabilityRQ.setFilter(filter);

		AvailabilityRQ.Stay stay = new AvailabilityRQ.Stay();
		stay.setCheckIn(btnSearchHotelPriceRQ.getPeriodOfStay().getCheckInDate());
		stay.setCheckOut(btnSearchHotelPriceRQ.getPeriodOfStay().getCheckOutDate());

		availabilityRQ.setStay(stay);

		List<BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room> roomLst = btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getRooms().getRoom();
		
		AvailabilityRQ.Occupancies resOccupancies = new AvailabilityRQ.Occupancies(); 
		availabilityRQ.setOccupancies(resOccupancies);
		
		List<AvailabilityRQ.Occupancies.Occupancy> resOccupancyLst = availabilityRQ.getOccupancies().getOccupancy();
		
		StringBuilder sb = new StringBuilder();
		for (BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room room : roomLst) {
			sb = sb.append(room.getNoOfRooms())
					.append(HBProperties.SEP1)
					.append(room.getAdults())
					.append(HBProperties.SEP1)
					.append(room.getChildren())
					.append(HBProperties.SEP2);
			
			AvailabilityRQ.Occupancies.Occupancy resOccupancy = new AvailabilityRQ.Occupancies.Occupancy();
			resOccupancy.setRooms(room.getNoOfRooms());
			resOccupancy.setAdults(room.getAdults());
			resOccupancy.setChildren(room.getChildren());
			
			AvailabilityRQ.Occupancies.Occupancy.Paxes resPaxes = new AvailabilityRQ.Occupancies.Occupancy.Paxes();
			resOccupancy.setPaxes(resPaxes);
			
			List<AvailabilityRQ.Occupancies.Occupancy.Paxes.Pax> resPaxLst = resOccupancy.getPaxes().getPax();
			List<BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room.Occupant> occupantLst = room.getOccupant();
			for (BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room.Occupant occupant : occupantLst) {
				AvailabilityRQ.Occupancies.Occupancy.Paxes.Pax resPax = new AvailabilityRQ.Occupancies.Occupancy.Paxes.Pax();
				resPax.setType(occupant.getType());
				resPax.setAge(occupant.getAge());
				resPax.setName(occupant.getName());
				resPax.setSurname(occupant.getSurname());
				
				resPaxLst.add(resPax);
			}
			
			resOccupancyLst.add(resOccupancy);
		}
		/** For hotel code specific search */
		if (btnSearchHotelPriceRQ.getHotels() != null) {
			List<String> hotelCdLst = btnSearchHotelPriceRQ.getHotels().getHotel();
			AvailabilityRQ.Hotels resHotels = new AvailabilityRQ.Hotels();
			List<String> resHotelLst = resHotels.getHotel();
			for (String hotelCd : hotelCdLst) {
				resHotelLst.add(hotelCd);
			}
			
			availabilityRQ.setHotels(resHotels);
		}
		
		rtRcmndMap.put(uuid, sb.toString());
		rqRsLst.add(availabilityRQ);
		
		logger.info("hotelbeds search request mapping done ---->");
		return availabilityRQ;
	}
	
	/**
	 * Used to map the Hotel beds availability response to Bonton response.
	 * @param availabilityRS Hotel availability RS object returned by HotelBeds API
	 * @param uuid Unique idenfier used to map RQ objects with their RS's.
	 * @return BTNSearchResponse Bonton specific RS object after mapping
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static BTNSearchResponse searchBeanRSMapper(AvailabilityRS availabilityRS, String uuid) throws Exception {
		logger.info("hotelbeds search response mapping started ---->");
		
		/** Adding HB availability response for logging */
		reqResMap.get(uuid).add(availabilityRS);
		
		BTNSearchResponse btnSearchRS = new BTNSearchResponse();

		if (availabilityRS.getError() != null) {
			BTNSearchResponse.BTNError errElmnt = new BTNSearchResponse.BTNError();
			errElmnt.setCode(availabilityRS.getError().getCode());
			errElmnt.setMessage(availabilityRS.getError().getMessage());

			btnSearchRS.setBTNError(errElmnt);
			
			/** Adding HB availability response for logging */
			reqResMap.get(uuid).add(btnSearchRS);
			
			logger.info("hotelbeds search response mapping done ---->");
			return btnSearchRS;
		}

		/** Fetch the searched rooms~adults~children combination */
		String tempComb = rtRcmndMap.get(uuid);
		tempComb = tempComb.substring(0, tempComb.length() - 1);
		String[] keySetArray = tempComb.split(HBProperties.SPLIT);
		int noOfRooms = keySetArray.length;
		Set<String> keySet = new HashSet<String>(Arrays.asList(keySetArray));
		
		/** do the appropriate mapping*/
		btnSearchRS.setTravelRequestID(HBProperties.EMPTY);
		btnSearchRS.setServiceRequestID(HBProperties.EMPTY);

		btnSearchRS.setOptionsCount(availabilityRS.getHotels().getTotal());

		boolean onlyOnce = true;
		
		btnSearchRS.setHotelOptions(new  BTNSearchResponse.HotelOptions());

		List<BTNSearchResponse.HotelOptions.Hotel> btnHotelLst = btnSearchRS.getHotelOptions().getHotel();
		List<AvailabilityRS.Hotels.Hotel> otaHotelLst = availabilityRS.getHotels().getHotel();

		for (AvailabilityRS.Hotels.Hotel otaHotel : otaHotelLst) {
			boolean addHotel = false;
			BTNSearchResponse.HotelOptions.Hotel btnHotel = new BTNSearchResponse.HotelOptions.Hotel();
			btnHotel.setHotelCode(otaHotel.getCode());
			btnHotel.setHotelName(otaHotel.getName());
			btnHotel.setSupplier(HBProperties.HB);
			btnHotel.setStarRating(otaHotel.getCategoryName());
			btnHotel.setLatitude(otaHotel.getLatitude() == null? 0f: otaHotel.getLatitude());
			btnHotel.setLongitude(otaHotel.getLongitude() == null? 0f: otaHotel.getLongitude());
			btnHotel.setFullAddress(otaHotel.getAddress() == null? HBProperties.EMPTY: otaHotel.getAddress());
			btnHotel.setCurrency(otaHotel.getCurrency());

			/** As this is common for all the hotels */
			if (onlyOnce) {
				BTNSearchResponse.City btnCity = new BTNSearchResponse.City();
				btnCity.setCityCode(otaHotel.getDestinationCode());
				btnCity.setCityName(otaHotel.getDestinationName());
				btnSearchRS.setCity(btnCity);
				onlyOnce = false;
			}
			
			btnHotel.setRoomOptions(new BTNSearchResponse.HotelOptions.Hotel.RoomOptions());

			List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room> btnRoomLst = btnHotel.getRoomOptions().getRoom();
			List<AvailabilityRS.Hotels.Hotel.Rooms.Room> otaRoomLst = otaHotel.getRooms().getRoom();

			for (AvailabilityRS.Hotels.Hotel.Rooms.Room otaRoom : otaRoomLst) {
				Map<String, List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate>> btnBrdRateMap = 
						new HashMap<String, List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate>>();

				List<AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate> otaRateLst = otaRoom.getRates().getRate();
				
				/** Added to not display the rooms for which the searched pax combination 
				 * doesn't match the combinations mentioned in rate keys. 
				 * Works in combination with resKeySet. Added to get rid of straight cases. */
				if (otaRateLst.size() < noOfRooms) {
					continue;
				}
				
				/** 
				 * Flag to help us - whether to display a rate or not and if not 
				 * "Bookable" rates are available then skipping the room. 
				 **/
				boolean isBookable = false;
				
				Set<String> resKeySet = new HashSet<String>();
				for (AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate otaRate : otaRateLst) {
					if (!otaRate.getRateType().equalsIgnoreCase(HBProperties.RATE_TYPE)) {
						/** Skipping rate entry as rateType is not BOOKABLE. Other possibility is RECHECK */
						continue;
					}
					isBookable = true; addHotel = true;
					BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate btnRate = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate();
					btnRate.setAdults(otaRate.getAdults());
					btnRate.setChildren(otaRate.getChildren());
					btnRate.setChildrenAges(otaRate.getChildrenAges());
					
					StringBuilder tempBffr = new StringBuilder()
							.append(otaRate.getRooms()).append(HBProperties.SEP1)
							.append(otaRate.getAdults()).append(HBProperties.SEP1)
							.append(otaRate.getChildren());
					
					resKeySet.add(tempBffr.toString());
					/** Decided not to use it but keep it.
					if (keySet.contains(tempBffr.toString())) {
						/** Set the recommended tag. Not required now but exists if needed later. *
						resRate.setRecommended(HBProperties.REC);
					}
					 */
					btnRate.setHoldValue(DFLTHOLDVALUE);
					
					btnRate.setRateKey(otaRate.getRateKey());
					btnRate.setPackaging(otaRate.getPackaging());
					btnRate.setMealType(otaRate.getBoardName());
					
					/** 
					 * Meal code contains board code. Should not be changed. Otherwise breaks the rate list
					 * sorting logic. Change the rateListCmptr comparator logic if it must change. 
					 **/
					btnRate.setMealCode(otaRate.getBoardCode());

					btnRate.setSupplierPrice(otaRate.getNet());
					btnRate.setOtaFee(0.0f);
					btnRate.setOtaDiscountAmount(0.0f);

					if (otaRate.getCancellationPolicies() != null) {
						btnRate.setCancellationPolicies(new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.CancellationPolicies());
						List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.CancellationPolicies.CancellationPolicy> btnCancPlcyLst = 
								btnRate.getCancellationPolicies().getCancellationPolicy();
						
						List<AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy> otaCancPlcyLst = 
								otaRate.getCancellationPolicies().getCancellationPolicy();
						
						for (AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy otaCancPlcy : otaCancPlcyLst) {
							BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.CancellationPolicies.CancellationPolicy resCancPlcy = 
									new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.CancellationPolicies.CancellationPolicy();

							resCancPlcy.setAmount(otaCancPlcy.getAmount());
							resCancPlcy.setFrom(otaCancPlcy.getFrom());

							btnCancPlcyLst.add(resCancPlcy);
						}
					}
					
					if (otaRate.getDailyRates() != null) {
						btnRate.setDailyRates(new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates());
						List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate> btnDailyRateLst = btnRate.getDailyRates().getDailyRate();
						List<AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate.DailyRates.DailyRate> otaDailyRateLst = otaRate.getDailyRates().getDailyRate();
						
						for (AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate.DailyRates.DailyRate dailyRate : otaDailyRateLst) {
							BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate btnDailyRate = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate();
							btnDailyRate.setOffset(dailyRate.getOffset());
							btnDailyRate.setDailyNet(dailyRate.getDailyNet());

							/* adding to the daily rate list */
							btnDailyRateLst.add(btnDailyRate);
						}
					}
					
					
					if (btnBrdRateMap.containsKey(otaRate.getBoardCode())) {
						btnBrdRateMap.get(otaRate.getBoardCode()).add(btnRate);
					} else {
						List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate> tmpRateLst = 
								new ArrayList<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate>();
						tmpRateLst.add(btnRate);
						btnBrdRateMap.put(otaRate.getBoardCode(), tmpRateLst);
					}
				}
				
				/** Add room to the room list only if atleast one returned rate 
				 * key is of type HBProperties.RATE_TYPE. 
				 * Second condition is to allow the room node only if it has 
				 * the requested or searched for pax combination. 
				 * for ex - if the search is for 1~1~0 and 1~1~1 then the the rate list 
				 * of the room must have atleast two rate keys for this pax combination
				 * in order for this room to be returned in the response. */
				addHotel = resKeySet.containsAll(keySet);
				if (isBookable && addHotel) {
					/* Sorted rate list */
//					Collections.sort(resRateLst, rateListCmptr);
					
					Set<String> tmpBrdSet = btnBrdRateMap.keySet();
					Iterator<String> tmpBrdSetItr = tmpBrdSet.iterator();
					while (tmpBrdSetItr.hasNext()) {
						String nxtBrdCode = tmpBrdSetItr.next();
						BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room btnRoom = 
								new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room();
						btnRoom.setRoomType(otaRoom.getName());
						btnRoom.setSupplier(HBProperties.HB);
						btnRoom.setMealCode(nxtBrdCode);
						
						btnRoom.getRate().addAll(btnBrdRateMap.get(nxtBrdCode));
						btnRoomLst.add(btnRoom);
					}
				}
			}
			if (addHotel) {
				btnHotelLst.add(btnHotel);
			}
		}
		/** Adding HB availability response for logging */
		reqResMap.get(uuid).add(btnSearchRS);
		
		logger.info("hotelbeds search response mapping done ---->");
		return btnSearchRS;
	}
	
	/**
	 * Used to map Bonton booking confirmation RQ object to HotelBeds
	 * specific booking confirmation RQ object.
	 * @param btnbookingRq Bonton booking confirmation RQ object
	 * @param uuid Unique idenfier used to map RQ objects with their RS's.
	 * @return HotelBeds specific booking confirmation RQ object
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static BookingRQ confirmBeanRQMapper(BTNConfirmRequest btnbookingRq, String uuid) throws Exception {
		logger.info("hotelbeds confirm request mapping started ---->");
		
		/** Preparing request-response map */
		List<? super Object> rqRsLst = new ArrayList<Object>();
		rqRsLst.add(btnbookingRq);
		reqResMap.put(uuid, rqRsLst);

		BookingRQ bookingRQ = new BookingRQ();

		BookingRQ.Holder holder = new BookingRQ.Holder();		
		holder.setName(btnbookingRq.getPrinciplePax().getName());
		holder.setSurname(btnbookingRq.getPrinciplePax().getSurname());
		bookingRQ.setHolder(holder);
		
		BookingRQ.Rooms resRooms = new BookingRQ.Rooms();
		
		List<BookingRQ.Rooms.Room> resRoomlst = resRooms.getRoom();
		List<BTNConfirmRequest.Rooms.Room> roomLst = btnbookingRq.getRooms().getRoom();		
		for (BTNConfirmRequest.Rooms.Room room : roomLst) {
			BookingRQ.Rooms.Room resRoom = new BookingRQ.Rooms.Room();
			BookingRQ.Rooms.Room.Paxes resPaxes = new BookingRQ.Rooms.Room.Paxes();
			
			resRoom.setRateKey(room.getUniqueKey());
			resRoom.setPaxes(resPaxes);
			List<BookingRQ.Rooms.Room.Paxes.Pax> resPaxLst = resPaxes.getPax();

			List<BTNConfirmRequest.Rooms.Room.Paxes.Pax> paxLst = room.getPaxes().getPax();
			for (BTNConfirmRequest.Rooms.Room.Paxes.Pax pax : paxLst){
				BookingRQ.Rooms.Room.Paxes.Pax resPax = new BookingRQ.Rooms.Room.Paxes.Pax();
				resPax.setRoomId(new Integer(pax.getRoomId()).intValue());
				resPax.setName(pax.getName());
				resPax.setSurname(pax.getSurname());
				resPax.setType(pax.getType());
				resPax.setAge(pax.getAge());

				resPaxLst.add(resPax);

			}
			resRoom.setPaxes(resPaxes);
			resRoomlst.add(resRoom);
		}
		bookingRQ.setRooms(resRooms);
		
		BookingRQ.PaymentData paymentdata = new BookingRQ.PaymentData();		
		BookingRQ.PaymentData.PaymentCard paymentcard = new BookingRQ.PaymentData.PaymentCard();
		//paymentcard.setCardNumber(value);
		//paymentcard.setCardCVC(value));
		//paymentcard.setCardType(value);
		//paymentcard.setExpiryDate(value);
		paymentdata.setPaymentCard(paymentcard);
				
		BookingRQ.PaymentData.ContactData contactdata = new BookingRQ.PaymentData.ContactData();
		contactdata.setEmail(btnbookingRq.getContactData().getEmail());
		//TODO: change this later
		contactdata.setPhoneNumber(btnbookingRq.getContactData().getPhoneNumber() + HBProperties.EMPTY);
		paymentdata.setContactData(contactdata);
		
//		bookingRQ.setPaymentData(paymentdata);
		
		bookingRQ.setClientReference(btnbookingRq.getClientReference());
		
		rqRsLst.add(bookingRQ);
		
		logger.info("hotelbeds confirm request mapping done ---->");
		return bookingRQ;
	}
	
	/**
	 * Used to map HotelBeds specific booking RS to Bonton specific 
	 * booking confirmation RS object.
	 * @param bookingRS HotelBeds booking confirmation RS object
	 * @param uuid Unique idenfier used to map RQ objects with their RS's.
	 * @return Booking confirmation RS object specific to Bonton API
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static BTNConfirmResponse confirmBeanRSMapper(BookingRS bookingRS, String uuid) throws Exception {
		logger.info("hotelbeds confirm response mapping started ---->");
		
		/** Adding HB confirm response for logging */
		reqResMap.get(uuid).add(bookingRS);
		
		BTNConfirmResponse btnConfirmRS = new BTNConfirmResponse();
		
		if (bookingRS.getError() != null) {
			BTNConfirmResponse.BTNError errElmnt = new BTNConfirmResponse.BTNError();
			errElmnt.setCode(bookingRS.getError().getCode());
			errElmnt.setMessage(bookingRS.getError().getMessage());
			
			btnConfirmRS.setBTNError(errElmnt);
			
			/** Adding Bonton confirm response for logging */
			reqResMap.get(uuid).add(btnConfirmRS);
			
			logger.info("hotelbeds confirm response mapping done ---->");
			return btnConfirmRS;
		}
		
		BTNConfirmResponse.Booking btnBooking = new BTNConfirmResponse.Booking();
		
		btnBooking.setModificationPolicies(new BTNConfirmResponse.Booking.ModificationPolicies());
		btnBooking.getModificationPolicies().setCancellation(bookingRS.getBooking().getModificationPolicies().getCancellation());
		btnBooking.getModificationPolicies().setModification(bookingRS.getBooking().getModificationPolicies().getModification());
		
		btnBooking.setPrinciplePax(new BTNConfirmResponse.Booking.PrinciplePax());
		btnBooking.getPrinciplePax().setName(bookingRS.getBooking().getHolder().getName());
		btnBooking.getPrinciplePax().setSurname(bookingRS.getBooking().getHolder().getSurname());
		
		btnBooking.setReference(bookingRS.getBooking().getReference());
		btnBooking.setClientReference(bookingRS.getBooking().getClientReference());
		btnBooking.setCreationDate(bookingRS.getBooking().getCreationDate());
		btnBooking.setTotalSellingRate(bookingRS.getBooking().getTotalNet());
		btnBooking.setStatus(bookingRS.getBooking().getRemark());
		
		BTNConfirmResponse.Booking.Hotel btnHotel = new BTNConfirmResponse.Booking.Hotel();
		BookingRS.Booking.Hotel otaHotel = bookingRS.getBooking().getHotel();
		btnHotel.setCheckIn(otaHotel.getCheckIn());
		btnHotel.setCheckOut(otaHotel.getCheckOut());
		btnHotel.setCode(otaHotel.getCode().toString());
		btnHotel.setName(otaHotel.getName());
		btnHotel.setCatCode(otaHotel.getCategoryCode());
		btnHotel.setCatName(otaHotel.getCategoryName());
		btnHotel.setDestCode(otaHotel.getDestinationCode());
		btnHotel.setDestName(otaHotel.getDestinationName());
		
		btnHotel.setSupplierdetails(new BTNConfirmResponse.Booking.Hotel.Supplierdetails());
		btnHotel.getSupplierdetails().setName(HBProperties.HB);
		btnHotel.getSupplierdetails().setVatNumber(otaHotel.getSupplier().getVatNumber());
		
		btnBooking.setHotel(btnHotel);
		
		List<BookingRS.Booking.Hotel.Rooms.Room> otaRoomLst = otaHotel.getRooms().getRoom();
		List<BTNConfirmResponse.Booking.Hotel.Rooms.Room> btnRoomLst = null;
		
		if (!otaRoomLst.isEmpty()) {
			btnHotel.setRooms(new BTNConfirmResponse.Booking.Hotel.Rooms());
			btnRoomLst = btnHotel.getRooms().getRoom();
		}
		
		int roomCount = otaRoomLst.size();
		int adultCount = 0, totalOccupant = 0;
		for (BookingRS.Booking.Hotel.Rooms.Room otaRoom : otaRoomLst) {
			BTNConfirmResponse.Booking.Hotel.Rooms.Room btnRoom = new BTNConfirmResponse.Booking.Hotel.Rooms.Room();
			
			List<BookingRS.Booking.Hotel.Rooms.Room.Paxes.Pax> otaPaxLst = otaRoom.getPaxes().getPax();
			List<BTNConfirmResponse.Booking.Hotel.Rooms.Room.Paxes.Pax> btnPaxLst = null;
			
			if (!otaPaxLst.isEmpty()) {
				btnRoom.setPaxes(new BTNConfirmResponse.Booking.Hotel.Rooms.Room.Paxes());
				btnPaxLst = btnRoom.getPaxes().getPax();
			}
			
			totalOccupant = otaPaxLst.size();
			for (BookingRS.Booking.Hotel.Rooms.Room.Paxes.Pax otaPax : otaPaxLst) {
				BTNConfirmResponse.Booking.Hotel.Rooms.Room.Paxes.Pax btnPax = new BTNConfirmResponse.Booking.Hotel.Rooms.Room.Paxes.Pax();
				btnPax.setAge(otaPax.getAge());
				btnPax.setName(otaPax.getName());
				btnPax.setRoomId(otaPax.getRoomId());
				btnPax.setSurname(otaPax.getSurname());
				btnPax.setType(otaPax.getType());
				btnPax.setValue(otaPax.getValue());
				
				if (HBProperties.ADULTCD.equals(otaPax.getType()))
					adultCount++;
				
				btnPaxLst.add(btnPax);
			}
			
			btnRoom.setRates(new BTNConfirmResponse.Booking.Hotel.Rooms.Room.Rates());
			BTNConfirmResponse.Booking.Hotel.Rooms.Room.Rates.Rate btnRate = new BTNConfirmResponse.Booking.Hotel.Rooms.Room.Rates.Rate(); 
			BookingRS.Booking.Hotel.Rooms.Room.Rates.Rate otaRate = otaRoom.getRates().getRate();
			
			btnRate.setNetRate(otaRate.getNet());
			btnRate.setPackaging(otaRate.getPackaging());
			btnRate.setRateType(otaRate.getRateClass());
			btnRate.setRateComments(otaRate.getRateComments());
			btnRate.setRoomCount(roomCount);
			btnRate.setAdultCount(adultCount);
			btnRate.setChildCount(totalOccupant - adultCount);
			
			btnRoom.getRates().setRate(btnRate);
			
			btnRate.setCancellationPolicies(new BTNConfirmResponse.Booking.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies());
			BTNConfirmResponse.Booking.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy btnCancPlcy = 
					new BTNConfirmResponse.Booking.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy();
			
			btnCancPlcy.setAmount(otaRate.getCancellationPolicies().getCancellationPolicy().getAmount());
			btnCancPlcy.setFrom(otaRate.getCancellationPolicies().getCancellationPolicy().getFrom().toString());
			btnCancPlcy.setValue(otaRate.getCancellationPolicies().getCancellationPolicy().getValue());
			
			btnRate.getCancellationPolicies().setCancellationPolicy(btnCancPlcy);
			
			
			btnRoomLst.add(btnRoom);
		}
		btnConfirmRS.setBooking(btnBooking);
		
		/** Adding Bonton confirm response for logging */
		reqResMap.get(uuid).add(btnConfirmRS);
		
		logger.info("hotelbeds confirm response mapping done ---->");
		return btnConfirmRS;
	}
	
	/**
	 * Used to map Bonton booking cancellation RQ object to HotelBeds
	 * specific RQ object.
	 * @param btnCancelRQ Bonton cancellation RQ object
	 * @param uuid Unique idenfier used to map RQ objects with their RS's.
	 * @return Booking cancellation RS object specific to HotelBeds API
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static BookingCancellationRS cancelBeanRQMapper(BTNCancelRQ btnCancelRQ, String uuid) throws Exception {
		logger.info("hotelbeds cancel request mapping started ---->");
		
		/** Preparing request-response map */
		List<? super Object> rqRsLst = new ArrayList<Object>();
		rqRsLst.add(btnCancelRQ);
		reqResMap.put(uuid, rqRsLst);

		/** Adding null as cancel request is send using HTTP DELETE, 
		 * 	so there is no HotelBeds request XML */
		rqRsLst.add(null);
		
		logger.info("hotelbeds cancel request mapping done ---->");
		return HBClient.postCancelBooking(btnCancelRQ);
	}
	
	/**
	 * Used to map the HotelBeds booking cancellation RS to Bonton
	 * specific cancellation RS object.
	 * @param cancelRS Cancellation RS object returned by HotelBeds API
	 * @param uuid Unique idenfier used to map RQ objects with their RS's.
	 * @return Cancellation RS object specific to Bonton API
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static BTNCancelRS cancelBeanRSMapper(BookingCancellationRS cancelRS, String uuid) throws Exception {
		logger.info("hotelbeds cancel response mapping started ---->");
		
		/** Adding HB cancel response for logging */
		reqResMap.get(uuid).add(cancelRS);
		
		BTNCancelRS btnCancelRS = new BTNCancelRS();
		
		if (cancelRS.getError() != null) {
			BTNCancelRS.BTNError errElmnt = new BTNCancelRS.BTNError();
			errElmnt.setCode(cancelRS.getError().getCode());
			errElmnt.setMessage(cancelRS.getError().getMessage());
			
			btnCancelRS.setBTNError(errElmnt);
			
			/** Adding Bonton cancel response for logging */
			reqResMap.get(uuid).add(btnCancelRS);
			
			logger.info("hotelbeds cancel response mapping done ---->");
			return btnCancelRS;
		}
		
		BookingCancellationRS.Booking otaBooking = cancelRS.getBooking();
		BTNCancelRS.Booking btnBooking = new BTNCancelRS.Booking();
		
		btnBooking.setModificationPolicies(new BTNCancelRS.Booking.ModificationPolicies());
		btnBooking.getModificationPolicies().setCancellation(otaBooking.getModificationPolicies().getCancellation());
		btnBooking.getModificationPolicies().setModification(otaBooking.getModificationPolicies().getModification());
		
		btnBooking.setPrinciplePax(new BTNCancelRS.Booking.PrinciplePax());
		btnBooking.getPrinciplePax().setName(otaBooking.getHolder().getName());
		btnBooking.getPrinciplePax().setSurname(otaBooking.getHolder().getSurname());
		
		btnBooking.setReference(otaBooking.getReference());
		btnBooking.setClientReference(otaBooking.getClientReference());
		btnBooking.setCreationDate(otaBooking.getCreationDate());
		btnBooking.setTotalSellingRate(otaBooking.getTotalNet());
		btnBooking.setStatus(otaBooking.getRemark());
		btnBooking.setCancellationReference(otaBooking.getCancellationReference());
		
		BookingCancellationRS.Booking.Hotel otaHotel = otaBooking.getHotel();
		BTNCancelRS.Booking.Hotel btnHotel = new BTNCancelRS.Booking.Hotel();
		btnHotel.setCheckIn(otaHotel.getCheckIn());
		btnHotel.setCheckOut(otaHotel.getCheckOut());
		btnHotel.setCode(otaHotel.getCode().toString());
		btnHotel.setName(otaHotel.getName());
		btnHotel.setCatCode(otaHotel.getCategoryCode());
		btnHotel.setCatName(otaHotel.getCategoryName());
		btnHotel.setDestCode(otaHotel.getDestinationCode());
		btnHotel.setDestName(otaHotel.getDestinationName());
		btnHotel.setCancellationAmount(otaHotel.getCancellationAmount());
		
		btnHotel.setSupplierdetails(new BTNCancelRS.Booking.Hotel.Supplierdetails()); 
		btnHotel.getSupplierdetails().setName(HBProperties.HB);
		btnHotel.getSupplierdetails().setVatNumber(otaHotel.getSupplier().getVatNumber());
		
		btnBooking.setHotel(btnHotel);
		
		List<BookingCancellationRS.Booking.Hotel.Rooms.Room> otaRoomLst = otaHotel.getRooms().getRoom();
		List<BTNCancelRS.Booking.Hotel.Rooms.Room> btnRoomLst = null;
		
		if (!otaRoomLst.isEmpty()) {
			btnHotel.setRooms(new BTNCancelRS.Booking.Hotel.Rooms());
			btnRoomLst = btnHotel.getRooms().getRoom();
		}
		
		int roomCount = otaRoomLst.size();
		int adultCount = 0, totalOccupant = 0;
		for (BookingCancellationRS.Booking.Hotel.Rooms.Room otaRoom : otaRoomLst) {
			BTNCancelRS.Booking.Hotel.Rooms.Room btnRoom = new BTNCancelRS.Booking.Hotel.Rooms.Room();
			List<BookingCancellationRS.Booking.Hotel.Rooms.Room.Paxes.Pax> otaPaxLst = otaRoom.getPaxes().getPax();
			List<BTNCancelRS.Booking.Hotel.Rooms.Room.Paxes.Pax> btnPaxLst = null;
			
			if (!otaPaxLst.isEmpty()) {
				btnRoom.setPaxes(new BTNCancelRS.Booking.Hotel.Rooms.Room.Paxes());
				btnPaxLst = btnRoom.getPaxes().getPax();
			}
			
			totalOccupant = otaPaxLst.size();
			for (BookingCancellationRS.Booking.Hotel.Rooms.Room.Paxes.Pax otaPax : otaPaxLst) {
				BTNCancelRS.Booking.Hotel.Rooms.Room.Paxes.Pax btnPax = new BTNCancelRS.Booking.Hotel.Rooms.Room.Paxes.Pax();
				btnPax.setAge(otaPax.getAge());
				btnPax.setName(otaPax.getName());
				btnPax.setRoomId(otaPax.getRoomId());
				btnPax.setSurname(otaPax.getSurname());
				btnPax.setType(otaPax.getType());
				btnPax.setValue(otaPax.getValue());
				
				if (HBProperties.ADULTCD.equals(otaPax.getType()))
					adultCount++;
				
				btnPaxLst.add(btnPax);
			}
			btnRoom.setRates(new BTNCancelRS.Booking.Hotel.Rooms.Room.Rates());
			BookingCancellationRS.Booking.Hotel.Rooms.Room.Rates.Rate rate = otaRoom.getRates().getRate();
			BTNCancelRS.Booking.Hotel.Rooms.Room.Rates.Rate btnRate = new BTNCancelRS.Booking.Hotel.Rooms.Room.Rates.Rate();
			btnRate.setNetRate(rate.getNet());
			btnRate.setPackaging(rate.getPackaging());
			btnRate.setRateType(rate.getRateClass());
			btnRate.setRoomCount(roomCount);
			btnRate.setAdultCount(adultCount);
			btnRate.setChildCount(totalOccupant - adultCount);
			
			btnRoom.getRates().setRate(btnRate);
			btnRoom.setStatus(otaRoom.getStatus());
			btnRoom.setCode(otaRoom.getCode());
			btnRoom.setId(otaRoom.getId());
			btnRoom.setName(otaRoom.getName());
			
			btnRoomLst.add(btnRoom);
		}
		btnCancelRS.setBooking(btnBooking);
		
		/** Adding Bonton cancel response for logging */
		reqResMap.get(uuid).add(btnCancelRS);
		
		logger.info("hotelbeds cancel response mapping done ---->");
		return btnCancelRS;
	}
	
	/**
	 * Used to map Bonton reprice RQ to HotelBeds specific reprice RQ.
	 * @param btnRepriceRQ Reprice RQ send by Bonton API
	 * @param uuid Unique identifier
	 * @return CheckRateRS which is used to prepare Bonton specific reprice RS.
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static CheckRateRS repriceBeanRQMapper(BTNRepriceRequest btnRepriceRQ, String uuid) throws Exception {
		logger.info("hotelbeds reprice request mapping started ---->");
		
		/** Preparing request-response map */
		List<? super Object> rqRsLst = new ArrayList<Object>();
		rqRsLst.add(btnRepriceRQ);
		reqResMap.put(uuid, rqRsLst);

		CheckRateRQ checkRateRQ = new CheckRateRQ();
		CheckRateRQ.Rooms resRooms = new CheckRateRQ.Rooms();
		List<CheckRateRQ.Rooms.Room> resRoomLst = resRooms.getRoom();
		
		List<BTNRepriceRequest.Rooms.Room> roomLst = btnRepriceRQ.getRooms().getRoom();
		for (BTNRepriceRequest.Rooms.Room room : roomLst) {
			CheckRateRQ.Rooms.Room resRoom = new CheckRateRQ.Rooms.Room();
			resRoom.setRateKey(room.getUniqueKey());
			
			resRoomLst.add(resRoom);
		}
		checkRateRQ.setRooms(resRooms);
		
		rqRsLst.add(checkRateRQ);
		
		logger.info("hotelbeds reprice request mapping done ---->");
		return HBClient.postRepricing(checkRateRQ);
	}	
	
	/**
	 * Used to map HotelBeds reprice RS to Bonton specific reprice RS.
	 * @param checkRateRS HotelBeds reprice RS object
	 * @param uuid Unique identifier
	 * @return Bonton specific reprice RS object
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static BTNRepriceResponse repriceBeanRSMapper(CheckRateRS checkRateRS, String uuid) throws Exception {
		logger.info("hotelbeds reprice response mapping started ---->");
		
		/** Adding HB reprice response for logging */
		reqResMap.get(uuid).add(checkRateRS);
		
		BTNRepriceResponse btnRepriceRS = new BTNRepriceResponse();

		if (checkRateRS.getError() != null) {
			BTNRepriceResponse.BTNError errElmnt = new BTNRepriceResponse.BTNError();
			errElmnt.setCode(checkRateRS.getError().getCode());
			errElmnt.setMessage(checkRateRS.getError().getMessage());

			btnRepriceRS.setBTNError(errElmnt);
			
			/** Adding Bonton reprice response for logging */
			reqResMap.get(uuid).add(btnRepriceRS);
			
			logger.info("hotelbeds reprice response mapping done ---->");
			return btnRepriceRS;
		}

		BTNRepriceResponse.Hotel btnHotel = new BTNRepriceResponse.Hotel(); 
		CheckRateRS.Hotel otaHotel = checkRateRS.getHotel();

		btnHotel.setCheckIn(otaHotel.getCheckIn());
		btnHotel.setCheckOut(otaHotel.getCheckOut());
		btnHotel.setCode(Integer.valueOf(otaHotel.getCode()));
		btnHotel.setName(otaHotel.getName());
		btnHotel.setCategoryName(otaHotel.getCategoryName());
		btnHotel.setCategoryCode(otaHotel.getCategoryCode());
		btnHotel.setDestinationCode(otaHotel.getDestinationCode());
		btnHotel.setDestinationName(otaHotel.getDestinationName());
		
		List<CheckRateRS.Hotel.Rooms.Room> otaRoomLst = otaHotel.getRooms().getRoom();
		List<BTNRepriceResponse.Hotel.Rooms.Room> btnRoomLst = null;
		
		if (!otaRoomLst.isEmpty()) {
			btnHotel.setRooms(new BTNRepriceResponse.Hotel.Rooms());
			btnRoomLst = btnHotel.getRooms().getRoom();
		}
		
		for (CheckRateRS.Hotel.Rooms.Room otaRoom : otaRoomLst) {
			
			BTNRepriceResponse.Hotel.Rooms.Room btnRoom = new BTNRepriceResponse.Hotel.Rooms.Room();
			btnRoom.setCode(otaRoom.getCode());
			btnRoom.setName(otaRoom.getName());
			
			btnRoom.setRates(new BTNRepriceResponse.Hotel.Rooms.Room.Rates());
			BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate btnRate = new BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate();
			
			CheckRateRS.Hotel.Rooms.Room.Rates.Rate otaRate = otaRoom.getRates().getRate();
			
			btnRate.setNetRate(new BigDecimal(otaRate.getNet().toString()));
			btnRate.setPackaging(otaRate.getPackaging());
			btnRate.setRateType(otaRate.getRateType());
			btnRate.setRateComments(otaRate.getRateComments());
			btnRate.setRoomCount(otaRate.getRooms());
			btnRate.setAdultCount(otaRate.getAdults());
			btnRate.setChildCount(otaRate.getChildren());
			
			btnRate.setCancellationPolicies(new BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies());

			BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy btnCancPlcy = 
					new BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy();
			
			btnCancPlcy.setAmount(new BigDecimal(otaRate.getCancellationPolicies().getCancellationPolicy().getAmount().toString()));
			btnCancPlcy.setFrom(otaRate.getCancellationPolicies().getCancellationPolicy().getFrom());
			
			btnRate.getCancellationPolicies().setCancellationPolicy(btnCancPlcy);
			btnRoom.getRates().setRate(btnRate);
			btnRoomLst.add(btnRoom);
		}
		
		btnRepriceRS.setHotel(btnHotel);
		
		/** Adding Bonton reprice response for logging */
		reqResMap.get(uuid).add(btnRepriceRS);
		
		logger.info("hotelbeds reprice response mapping done ---->");
		return btnRepriceRS;
	}
	
	/**
	 * All the logging threads are handled by separate executor thread.
	 * i.e: logging for each operation executes in a separate thread.
	 * It is possible that some thing goes wrong while preparing the
	 * request-response list. In that scenario, this method goes ahead and
	 * logs whatever is available in the reqResLst. Also, if any exception 
	 * occurs while inserting the request/ responses, this method will silently
	 * log the same in the log file/
	 * @param uuid unique identifier for request-response pairs
	 * @param operation search, reprice, confirm or cancel
	 * @param supplier service provider like HB, Desia or others
	 * @throws Exception 
	 * @author Tirath
	 */
	public static void logReqRes(final String uuid, final String op, final String supplier) throws Exception {
		hbEs.submit(new Runnable() {

			@Override
			public void run() {
				
				List<? super Object> reqResLst = reqResMap.get(uuid);
				try {
					switch (op) {
					case HBProperties.SEARCH:
						HBDBConnection.insert(op, 
								XmlProcessor.getBeanInXml((BTNSearchRequest) reqResLst.get(0)),
								XmlProcessor.getBeanInXml((AvailabilityRQ) reqResLst.get(1)),
								XmlProcessor.getBeanInXml((AvailabilityRS) reqResLst.get(2)),
								XmlProcessor.getBeanInXml((BTNSearchResponse) reqResLst.get(3)), 
								supplier);
						break;
					case HBProperties.REPRICE:
						HBDBConnection.insert(op, 
								XmlProcessor.getBeanInXml((BTNRepriceRequest) reqResLst.get(0)),
								XmlProcessor.getBeanInXml((CheckRateRQ) reqResLst.get(1)),
								XmlProcessor.getBeanInXml((CheckRateRS) reqResLst.get(2)),
								XmlProcessor.getBeanInXml((BTNRepriceResponse) reqResLst.get(3)), 
								supplier);
						break;
					case HBProperties.CONFIRM: 
						HBDBConnection.insert(op, 
								XmlProcessor.getBeanInXml((BTNConfirmRequest) reqResLst.get(0)),
								XmlProcessor.getBeanInXml((BookingRQ) reqResLst.get(1)),
								XmlProcessor.getBeanInXml((BookingRS) reqResLst.get(2)),
								XmlProcessor.getBeanInXml((BTNConfirmResponse) reqResLst.get(3)), 
								supplier);
						break;
					case HBProperties.CANCEL: {
						HBDBConnection.insert(op, 
								XmlProcessor.getBeanInXml((BTNCancelRQ) reqResLst.get(0)),
								null,	//As its a HTTP DELETE OPERATION
								XmlProcessor.getBeanInXml((BookingCancellationRS) reqResLst.get(2)),
								XmlProcessor.getBeanInXml((BTNCancelRS) reqResLst.get(3)), 
								supplier);
						break;
					}
					}
				} catch (Exception e) {
					logger.error("Exception occured while logging {} request and responses in the DB {}", op, e);
				}
				/** Remove the entry once we are done logging in DB */
				reqResMap.remove(uuid);
				
			}});
	}
	
}
