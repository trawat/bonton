package com.desia.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.processor.XmlProcessor;
import com.desia.artifacts.search.AvailRequestSegmentsType.AvailRequestSegment;
import com.desia.artifacts.search.AvailRequestSegmentsType.AvailRequestSegment.HotelSearchCriteria;
import com.desia.artifacts.search.BasicPropertyInfoType;
import com.desia.artifacts.search.CountryNameType;
import com.desia.artifacts.search.DateTimeSpanType;
import com.desia.artifacts.search.ErrorType;
import com.desia.artifacts.search.GuestCountType;
import com.desia.artifacts.search.HotelSearchCriteriaType.Criterion;
import com.desia.artifacts.search.HotelSearchCriterionType;
import com.desia.artifacts.search.ItemSearchCriterionType;
import com.desia.artifacts.search.ItemSearchCriterionType.Address;
import com.desia.artifacts.search.ItemSearchCriterionType.HotelRef;
import com.desia.artifacts.search.OTAHotelAvailRQ;
import com.desia.artifacts.search.OTAHotelAvailRQ.AvailRequestSegments;
import com.desia.artifacts.search.OTAHotelAvailRS;
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
	
	private static final String DFLTHOLDVALUE = "15";
	private static final String DFLTRCMNDVALUE = "0";
	private static final String DFLTCTRYVALUE = "India";
	
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
		otaHotelAvailRQ.setRequestedCurrency(DesiaProperties.CURRENCY);//Hard coding the currrency

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
		if (btnItemDestination != null 
				&& !DesiaProperties.EMPTY.equals(btnItemDestination.getDestinationCode().trim())) {
			Address address = new Address();
			address.setCityName(btnItemDestination.getDestinationCode());

			CountryNameType otaCountryNameType = new CountryNameType();
			/** we need to have this always set to India */
			//btnSearchRequest.getRequestDetails().getSearchHotelPriceRequest().getItemDestination().getDestinationType();
			otaCountryNameType.setCode(DFLTCTRYVALUE);
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
			otaGuestAdultCount.setAgeQualifyingCode(DesiaProperties.ADULTAGECD);
			otaGuestAdultCount.setCount(adultCount);
			otaGuestCountLst.add(otaGuestAdultCount);
			
			List<BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room.Occupant> btnOccupantLst = btnRoom.getOccupant();
			for (BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room.Occupant btnOccupant : btnOccupantLst) {
				if (btnOccupant.getType().equalsIgnoreCase(DesiaProperties.CHILDCD)) {
					GuestCountType.GuestCount otaGuestChildCount = new GuestCountType.GuestCount();
					otaGuestChildCount.setAgeQualifyingCode(DesiaProperties.CHILDAGECD);
					otaGuestChildCount.setAge(btnOccupant.getAge());
					otaGuestChildCount.setCount(1);
					
					otaGuestCountLst.add(otaGuestChildCount);
				}
			}
			otaRoomLst.add(otaRoom);
		}
		
		TPAExtensionsType otaTPAExtensionsType = new TPAExtensionsType();
		UserAuthentication userAuth = new UserAuthentication();
		userAuth.setUsername(DesiaProperties.DUSERNAME);
		userAuth.setPassword(DesiaProperties.DPASSWORD);
		userAuth.setPropertyId(DesiaProperties.DPROPERTYID);
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

		
		btnSearchRS.setTravelRequestID(DesiaProperties.EMPTY);
		btnSearchRS.setServiceRequestID(DesiaProperties.EMPTY);
		
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
		
		List<OTAHotelAvailRS.RoomStays.RoomStay> otaHotelLst = otaHotelAvailRS.getRoomStays().getRoomStay();
		for (OTAHotelAvailRS.RoomStays.RoomStay otaHotel : otaHotelLst) {
			BTNSearchResponse.HotelOptions.Hotel btnHotel = new BTNSearchResponse.HotelOptions.Hotel();

			BasicPropertyInfoType otaBasicPropertyInfoType = otaHotel.getBasicPropertyInfo();
			btnHotel.setHotelCode(otaBasicPropertyInfoType.getHotelCode());
			btnHotel.setHotelName(fromStaticDump);
			btnHotel.setLocation(fromStaticDump);
			btnHotel.setSupplier(DesiaProperties.DESIA);
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
					btnRoom.setSupplier(DesiaProperties.DESIA);
					
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
					rateKey = rateKey.replaceAll(DesiaProperties.COMMA, DesiaProperties.SEP2);
					//btnRate.setRateKey(rtDateDetails.toString().concat(rateKey));
					btnRate.setRateKey(rateKey);
					
					btnRate.setSupplierPrice(amountAfterTax);
					btnRate.setOtaFee(0.0f);
					btnRate.setOtaDiscountAmount(0.0f);
					
					/** below setters are wrong */
					btnRate.setAdults(((RoomTypeType.Occupancy)roomTypeMap.get(otaRoomId).getOccupancy().get(0)).getMaxOccupancy());
					btnRate.setChildren(((RoomTypeType.Occupancy)roomTypeMap.get(otaRoomId).getOccupancy().get(1)).getMaxOccupancy());
					
					btnRate.setRecommended(DFLTRCMNDVALUE);
					btnRate.setHoldValue(DFLTHOLDVALUE);
					
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
					rateKey = rateKey.replaceAll(DesiaProperties.COMMA, DesiaProperties.SEP2);
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
