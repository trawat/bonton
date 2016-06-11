package com.desia.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.artifacts.BTNSearchResponse.HotelOptions;
import com.bonton.utility.desia.Hotels;
import com.desia.artifacts.AvailRequestSegmentsType.AvailRequestSegment;
import com.desia.artifacts.AvailRequestSegmentsType.AvailRequestSegment.HotelSearchCriteria;
import com.desia.artifacts.CountryNameType;
import com.desia.artifacts.DateTimeSpanType;
import com.desia.artifacts.GuestCountType;
import com.desia.artifacts.GuestCountType.GuestCount;
import com.desia.artifacts.HotelSearchCriteriaType.Criterion;
import com.desia.artifacts.HotelSearchCriterionType.RoomStayCandidates;
import com.desia.artifacts.ItemSearchCriterionType.Address;
import com.desia.artifacts.OTAHotelAvailRQ;
import com.desia.artifacts.OTAHotelAvailRQ.AvailRequestSegments;
import com.desia.artifacts.OTAHotelAvailRS;
import com.desia.artifacts.OTAHotelAvailRS.RoomStays.RoomStay;
import com.desia.artifacts.Pagination;
import com.desia.artifacts.RoomStayCandidateType;
import com.desia.artifacts.TGServiceEndPoint;
import com.desia.artifacts.TGServiceEndPointImplService;
import com.desia.artifacts.TPAExtensionsType;
import com.desia.artifacts.TPAExtensionsType.UserAuthentication;
import com.desia.handler.MessageHandler;

public class DesiaService {
	
	public String search(BTNSearchRequest searchBean, String requestId) throws Exception {
		OTAHotelAvailRS otaHotelAvailRs = call(searchBean);
		Hotels hotels = DesiaDataProcessor.getHBDataReponseInAggregationFormat(otaHotelAvailRs);
		getSearchResponse(hotels);
		
		return null;
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
	public static void main(String...a) throws Exception {
		InputStream is = new FileInputStream(new File("SearchRequest.xml"));
		JAXBContext ctx = JAXBContext.newInstance("com.desia.jaxbartifacts");
		Unmarshaller u = ctx.createUnmarshaller();
		
		BTNSearchRequest btnSearchRequest = (BTNSearchRequest) u.unmarshal(is);
		//BTNSearchRequest btnSearchRequest = element.getValue();
		call(btnSearchRequest);
	}
	public static OTAHotelAvailRS call(BTNSearchRequest  btnSearchRequest) throws Exception {
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
		return otaHotelAvailRs;
		//forRead(otaHotelAvailRs);
	}
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
