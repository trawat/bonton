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

import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.desia.Hotels;
import com.desia.artifacts.AvailRequestSegmentsType.AvailRequestSegment;
import com.desia.artifacts.AvailRequestSegmentsType.AvailRequestSegment.HotelSearchCriteria;
import com.desia.artifacts.CountryNameType;
import com.desia.artifacts.DateTimeSpanType;
import com.desia.artifacts.GuestCountType.GuestCount;
import com.desia.artifacts.HotelSearchCriteriaType.Criterion;
import com.desia.artifacts.HotelSearchCriterionType.RoomStayCandidates;
import com.desia.artifacts.ItemSearchCriterionType.Address;
import com.desia.artifacts.OTAHotelAvailRQ;
import com.desia.artifacts.OTAHotelAvailRQ.AvailRequestSegments;
import com.desia.artifacts.OTAHotelAvailRS.RoomStays.RoomStay;
import com.desia.artifacts.OTAHotelAvailRS;
import com.desia.artifacts.RatePlanType;
import com.desia.artifacts.RoomStayType.RoomRates.RoomRate;
import com.desia.artifacts.GuestCountType;
import com.desia.artifacts.Pagination;
import com.desia.artifacts.RoomStayCandidateType;
import com.desia.artifacts.RoomTypeType;
import com.desia.artifacts.TGServiceEndPoint;
import com.desia.artifacts.TGServiceEndPointImplService;
import com.desia.artifacts.TPAExtensionsType;
import com.desia.artifacts.TPAExtensionsType.UserAuthentication;
import com.desia.handler.MessageHandler;

public class DesiaServiceHelper {
	private static Logger logger = LoggerFactory.getLogger(DesiaServiceHelper.class); 

	public DesiaServiceHelper() {}
	
	public OTAHotelAvailRQ searchBeanRequestMapper(BTNSearchRequest btnSearchRequest) {
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
		dateRange.setStart(btnSearchRequest.getRequestDetails().getSearchHotelPriceRequest().getPeriodOfStay().getCheckInDate());
		dateRange.setEnd(btnSearchRequest.getRequestDetails().getSearchHotelPriceRequest().getPeriodOfStay().getCheckOutDate());

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
	
	public BTNSearchResponse searchBeanResponseMapper(OTAHotelAvailRS otaHotelAvailRS) throws Exception {
		BTNSearchResponse btnSearchResponse = new BTNSearchResponse();
		
		/** do the appropriate mapping*/
		
		return btnSearchResponse;
	}
	
	public OTAHotelAvailRS sendSearchRequest(OTAHotelAvailRQ otaHotelAvailRQ) throws Exception {
		TGServiceEndPointImplService sib = new TGServiceEndPointImplService();
		sib.setHandlerResolver(new HandlerResolver() {

			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				List<Handler> handler = new LinkedList<>();
				handler.add(new MessageHandler());
				return handler;
			}});
		TGServiceEndPoint sei = (TGServiceEndPoint) sib.getTGServiceEndPointImplPort();

		return sei.fetchResponse(otaHotelAvailRQ);
	}
	
	private static Hotels getReponseInAggregationFormat(OTAHotelAvailRS rs) {
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
					resRate.setNet(0.0f);
					
					resRoom.setRate(resRate);
					resRoomLst.add(resRoom);
				}
				resHotelLst.add(resHotel);
			}
		}
		
		return hotels;
	}
	
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
	public static void forRead(OTAHotelAvailRS otaHotelAvailRs) throws Exception {
		BTNSearchResponse hotelResponse = new BTNSearchResponse();
		
		hotelResponse.setTravelRequestID("");
		hotelResponse.setServiceRequestID("");
		hotelResponse.setOptionsCount(otaHotelAvailRs.getTPAExtensions().getHotelsInfo().getTotal());
		hotelResponse.setMOptionsCount(otaHotelAvailRs.getTPAExtensions().getHotelsInfo().getTotal());
		
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
			btnHotel.setLatitude("");
			btnHotel.setLongitude("");
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
