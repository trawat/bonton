package com.desia.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
import com.bonton.utility.processor.XmlProcessor;
import com.desia.artifacts.search.AvailRequestSegmentsType.AvailRequestSegment;
import com.desia.artifacts.search.AvailRequestSegmentsType.AvailRequestSegment.HotelSearchCriteria;
import com.desia.artifacts.search.BasicPropertyInfoType;
import com.desia.artifacts.search.CountryNameType;
import com.desia.artifacts.search.DateTimeSpanType;
import com.desia.artifacts.search.ErrorType;
import com.desia.artifacts.search.GuestCountType;
import com.desia.artifacts.search.GuestCountType.GuestCount;
import com.desia.artifacts.search.HotelSearchCriteriaType.Criterion;
import com.desia.artifacts.search.HotelSearchCriterionType;
import com.desia.artifacts.search.HotelSearchCriterionType.RoomStayCandidates;
import com.desia.artifacts.search.ItemSearchCriterionType;
import com.desia.artifacts.search.ItemSearchCriterionType.Address;
import com.desia.artifacts.search.ItemSearchCriterionType.HotelRef;
import com.desia.artifacts.search.OTAHotelAvailRQ;
import com.desia.artifacts.search.OTAHotelAvailRQ.AvailRequestSegments;
import com.desia.artifacts.search.OTAHotelAvailRS;
import com.desia.artifacts.search.OTAHotelAvailRS.RoomStays.RoomStay;
import com.desia.artifacts.search.Pagination;
import com.desia.artifacts.search.RatePlanType;
import com.desia.artifacts.search.RateType;
import com.desia.artifacts.search.RoomStayCandidateType;
import com.desia.artifacts.search.RoomStayType;
import com.desia.artifacts.search.RoomStayType.RoomRates.RoomRate;
import com.desia.artifacts.search.RoomTypeType;
import com.desia.artifacts.search.TGServiceEndPoint;
import com.desia.artifacts.search.TGServiceEndPointImplService;
import com.desia.artifacts.search.TPAExtensionsType;
import com.desia.artifacts.search.TPAExtensionsType.UserAuthentication;
import com.desia.handler.MessageHandler;
import com.desia.util.DesiaDBConnection;
import com.desia.util.DesiaProperties;

/**
 * Helper class - contains static methods for request and response mapping methods.
 * @author Tirath
 */
public class DesiaSearchServiceHelper {
	private static Logger logger = LoggerFactory.getLogger(DesiaSearchServiceHelper.class);
	
	private static final TGServiceEndPointImplService searchSIB = new TGServiceEndPointImplService();
	private static TGServiceEndPoint searchSEI = null;
	
	private static final ExecutorService desiaEs = Executors.newCachedThreadPool();
	
	/* Holds unique uuid and generated request-response list as key-value */
	private static final Map<String, List<? super Object>> reqResMap = new HashMap<>();
	
	private DesiaSearchServiceHelper() {}
	
	static {
		HandlerResolver handlerResolver = new HandlerResolver() {
			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				List<Handler> handler = new LinkedList<>();
				handler.add(new MessageHandler());
				return handler;
			}
		};
		searchSIB.setHandlerResolver(handlerResolver);//TODO: uncomment this later
		searchSEI = (TGServiceEndPoint) searchSIB.getTGServiceEndPointImplPort();
	}
	
	/**
	 * Used to map Bonton hotel availability RQ object to Desia API
	 * specific RQ object.
	 * @param btnSearchRQ Bonton specific search RQ object
	 * @param uuid Unique idenfier used to map RQ objects with their RS's.
	 * @return Desia specific hotel availability RQ object
	 * @author Tirath
	 */
	public static OTAHotelAvailRQ searchBeanRQMapper(BTNSearchRequest btnSearchRQ, String uuid) throws Exception {
		logger.info("desia search request mapping started ---->");

		/** Preparing request-response map for logging */
		List<? super Object> rqRsLst = new ArrayList<>();
		rqRsLst.add(btnSearchRQ);
		reqResMap.put(uuid, rqRsLst);
		
		OTAHotelAvailRQ otaHotelAvailRQ = new OTAHotelAvailRQ();
		otaHotelAvailRQ.setRequestedCurrency("INR");//Hard coding the currrency

		/** Bonton city or hotel search detail node */
		BTNSearchRequest.RequestDetails.SearchHotelPriceRequest btnHotelDetailRQNode =  btnSearchRQ.getRequestDetails().getSearchHotelPriceRequest();
		
		/* Award rating */
		String min = btnHotelDetailRQNode.getMinStarRating();
		String max = btnHotelDetailRQNode.getMaxStarRating();
		if (null != min && null != max) {
			otaHotelAvailRQ.setSortOrder("STAR_RATING_ASCENDING");
		} else {
			otaHotelAvailRQ.setSortOrder("TG_RANKING");
		}

		AvailRequestSegments reqSgmnts = new AvailRequestSegments();
		List<AvailRequestSegment> otaAvailRequestSegmentLst = reqSgmnts.getAvailRequestSegment();
		AvailRequestSegment otaAvailRequestSegment = new AvailRequestSegment();

		HotelSearchCriteria otaSearchCriteria = new HotelSearchCriteria();
//		otaSearchCriteria.setAvailableOnlyIndicator(true);
		List<Criterion> otaCriterionLst = otaSearchCriteria.getCriterion();

		Criterion otaCriterion = new Criterion();
//		otaCriterion.setExactMatch(true);
		List<ItemSearchCriterionType.HotelRef> otaHotelRefLst = otaCriterion.getHotelRef();
		
		/** In case ItemDestination node is present, search will be based on City, otherwise hotel code. 
		 * Also, in case of Desia - if item destination code is passed as "", Desia API returns some results
		 * and on the contrary HB API returns ZERO hotels in search result. */
		BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.ItemDestination btnItemDestination = btnHotelDetailRQNode.getItemDestination();
		if (btnItemDestination != null && !"".equals(btnItemDestination.getDestinationCode().trim())) {
			Address address = new Address();
			address.setCityName(btnItemDestination.getDestinationCode());

			CountryNameType otaCountryNameType = new CountryNameType();
			/** we need to have this always set to India */
			//btnSearchRequest.getRequestDetails().getSearchHotelPriceRequest().getItemDestination().getDestinationType();
			otaCountryNameType.setCode("India");
			address.setCountryName(otaCountryNameType);
			otaCriterion.setAddress(address);
		} else if (btnHotelDetailRQNode.getHotels() != null) {
			List<String> hotelCdLst = btnHotelDetailRQNode.getHotels().getHotel();
			for (String hotelCd : hotelCdLst) {
				HotelRef hotelRef = new HotelRef();
				hotelRef.setHotelCode(hotelCd);
				otaHotelRefLst.add(hotelRef);
			}
		}
		
		/** Set checkin and checkout date. */
		DateTimeSpanType otaDateTimeSpanType = new DateTimeSpanType();
		otaDateTimeSpanType.setStart(btnHotelDetailRQNode.getPeriodOfStay().getCheckInDate().toString());
		otaDateTimeSpanType.setEnd(btnHotelDetailRQNode.getPeriodOfStay().getCheckOutDate().toString());

		/** Set occupancy data from the BTN request. */
		otaCriterion.setRoomStayCandidates(new HotelSearchCriterionType.RoomStayCandidates());
		HotelSearchCriterionType.RoomStayCandidates otaRooms = otaCriterion.getRoomStayCandidates();
		List<RoomStayCandidateType> otaRoomLst = otaRooms.getRoomStayCandidate();
		List<BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room> btnRoomLst = btnHotelDetailRQNode.getRooms().getRoom();
		for (BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room btnRoom : btnRoomLst) {
			RoomStayCandidateType otaRoom = new RoomStayCandidateType();
			otaRoom.setGuestCounts(new GuestCountType());
			GuestCountType otaGuestCountType = otaRoom.getGuestCounts();
			List<GuestCountType.GuestCount> otaGuestCountLst = otaGuestCountType.getGuestCount();
			
			
			/** Setting the available adults distribution. */
			int adultCount = btnRoom.getAdults();
			GuestCountType.GuestCount otaGuestAdultCount = new GuestCountType.GuestCount();
			otaGuestAdultCount.setAgeQualifyingCode("10");
			otaGuestAdultCount.setCount(adultCount);
			otaGuestCountLst.add(otaGuestAdultCount);
			
			List<BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room.Occupant> btnOccupantLst = btnRoom.getOccupant();
			for (BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room.Occupant btnOccupant : btnOccupantLst) {
				if (btnOccupant.getType().equalsIgnoreCase("CH")) {
					GuestCountType.GuestCount otaGuestChildCount = new GuestCountType.GuestCount();
					otaGuestChildCount.setAgeQualifyingCode("8");
					otaGuestChildCount.setAge(btnOccupant.getAge());
					otaGuestChildCount.setCount(1);
					
					otaGuestCountLst.add(otaGuestChildCount);
				}
			}
			otaRoomLst.add(otaRoom);
		}
		
		TPAExtensionsType otaTPAExtensionsType = new TPAExtensionsType();
		UserAuthentication userAuth = new UserAuthentication();
		userAuth.setUsername("bontonsell");userAuth.setPassword("test@789");userAuth.setPropertyId("1300001211");
		otaTPAExtensionsType.setUserAuthentication(userAuth);
		
		/** To fetch all the hotels instead of only 20 (default behavior) */
		Pagination otaPagination = new Pagination();
		otaPagination.setEnabled(false);
		
		otaTPAExtensionsType.setPagination(otaPagination);
		otaCriterion.setTPAExtensions(otaTPAExtensionsType);
		otaCriterion.setStayDateRange(otaDateTimeSpanType);
		otaCriterionLst.add(otaCriterion);
	
		
		
		otaAvailRequestSegment.setHotelSearchCriteria(otaSearchCriteria);
		otaAvailRequestSegmentLst.add(otaAvailRequestSegment);

		otaHotelAvailRQ.setAvailRequestSegments(reqSgmnts);

		/** Adding Desia search booking RQ for logging */
		rqRsLst.add(otaHotelAvailRQ);
		
		logger.info("desia search request mapping done ---->");
		return otaHotelAvailRQ;
	}
	
	/**
	 * Used to map the Desia availability response to Bonton response.
	 * @param otaHotelAvailRS Hotel availability RS object returned by Desia API
	 * @param uuid Unique idenfier used to map RQ objects with their RS's.
	 * @return BTNSearchResponse Bonton specific RS object after mapping
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static BTNSearchResponse searchBeanRSMapper(OTAHotelAvailRS otaHotelAvailRS, String uuid) throws Exception {
		logger.info("desia search response mapping started ---->");
		
		/** Adding Desia search booking response for logging */
		reqResMap.get(uuid).add(otaHotelAvailRS);
		
		BTNSearchResponse btnSearchRS = new BTNSearchResponse();
		
		if (otaHotelAvailRS.getErrors() != null) {
			BTNSearchResponse.BTNError errElmnt = new BTNSearchResponse.BTNError();
			
			List<ErrorType> otaErrorLst = otaHotelAvailRS.getErrors().getError();
			StringBuilder errCode = new StringBuilder();
			StringBuilder errMsg = new StringBuilder();
			for (ErrorType otaErrorType : otaErrorLst) {
				if (errCode.length() != 0) {
					errCode.append(DesiaProperties.SEP2);
					errMsg.append(DesiaProperties.SEP2);
				}
				errCode.append(otaErrorType.getCode());
				errMsg.append(otaErrorType.getShortText());
				
			}
			errElmnt.setCode(errCode.toString());
			errElmnt.setMessage(errMsg.toString());

			btnSearchRS.setBTNError(errElmnt);
			
			/** Adding Desia search booking response for logging */
			reqResMap.get(uuid).add(btnSearchRS);
			
			logger.info("desia search response contains error. Returning ---->");
			return btnSearchRS;
		}

		
		btnSearchRS.setTravelRequestID("");
		btnSearchRS.setServiceRequestID("");
		
		/** Setting the available no of hotels differently for City and Hotel search */
		if (otaHotelAvailRS.getTPAExtensions() != null && otaHotelAvailRS.getTPAExtensions().getHotelsInfo() != null) {
			btnSearchRS.setOptionsCount(otaHotelAvailRS.getTPAExtensions().getHotelsInfo().getAvailable());
		}
		
		String fromStaticDump = "fromstaticdump";
		BTNSearchResponse.City btnCity = new BTNSearchResponse.City();
		btnCity.setCityCode(fromStaticDump);//from dump
		btnCity.setCityName(fromStaticDump);//from dump
		btnSearchRS.setCity(btnCity);
		
		BTNSearchResponse.HotelOptions btnHotels = new BTNSearchResponse.HotelOptions();
		btnSearchRS.setHotelOptions(btnHotels);
		List<BTNSearchResponse.HotelOptions.Hotel> btnHotelLst = btnHotels.getHotel();
		
		/** Hard coding checkin and checkout date for now */
		//UI is expected to share checkin and checkout details
		/*String checkin = "29-07-2016";
		String checkout = "30-07-2016";
		StringBuilder rtDateDetails = new StringBuilder();
		rtDateDetails.append(checkin);rtDateDetails.append(DesiaProperties.SEP2);
		rtDateDetails.append(checkout);rtDateDetails.append(DesiaProperties.SEP2);
		*/
		
		List<OTAHotelAvailRS.RoomStays.RoomStay> otaHotelLst = otaHotelAvailRS.getRoomStays().getRoomStay();
		for (OTAHotelAvailRS.RoomStays.RoomStay otaHotel : otaHotelLst) {
			BTNSearchResponse.HotelOptions.Hotel btnHotel = new BTNSearchResponse.HotelOptions.Hotel();

			BasicPropertyInfoType otaBasicPropertyInfoType = otaHotel.getBasicPropertyInfo();
			btnHotel.setHotelCode(otaBasicPropertyInfoType.getHotelCode());
			btnHotel.setHotelName(fromStaticDump);
			btnHotel.setLocation(fromStaticDump);
			btnHotel.setSupplier("Desia");
			btnHotel.setStarRating(fromStaticDump);
			btnHotel.setMainImage(fromStaticDump);
			btnHotel.setFullAddress(fromStaticDump);
			btnHotel.setLatitude(0.0f);//TODO: set these later
			btnHotel.setLongitude(0.0f);
			btnHotel.setDescription(fromStaticDump);
			btnHotel.setRemarks(fromStaticDump);
			btnHotel.setEssentialInformation(fromStaticDump);
			
			StringBuilder hotelDetails = new StringBuilder();
			hotelDetails.append(otaBasicPropertyInfoType.getHotelCode());hotelDetails.append(DesiaProperties.SEP2);
			
			List<RoomTypeType> roomTypeLst = otaHotel.getRoomTypes().getRoomType();
			List<RatePlanType> rateTypeLst = otaHotel.getRatePlans().getRatePlan();
			
			List<RoomRate> roomRateLst = otaHotel.getRoomRates().getRoomRate();
			
			Map<String, RoomTypeType> roomTypeMap = new HashMap<>();
			Map<String, RatePlanType> ratePlanMap = new HashMap<>();
			
			/* Populating values in map types */ 
			for (RoomTypeType tmpRoomType : roomTypeLst) {
				roomTypeMap.put(tmpRoomType.getRoomTypeCode(), tmpRoomType);
			}
			
			for (RatePlanType tmpRatePlan : rateTypeLst) {
				ratePlanMap.put(tmpRatePlan.getRatePlanCode(), tmpRatePlan);
			}
			
			BTNSearchResponse.HotelOptions.Hotel.RoomOptions btnRoomOptions = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions();
			btnHotel.setRoomOptions(btnRoomOptions);
			List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room> btnRoomLst = btnRoomOptions.getRoom();
			
			List<RoomStayType.RoomRates.RoomRate> otaRoomRateLst = otaHotel.getRoomRates().getRoomRate();
			
			Map<String, BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room> roomRateMap = new HashMap<>();
			
			/** To keep track of Amount before tax and tax amount associated with a rate node. */
			Map<String, List<String>> roomRateAmtMap = new HashMap<>();
			
			for (RoomStayType.RoomRates.RoomRate otaRoomRate : otaRoomRateLst) {
				String otaRoomId = otaRoomRate.getRoomID();
				String otaRatePlanId = otaRoomRate.getRatePlanCode();
				String mapId = otaRoomId.concat(otaRatePlanId);
				
				BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room btnRoom = roomRateMap.get(mapId);
				if (btnRoom == null) {
					btnRoom = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room();
					btnRoom.setRoomType(roomTypeMap.get(otaRoomId).getRoomType());
					btnRoom.setSupplier("DESIA");
					
					/** Add room to room list only when a new room is created */
					btnRoomLst.add(btnRoom);
					roomRateMap.put(mapId, btnRoom);
				}
				
				/** Their will always be one rate key for a room which we prepare while preparing this response */
				List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate> btnRateLst = btnRoom.getRate();
				BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate btnRate = null;
				if (btnRateLst.size() == 0) {
					/** For rate key preparation. Indexes should not be changed.
					 * Otherwise, change the logic of fetching and resetting rate key
					 * components in the else block. */
					List<String> rateKeyItemLst = new ArrayList<>();
					rateKeyItemLst.add(btnHotel.getHotelCode());	//0
					rateKeyItemLst.add(otaRoomId);					//1
					rateKeyItemLst.add(otaRatePlanId);				//2
					
					Float amountBeforeTax = ((RateType.Rate) otaRoomRate.getRates().getRate().get(0)).getBase().getAmountBeforeTax().floatValue();
					Float taxAmount = ((RateType.Rate)otaRoomRate.getRates().getRate().get(0)).getBase().getTaxes().getAmount().floatValue();
					float amountAfterTax = amountBeforeTax + taxAmount;
					
					rateKeyItemLst.add(amountBeforeTax.toString());	//3
					rateKeyItemLst.add(taxAmount.toString());		//4
					roomRateAmtMap.put(mapId, rateKeyItemLst);
					
					btnRate = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate();
					btnRate.setPackaging("false");
					btnRate.setMealCode("mealcode");
					btnRate.setMealCode("mealcode");
					
					/** Setting the prepared rate key */
					String rateKey = rateKeyItemLst.toString();
					rateKey = rateKey.substring(1, rateKey.length() - 1);
					rateKey = rateKey.replaceAll(",", "|");
					//btnRate.setRateKey(rtDateDetails.toString().concat(rateKey));
					btnRate.setRateKey(rateKey);
					
					btnRate.setSupplierPrice(amountAfterTax);
					btnRate.setOtaFee(0.0f);
					btnRate.setOtaDiscountAmount(0.0f);
					
					/** below setters are wrong */
					btnRate.setAdults(((RoomTypeType.Occupancy)roomTypeMap.get(otaRoomId).getOccupancy().get(0)).getMaxOccupancy());
					btnRate.setChildren(((RoomTypeType.Occupancy)roomTypeMap.get(otaRoomId).getOccupancy().get(1)).getMaxOccupancy());
					
					btnRate.setRecommended("0");
					btnRate.setHoldValue("15");
					
					BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates btnDailyRates = 
							new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates();
					List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate> btnDailyRateLst = btnDailyRates.getDailyRate();
					BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate btnDailyRate = 
							new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate();
					
					btnDailyRate.setDailySellingRate(amountBeforeTax);
					btnDailyRate.setDailyNet(amountAfterTax);
					btnDailyRateLst.add(btnDailyRate);
					
					btnRate.setDailyRates(btnDailyRates);
					btnRateLst.add(btnRate);
				} else {
					/** As there's always going to be only one rate key associated with a room */
					btnRate = btnRateLst.get(0);
					
					/** For rate key modification */
					List<String> rateKeyItemLst = roomRateAmtMap.get(mapId);
					
					Float amountBeforeTax = ((RateType.Rate) otaRoomRate.getRates().getRate().get(0)).getBase().getAmountBeforeTax().floatValue();
					Float taxAmount = ((RateType.Rate)otaRoomRate.getRates().getRate().get(0)).getBase().getTaxes().getAmount().floatValue();
					float amountAfterTax = amountBeforeTax + taxAmount;
					
					btnRate.setSupplierPrice(btnRate.getSupplierPrice() + amountAfterTax);
					
					BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate btnDailyRate = 
							new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate();
					
					btnDailyRate.setDailySellingRate(amountBeforeTax);
					btnDailyRate.setDailyNet(amountAfterTax);
					
					/** Adding amounts from new room rate node to the existing one */
					amountBeforeTax = amountBeforeTax + new Float(rateKeyItemLst.get(3)).floatValue();
					taxAmount = taxAmount + new Float(rateKeyItemLst.get(4)).floatValue();
					
					rateKeyItemLst.set(3, amountBeforeTax.toString());
					rateKeyItemLst.set(4, taxAmount.toString());
					
					/** Setting the prepared rate key */
					String rateKey = rateKeyItemLst.toString();
					rateKey = rateKey.substring(1, rateKey.length() - 1);
					rateKey = rateKey.replaceAll(",", "|");
					//btnRate.setRateKey(rtDateDetails.toString().concat(rateKey));
					btnRate.setRateKey(rateKey);
					
					btnRate.getDailyRates().getDailyRate().add(btnDailyRate);
				}
			}
			btnHotelLst.add(btnHotel);
		}		
		
		/** Adding bonton search booking response for logging */
		reqResMap.get(uuid).add(btnSearchRS);
		
		logger.info("desia search response mapping done ---->");
		return btnSearchRS;
	}
	
	
	
	public static OTAHotelAvailRS sendSearchRQ(OTAHotelAvailRQ otaHotelAvailRQ) throws Exception {
		return searchSEI.fetchResponse(otaHotelAvailRQ);
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
//				resHotel.setHotelName("");//From static dump
//				resHotel.setHotelZone("");
//				resHotel.setDestinationCode("");
//				resHotel.setDestinationName("");
//				resHotel.setRating("");//from dump
//				resHotel.setImageUrl("");//from dump
//				resHotel.setDescription("");//dump
//				resHotel.setRemarks("");
				
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
//					net = net.add(roomRate.getRates().getRate().get(0).getTPAExtensions().getRate().getBase().getAmountBeforeTax());
					
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
	public static void logReqRes(String uuid, String op, String supplier) throws Exception {
		desiaEs.submit(new Runnable() {

			@Override
			public void run() {
				logger.info("desia RQ-RS logging for {} operation id {} started --->", op, uuid);
				
				List<? super Object> reqResLst = reqResMap.get(uuid);
				try {
					switch (op) {
					case DesiaProperties.SEARCH:
						DesiaDBConnection.insert(op, 
								XmlProcessor.getBeanInXml((BTNSearchRequest) reqResLst.get(0)),
								XmlProcessor.getBeanInXml((OTAHotelAvailRQ) reqResLst.get(1)),
								XmlProcessor.getBeanInXml((OTAHotelAvailRS) reqResLst.get(2)),
								XmlProcessor.getBeanInXml((BTNSearchResponse) reqResLst.get(3)), 
								supplier);
						break;
					}
				} catch (Exception e) {
					logger.error("Exception occured while logging {} request and responses in the DB {}", op, e);
				}
				/** Remove the entry once we are done logging in DB */
				reqResMap.remove(uuid);
				
				logger.info("desia RQ-RS logging for {} operation id {} completed --->", op, uuid);
			}});
	}
}
