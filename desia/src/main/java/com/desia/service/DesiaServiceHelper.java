package com.desia.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

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
import com.bonton.utility.desia.Hotels;
import com.desia.artifacts.booking.OTACancelRQ;
import com.desia.artifacts.booking.OTACancelRS;
import com.desia.artifacts.booking.OTAHotelResRQ;
import com.desia.artifacts.booking.OTAHotelResRS;
import com.desia.artifacts.booking.TGBookingServiceEndPoint;
import com.desia.artifacts.booking.TGBookingServiceEndPointImplService;
import com.desia.artifacts.search.AvailRequestSegmentsType.AvailRequestSegment;
import com.desia.artifacts.search.AvailRequestSegmentsType.AvailRequestSegment.HotelSearchCriteria;
import com.desia.artifacts.search.CountryNameType;
import com.desia.artifacts.search.DateTimeSpanType;
import com.desia.artifacts.search.GuestCountType;
import com.desia.artifacts.search.GuestCountType.GuestCount;
import com.desia.artifacts.search.HotelSearchCriteriaType.Criterion;
import com.desia.artifacts.search.HotelSearchCriterionType.RoomStayCandidates;
import com.desia.artifacts.search.ItemSearchCriterionType.Address;
import com.desia.artifacts.search.OTAHotelAvailRQ;
import com.desia.artifacts.search.OTAHotelAvailRQ.AvailRequestSegments;
import com.desia.artifacts.search.OTAHotelAvailRS;
import com.desia.artifacts.search.OTAHotelAvailRS.RoomStays.RoomStay;
import com.desia.artifacts.search.Pagination;
import com.desia.artifacts.search.RatePlanType;
import com.desia.artifacts.search.RoomStayCandidateType;
import com.desia.artifacts.search.RoomStayType.RoomRates.RoomRate;
import com.desia.artifacts.search.RoomTypeType;
import com.desia.artifacts.search.TGServiceEndPoint;
import com.desia.artifacts.search.TGServiceEndPointImplService;
import com.desia.artifacts.search.TPAExtensionsType;
import com.desia.artifacts.search.TPAExtensionsType.UserAuthentication;
import com.desia.handler.MessageHandler;

public class DesiaServiceHelper {
	private static Logger logger = LoggerFactory.getLogger(DesiaServiceHelper.class);
	
	private static final TGServiceEndPointImplService searchSIB = new TGServiceEndPointImplService();
	private static final TGBookingServiceEndPointImplService bookingSIB = new TGBookingServiceEndPointImplService();
	
	private static TGServiceEndPoint searchSEI = null;
	private static TGBookingServiceEndPoint bookingSEI = null;
	
	
	private DesiaServiceHelper() {}
	
	static {
		HandlerResolver handlerResolver = new HandlerResolver() {
			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				List<Handler> handler = new LinkedList<>();
				handler.add(new MessageHandler());
				return handler;
			}
		};
		//searchSIB.setHandlerResolver(handlerResolver);//TODO: uncomment this later
		bookingSIB.setHandlerResolver(handlerResolver);
		
		searchSEI = (TGServiceEndPoint) searchSIB.getTGServiceEndPointImplPort();
		bookingSEI = (TGBookingServiceEndPoint) bookingSIB.getTGBookingServiceEndPointImplPort();
	}
	
	public static OTAHotelAvailRQ searchBeanRequestMapper(BTNSearchRequest btnSearchRequest) throws Exception {
		/* Add appropriate mapping */

		/* Use below set of mapping to start and prepare final set of mapping */
		//Request preparation
		OTAHotelAvailRQ otaHotelAvailRQ = new OTAHotelAvailRQ();

		/* Assumption. Might change in future */
		String min = btnSearchRequest.getRequestDetails().getSearchHotelPriceRequest().getMinStarRating();
		String max = btnSearchRequest.getRequestDetails().getSearchHotelPriceRequest().getMaxStarRating();
		if (null != min && null != max) {
			otaHotelAvailRQ.setSortOrder("STAR_RATING_ASCENDING");
		} else {
			otaHotelAvailRQ.setSortOrder("TG_RANKING");
		}
		/***********/

		AvailRequestSegments reqSgmnts = new AvailRequestSegments();
		List<AvailRequestSegment> reqSgmntLst = reqSgmnts.getAvailRequestSegment();
		AvailRequestSegment reqSgmnt = new AvailRequestSegment();

		HotelSearchCriteria searchCriteria = new HotelSearchCriteria();
		List<Criterion> criterionLst = searchCriteria.getCriterion();

		Criterion tmpCriterion = new Criterion();
		Address address = new Address();
		//set city name
		address.setCityName(btnSearchRequest.getRequestDetails().getSearchHotelPriceRequest().getItemDestination().getDestinationCode());

		CountryNameType c = new CountryNameType();

		/* we need to have this always set to India */
		//btnSearchRequest.getRequestDetails().getSearchHotelPriceRequest().getItemDestination().getDestinationType();
		c.setCode("India");
		address.setCountryName(c);

		DateTimeSpanType dateRange = new DateTimeSpanType();
		//need to check the date format
		dateRange.setStart(btnSearchRequest.getRequestDetails().getSearchHotelPriceRequest().getPeriodOfStay().getCheckInDate().toString());
		dateRange.setEnd(btnSearchRequest.getRequestDetails().getSearchHotelPriceRequest().getPeriodOfStay().getCheckOutDate().toString());

		TPAExtensionsType extnsn = new TPAExtensionsType();


		UserAuthentication userAuth = new UserAuthentication();
		userAuth.setUsername("bontonnet");userAuth.setPassword("test@567");userAuth.setPropertyId("1300001210");

		extnsn.setUserAuthentication(userAuth);
		tmpCriterion.setTPAExtensions(extnsn);

		tmpCriterion.setStayDateRange(dateRange);
		tmpCriterion.setAddress(address);

		criterionLst.add(tmpCriterion);

		reqSgmnt.setHotelSearchCriteria(searchCriteria);
		reqSgmntLst.add(reqSgmnt);

		otaHotelAvailRQ.setAvailRequestSegments(reqSgmnts);

		return otaHotelAvailRQ;
	}
	
	
	public static BTNSearchResponse searchBeanResponseMapper(OTAHotelAvailRS otaHotelAvailRS) throws Exception {
		BTNSearchResponse btnSearchRS = new BTNSearchResponse();
		
		btnSearchRS.setTravelRequestID("");
		btnSearchRS.setServiceRequestID("");
		btnSearchRS.setOptionsCount(otaHotelAvailRS.getTPAExtensions().getHotelsInfo().getAvailable());
		
		/* don't know from where to get this*/
		//hotelResponse.getCity().setCityCode(value);
		//hotelResponse.getCity().setCityName(value);
		
		Hotels hotels = getHotelList(otaHotelAvailRS.getRoomStays().getRoomStay());
		List<Hotels.Hotel> hotelLst = hotels.getHotel();
		
		BTNSearchResponse.HotelOptions resHotels = new BTNSearchResponse.HotelOptions();
		btnSearchRS.setHotelOptions(resHotels);
		List<BTNSearchResponse.HotelOptions.Hotel> resHotelLst = resHotels.getHotel();
		
		for (Hotels.Hotel hotel : hotelLst) {
			/* Using fully qualified names in order to avoid confusion */
			BTNSearchResponse.HotelOptions.Hotel resHotel = new BTNSearchResponse.HotelOptions.Hotel();
			
			resHotel.setHotelCode(hotel.getHotelCode());
			resHotel.setHotelName(hotel.getHotelName());
			resHotel.setLocation("");
			resHotel.setSupplier(hotel.getSupplier());
			resHotel.setStarRating(hotel.getRating());
			resHotel.setMainImage(hotel.getImageUrl());
			resHotel.setFullAddress("");
			//resHotel.setLatitude("");//TODO: set these later
			//resHotel.setLongitude("");
			resHotel.setDescription(hotel.getDescription());
			resHotel.setRemarks(hotel.getDescription());
			resHotel.setEssentialInformation("");
			
			//List<String> btnHotelAmenityLst = btnHotel.getAmenities().getAmenity();
			/* loop through the amenities and add them to this list */
			
			BTNSearchResponse.HotelOptions.Hotel.RoomOptions resRoomOptions = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions();
			resHotel.setRoomOptions(resRoomOptions);
			
			List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room> resRoomLst = resHotel.getRoomOptions().getRoom();
			List<Hotels.Hotel.Rooms.Room> roomLst = hotel.getRooms().getRoom();
			
			for (Hotels.Hotel.Rooms.Room room : roomLst){

				BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room resRoom = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room();
				resRoom.setSupplier(room.getSupplier());
				resRoom.setRateKey(room.getRate().getUniqueKey());
				resRoom.setRoomDescription(room.getName());
				
				/* check this .. using first index for now*/
				BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.FinalPrice resFinalPrice = 
						new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.FinalPrice();
				
				/* narrowing the value. Change it late to use BigDecimal */
				resFinalPrice.setSupplierPrice(room.getRate().getNet().floatValue());
				resFinalPrice.setOtaFee(0.0f);
				resFinalPrice.setOtaDiscountAmount(0.0f);
				
//				BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.CancellationPolicies resCancPlcy = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.CancellationPolicies();
//				resCancPlcy.setAmount(rate.getCancellationPolicies().getCancellationPolicy().getAmount());
//				resCancPlcy.setFrom(rate.getCancellationPolicies().getCancellationPolicy().getFrom());
				
				resRoom.setFinalPrice(resFinalPrice);
				//resRoom.setCancellationPolicies(resCancPlcy);
				resRoomLst.add(resRoom);
			}
			
			resHotelLst.add(resHotel);
		}
		
		return btnSearchRS;
	}
	
	
	public static OTAHotelResRQ repriceBeanRequestMapper(BTNRepriceRequest btnRepriceRQ) throws Exception {
		OTAHotelResRQ otaHotelResRQ = new OTAHotelResRQ();
		
		/* Add appropriate mapping here. */
		
		return otaHotelResRQ;
	}
	
	public static BTNRepriceResponse repriceBeanResponseMapper(OTAHotelResRS otaHotelResRS) throws Exception {
		BTNRepriceResponse btnRepriceRS = new BTNRepriceResponse();
		
		/* Add appropriate mapping here. */
		
		return btnRepriceRS;
	}
	
	public static OTAHotelResRQ confirmBeanRequestMapper(BTNConfirmRequest btnConfirmRQ) throws Exception {
		OTAHotelResRQ otaHotelResRQ = new OTAHotelResRQ();
		
		/* Add appropriate mapping here. */
		
		return otaHotelResRQ;
	}
	
	public static BTNConfirmResponse confirmBeanResponseMapper(OTAHotelResRS otaHotelResRS) throws Exception {
		BTNConfirmResponse btnConfirmRS = new BTNConfirmResponse();
		
		/* Add appropriate mapping here. */
		
		return btnConfirmRS;
	}
	
	public static OTACancelRQ cancelBeanRequestMapper(BTNCancelRQ btnCancelRQ) throws Exception {
		OTACancelRQ otaCancelRQ = new OTACancelRQ();
		
		/* Add appropriate mapping here. */
		
		return otaCancelRQ;
	}
	
	public static BTNCancelRS cancelBeanResponseMapper(OTACancelRS otaCancelRS) throws Exception {
		BTNCancelRS btnCancelRS = new BTNCancelRS();
		
		/* Add appropriate mapping here. */
		
		return btnCancelRS;
	}
	
	public static OTAHotelAvailRS sendSearchRequest(OTAHotelAvailRQ otaHotelAvailRQ) throws Exception {
		return searchSEI.fetchResponse(otaHotelAvailRQ);
	}
	
	public static OTAHotelResRS sendRepriceRequest(OTAHotelResRQ otaHotelResRQ) throws Exception {
		return bookingSEI.createBooking(otaHotelResRQ);
	}
	
	public static OTAHotelResRS sendConfirmRequest(OTAHotelResRQ otaHotelResRQ) throws Exception {
		return bookingSEI.createBooking(otaHotelResRQ);
	}
	
	public static OTACancelRS sendCancelRequest(OTACancelRQ otaCancelRQ) throws Exception {
		return bookingSEI.cancelBooking(otaCancelRQ);
	}
	
	private static Hotels getHotelList(List<OTAHotelAvailRS.RoomStays.RoomStay> hotelLst) throws Exception {
		Hotels hotels = new Hotels();
		
		if (hotelLst.size() != 0) {
			
			/* Hotel list response */
			List<Hotels.Hotel> resHotelLst = hotels.getHotel();
			
			for (OTAHotelAvailRS.RoomStays.RoomStay hotel : hotelLst) {
				Hotels.Hotel resHotel = new Hotels.Hotel();
				resHotel.setSupplier("DESIA");	//TODO: hard coded
				resHotel.setHotelCode(hotel.getBasicPropertyInfo().getHotelCode());
				resHotel.setHotelName("");	//TODO: not available
				resHotel.setHotelZone("");
				resHotel.setDestinationCode("");
				resHotel.setDestinationName("");
				resHotel.setRating("");
				resHotel.setImageUrl("");
				resHotel.setDescription("");
				resHotel.setRemarks("");
				
				List<RoomTypeType> roomTypeLst = hotel.getRoomTypes().getRoomType();
				List<RatePlanType> rateTypeLst = hotel.getRatePlans().getRatePlan();
				
				List<RoomRate> roomRateLst = hotel.getRoomRates().getRoomRate();
				
				Map<String, RoomTypeType> roomTypeMap = new HashMap<>();
				Map<String, RatePlanType> ratePlanMap = new HashMap<>();
				
				/* Populating values in map types */ 
				for (RoomTypeType tmpRoomType : roomTypeLst) {
					roomTypeMap.put(tmpRoomType.getRoomTypeCode(), tmpRoomType);
				}
				
				for (RatePlanType tmpRatePlan : rateTypeLst) {
					ratePlanMap.put(tmpRatePlan.getRatePlanCode(), tmpRatePlan);
				}
				
				Hotels.Hotel.Rooms resRooms = new Hotels.Hotel.Rooms();
				List<Hotels.Hotel.Rooms.Room> resRoomLst = resRooms.getRoom();
				
				/* To keep track of resRate object for the same 
				 * roomId-rateId combination to return net amount; */
				Map<String, Hotels.Hotel.Rooms.Room.Rate> roomTypeIdMap = new HashMap<>();
				
				for (RoomRate roomRate : roomRateLst) {
					String roomId = roomRate.getRoomID();
					String rateId = roomRate.getRatePlanCode();
					
					//RoomTypeType roomTypeItem = roomTypeMap.get(rateId);
					//RatePlanType ratePlanItem = ratePlanMap.get(roomId);
					
					String tempId = roomId + rateId;
					BigDecimal net = new BigDecimal(0);
					net = net.add(roomRate.getRates().getRate().get(0).getTPAExtensions().getRate().getBase().getAmountBeforeTax());
					
					if (roomTypeIdMap.get(tempId) == null) {
						Hotels.Hotel.Rooms.Room resRoom = new Hotels.Hotel.Rooms.Room();
						resRoom.setCode(roomId);
						resRoom.setName(roomTypeMap.get(roomId).getRoomType());
						resRoom.setSupplier("DESIA");
						
						Hotels.Hotel.Rooms.Room.Rate resRate = new Hotels.Hotel.Rooms.Room.Rate();
						resRate.setUniqueKey(rateId);
						resRate.setClazz("");
						resRate.setType(ratePlanMap.get(rateId).getRatePlanType());
						resRate.setAvailability("");
						resRate.setBoardName("");
						
						// always one rate element is returned
						resRate.setNet(net);
						
						resRoom.setRate(resRate);
						resRoomLst.add(resRoom);
						roomTypeIdMap.put(tempId, resRate);
					} else {
						roomTypeIdMap.get(tempId).setNet(roomTypeIdMap.get(tempId).getNet().add(net));
					}
					
					//Hotels.Hotel.Rooms.Room resRoom = new Hotels.Hotel.Rooms.Room();
//					resRoom.setCode(roomId);
//					resRoom.setName(roomTypeMap.get(roomId).getRoomType());
//					resRoom.setSupplier("DESIA");
					
//					Hotels.Hotel.Rooms.Room.Rate resRate = new Hotels.Hotel.Rooms.Room.Rate();
//					resRate.setUniqueKey(rateId);
//					resRate.setClazz("");
//					resRate.setType(ratePlanMap.get(rateId).getRatePlanType());
//					resRate.setAvailability("");
//					resRate.setBoardName("");
//					
//					String tempId = roomId + rateId;
//					BigDecimal net = new BigDecimal(0);
//					net.add(roomRate.getRates().getRate().get(0).getTPAExtensions().getRate().getBase().getAmountBeforeTax());
					
//					if (roomTypeIdMap.get(tempId) == null) {
//						// always one rate element is returned
//						resRate.setNet(net);
//						roomTypeIdMap.put(tempId, resRate);
//					} else {
//						roomTypeIdMap.get(tempId).getNet().add(net);
//					}
					
//					resRoom.setRate(resRate);
//					resRoomLst.add(resRoom);
					
				}
				resHotel.setRooms(resRooms);
				resHotelLst.add(resHotel);
			}
		}
		
		return hotels;
	}
	
	
	/** Not used. */
	private static BTNSearchResponse searchBeanResponseMapperTest(OTAHotelAvailRS otaHotelAvailRS) throws Exception {
		BTNSearchResponse btnSearchRS = new BTNSearchResponse();
		
		btnSearchRS.setTravelRequestID("");
		btnSearchRS.setServiceRequestID("");
		btnSearchRS.setOptionsCount(otaHotelAvailRS.getTPAExtensions().getHotelsInfo().getAvailable());
		
		/* don't know fro where to get this*/
		//hotelResponse.getCity().setCityCode(value);
		//hotelResponse.getCity().setCityName(value);
		
		List<OTAHotelAvailRS.RoomStays.RoomStay> roomStayLst = otaHotelAvailRS.getRoomStays().getRoomStay();
		BTNSearchResponse.HotelOptions resHotels = new BTNSearchResponse.HotelOptions();
		btnSearchRS.setHotelOptions(resHotels);
		List<BTNSearchResponse.HotelOptions.Hotel> resHotelLst = btnSearchRS.getHotelOptions().getHotel();
		
		int index = 0;
		for (RoomStay roomStay : roomStayLst) {
			/* Using fully qualified names in order to avoid confusion */
			BTNSearchResponse.HotelOptions.Hotel resHotel = new BTNSearchResponse.HotelOptions.Hotel();
			resHotel.setHotelCode(roomStay.getBasicPropertyInfo().getHotelCode());
			resHotel.setHotelName("");
			resHotel.setLocation("");
			resHotel.setSupplier("");
			resHotel.setStarRating("");
			resHotel.setMainImage("");
			resHotel.setFullAddress("");
			//resHotel.setLatitude("");//TODO: set these later
			//resHotel.setLongitude("");
			resHotel.setDescription("");
			resHotel.setRemarks("");
			resHotel.setEssentialInformation("");
			
			//List<String> btnHotelAmenityLst = btnHotel.getAmenities().getAmenity();
			/* loop through the amenities and add them to this list */
			
			
			resHotelLst.add(resHotel);
		}
		
		return btnSearchRS;
	}
	
	/** Not used. */
	private static Hotels getHotelsTest(OTAHotelAvailRS rs) {
		Hotels hotels = new Hotels();
		
		List<OTAHotelAvailRS.RoomStays.RoomStay> hotelLst = rs.getRoomStays().getRoomStay();
		
		if (hotelLst.size() != 0) {
			hotels.setOptionsCount(rs.getTPAExtensions().getHotelsInfo().getAvailable());
			
			/* Hotel list response */
			List<Hotels.Hotel> resHotelLst = hotels.getHotel();
			
			for (OTAHotelAvailRS.RoomStays.RoomStay hotel : hotelLst) {
				Hotels.Hotel resHotel = new Hotels.Hotel();
				resHotel.setSupplier("DESIA");	//TODO: hard coded
				resHotel.setHotelCode(hotel.getBasicPropertyInfo().getHotelCode());
				resHotel.setHotelName("");	//TODO: not available
				resHotel.setHotelZone("");
				resHotel.setDestinationCode("");
				resHotel.setDestinationName("");
				resHotel.setRating("");
				resHotel.setImageUrl("");
				resHotel.setDescription("");
				resHotel.setRemarks("");
				
				List<RoomTypeType> roomTypeLst = hotel.getRoomTypes().getRoomType();
				List<RatePlanType> rateTypeLst = hotel.getRatePlans().getRatePlan();
				
				List<RoomRate> roomRateLst = hotel.getRoomRates().getRoomRate();
				
				Map<String, RoomTypeType> roomTypeMap = new HashMap<>();
				Map<String, RatePlanType> ratePlanMap = new HashMap<>();
				
				List<Hotels.Hotel.Rooms.Room> resRoomLst = resHotel.getRooms().getRoom();
				
				for (RoomRate roomRate : roomRateLst) {
					String roomId = roomRate.getRoomID();
					String rateId = roomRate.getRatePlanCode();
					
					RoomTypeType roomTypeItem = roomTypeMap.get(rateId);
					RatePlanType ratePlanItem = ratePlanMap.get(roomId);
					
					if (roomTypeItem == null) {
						for (RoomTypeType tmpRoomType : roomTypeLst) {
							roomTypeMap.put(tmpRoomType.getRoomID(), tmpRoomType);
						}
					} 
					if (ratePlanItem == null) {
						for (RatePlanType tmpRatePlan : rateTypeLst) {
							ratePlanMap.put(tmpRatePlan.getRatePlanCode(), tmpRatePlan);
						}
					}
					
					Hotels.Hotel.Rooms.Room resRoom = new Hotels.Hotel.Rooms.Room();
					resRoom.setCode(roomId);
					resRoom.setName(roomTypeMap.get(roomId).getRoomType());
					resRoom.setSupplier("DESIA");
					
					Hotels.Hotel.Rooms.Room.Rate resRate = new Hotels.Hotel.Rooms.Room.Rate();
					resRate.setUniqueKey(rateId);
					resRate.setClazz("");
					resRate.setType(ratePlanMap.get(rateId).getRatePlanType());
					resRate.setAvailability("");
					resRate.setBoardName("");
					//resRate.setNet();
					
					resRoom.setRate(resRate);
					resRoomLst.add(resRoom);
				}
				resHotelLst.add(resHotel);
			}
		}
		
		return hotels;
	}
	
	/** Not used. */
	private static BTNSearchResponse getSearchResponse(Hotels hotels) {
		BTNSearchResponse searchRespBean = new BTNSearchResponse();
		
		searchRespBean.setTravelRequestID("");
		searchRespBean.setServiceRequestID("");
		searchRespBean.setOptionsCount(hotels.getOptionsCount());
		//searchRespBean.setCurrency("");
		//searchRespBean.setCity("");

		List<BTNSearchResponse.HotelOptions.Hotel> resHotelLst = searchRespBean.getHotelOptions().getHotel();
		List<Hotels.Hotel> hotelLst = hotels.getHotel();
		for (Hotels.Hotel hotel : hotelLst) {
			BTNSearchResponse.HotelOptions.Hotel resHotel = new BTNSearchResponse.HotelOptions.Hotel();
			resHotel.setHotelCode(hotel.getHotelCode());
			resHotel.setHotelName(hotel.getHotelName());
			resHotel.setLocation(hotel.getHotelZone());
			resHotel.setSupplier(hotel.getSupplier());//make this the first element
			resHotel.setStarRating(hotel.getRating());//change this name
			resHotel.setMainImage(hotel.getImageUrl());
			resHotel.setImageCount(0);// check if this is still required
			resHotel.setFullAddress("");//not present in the response
			//not setting longitude and latitude. check
			resHotel.setDescription(hotel.getDescription());
			resHotel.setRemarks(hotel.getRemarks());
			resHotel.setEssentialInformation("");//not there in the request
			
			List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room> resRoomLst = resHotel.getRoomOptions().getRoom();
			List<Hotels.Hotel.Rooms.Room> roomLst = hotel.getRooms().getRoom();
			for (Hotels.Hotel.Rooms.Room room : roomLst) {
				BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room resRoom = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room();
				//resRoom.
				
				//resRoomLst.add(resRoom);
			}
			
			resHotelLst.add(resHotel);
		}
		
		return searchRespBean;
	}
	
	/* For Testing */
	public static void call(/*String xml*/) throws Exception {
		//Request preparation
		OTAHotelAvailRQ otaHotelAvailRQ = new OTAHotelAvailRQ();
		otaHotelAvailRQ.setRequestedCurrency("INR");
		otaHotelAvailRQ.setSortOrder("TG_RANKING");
		otaHotelAvailRQ.setPrimaryLangID("en");
		otaHotelAvailRQ.setVersion(new BigDecimal(0.0));
		otaHotelAvailRQ.setSearchCacheLevel("VeryRecent");

		AvailRequestSegments reqSgmnts = new AvailRequestSegments();
		List<AvailRequestSegment> reqSgmntLst = reqSgmnts.getAvailRequestSegment();
		AvailRequestSegment reqSgmnt = new AvailRequestSegment();

		HotelSearchCriteria searchCriteria = new HotelSearchCriteria();
		List<Criterion> criterionLst = searchCriteria.getCriterion();
		
		Criterion tmpCriterion = new Criterion();
		Address address = new Address();
		address.setCityName("Del");
		
		CountryNameType c = new CountryNameType();
		c.setCode("India");
		address.setCountryName(c);
		
		DateTimeSpanType dateRange = new DateTimeSpanType();
		dateRange.setStart("2016-06-11");
		dateRange.setEnd("2016-06-12");
		
		RoomStayCandidates roomStayCandidates = new RoomStayCandidates();
		List<RoomStayCandidateType> roomStayCandidateLst = roomStayCandidates.getRoomStayCandidate();
		RoomStayCandidateType candidateType = new RoomStayCandidateType();
		
		GuestCountType guestCounts = new GuestCountType();
		List<GuestCount> guestCountLst = guestCounts.getGuestCount();
		
		GuestCount guestOne = new GuestCount();
		guestOne.setAgeQualifyingCode("10");
		GuestCount guestTwo = new GuestCount();
		guestTwo.setAge(10);guestTwo.setAgeQualifyingCode("8");
		
		TPAExtensionsType extnsn = new TPAExtensionsType();
		Pagination pagination = new Pagination();
		pagination.setEnabled(true);
		pagination.setHotelsFrom(2);
		pagination.setHotelsTo(5);
		
		UserAuthentication userAuth = new UserAuthentication();
		userAuth.setUsername("bontonnet");userAuth.setPassword("test@567");userAuth.setPropertyId("1300001210");
		
		extnsn.setUserAuthentication(userAuth);
		extnsn.setPagination(pagination);
		tmpCriterion.setTPAExtensions(extnsn);
		
		guestCountLst.add(guestOne);
		guestCountLst.add(guestTwo);
		
		candidateType.setGuestCounts(guestCounts);
		roomStayCandidateLst.add(candidateType);
		
		tmpCriterion.setRoomStayCandidates(roomStayCandidates);
		tmpCriterion.setStayDateRange(dateRange);
		tmpCriterion.setAddress(address);
		
		criterionLst.add(tmpCriterion);
		
		reqSgmnt.setHotelSearchCriteria(searchCriteria);
		reqSgmntLst.add(reqSgmnt);
		
		otaHotelAvailRQ.setAvailRequestSegments(reqSgmnts);
		
		TGServiceEndPointImplService sib = new TGServiceEndPointImplService();
		sib.setHandlerResolver(new HandlerResolver() {

			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				List<Handler> handler = new LinkedList<>();
				handler.add(new MessageHandler());
				return handler;
			}});
		TGServiceEndPoint sei = (TGServiceEndPoint) sib.getTGServiceEndPointImplPort();
		
		OTAHotelAvailRS otaHotelAvailRs =  sei.fetchResponse(otaHotelAvailRQ);
		forRead(otaHotelAvailRs);
	}
	
	/* For testing */
	private static void forRead(OTAHotelAvailRS otaHotelAvailRs) throws Exception {
		BTNSearchResponse hotelResponse = new BTNSearchResponse();
		
		hotelResponse.setTravelRequestID("");
		hotelResponse.setServiceRequestID("");
		hotelResponse.setOptionsCount(otaHotelAvailRs.getTPAExtensions().getHotelsInfo().getAvailable());
		
		/* don't know fro where to get this*/
		//hotelResponse.getCity().setCityCode(value);
		//hotelResponse.getCity().setCityName(value);
		
		List<OTAHotelAvailRS.RoomStays.RoomStay> roomStayLst = otaHotelAvailRs.getRoomStays().getRoomStay();
		BTNSearchResponse.HotelOptions hotelOptions = new BTNSearchResponse.HotelOptions();
		hotelResponse.setHotelOptions(hotelOptions);
		List<BTNSearchResponse.HotelOptions.Hotel> btnHotelLst = hotelResponse.getHotelOptions().getHotel();
		
		int index = 0;
		for (RoomStay roomStay : roomStayLst) {
			/* Using fully qualified names in order to avoid confusion */
			BTNSearchResponse.HotelOptions.Hotel btnHotel = new BTNSearchResponse.HotelOptions.Hotel();
			btnHotel.setHotelCode(roomStay.getBasicPropertyInfo().getHotelCode());
			btnHotel.setHotelName("");
			btnHotel.setLocation("");
			btnHotel.setSupplier("");
			btnHotel.setStarRating("");
			btnHotel.setMainImage("");
			btnHotel.setFullAddress("");
			//btnHotel.setLatitude("");//TODO: set these later
			//btnHotel.setLongitude("");
			btnHotel.setDescription("");
			btnHotel.setRemarks("");
			btnHotel.setEssentialInformation("");
			
			//List<String> btnHotelAmenityLst = btnHotel.getAmenities().getAmenity();
			/* loop through the amenities and add them to this list */
			
			
			btnHotelLst.add(btnHotel);
		}
		
		OutputStream os = new FileOutputStream(new File("SearchResponse.xml"));
		JAXBContext ctx = JAXBContext.newInstance("com.desia.jaxbartifacts");
		Marshaller m = ctx.createMarshaller();
		
		m.marshal(hotelResponse, os);
	}
}
