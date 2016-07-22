package com.hotelbeds.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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
		/* Should not be instantiated */
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
		
		/* To fetch the daily price break down */
		availabilityRQ.setDailyRate(btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().isIncludePriceBreakdown());
		
		if (btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getItemDestination() != null) {
			AvailabilityRQ.Destination destination = new AvailabilityRQ.Destination();
			destination.setCode(btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getItemDestination().getDestinationCode());
			//destination.setZone(searchBean.getRequestDetails().getSearchHotelPriceRequest().getItemDestination().getDestinationType());
			
			availabilityRQ.setDestination(destination);
		}

		AvailabilityRQ.Filter filter = new AvailabilityRQ.Filter();
		if (btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getMinStarRating() != null) {
			filter.setMinCategory(btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getMinStarRating());
		}
		if (btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getMaxStarRating() != null) {
			filter.setMaxCategory(btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getMaxStarRating());
		}

		availabilityRQ.setFilter(filter);

		AvailabilityRQ.Stay stay = new AvailabilityRQ.Stay();
		stay.setCheckIn(btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getPeriodOfStay().getCheckInDate());
		stay.setCheckOut(btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getPeriodOfStay().getCheckOutDate());

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
		if (btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getHotels() != null) {
			List<String> hotelCdLst = btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getHotels().getHotel();
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
		
		BTNSearchResponse btnSearchResponse = new BTNSearchResponse();

		if (availabilityRS.getError() != null) {
			BTNSearchResponse.BTNError errElmnt = new BTNSearchResponse.BTNError();
			errElmnt.setCode(availabilityRS.getError().getCode());
			errElmnt.setMessage(availabilityRS.getError().getMessage());

			btnSearchResponse.setBTNError(errElmnt);
			
			/** Adding HB availability response for logging */
			reqResMap.get(uuid).add(btnSearchResponse);
			
			logger.info("hotelbeds search response mapping done ---->");
			return btnSearchResponse;
		}

		/** Fetch the searched rooms~adults~children combination */
		String tempComb = rtRcmndMap.get(uuid);
		tempComb = tempComb.substring(0, tempComb.length() - 1);
		String[] keySetArray = tempComb.split(HBProperties.SPLIT);
		int noOfRooms = keySetArray.length;
		Set<String> keySet = new HashSet<String>(Arrays.asList(keySetArray));
		
		/** do the appropriate mapping*/
		btnSearchResponse.setTravelRequestID(HBProperties.EMPTY);
		btnSearchResponse.setServiceRequestID(HBProperties.EMPTY);

		btnSearchResponse.setOptionsCount(availabilityRS.getHotels().getTotal());

		boolean onlyOnce = true;
		BTNSearchResponse.HotelOptions resHotelOptions = new  BTNSearchResponse.HotelOptions();
		btnSearchResponse.setHotelOptions(resHotelOptions);

		List<BTNSearchResponse.HotelOptions.Hotel> resHotelLst = resHotelOptions.getHotel();
		List<AvailabilityRS.Hotels.Hotel> hotelLst = availabilityRS.getHotels().getHotel();

		for (AvailabilityRS.Hotels.Hotel hotel : hotelLst) {
			boolean addHotel = false;
			BTNSearchResponse.HotelOptions.Hotel resHotel = new BTNSearchResponse.HotelOptions.Hotel();
			resHotel.setHotelCode(hotel.getCode());
			resHotel.setHotelName(hotel.getName());
			resHotel.setStarRating(hotel.getCategoryName());
			resHotel.setLatitude(hotel.getLatitude() == null? 0f: hotel.getLatitude());
			resHotel.setLongitude(hotel.getLongitude() == null? 0f: hotel.getLongitude());
			resHotel.setFullAddress(hotel.getAddress() == null? HBProperties.EMPTY: hotel.getAddress());

			/** As this is common for all the hotels */
			if (onlyOnce) {
				BTNSearchResponse.City city = new BTNSearchResponse.City();
				city.setCityCode(hotel.getDestinationCode());
				city.setCityName(hotel.getDestinationName());
				btnSearchResponse.setCity(city);
				onlyOnce = false;
			}
			
			BTNSearchResponse.HotelOptions.Hotel.RoomOptions resRoomOptions = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions();
			resHotel.setRoomOptions(resRoomOptions);

			List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room> resRoomLst = resRoomOptions.getRoom();
			List<AvailabilityRS.Hotels.Hotel.Rooms.Room> roomLst = hotel.getRooms().getRoom();

			for (AvailabilityRS.Hotels.Hotel.Rooms.Room room : roomLst) {
				BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room resRoom = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room();
				resRoom.setRoomType(room.getName());
				resRoom.setSupplier(HBProperties.HB);

				List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate> resRateLst = resRoom.getRate();
				List<AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate> rateLst = room.getRates().getRate();
				
				/** Added to not display the rooms for which the searched pax combination 
				 * doesn't match the combinations mentioned in rate keys. 
				 * Works in combination with resKeySet. Added to get rid of straight cases. */
				if (rateLst.size() < noOfRooms) {
					continue;
				}
				
				/** 
				 * Flag to help us - whether to display a rate or not and if not 
				 * "Bookable" rates are available then skipping the room. 
				 **/
				boolean isBookable = false;
				
				Set<String> resKeySet = new HashSet<String>();
				for (AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate rate : rateLst) {
					if (!rate.getRateType().equalsIgnoreCase(HBProperties.RATE_TYPE)) {
						/** Skipping rate entry as rateType is not BOOKABLE. Other possibility is RECHECK */
						continue;
					}
					isBookable = true; addHotel = true;
					BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate resRate = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate();
					resRate.setAdults(rate.getAdults());
					resRate.setChildren(rate.getChildren());
					resRate.setChildrenAges(rate.getChildrenAges());
					
					StringBuilder tempBffr = new StringBuilder()
							.append(rate.getRooms()).append(HBProperties.SEP1)
							.append(rate.getAdults()).append(HBProperties.SEP1)
							.append(rate.getChildren());
					
					resKeySet.add(tempBffr.toString());
					/** Decide not to use it but keep it.
					if (keySet.contains(tempBffr.toString())) {
						/** Set the recommended tag. Not required now but exists if needed later. *
						resRate.setRecommended(HBProperties.REC);
					}
					 */
					
					resRate.setRateKey(rate.getRateKey());
					resRate.setPackaging(rate.getPackaging());
					resRate.setMealType(rate.getBoardName());
					
					/** 
					 * Meal code contains board code. Should not be changed. Otherwise breaks the rate list
					 * sorting logic. Change the rateListCmptr comparator logic if it must change. 
					 **/
					resRate.setMealCode(rate.getBoardCode());

					resRate.setSupplierPrice(rate.getNet());
					resRate.setOtaFee(0.0f);
					resRate.setOtaDiscountAmount(0.0f);

					BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.CancellationPolicies resCancPlcies = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.CancellationPolicies();
					
					if (rate.getCancellationPolicies() != null) {
						List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.CancellationPolicies.CancellationPolicy> resCancPlcyLst = 
								resCancPlcies.getCancellationPolicy();
						
						List<AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy> cancPlcyLst = 
								rate.getCancellationPolicies().getCancellationPolicy();
						
						for (AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy cancPlcy : cancPlcyLst) {
							BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.CancellationPolicies.CancellationPolicy resCancPlcy = 
									new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.CancellationPolicies.CancellationPolicy();

							resCancPlcy.setAmount(cancPlcy.getAmount());
							resCancPlcy.setFrom(cancPlcy.getFrom());

							resCancPlcyLst.add(resCancPlcy);
						}
					}
					
					BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates resDailyRates = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates();

					if (rate.getDailyRates() != null) {
						List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate> resDailyRateLst = resDailyRates.getDailyRate();
						List<AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate.DailyRates.DailyRate> dailyRateLst = rate.getDailyRates().getDailyRate();
						
						for (AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate.DailyRates.DailyRate dailyRate : dailyRateLst) {
							BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate resDailyRate = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate();
							resDailyRate.setOffset(dailyRate.getOffset());
							resDailyRate.setDailyNet(dailyRate.getDailyNet());

							/* adding to the daily rate list */
							resDailyRateLst.add(resDailyRate);
						}
					}
					
					resRate.setDailyRates(resDailyRates);
					resRate.setCancellationPolicies(resCancPlcies);
					
					resRateLst.add(resRate);
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
					Collections.sort(resRateLst, rateListCmptr);
					resRoomLst.add(resRoom);
				}
			}
			if (addHotel) {
				resHotelLst.add(resHotel);
			}
		}
		/** Adding HB availability response for logging */
		reqResMap.get(uuid).add(btnSearchResponse);
		
		logger.info("hotelbeds search response mapping done ---->");
		return btnSearchResponse;
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
		contactdata.setPhoneNumber(btnbookingRq.getContactData().getPhoneNumber() + "");
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
		
		BTNConfirmResponse btnConfirmResponse = new BTNConfirmResponse();
		
		if (bookingRS.getError() != null) {
			BTNConfirmResponse.BTNError errElmnt = new BTNConfirmResponse.BTNError();
			errElmnt.setCode(bookingRS.getError().getCode());
			errElmnt.setMessage(bookingRS.getError().getMessage());
			
			btnConfirmResponse.setBTNError(errElmnt);
			
			/** Adding Bonton confirm response for logging */
			reqResMap.get(uuid).add(btnConfirmResponse);
			
			logger.info("hotelbeds confirm response mapping done ---->");
			return btnConfirmResponse;
		}
		
		BTNConfirmResponse.Booking resBooking = new BTNConfirmResponse.Booking();
		BTNConfirmResponse.Booking.ModificationPolicies resModiPolicies = new BTNConfirmResponse.Booking.ModificationPolicies();
		BTNConfirmResponse.Booking.PrinciplePax resPrinciplePax = new BTNConfirmResponse.Booking.PrinciplePax();
		
		
		resModiPolicies.setCancellation(bookingRS.getBooking().getModificationPolicies().getCancellation());
		resModiPolicies.setModification(bookingRS.getBooking().getModificationPolicies().getModification());
		
		resPrinciplePax.setName(bookingRS.getBooking().getHolder().getName());
		resPrinciplePax.setSurname(bookingRS.getBooking().getHolder().getSurname());
		
		resBooking.setModificationPolicies(resModiPolicies);
		resBooking.setPrinciplePax(resPrinciplePax);
		resBooking.setReference(bookingRS.getBooking().getReference());
		resBooking.setClientReference(bookingRS.getBooking().getClientReference());
		resBooking.setCreationDate(bookingRS.getBooking().getCreationDate());
		resBooking.setTotalSellingRate(bookingRS.getBooking().getTotalNet());
		resBooking.setStatus(bookingRS.getBooking().getRemark());
		
		BTNConfirmResponse.Booking.Hotel resHotel = new BTNConfirmResponse.Booking.Hotel();
		BookingRS.Booking.Hotel hotel = bookingRS.getBooking().getHotel();
		resHotel.setCheckIn(hotel.getCheckIn());
		resHotel.setCheckOut(hotel.getCheckOut());
		resHotel.setCode(new Integer(hotel.getCode()).toString());
		resHotel.setName(hotel.getName());
		resHotel.setCatCode(hotel.getCategoryCode());
		resHotel.setCatName(hotel.getCategoryName());
		resHotel.setDestCode(hotel.getDestinationCode());
		resHotel.setDestName(hotel.getDestinationName());
		
		BTNConfirmResponse.Booking.Hotel.Supplierdetails resSupplierDetails = new BTNConfirmResponse.Booking.Hotel.Supplierdetails(); 
		resSupplierDetails.setName("HotelBeds");
		resSupplierDetails.setVatNumber(hotel.getSupplier().getVatNumber());
		
		BTNConfirmResponse.Booking.Hotel.Rooms resRooms = new BTNConfirmResponse.Booking.Hotel.Rooms();
		resHotel.setRooms(resRooms);
		resHotel.setSupplierdetails(resSupplierDetails);
		
		resBooking.setHotel(resHotel);
		
		List<BTNConfirmResponse.Booking.Hotel.Rooms.Room> resRoomLst = resRooms.getRoom();
		List<BookingRS.Booking.Hotel.Rooms.Room> roomLst = hotel.getRooms().getRoom();
		
		int roomCount = roomLst.size();
		int adultCount = 0, totalOccupant = 0;
		for (BookingRS.Booking.Hotel.Rooms.Room room : roomLst) {
			BTNConfirmResponse.Booking.Hotel.Rooms.Room.Paxes resPaxes = new BTNConfirmResponse.Booking.Hotel.Rooms.Room.Paxes();
			BTNConfirmResponse.Booking.Hotel.Rooms.Room.Rates resRates = new BTNConfirmResponse.Booking.Hotel.Rooms.Room.Rates();
			
			List<BookingRS.Booking.Hotel.Rooms.Room.Paxes.Pax> paxLst = room.getPaxes().getPax();
			
			totalOccupant = paxLst.size();
			for (BookingRS.Booking.Hotel.Rooms.Room.Paxes.Pax pax : paxLst) {
				BTNConfirmResponse.Booking.Hotel.Rooms.Room.Paxes.Pax resPax = new BTNConfirmResponse.Booking.Hotel.Rooms.Room.Paxes.Pax();
				resPax.setAge(pax.getAge());
				resPax.setName(pax.getName());
				resPax.setRoomId(pax.getRoomId());
				resPax.setSurname(pax.getSurname());
				resPax.setType(pax.getType());
				resPax.setValue(pax.getValue());
				
				if ("AD".equals(pax.getType()))
					adultCount++;
				
				resPaxes.getPax().add(resPax);
			}
			BTNConfirmResponse.Booking.Hotel.Rooms.Room.Rates.Rate resRate = new BTNConfirmResponse.Booking.Hotel.Rooms.Room.Rates.Rate(); 
			BookingRS.Booking.Hotel.Rooms.Room.Rates.Rate rate = room.getRates().getRate();
			
			resRate.setNetRate(rate.getNet());
			resRate.setPackaging(rate.getPackaging());
			resRate.setRateType(rate.getRateClass());
			resRate.setRoomCount(roomCount);
			resRate.setAdultCount(adultCount);
			resRate.setChildCount(totalOccupant - adultCount);
			
			BTNConfirmResponse.Booking.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies resCplcies = new BTNConfirmResponse.Booking.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies();
			BTNConfirmResponse.Booking.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy resCplcy = new BTNConfirmResponse.Booking.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy();
			
			resCplcy.setAmount(rate.getCancellationPolicies().getCancellationPolicy().getAmount());
			resCplcy.setFrom(rate.getCancellationPolicies().getCancellationPolicy().getFrom().toString());
			resCplcy.setValue(rate.getCancellationPolicies().getCancellationPolicy().getValue());
			
			resCplcies.setCancellationPolicy(resCplcy);
			resRate.setCancellationPolicies(resCplcies);
			resRates.setRate(resRate);
			
			
			
			BTNConfirmResponse.Booking.Hotel.Rooms.Room resRoom = new BTNConfirmResponse.Booking.Hotel.Rooms.Room();
			resRoom.setPaxes(resPaxes);
			resRoom.setRates(resRates);
			resRoomLst.add(resRoom);
		}
		btnConfirmResponse.setBooking(resBooking);
		
		/** Adding Bonton confirm response for logging */
		reqResMap.get(uuid).add(btnConfirmResponse);
		
		logger.info("hotelbeds confirm response mapping done ---->");
		return btnConfirmResponse;
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
		
		BTNCancelRS.Booking resBooking = new BTNCancelRS.Booking();
		BTNCancelRS.Booking.ModificationPolicies resModiPolicies = new BTNCancelRS.Booking.ModificationPolicies();
		BTNCancelRS.Booking.PrinciplePax resPrinciplePax = new BTNCancelRS.Booking.PrinciplePax();
		
		BookingCancellationRS.Booking booking = cancelRS.getBooking();
		resModiPolicies.setCancellation(booking.getModificationPolicies().getCancellation());
		resModiPolicies.setModification(booking.getModificationPolicies().getModification());
		
		resPrinciplePax.setName(booking.getHolder().getName());
		resPrinciplePax.setSurname(booking.getHolder().getSurname());
		
		resBooking.setModificationPolicies(resModiPolicies);
		resBooking.setPrinciplePax(resPrinciplePax);
		resBooking.setReference(booking.getReference());
		resBooking.setClientReference(booking.getClientReference());
		resBooking.setCreationDate(booking.getCreationDate());
		resBooking.setTotalSellingRate(booking.getTotalNet());
		resBooking.setStatus(booking.getRemark());
		resBooking.setCancellationReference(booking.getCancellationReference());
		
		BTNCancelRS.Booking.Hotel resHotel = new BTNCancelRS.Booking.Hotel();
		BookingCancellationRS.Booking.Hotel hotel = booking.getHotel();
		resHotel.setCheckIn(hotel.getCheckIn());
		resHotel.setCheckOut(hotel.getCheckOut());
		resHotel.setCode(new Integer(hotel.getCode()).toString());
		resHotel.setName(hotel.getName());
		resHotel.setCatCode(hotel.getCategoryCode());
		resHotel.setCatName(hotel.getCategoryName());
		resHotel.setDestCode(hotel.getDestinationCode());
		resHotel.setDestName(hotel.getDestinationName());
		resHotel.setCancellationAmount(hotel.getCancellationAmount());
		//hotel.getZoneCode() //setters not available
		//hotel.getZoneName()
		//hotel.getLatitude()
		//hotel.getLongitude()
		//hotel.getTotalNet()
		//hotel.getCurrency()
		
		BTNCancelRS.Booking.Hotel.Supplierdetails resSupplierDetails = new BTNCancelRS.Booking.Hotel.Supplierdetails(); 
		resSupplierDetails.setName("HotelBeds");
		resSupplierDetails.setVatNumber(hotel.getSupplier().getVatNumber());
		
		BTNCancelRS.Booking.Hotel.Rooms resRooms = new BTNCancelRS.Booking.Hotel.Rooms();
		resHotel.setRooms(resRooms);
		resHotel.setSupplierdetails(resSupplierDetails);
		
		resBooking.setHotel(resHotel);
		
		List<BTNCancelRS.Booking.Hotel.Rooms.Room> resRoomLst = resRooms.getRoom();
		List<BookingCancellationRS.Booking.Hotel.Rooms.Room> roomLst = hotel.getRooms().getRoom();
		
		int roomCount = roomLst.size();
		int adultCount = 0, totalOccupant = 0;
		for (BookingCancellationRS.Booking.Hotel.Rooms.Room room : roomLst) {
			BTNCancelRS.Booking.Hotel.Rooms.Room.Paxes resPaxes = new BTNCancelRS.Booking.Hotel.Rooms.Room.Paxes();
			BTNCancelRS.Booking.Hotel.Rooms.Room.Rates resRates = new BTNCancelRS.Booking.Hotel.Rooms.Room.Rates();
			
			List<BookingCancellationRS.Booking.Hotel.Rooms.Room.Paxes.Pax> paxLst = room.getPaxes().getPax();
			
			totalOccupant = paxLst.size();
			for (BookingCancellationRS.Booking.Hotel.Rooms.Room.Paxes.Pax pax : paxLst) {
				BTNCancelRS.Booking.Hotel.Rooms.Room.Paxes.Pax resPax = new BTNCancelRS.Booking.Hotel.Rooms.Room.Paxes.Pax();
				resPax.setAge(pax.getAge());
				resPax.setName(pax.getName());
				resPax.setRoomId(pax.getRoomId());
				resPax.setSurname(pax.getSurname());
				resPax.setType(pax.getType());
				resPax.setValue(pax.getValue());
				
				if ("AD".equals(pax.getType()))
					adultCount++;
				
				resPaxes.getPax().add(resPax);
			}
			BTNCancelRS.Booking.Hotel.Rooms.Room.Rates.Rate resRate = new BTNCancelRS.Booking.Hotel.Rooms.Room.Rates.Rate(); 
			BookingCancellationRS.Booking.Hotel.Rooms.Room.Rates.Rate rate = room.getRates().getRate();
			
			//rate.getBoardCode()
			//rate.getBoardName()
			resRate.setNetRate(rate.getNet());
			resRate.setPackaging(rate.getPackaging());
			//rate.getPaymentType()
			resRate.setRateType(rate.getRateClass());
			//rate.getRateComments()
			resRate.setRoomCount(roomCount);
			resRate.setAdultCount(adultCount);
			resRate.setChildCount(totalOccupant - adultCount);
			
			//BTNCancelRS.Booking.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies resCplcies = new BTNCancelRS.Booking.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies();
			//BTNCancelRS.Booking.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy resCplcy = new BTNCancelRS.Booking.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy();
			
			//resCplcy.setAmount(rate.getCancellationPolicies().getCancellationPolicy().getAmount());
			//resCplcy.setFrom(rate.getCancellationPolicies().getCancellationPolicy().getFrom().toString());
			//resCplcy.setValue(rate.getCancellationPolicies().getCancellationPolicy().getValue());
			
			//resCplcies.setCancellationPolicy(resCplcy);
			//resRate.setCancellationPolicies(resCplcies);
			resRates.setRate(resRate);
			
			
			
			BTNCancelRS.Booking.Hotel.Rooms.Room resRoom = new BTNCancelRS.Booking.Hotel.Rooms.Room();
			resRoom.setStatus(room.getStatus());
			resRoom.setCode(room.getCode());
			resRoom.setId(room.getId());
			resRoom.setName(room.getName());
			resRoom.setPaxes(resPaxes);
			resRoom.setRates(resRates);
			resRoomLst.add(resRoom);
		}
		btnCancelRS.setBooking(resBooking);
		
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
		
		BTNRepriceResponse btnRepriceRs = new BTNRepriceResponse();

		if (checkRateRS.getError() != null) {
			BTNRepriceResponse.BTNError errElmnt = new BTNRepriceResponse.BTNError();
			errElmnt.setCode(checkRateRS.getError().getCode());
			errElmnt.setMessage(checkRateRS.getError().getMessage());

			btnRepriceRs.setBTNError(errElmnt);
			
			/** Adding Bonton reprice response for logging */
			reqResMap.get(uuid).add(btnRepriceRs);
			
			logger.info("hotelbeds reprice response mapping done ---->");
			return btnRepriceRs;
		}

		BTNRepriceResponse.Hotel resHotel = new BTNRepriceResponse.Hotel(); 
		CheckRateRS.Hotel hotel = checkRateRS.getHotel();

		resHotel.setCheckIn(hotel.getCheckIn());
		resHotel.setCheckOut(hotel.getCheckOut());
		resHotel.setCode(new Integer(hotel.getCode()));
		resHotel.setName(hotel.getName());
		resHotel.setCategoryName(hotel.getCategoryName());
		resHotel.setCategoryCode(hotel.getCategoryCode());
		resHotel.setDestinationCode(hotel.getDestinationCode());
		resHotel.setDestinationName(hotel.getDestinationName());
		
		BTNRepriceResponse.Hotel.Rooms resRooms = new BTNRepriceResponse.Hotel.Rooms();
		List<BTNRepriceResponse.Hotel.Rooms.Room> resRoomLst = resRooms.getRoom();
		
		List<CheckRateRS.Hotel.Rooms.Room> roomLst = hotel.getRooms().getRoom();
		for (CheckRateRS.Hotel.Rooms.Room room : roomLst) {
			
			BTNRepriceResponse.Hotel.Rooms.Room resRoom = new BTNRepriceResponse.Hotel.Rooms.Room();
			resRoom.setCode(room.getCode());
			resRoom.setName(room.getName());
			
			CheckRateRS.Hotel.Rooms.Room.Rates.Rate rate = room.getRates().getRate();
			BTNRepriceResponse.Hotel.Rooms.Room.Rates resRates = new BTNRepriceResponse.Hotel.Rooms.Room.Rates();
			BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate resRate = new BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate();
			
			BigDecimal net = new BigDecimal(rate.getNet().toString());
			
			resRate.setNetRate(net);
			resRate.setPackaging(rate.getPackaging());
			resRate.setRateType(rate.getRateType());
//			resRate.setCategory();
			resRate.setRoomCount(rate.getRooms());
			resRate.setAdultCount(rate.getAdults());
			resRate.setChildCount(rate.getChildren());
			
			BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies rescpies = 
					new BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies();
			BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy rescpy = 
					new BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy();
			
			rescpy.setAmount(new BigDecimal(rate.getCancellationPolicies().getCancellationPolicy().getAmount().toString()));
			rescpy.setFrom(rate.getCancellationPolicies().getCancellationPolicy().getFrom());
			
			rescpies.setCancellationPolicy(rescpy);
			resRate.setCancellationPolicies(rescpies);
			resRates.setRate(resRate);
			resRoom.setRates(resRates);
			
			resRoomLst.add(resRoom);
		}
		resHotel.setRooms(resRooms);
		btnRepriceRs.setHotel(resHotel);
		
		/** Adding Bonton reprice response for logging */
		reqResMap.get(uuid).add(btnRepriceRs);
		
		logger.info("hotelbeds reprice response mapping done ---->");
		return btnRepriceRs;
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
				logger.info("hotelbeds RQ-RS logging for {} operation id {} started --->", op, uuid);
				
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
				
				logger.info("hotelbeds RQ-RS logging for {} operation id {} completed --->", op, uuid);
			}});
	}
	
}
