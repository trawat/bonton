package com.desia.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNRepriceResponse;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.processor.XmlProcessor;
import com.desia.artifacts.search.AdditionalGuestAmountType;
import com.desia.artifacts.search.AmountType;
import com.desia.artifacts.search.AvailRequestSegmentsType.AvailRequestSegment;
import com.desia.artifacts.search.AvailRequestSegmentsType.AvailRequestSegment.HotelSearchCriteria;
import com.desia.artifacts.search.BasicPropertyInfoType;
import com.desia.artifacts.search.CountryNameType;
import com.desia.artifacts.search.DateTimeSpanType;
import com.desia.artifacts.search.ErrorType;
import com.desia.artifacts.search.FormattedTextTextType;
import com.desia.artifacts.search.GuestCountType;
import com.desia.artifacts.search.HotelSearchCriteriaType.Criterion;
import com.desia.artifacts.search.HotelSearchCriterionType;
import com.desia.artifacts.search.HotelSearchCriterionType.Award;
import com.desia.artifacts.search.HotelSearchCriterionType.RateRange;
import com.desia.artifacts.search.ItemSearchCriterionType;
import com.desia.artifacts.search.ItemSearchCriterionType.Address;
import com.desia.artifacts.search.ItemSearchCriterionType.HotelRef;
import com.desia.artifacts.search.OTAHotelAvailRQ;
import com.desia.artifacts.search.OTAHotelAvailRQ.AvailRequestSegments;
import com.desia.artifacts.search.OTAHotelAvailRS;
import com.desia.artifacts.search.Pagination;
import com.desia.artifacts.search.ParagraphType;
import com.desia.artifacts.search.RatePlanType;
import com.desia.artifacts.search.RateType.Rate;
import com.desia.artifacts.search.RoomStayCandidateType;
import com.desia.artifacts.search.RoomStayType;
import com.desia.artifacts.search.RoomTypeType;
import com.desia.artifacts.search.TPAExtensionsType;
import com.desia.artifacts.search.TPAExtensionsType.UserAuthentication;
import com.desia.util.DesiaDBConnection;
import com.desia.util.DesiaProperties;

/**
 * Helper class - contains static methods for request and response mapping methods.
 * @author Tirath
 */
public class DesiaSearchServiceHelper {
	private static Logger logger = LoggerFactory.getLogger(DesiaSearchServiceHelper.class);
	
	private static final ExecutorService desiaEs = Executors.newCachedThreadPool();
	
	/** Holds unique uuid and generated request-response list as key-value. */
	private static final Map<String, List<? super Object>> reqResMap = new HashMap<>();
	
	private static final String DFLTHOLDVALUE = "15";
	private static final String DFLTRCMNDVALUE = "0";
	private static final String DFLTCTRYVALUE = "India";
	private static final String BASE = "Base";
	private static final String ADDTNLGSTAMT = "AdditionalGuestAmount";
	
	/** Holds unique uuid and passed check in, check out, hotel, room, rate ids and paxes combination. */
	private static final Map<String, String> rateKeyMap = new HashMap<>();
	
	private DesiaSearchServiceHelper() {
		/** Shouldn't be instantiated */
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
		
		AvailRequestSegments reqSgmnts = new AvailRequestSegments();
		List<AvailRequestSegment> otaAvailRequestSegmentLst = reqSgmnts.getAvailRequestSegment();
		AvailRequestSegment otaAvailRequestSegment = new AvailRequestSegment();

		HotelSearchCriteria otaSearchCriteria = new HotelSearchCriteria();
//		otaSearchCriteria.setAvailableOnlyIndicator(true);
		List<Criterion> otaCriterionLst = otaSearchCriteria.getCriterion();

		Criterion otaCriterion = new Criterion();
//		otaCriterion.setExactMatch(true);
		
		/* Award rating */
		List<Award> otaAwardLst = otaCriterion.getAward();
		Award otaAward = new Award();
		String min = btnHotelDetailRQNode.getMinStarRating();
		String max = btnHotelDetailRQNode.getMaxStarRating();
		
		if (null != max) {
			otaAward.setRating(max);
		} else if (null != min) {
			otaAward.setRating(min);
		}
		otaAwardLst.add(otaAward);
		
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
		
		/** Set check in and checkout date. */
		DateTimeSpanType otaDateTimeSpanType = new DateTimeSpanType();
		String checkInDate = btnHotelDetailRQNode.getPeriodOfStay().getCheckInDate().toString();
		String checkOutDate = btnHotelDetailRQNode.getPeriodOfStay().getCheckOutDate().toString();
		
		otaDateTimeSpanType.setStart(checkInDate);
		otaDateTimeSpanType.setEnd(checkOutDate);
		
		List<RateRange> otaRateRangeLst = otaCriterion.getRateRange();
		RateRange otaRateRange = new RateRange();
		
		if (btnHotelDetailRQNode.getMinRate() != null) {
			otaRateRange.setMinRate(new BigDecimal(btnHotelDetailRQNode.getMinRate()));
		}
		
		if (btnHotelDetailRQNode.getMaxRate() != null) {
			otaRateRange.setMaxRate(new BigDecimal(btnHotelDetailRQNode.getMaxRate()));
		}
		otaRateRangeLst.add(otaRateRange);

		/** Set occupancy data from the BTN request. */
		otaCriterion.setRoomStayCandidates(new HotelSearchCriterionType.RoomStayCandidates());
		HotelSearchCriterionType.RoomStayCandidates otaRooms = otaCriterion.getRoomStayCandidates();
		List<RoomStayCandidateType> otaRoomLst = otaRooms.getRoomStayCandidate();
		List<BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room> btnRoomLst = btnHotelDetailRQNode.getRooms().getRoom();
		StringBuilder paxesDistribution = new StringBuilder(DesiaProperties.EMPTY);
		
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
			
			StringBuilder childAges = new StringBuilder(DesiaProperties.EMPTY);
			int childOccupantCount = 0;
			List<BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room.Occupant> btnOccupantLst = btnRoom.getOccupant();
			
			for (BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room.Occupant btnOccupant : btnOccupantLst) {
				if (btnOccupant.getType().equalsIgnoreCase(DesiaProperties.CHILDCD)) {
					childOccupantCount++;	/** Used in rate key preparation */
					GuestCountType.GuestCount otaGuestChildCount = new GuestCountType.GuestCount();
					otaGuestChildCount.setAgeQualifyingCode(DesiaProperties.CHILDAGECD);
					otaGuestChildCount.setAge(btnOccupant.getAge());
					otaGuestChildCount.setCount(1);
					
					otaGuestCountLst.add(otaGuestChildCount);
					
					if (childAges.length() != 0) {
						childAges.append(DesiaProperties.HASH);
						childAges.append(btnOccupant.getAge());
					} else {
						childAges.append(btnOccupant.getAge());
					}
				}
			}
			/** Rate key preparation logic. This will be used in search response */
			if (paxesDistribution.length() != 0) {
				paxesDistribution.append(DesiaProperties.DHASH);
			}
			paxesDistribution.append(DesiaProperties.ONE);
			paxesDistribution.append(DesiaProperties.TILDA);
			paxesDistribution.append(adultCount);
			paxesDistribution.append(DesiaProperties.TILDA);
			paxesDistribution.append(childOccupantCount);
			
			if (childOccupantCount != 0) {
				paxesDistribution.append(DesiaProperties.TILDA);
				paxesDistribution.append(childAges);
			}
			
			otaRoomLst.add(otaRoom);
		}
		/** Final rate key from search request */ 
		StringBuilder searchRateKey = new StringBuilder(DesiaProperties.EMPTY);
		searchRateKey.append(checkInDate.replaceAll(DesiaProperties.DASH, DesiaProperties.EMPTY));
		searchRateKey.append(DesiaProperties.PIPE);
		searchRateKey.append(checkOutDate.replaceAll(DesiaProperties.DASH, DesiaProperties.EMPTY));
		searchRateKey.append(DesiaProperties.PIPE);
		searchRateKey.append(paxesDistribution);
		
		rateKeyMap.put(uuid, searchRateKey.toString());
		
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
					errCode.append(DesiaProperties.PIPE);
					errMsg.append(DesiaProperties.PIPE);
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
		
		BTNSearchResponse.City btnCity = new BTNSearchResponse.City();
		btnCity.setCityCode(DesiaProperties.EMPTY);
		btnCity.setCityName(DesiaProperties.EMPTY);
		btnSearchRS.setCity(btnCity);
		
		BTNSearchResponse.HotelOptions btnHotels = new BTNSearchResponse.HotelOptions();
		btnSearchRS.setHotelOptions(btnHotels);
		List<BTNSearchResponse.HotelOptions.Hotel> btnHotelLst = btnHotels.getHotel();
		
		List<OTAHotelAvailRS.RoomStays.RoomStay> otaHotelLst = otaHotelAvailRS.getRoomStays().getRoomStay();
		for (OTAHotelAvailRS.RoomStays.RoomStay otaHotel : otaHotelLst) {
			BTNSearchResponse.HotelOptions.Hotel btnHotel = new BTNSearchResponse.HotelOptions.Hotel();

			BasicPropertyInfoType otaBasicPropertyInfoType = otaHotel.getBasicPropertyInfo();
			btnHotel.setHotelCode(otaBasicPropertyInfoType.getHotelCode());
			btnHotel.setHotelName(getNodeValue(otaBasicPropertyInfoType.getHotelName()));
			btnHotel.setSupplier(DesiaProperties.DESIA);
			btnHotel.setLatitude(0.0f);
			btnHotel.setLongitude(0.0f);
			//btnHotel.setCurrency(otaBasicPropertyInfoType.getCurrencyCode());
			
			/** To counter hotel and city search differently for star rating */
			if (otaBasicPropertyInfoType.getAward().size() != 0) {
				btnHotel.setStarRating(getNodeValue(otaBasicPropertyInfoType.getAward().get(0).getRating()));
			} else {
				btnHotel.setStarRating(DesiaProperties.EMPTY);
			}
			
			btnHotel.setFullAddress(DesiaProperties.EMPTY);
			
			StringBuilder hotelDetails = new StringBuilder();
			hotelDetails.append(otaBasicPropertyInfoType.getHotelCode());
			hotelDetails.append(DesiaProperties.PIPE);
			
			List<RoomTypeType> roomTypeLst = otaHotel.getRoomTypes().getRoomType();
			List<RatePlanType> rateTypeLst = otaHotel.getRatePlans().getRatePlan();
			
			//List<RoomRate> roomRateLst = otaHotel.getRoomRates().getRoomRate();
			
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
			//Map<String, List<String>> roomRateAmtMap = new HashMap<>();
			
			int offSetCount = 1;
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
				
				String searchedRateKey = rateKeyMap.get(uuid);
				String[] searchedRateKeyAry = searchedRateKey.split(DesiaProperties.PIPESPLIT);
				
				Rate otaRoomRateRate = otaRoomRate.getRates().getRate().get(0);
				
				BigDecimal amountBeforeTax = otaRoomRateRate.getBase().getAmountBeforeTax();
				BigDecimal taxAmount = otaRoomRateRate.getBase().getTaxes().getAmount();
				BigDecimal additionalGuestCharges = new BigDecimal(0);
				
				AmountType.AdditionalGuestAmounts otaAdditionalGuestAmounts = otaRoomRateRate.getAdditionalGuestAmounts();
				
				if (otaAdditionalGuestAmounts != null) {
					List<AdditionalGuestAmountType> otaAdditionalGuestAmountLst = otaAdditionalGuestAmounts.getAdditionalGuestAmount();
					for (AdditionalGuestAmountType otaAdditionalGuestAmountType : otaAdditionalGuestAmountLst) {
						additionalGuestCharges = additionalGuestCharges.add(otaAdditionalGuestAmountType.getAmount().getAmountBeforeTax());
					}
				}
				
				BigDecimal baseDiscountCharges = new BigDecimal(0);
				BigDecimal additionalGuestDiscountCharges = new BigDecimal(0);
				
				List<AmountType.Discount> otaDiscountLst = otaRoomRateRate.getDiscount();
				if (!otaDiscountLst.isEmpty()) {
					for (AmountType.Discount otaDiscount : otaDiscountLst) {
						if (BASE.equals(otaDiscount.getAppliesTo())) {
							baseDiscountCharges = baseDiscountCharges.add(otaDiscount.getAmountBeforeTax());
						} else if (ADDTNLGSTAMT.equals(otaDiscount.getAppliesTo())) {
							additionalGuestDiscountCharges = additionalGuestDiscountCharges.add(otaDiscount.getAmountBeforeTax());
						}
					}
				}
				amountBeforeTax = amountBeforeTax.subtract(baseDiscountCharges);
				additionalGuestCharges = additionalGuestCharges.subtract(additionalGuestDiscountCharges);
				amountBeforeTax = amountBeforeTax.add(additionalGuestCharges);
				BigDecimal amountAfterTax = amountBeforeTax.add(taxAmount);
				
				if (btnRateLst.isEmpty()) {
					/** 
					 * Setting this here as in some cases BasicPropertyInfo node doesn't return
					 * currency code in the response. Also, setting it here will set it only once.
					 * Not appropriate but logical.
					 */
					btnHotel.setCurrency(otaRoomRate.getTotal().getCurrencyCode());
					
					/** For rate key preparation. Indexes should not be changed.
					 * Otherwise, change the logic of fetching and resetting rate key
					 * components in the else block. */
					List<String> rateKeyItemLst = new ArrayList<>();
					rateKeyItemLst.add(searchedRateKeyAry[0]);				//0
					rateKeyItemLst.add(searchedRateKeyAry[1]);				//1
					rateKeyItemLst.add(btnHotel.getHotelCode());			//2
					rateKeyItemLst.add(otaRoomId);							//3
					rateKeyItemLst.add(otaRatePlanId);						//4
					
					rateKeyItemLst.add(searchedRateKeyAry[2].replace(DesiaProperties.DHASH, DesiaProperties.PIPE));
					
					btnRate = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate();
					btnRate.setPackaging(Boolean.toString(false));
					
					RatePlanType otaRatePlanType = ratePlanMap.get(otaRatePlanId);
					
					
					if (otaRatePlanType.getRatePlanInclusions() != null) {
						StringBuilder tempMealCodeDesc = new StringBuilder(DesiaProperties.EMPTY);
						ParagraphType otaParagraphType = otaRatePlanType.getRatePlanInclusions().getRatePlanInclusionDesciption();
						List<JAXBElement<?>> tmpJAXBElementLst = otaParagraphType.getImageOrTextOrURL();
						for (JAXBElement<?> tmpJAXBElement : tmpJAXBElementLst) {
							tempMealCodeDesc.append(((FormattedTextTextType) tmpJAXBElement.getValue()).getValue());
						}
						btnRate.setMealCode(tempMealCodeDesc.toString());
					}
					btnRate.setMealType(DesiaProperties.EMPTY);
					
					/** Setting the prepared rate key */
					String rateKey = rateKeyItemLst.toString();
					rateKey = rateKey.replaceAll(DesiaProperties.SPACESPLIT, DesiaProperties.EMPTY);
					rateKey = rateKey.substring(1, rateKey.length() - 1);
					rateKey = rateKey.replaceAll(DesiaProperties.COMMA, DesiaProperties.PIPE);
					rateKey = rateKey.replaceAll(DesiaProperties.HASH, DesiaProperties.COMMA);
					//btnRate.setRateKey(rtDateDetails.toString().concat(rateKey));
					btnRate.setRateKey(rateKey);
					
					/** NARROWING CONVERSION **/
					btnRate.setSupplierPrice(amountAfterTax.floatValue());
					btnRate.setOtaFee(0.0f);
					btnRate.setOtaDiscountAmount(0.0f);
					
					/** below setters are settting the max occupancy */
					btnRate.setAdults(((RoomTypeType.Occupancy)roomTypeMap.get(otaRoomId).getOccupancy().get(0)).getMaxOccupancy());
					btnRate.setChildren(((RoomTypeType.Occupancy)roomTypeMap.get(otaRoomId).getOccupancy().get(1)).getMaxOccupancy());
					
					btnRate.setRecommended(DFLTRCMNDVALUE);
					btnRate.setHoldValue(DFLTHOLDVALUE);
					
					BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates btnDailyRates = 
							new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates();
					List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate> btnDailyRateLst = btnDailyRates.getDailyRate();
					BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate btnDailyRate = 
							new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate();
					
					/** NARROWING CONVERSION **/
					btnDailyRate.setOffset(offSetCount);
					btnDailyRate.setDailySellingRate(amountBeforeTax.floatValue());
					btnDailyRate.setDailyNet(amountAfterTax.floatValue());
					btnDailyRateLst.add(btnDailyRate);
					
					btnRate.setDailyRates(btnDailyRates);
					btnRateLst.add(btnRate);
				} else {
					/** As there's always going to be only one rate key associated with a room */
					btnRate = btnRateLst.get(0);
					
					BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate btnDailyRate = 
							new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate();
					btnDailyRate.setOffset(offSetCount++);
					btnDailyRate.setDailySellingRate(amountBeforeTax.floatValue());
					btnDailyRate.setDailyNet(amountAfterTax.floatValue());
					
					btnRate.getDailyRates().getDailyRate().add(btnDailyRate);
					
					btnRate.setSupplierPrice(BigDecimal.valueOf(btnRate.getSupplierPrice()).add(amountAfterTax).floatValue());
				}
			}
			btnHotelLst.add(btnHotel);
		}		
		
		/** Adding bonton search booking response for logging */
		reqResMap.get(uuid).add(btnSearchRS);
		
		logger.info("desia search response mapping done ---->");
		return btnSearchRS;
	}
	
		
	/**
	 * Used to map Bonton hotel search RQ object to Desia API
	 * specific RQ object. (Searching for hotel is repricing in Desia)
	 * @param btnRepriceRQ Bonton specific reprice RQ object
	 * @param uuid Unique idenfier used to map RQ objects with their RS's.
	 * @return Desia specific hotel availability search RQ object
	 * @author Tirath
	 */
	public static OTAHotelAvailRQ repriceBeanRQMapper(BTNRepriceRequest btnRepriceRQ, String uuid) throws Exception {
		logger.info("desia hotel search/ repricing request mapping started ---->");

		/** Preparing request-response map for logging */
		List<? super Object> rqRsLst = new ArrayList<>();
		rqRsLst.add(btnRepriceRQ);
		reqResMap.put(uuid, rqRsLst);
		
		OTAHotelAvailRQ otaHotelAvailRQ = new OTAHotelAvailRQ();
		otaHotelAvailRQ.setRequestedCurrency(DesiaProperties.CURRENCY);

		/** Rate key decompsition */
		List<BTNRepriceRequest.Rooms.Room> btnRoomLst = btnRepriceRQ.getRooms().getRoom();
		/** Their will be always a single rate key. */
		String rateKey = btnRoomLst.get(0).getUniqueKey();
		String[] rateKeyAry = rateKey.split(DesiaProperties.PIPESPLIT);
		String checkInDate = getFormattedDate(rateKeyAry[0]);
		String checkOutDate = getFormattedDate(rateKeyAry[1]);
		String hotelCode = rateKeyAry[2];
		String[] roomOccupancyAry = rateKey.substring(rateKey.indexOf(rateKeyAry[5])).split(DesiaProperties.PIPESPLIT);
		
		AvailRequestSegments reqSgmnts = new AvailRequestSegments();
		List<AvailRequestSegment> otaAvailRequestSegmentLst = reqSgmnts.getAvailRequestSegment();
		AvailRequestSegment otaAvailRequestSegment = new AvailRequestSegment();

		HotelSearchCriteria otaSearchCriteria = new HotelSearchCriteria();
		List<Criterion> otaCriterionLst = otaSearchCriteria.getCriterion();

		Criterion otaCriterion = new Criterion();
		
		List<ItemSearchCriterionType.HotelRef> otaHotelRefLst = otaCriterion.getHotelRef();
		
		HotelRef hotelRef = new HotelRef();
		hotelRef.setHotelCode(hotelCode);
		otaHotelRefLst.add(hotelRef);
		
		/** Set check in and checkout date. */
		DateTimeSpanType otaDateTimeSpanType = new DateTimeSpanType();
		otaDateTimeSpanType.setStart(checkInDate);
		otaDateTimeSpanType.setEnd(checkOutDate);
		
		/** Set occupancy data from the BTN request. */
		otaCriterion.setRoomStayCandidates(new HotelSearchCriterionType.RoomStayCandidates());
		HotelSearchCriterionType.RoomStayCandidates otaRooms = otaCriterion.getRoomStayCandidates();
		List<RoomStayCandidateType> otaRoomLst = otaRooms.getRoomStayCandidate();
		
		for (String roomOccupants : roomOccupancyAry) {
			String[] roomOccupantsDtlAry = roomOccupants.split(DesiaProperties.TILDA);
			
			RoomStayCandidateType otaRoom = new RoomStayCandidateType();
			otaRoom.setGuestCounts(new GuestCountType());
			GuestCountType otaGuestCountType = otaRoom.getGuestCounts();
			List<GuestCountType.GuestCount> otaGuestCountLst = otaGuestCountType.getGuestCount();
			
			
			/** Setting the available adults distribution. */
			GuestCountType.GuestCount otaGuestAdultCount = new GuestCountType.GuestCount();
			otaGuestAdultCount.setAgeQualifyingCode(DesiaProperties.ADULTAGECD);
			otaGuestAdultCount.setCount(Integer.valueOf(roomOccupantsDtlAry[1]));
			otaGuestCountLst.add(otaGuestAdultCount);
			
			/** Setting child distribution */
			int childCount = Integer.valueOf(roomOccupantsDtlAry[2]);
			if (childCount != 0) {
				String childrenAges = roomOccupantsDtlAry[3];
				if (childCount == 1) {
					GuestCountType.GuestCount otaGuestChildCount = new GuestCountType.GuestCount();
					otaGuestChildCount.setAgeQualifyingCode(DesiaProperties.CHILDAGECD);
					otaGuestChildCount.setAge(Integer.valueOf(childrenAges));
					otaGuestChildCount.setCount(1);
					
					otaGuestCountLst.add(otaGuestChildCount);
				} else {
					/** More than one child and its age needs to be set */
					String[] childrenAgesAry = childrenAges.split(DesiaProperties.COMMA);
					for (String childAge : childrenAgesAry) {
						GuestCountType.GuestCount otaGuestChildCount = new GuestCountType.GuestCount();
						otaGuestChildCount.setAgeQualifyingCode(DesiaProperties.CHILDAGECD);
						otaGuestChildCount.setAge(Integer.valueOf(childAge));
						otaGuestChildCount.setCount(1);
						
						otaGuestCountLst.add(otaGuestChildCount);
					}
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
		
		otaCriterion.setTPAExtensions(otaTPAExtensionsType);
		otaCriterion.setStayDateRange(otaDateTimeSpanType);
		otaCriterionLst.add(otaCriterion);
		
		otaAvailRequestSegment.setHotelSearchCriteria(otaSearchCriteria);
		otaAvailRequestSegmentLst.add(otaAvailRequestSegment);

		otaHotelAvailRQ.setAvailRequestSegments(reqSgmnts);

		/** Adding Desia search booking RQ for logging */
		rqRsLst.add(otaHotelAvailRQ);
		
		logger.info("desia hotel search/ repricing request mapping done ---->");
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
	public static BTNRepriceResponse repriceBeanRSMapper(OTAHotelAvailRS otaHotelAvailRS, String uuid) throws Exception {
		logger.info("desia reprice/ hotel response mapping started ---->");
		
		/** Adding Desia search booking response for logging */
		reqResMap.get(uuid).add(otaHotelAvailRS);
		
		BTNRepriceResponse btnRepriceRS = new BTNRepriceResponse();
		
		if (otaHotelAvailRS.getErrors() != null) {
			BTNRepriceResponse.BTNError errElmnt = new BTNRepriceResponse.BTNError();
			
			List<ErrorType> otaErrorLst = otaHotelAvailRS.getErrors().getError();
			StringBuilder errCode = new StringBuilder();
			StringBuilder errMsg = new StringBuilder();
			for (ErrorType otaErrorType : otaErrorLst) {
				if (errCode.length() != 0) {
					errCode.append(DesiaProperties.PIPE);
					errMsg.append(DesiaProperties.PIPE);
				}
				errCode.append(otaErrorType.getCode());
				errMsg.append(otaErrorType.getShortText());
				
			}
			errElmnt.setCode(errCode.toString());
			errElmnt.setMessage(errMsg.toString());

			btnRepriceRS.setBTNError(errElmnt);
			
			/** Adding Desia reprice/ hotel booking response for logging */
			reqResMap.get(uuid).add(btnRepriceRS);
			
			logger.info("desia reprice/ hotel response contains error. Returning ---->");
			return btnRepriceRS;
		}

		
		List<OTAHotelAvailRS.RoomStays.RoomStay> otaHotelLst = otaHotelAvailRS.getRoomStays().getRoomStay();
		for (OTAHotelAvailRS.RoomStays.RoomStay otaHotel : otaHotelLst) {
			BTNRepriceResponse.Hotel btnHotel = new BTNRepriceResponse.Hotel();
			
			String repricedRateKey = ((BTNRepriceRequest) reqResMap.get(uuid).get(0)).getRooms().getRoom().get(0).getUniqueKey();
			String[] rateKeyAry = repricedRateKey.split(DesiaProperties.PIPESPLIT);
//			String checkInDate = getFormattedDate(rateKeyAry[0]);
//			String checkOutDate = getFormattedDate(rateKeyAry[1]);

//			resHotel.setCheckIn("");
//			resHotel.setCheckOut(checkOutDate);


			BasicPropertyInfoType otaBasicPropertyInfoType = otaHotel.getBasicPropertyInfo();
			btnHotel.setCode(Integer.valueOf(otaBasicPropertyInfoType.getHotelCode()));
			btnHotel.setName(getNodeValue(otaBasicPropertyInfoType.getHotelName()));
			btnHotel.setCategoryName(((BasicPropertyInfoType.Award) otaBasicPropertyInfoType.getAward().get(0)).getRating());
			btnHotel.setCategoryCode(DesiaProperties.EMPTY);
			btnHotel.setDestinationCode(DesiaProperties.EMPTY);
			btnHotel.setDestinationName(DesiaProperties.EMPTY);
			
			List<RoomTypeType> roomTypeLst = otaHotel.getRoomTypes().getRoomType();
			List<RatePlanType> rateTypeLst = otaHotel.getRatePlans().getRatePlan();
			
			Map<String, RoomTypeType> roomTypeMap = new HashMap<>();
			Map<String, RatePlanType> ratePlanMap = new HashMap<>();
			
			/* Populating values in map types */ 
			for (RoomTypeType tmpRoomType : roomTypeLst) {
				roomTypeMap.put(tmpRoomType.getRoomTypeCode(), tmpRoomType);
			}
			
			for (RatePlanType tmpRatePlan : rateTypeLst) {
				ratePlanMap.put(tmpRatePlan.getRatePlanCode(), tmpRatePlan);
			}
			
			List<RoomStayType.RoomRates.RoomRate> otaRoomRateLst = otaHotel.getRoomRates().getRoomRate();
			
			BTNRepriceResponse.Hotel.Rooms btnRooms = new BTNRepriceResponse.Hotel.Rooms();
			List<BTNRepriceResponse.Hotel.Rooms.Room> btnRoomLst = btnRooms.getRoom();
			for (RoomStayType.RoomRates.RoomRate otaRoomRate : otaRoomRateLst) {
				String otaRoomId = otaRoomRate.getRoomID();
				String otaRatePlanId = otaRoomRate.getRatePlanCode();
				
				if (!(otaRoomId.equals(rateKeyAry[3]) && otaRatePlanId.equals(rateKeyAry[4]))) {
					continue;
				}
				
				Rate otaRoomRateRate = otaRoomRate.getRates().getRate().get(0);
				BigDecimal amountBeforeTax = otaRoomRateRate.getBase().getAmountBeforeTax();
				BigDecimal taxAmount = otaRoomRateRate.getBase().getTaxes().getAmount();
				BigDecimal additionalGuestCharges = new BigDecimal(0);
				
				AmountType.AdditionalGuestAmounts otaAdditionalGuestAmounts = otaRoomRateRate.getAdditionalGuestAmounts();
				
				if (otaAdditionalGuestAmounts != null) {
					List<AdditionalGuestAmountType> otaAdditionalGuestAmountLst = otaAdditionalGuestAmounts.getAdditionalGuestAmount();
					for (AdditionalGuestAmountType otaAdditionalGuestAmountType : otaAdditionalGuestAmountLst) {
						additionalGuestCharges = additionalGuestCharges.add(otaAdditionalGuestAmountType.getAmount().getAmountBeforeTax());
					}
				}
				
				BigDecimal baseDiscountCharges = new BigDecimal(0);
				BigDecimal additionalGuestDiscountCharges = new BigDecimal(0);
				
				List<AmountType.Discount> otaDiscountLst = otaRoomRateRate.getDiscount();
				if (!otaDiscountLst.isEmpty()) {
					for (AmountType.Discount otaDiscount : otaDiscountLst) {
						if (BASE.equals(otaDiscount.getAppliesTo())) {
							baseDiscountCharges = baseDiscountCharges.add(otaDiscount.getAmountBeforeTax());
						} else if (ADDTNLGSTAMT.equals(otaDiscount.getAppliesTo())) {
							additionalGuestDiscountCharges = additionalGuestDiscountCharges.add(otaDiscount.getAmountBeforeTax());
						}
					}
				}
				
				amountBeforeTax = amountBeforeTax.subtract(baseDiscountCharges);
				additionalGuestCharges = additionalGuestCharges.subtract(additionalGuestDiscountCharges);
				amountBeforeTax = amountBeforeTax.add(additionalGuestCharges);
				BigDecimal amountAfterTax = amountBeforeTax.add(taxAmount);
				
				if (btnRoomLst.isEmpty()) {
					BTNRepriceResponse.Hotel.Rooms.Room btnRoom = new BTNRepriceResponse.Hotel.Rooms.Room();
					btnRoom.setCode(otaRoomId);
					btnRoom.setName(roomTypeMap.get(otaRoomId).getRoomType());
					
					
					/** Their will always be one rate key for a room which we prepare while preparing this response */
					BTNRepriceResponse.Hotel.Rooms.Room.Rates btnRates = new BTNRepriceResponse.Hotel.Rooms.Room.Rates();
					BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate btnRate = new BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate();
					
					btnRate.setNetRate(amountAfterTax);
					btnRate.setPackaging(Boolean.toString(false));
					btnRate.setRateType("BOOKABLE");
					btnRate.setRateComments(DesiaProperties.EMPTY);
					btnRate.setCategory(DesiaProperties.EMPTY);
					btnRate.setRoomCount(1);
					btnRate.setAdultCount(1);
					btnRate.setChildCount(1);
					btnRate.setTaxAmount(taxAmount);
					
					BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies btncpies = 
							new BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies();
					BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy btncpy = 
							new BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy();
					
					btncpy.setAmount(null);
					btncpy.setFrom(null);
					
					btncpies.setCancellationPolicy(btncpy);
					btnRate.setCancellationPolicies(btncpies);
					btnRates.setRate(btnRate);
					btnRoom.setRates(btnRates);
					
					btnRoomLst.add(btnRoom);
				} else {
					BTNRepriceResponse.Hotel.Rooms.Room.Rates.Rate btnRate = btnRoomLst.get(0).getRates().getRate();
					btnRate.setNetRate(amountAfterTax.add(btnRate.getNetRate()));
					btnRate.setTaxAmount(taxAmount.add(btnRate.getTaxAmount()));
				}
				
			}
			btnHotel.setRooms(btnRooms);
			btnRepriceRS.setHotel(btnHotel);
		}
		
		/** Adding bonton reprice response for logging */
		reqResMap.get(uuid).add(btnRepriceRS);
		
		logger.info("desia reprice/ hotel response mapping done ---->");
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
					case DesiaProperties.REPRICE:
						DesiaDBConnection.insert(op, 
								XmlProcessor.getBeanInXml((BTNRepriceRequest) reqResLst.get(0)),
								XmlProcessor.getBeanInXml((OTAHotelAvailRQ) reqResLst.get(1)),
								XmlProcessor.getBeanInXml((OTAHotelAvailRS) reqResLst.get(2)),
								XmlProcessor.getBeanInXml((BTNRepriceResponse) reqResLst.get(3)), 
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
	
	private static final String getNodeValue(String crntValue) {
		return null != crntValue? crntValue: DesiaProperties.EMPTY;
	}
	private static final String getFormattedDate(String plainDateStr) {
		StringBuilder formatterDate = new StringBuilder(DesiaProperties.EMPTY);
		formatterDate.append(plainDateStr.substring(0, 4));
		formatterDate.append(DesiaProperties.DASH);
		formatterDate.append(plainDateStr.substring(4, 6));
		formatterDate.append(DesiaProperties.DASH);
		formatterDate.append(plainDateStr.substring(6, 8));
		
		return formatterDate.toString();
	}
}
