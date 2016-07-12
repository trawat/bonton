package com.desia.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNCancelRS;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNConfirmResponse;
import com.bonton.utility.artifacts.BTNFinalBookingRQ;
import com.bonton.utility.artifacts.BTNFinalBookingRS;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.hotelbeds.AvailabilityRQ;
import com.bonton.utility.hotelbeds.AvailabilityRS;
import com.bonton.utility.processor.XmlProcessor;
import com.desia.artifacts.booking.BasicPropertyInfoType;
import com.desia.artifacts.booking.CompanyNameType;
import com.desia.artifacts.booking.CountryNameType;
import com.desia.artifacts.booking.CustomerType;
import com.desia.artifacts.booking.CustomerType.Address;
import com.desia.artifacts.booking.CustomerType.Email;
import com.desia.artifacts.booking.CustomerType.Telephone;
import com.desia.artifacts.booking.DateTimeSpanType;
import com.desia.artifacts.booking.EmailType;
import com.desia.artifacts.booking.ErrorType;
import com.desia.artifacts.booking.GuaranteeType;
import com.desia.artifacts.booking.GuestCountType;
import com.desia.artifacts.booking.GuestCountType.GuestCount;
import com.desia.artifacts.booking.HotelReservationsType;
import com.desia.artifacts.booking.HotelReservationsType.HotelReservation;
import com.desia.artifacts.booking.OTACancelRQ;
import com.desia.artifacts.booking.OTACancelRQ.UniqueID;
import com.desia.artifacts.booking.OTACancelRS;
import com.desia.artifacts.booking.OTAHotelResRQ;
import com.desia.artifacts.booking.OTAHotelResRS;
import com.desia.artifacts.booking.POSType;
import com.desia.artifacts.booking.PersonNameType;
import com.desia.artifacts.booking.ProfileType;
import com.desia.artifacts.booking.ProfilesType;
import com.desia.artifacts.booking.ProfilesType.ProfileInfo;
import com.desia.artifacts.booking.RatePlanType;
import com.desia.artifacts.booking.ResGlobalInfoType;
import com.desia.artifacts.booking.ResGuestType;
import com.desia.artifacts.booking.ResGuestsType;
import com.desia.artifacts.booking.RoomStayType.RatePlans;
import com.desia.artifacts.booking.RoomStayType.RoomTypes;
import com.desia.artifacts.booking.RoomStaysType;
import com.desia.artifacts.booking.RoomStaysType.RoomStay;
import com.desia.artifacts.booking.RoomTypeType;
import com.desia.artifacts.booking.SourceType;
import com.desia.artifacts.booking.SourceType.RequestorID;
import com.desia.artifacts.booking.StateProvType;
import com.desia.artifacts.booking.TGBookingServiceEndPoint;
import com.desia.artifacts.booking.TGBookingServiceEndPointImplService;
import com.desia.artifacts.booking.TPAExtensionsType;
import com.desia.artifacts.booking.TPAExtensionsType.CancelDates;
import com.desia.artifacts.booking.TaxesType;
import com.desia.artifacts.booking.TotalType;
import com.desia.artifacts.booking.TransactionActionType;
import com.desia.artifacts.booking.TransactionStatusType;
import com.desia.artifacts.booking.UniqueIDType;
import com.desia.artifacts.booking.VerificationType;
import com.desia.artifacts.booking.VerificationType.PersonName;
import com.desia.handler.MessageHandler;
import com.desia.util.DesiaDBConnection;
import com.desia.util.DesiaProperties;

public class DesiaBookingServiceHelper {
	private static Logger logger = LoggerFactory.getLogger(DesiaBookingServiceHelper.class);
	
	private static final ExecutorService desiaEs = Executors.newCachedThreadPool();
	
	private static final TGBookingServiceEndPointImplService bookingSIB = new TGBookingServiceEndPointImplService();
	private static TGBookingServiceEndPoint bookingSEI = null;
	
	/* Holds unique uuid and generated request-response list as key-value */
	private static final Map<String, List<? super Object>> reqResMap = new HashMap<>();
	
	private DesiaBookingServiceHelper() {}
	
	static {
		HandlerResolver handlerResolver = new HandlerResolver() {
			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				List<Handler> handler = new LinkedList<>();
				handler.add(new MessageHandler());
				return handler;
			}
		};
		bookingSIB.setHandlerResolver(handlerResolver);
		bookingSEI = (TGBookingServiceEndPoint) bookingSIB.getTGBookingServiceEndPointImplPort();
	}
	
	/**
	 * Used to map the final booking RQ object send to Desia API  
	 * prepared from Bonton specific Final booking RQ object.
	 * @param btnFinalBookingRQ bonton final booking request object
	 * @return OTAHotelResRQ Desia final booking request
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static OTAHotelResRQ finalBookingRQMapper(BTNFinalBookingRQ btnFinalBookingRQ, String uuid) throws Exception {
		logger.info("desia final booking request mapping started ---->");
		
		/** Preparing request-response map for logging */
		List<? super Object> rqRsLst = new ArrayList<>();
		rqRsLst.add(btnFinalBookingRQ);
		reqResMap.put(uuid, rqRsLst);
		
		OTAHotelResRQ otaHotelResRQ = new OTAHotelResRQ();
//		otaHotelResRQ.setVersion();	//TODO: uncomment if required
		
		POSType otaPOSType = new POSType();
		
		SourceType otaSourceType = new SourceType();
		otaSourceType.setISOCurrency("INR");
		
		RequestorID otaRequestorID = new RequestorID();
		otaRequestorID.setID("1300001211");
		otaRequestorID.setMessagePassword("test@789");
		
		CompanyNameType otaCompanyNameType = new CompanyNameType();
		otaCompanyNameType.setCode("bontonsell");
		
		otaRequestorID.setCompanyName(otaCompanyNameType);
		otaSourceType.setRequestorID(otaRequestorID);
		List<SourceType> otaPOSTypeLst = otaPOSType.getSource();
		otaPOSTypeLst.add(otaSourceType);
		
		/** Tag goes to final booking */
		List<UniqueIDType> otaUniqueIDTypeLst = otaHotelResRQ.getUniqueID();
		UniqueIDType otaUniqueIDType = new UniqueIDType();
		
		/** Setting provisional booking id */
		otaUniqueIDType.setID(btnFinalBookingRQ.getProvBookingId());
		otaUniqueIDType.setType("23");
		otaUniqueIDTypeLst.add(otaUniqueIDType);
		
		HotelReservationsType otaHotelReservationsType = new HotelReservationsType();
		List<HotelReservationsType.HotelReservation> otaHotelReservationsTypeLst = otaHotelReservationsType.getHotelReservation();
		
		HotelReservation otaHotelReservation = new HotelReservation();
		ResGlobalInfoType otaResGlobalInfoType = new ResGlobalInfoType();
		
		GuaranteeType otaGuaranteeType = new GuaranteeType();
		otaGuaranteeType.setGuaranteeType("PrePay");
		
		otaResGlobalInfoType.setGuarantee(otaGuaranteeType);
		otaHotelReservation.setResGlobalInfo(otaResGlobalInfoType);
		otaHotelReservationsTypeLst.add(otaHotelReservation);
		
		otaHotelResRQ.setHotelReservations(otaHotelReservationsType);
		otaHotelResRQ.setPOS(otaPOSType);
		
		/** Adding Desia final booking RQ for logging */
		rqRsLst.add(otaHotelResRQ);
		
		logger.info("desia final booking request mapping done ---->");
		return otaHotelResRQ;
	}
	
	/**
	 * Used to map the final booking RS object returned from Desia API to 
	 * Bonton specific Final booking RS object.
	 * @param otaHotelResRS final booking response from Desia API
	 * @return BTNFinalBookingRS Bonton final booking response
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static BTNFinalBookingRS finalBookingRSMapper(OTAHotelResRS otaHotelResRS, String uuid) throws Exception {
		logger.info("desia final booking response mapping started ---->");
		
		/** Adding Desia final booking response for logging */
		reqResMap.get(uuid).add(otaHotelResRS);
		
		BTNFinalBookingRS btnFinalBookingRS = new BTNFinalBookingRS();
		
		if (otaHotelResRS.getErrors() != null) {
			BTNFinalBookingRS.BTNError errElmnt = new BTNFinalBookingRS.BTNError();
			
			List<ErrorType> otaErrorLst = otaHotelResRS.getErrors().getError();
			StringBuilder errCode = new StringBuilder();
			StringBuilder errMsg = new StringBuilder();
			for (ErrorType otaErrorType : otaErrorLst) {
				if (errCode.length() != 0) {
					errCode.append(DesiaProperties.SEP2);
					errMsg.append(DesiaProperties.SEP2);
				}
				errCode.append(otaErrorType.getCode());
				errMsg.append(otaErrorType.getValue());
				
			}
			errElmnt.setCode(errCode.toString());
			errElmnt.setMessage(errMsg.toString());

			btnFinalBookingRS.setBTNError(errElmnt);
			
			/** Adding Desia final booking response for logging */
			reqResMap.get(uuid).add(btnFinalBookingRS);
			
			logger.info("desia final booking response contains error. Returning ---->");
			return btnFinalBookingRS;
		}
		List<HotelReservation> otaHotelReservationLst = otaHotelResRS.getHotelReservations().getHotelReservation();
		HotelReservation otaHotelReservation = otaHotelReservationLst.get(0);
		List<UniqueIDType> otaUniqueIDTypeLst = otaHotelReservation.getUniqueID();
		UniqueIDType otaUniqueIDType = new UniqueIDType();
		btnFinalBookingRS.setReferenceId(otaUniqueIDType.getID());
		
		/** Adding bonton final booking response for logging */
		reqResMap.get(uuid).add(btnFinalBookingRS);
		
		logger.info("desia final booking response mapping done ---->");
		return btnFinalBookingRS;
	}
	
	/**
	 * Used to map Bonton provisional booking RQ object to Desia
	 * specific provisional booking RQ object.
	 * @param btnConfirmRQ Bonton provisional booking RQ object
	 * @param uuid Unique idenfier used to map RQ objects with their RS's.
	 * @return Desia specific provisional booking RQ object
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static OTAHotelResRQ provisionalBeanRQMapper(BTNConfirmRequest btnConfirmRQ, String uuid) throws Exception {
		logger.info("desia provisional booking request mapping started ---->");
		
		/** Preparing request-response map for logging */
		List<? super Object> rqRsLst = new ArrayList<>();
		rqRsLst.add(btnConfirmRQ);
		reqResMap.put(uuid, rqRsLst);
		
		OTAHotelResRQ otaHotelResRQ = new OTAHotelResRQ();
		
		POSType otaPOSType = new POSType();
		
		SourceType otaSourceType = new SourceType();
		otaSourceType.setISOCurrency("INR");
		
		RequestorID otaRequestorID = new RequestorID();
		otaRequestorID.setID("1300001211");
		otaRequestorID.setMessagePassword("test@789");
		
		CompanyNameType otaCompanyNameType = new CompanyNameType();
		otaCompanyNameType.setCode("bontonsell");
		
		otaRequestorID.setCompanyName(otaCompanyNameType);
		otaSourceType.setRequestorID(otaRequestorID);
		List<SourceType> otaPOSTypeLst = otaPOSType.getSource();
		otaPOSTypeLst.add(otaSourceType);
		
		/** Tag goes to final booking */
		List<UniqueIDType> otaUniqueIDTypeLst = otaHotelResRQ.getUniqueID();
		UniqueIDType otaUniqueIDType = new UniqueIDType();
		otaUniqueIDType.setID("");
		otaUniqueIDType.setType("");
		otaUniqueIDTypeLst.add(otaUniqueIDType);
		
		HotelReservationsType otaHotelReservationsType = new HotelReservationsType();
		List<HotelReservationsType.HotelReservation> otaHotelReservationsTypeLst = otaHotelReservationsType.getHotelReservation();
		
		HotelReservation otaHotelReservation = new HotelReservation();
		RoomStaysType otaRoomStaysType = new RoomStaysType();
		List<RoomStaysType.RoomStay> otaRoomStayLst = otaRoomStaysType.getRoomStay();
		
		List<BTNConfirmRequest.Rooms.Room> btnRoomLst = btnConfirmRQ.getRooms().getRoom();
		
		/** As the rate key passed is going to be same for all the rooms. We will fetch 
		 * only rate key and get the required details out. */
		String rateKey = btnRoomLst.get(0).getUniqueKey();
		rateKey = rateKey.replaceAll("\\s+", "");
		String[] rateKeyAry = rateKey.split(DesiaProperties.SPLIT);
		
		
		GuestCountType otaGuestCountType = new GuestCountType();
		otaGuestCountType.setIsPerRoom(false);
		List<GuestCountType.GuestCount> otaGuestCountTypeLst = otaGuestCountType.getGuestCount();
		
		
		int resGuestRPHIndex = 0;
		for (BTNConfirmRequest.Rooms.Room btnRoom : btnRoomLst) {
			List<BTNConfirmRequest.Rooms.Room.Paxes.Pax> btnPaxLst = btnRoom.getPaxes().getPax();
			for (BTNConfirmRequest.Rooms.Room.Paxes.Pax btnPax : btnPaxLst) {
				GuestCount otaGuestCount = new GuestCount();
				
				if (btnPax.getType().equalsIgnoreCase("AD")) {
					otaGuestCount.setAgeQualifyingCode("10");
				} else if (btnPax.getType().equalsIgnoreCase("CH")) {
					otaGuestCount.setAgeQualifyingCode("8");
					otaGuestCount.setAge(btnPax.getAge());
				}
				
				otaGuestCount.setCount(1);
				otaGuestCount.setResGuestRPH("" + resGuestRPHIndex);
				
				otaGuestCountTypeLst.add(otaGuestCount);
			}
			/** Increasing the resGuestRPHIndex count */
			resGuestRPHIndex++;
		}
		
		RoomTypes otaRoomTypes = new RoomTypes();
		List<RoomTypeType> otaRoomTypeLst = otaRoomTypes.getRoomType();
		RoomStay otaRoomStay = new RoomStay();
		
		RoomTypeType otaRoomTypeType = new RoomTypeType();
		otaRoomTypeType.setNumberOfUnits(new BigInteger("" + btnRoomLst.size()));
		otaRoomTypeType.setRoomTypeCode(rateKeyAry[1]);
		
		RatePlans otaRatePlans = new RatePlans();
		List<RatePlanType> otaRatePlanLst = otaRatePlans.getRatePlan();
		
		RatePlanType otaRatePlanType = new RatePlanType();		
		otaRatePlanType.setRatePlanCode(rateKeyAry[2]);
		
		DateTimeSpanType otaTimeSpan = new DateTimeSpanType();
		otaTimeSpan.setStart(btnConfirmRQ.getPeriodOfStay().getCheckInDate().toString());
		otaTimeSpan.setEnd(btnConfirmRQ.getPeriodOfStay().getCheckOutDate().toString());
		
		TotalType otaTotalType = new TotalType();
		otaTotalType.setAmountBeforeTax(new BigDecimal("" + rateKeyAry[3]));
		otaTotalType.setCurrencyCode("INR");
		
		TaxesType otaTaxesType = new TaxesType();
		otaTaxesType.setAmount(new BigDecimal("" + rateKeyAry[4]));
		otaTaxesType.setCurrencyCode("INR");
		
		otaTotalType.setTaxes(otaTaxesType);
		
		BasicPropertyInfoType otaBasicPropertyInfoType = new BasicPropertyInfoType();
		otaBasicPropertyInfoType.setHotelCode(rateKeyAry[0]);
		
		ResGuestsType otaResGuestsType = new ResGuestsType();
		List<ResGuestType> otaResGuestTypeLst = otaResGuestsType.getResGuest();
		ResGuestType otaResGuestType = new ResGuestType();
		otaResGuestTypeLst.add(otaResGuestType);
		
		ProfilesType otaProfilesType = new ProfilesType();
		List<ProfilesType.ProfileInfo> otaProfileInfoLst = otaProfilesType.getProfileInfo();
		
		ProfileInfo otaProfileInfo = new ProfileInfo();
		otaProfileInfoLst.add(otaProfileInfo);
		
		ProfileType otaProfileType = new ProfileType();
		otaProfileType.setProfileType("1");
		
		CustomerType otaCustomerType = new CustomerType();
		
		List<PersonNameType> otaPersonNameTypeLst = otaCustomerType.getPersonName();
		PersonNameType otaFirstNameType = new PersonNameType();
		otaFirstNameType.setNameType(btnConfirmRQ.getContactData().getPersonName().getFirstName());
		PersonNameType otaLastNameType = new PersonNameType();
		otaLastNameType.setNameType(btnConfirmRQ.getContactData().getPersonName().getLastName());
		otaPersonNameTypeLst.add(otaFirstNameType);
		otaPersonNameTypeLst.add(otaLastNameType);
		
		List<Email> otaEmailLst = otaCustomerType.getEmail();
		Email otaEmail = new Email();
		otaEmail.setEmailType(btnConfirmRQ.getContactData().getEmail());
		otaEmailLst.add(otaEmail);
		
		List<Address> otaAddressLst = otaCustomerType.getAddress();
		Address otaAddress = new Address();
		List<String> otaAddressString = otaAddress.getAddressLine();
		otaAddressString.add(btnConfirmRQ.getContactData().getAddress());
		
		StateProvType otaStateProvType = new StateProvType();
		otaStateProvType.setStateCode("");
		
		otaAddress.setPostalCode(btnConfirmRQ.getContactData().getPostalCd());
		
		CountryNameType otaCountryNameType = new CountryNameType();
		otaCountryNameType.setCode(btnConfirmRQ.getContactData().getCountryCd());
		otaCountryNameType.setValue(btnConfirmRQ.getContactData().getCountryCd());
		
		otaAddress.setStateProv(otaStateProvType);
		otaAddress.setCountryName(otaCountryNameType);
		otaAddressLst.add(otaAddress);
		
		List<CustomerType.Telephone> otaTelephoneLst = otaCustomerType.getTelephone();
		Telephone otaTelephone = new Telephone();
		otaTelephone.setPhoneNumber(btnConfirmRQ.getContactData().getPhoneNumber().toString());
		otaTelephoneLst.add(otaTelephone);
		
		ResGlobalInfoType otaResGlobalInfoType = new ResGlobalInfoType();
		GuaranteeType otaGuaranteeType = new GuaranteeType();
		otaGuaranteeType.setGuaranteeType("PrePay");
		otaResGlobalInfoType.setGuarantee(otaGuaranteeType);
		
		otaHotelReservation.setResGlobalInfo(otaResGlobalInfoType);
		
		otaProfileType.setCustomer(otaCustomerType);
		otaProfileInfo.setProfile(otaProfileType);
		otaResGuestType.setProfiles(otaProfilesType);
		otaHotelReservation.setResGuests(otaResGuestsType);
		otaRoomStay.setBasicPropertyInfo(otaBasicPropertyInfoType);
		otaRoomStay.setTotal(otaTotalType);
		otaRoomStay.setTimeSpan(otaTimeSpan);
		otaRoomStay.setGuestCounts(otaGuestCountType);
		otaRoomStay.setRatePlans(otaRatePlans);
		otaRoomTypeLst.add(otaRoomTypeType);
		otaRatePlanLst.add(otaRatePlanType);
		otaRoomStay.setRoomTypes(otaRoomTypes);
		otaRoomStayLst.add(otaRoomStay);
		otaHotelReservation.setRoomStays(otaRoomStaysType);
		otaHotelReservationsTypeLst.add(otaHotelReservation);
		otaHotelResRQ.setHotelReservations(otaHotelReservationsType);
		otaHotelResRQ.setPOS(otaPOSType);
		
		/** Adding Desia final booking RQ for logging */
		rqRsLst.add(otaHotelResRQ);
		
		logger.info("desia provisional booking request mapping done ---->");
		return otaHotelResRQ;
	}
	
	/**
	 * Used to map Desia specific booking RS to Bonton specific 
	 * booking confirmation RS object.
	 * @param bookingRS Desia booking confirmation RS object
	 * @param uuid Unique idenfier used to map RQ objects with their RS's.
	 * @return Booking confirmation RS object specific to Bonton API
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static BTNConfirmResponse provisionalBeanRSMapper(OTAHotelResRS otaHotelResRS, String uuid) throws Exception {
		logger.info("desia provisional booking response mapping started ---->");
		
		/** Adding Desia provisional booking response for logging */
		reqResMap.get(uuid).add(otaHotelResRS);
		
		BTNConfirmResponse btnConfirmRS = new BTNConfirmResponse();
		
		if (otaHotelResRS.getErrors() != null) {
			BTNConfirmResponse.BTNError errElmnt = new BTNConfirmResponse.BTNError();
			
			List<ErrorType> otaErrorLst = otaHotelResRS.getErrors().getError();
			StringBuilder errCode = new StringBuilder();
			StringBuilder errMsg = new StringBuilder();
			for (ErrorType otaErrorType : otaErrorLst) {
				if (errCode.length() != 0) {
					errCode.append(DesiaProperties.SEP2);
					errMsg.append(DesiaProperties.SEP2);
				}
				errCode.append(otaErrorType.getCode());
				errMsg.append(otaErrorType.getValue());
				
			}
			errElmnt.setCode(errCode.toString());
			errElmnt.setMessage(errMsg.toString());

			btnConfirmRS.setBTNError(errElmnt);
			
			/** Adding Desia provisional booking response for logging */
			reqResMap.get(uuid).add(btnConfirmRS);
			
			logger.info("desia provisional booking response contains error. Returning ---->");
			return btnConfirmRS;
		}
		
		BTNConfirmResponse.Booking btnBooking = new BTNConfirmResponse.Booking();
		HotelReservation otaHotelReservation = (HotelReservation) otaHotelResRS.getHotelReservations().getHotelReservation().get(0);
		UniqueIDType otaUniqueIDType = (UniqueIDType) otaHotelReservation.getUniqueID().get(0);
		btnBooking.setReference(otaUniqueIDType.getID());

		/** Adding bonton provisional booking response for logging */
		reqResMap.get(uuid).add(btnBooking);
		
		logger.info("desia provisional booking response mapping done ---->");
		return btnConfirmRS;
	}
	
	/**
	 * Used to map Bonton booking cancellation RQ object to Desia
	 * specific RQ object.
	 * @param btnCancelRQ Bonton cancellation RQ object
	 * @param uuid Unique idenfier used to map RQ objects with their RS's.
	 * @return Booking cancellation RS object specific to Desia API
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static OTACancelRQ cancelBeanRQMapper(BTNCancelRQ btnCancelRQ, String uuid) throws Exception {
		logger.info("desia cancel booking request mapping started ---->");
		
		/** Preparing request-response map for logging */
		List<? super Object> rqRsLst = new ArrayList<>();
		rqRsLst.add(btnCancelRQ);
		reqResMap.put(uuid, rqRsLst);
		
		OTACancelRQ otaCancelRQ = new OTACancelRQ();
		
		String cancelFlag = btnCancelRQ.getCancelDetails().getCancelFlag();
		if (cancelFlag.equalsIgnoreCase(TransactionActionType.CANCEL.toString())) {
			otaCancelRQ.setCancelType(TransactionActionType.CANCEL);
		} else {
			otaCancelRQ.setCancelType(TransactionActionType.INITIATE);
		}
		
		POSType otaPOSType = new POSType();
		
		SourceType otaSourceType = new SourceType();
		
		RequestorID otaRequestorID = new RequestorID();
		otaRequestorID.setID("1300001211");
		otaRequestorID.setMessagePassword("test@789");
		
		CompanyNameType otaCompanyNameType = new CompanyNameType();
		otaCompanyNameType.setCode("bontonsell");
		
		otaRequestorID.setCompanyName(otaCompanyNameType);
		otaSourceType.setRequestorID(otaRequestorID);
		List<SourceType> otaPOSTypeLst = otaPOSType.getSource();
		otaPOSTypeLst.add(otaSourceType);
		
		/** Tag goes to final booking */
		List<OTACancelRQ.UniqueID> otaUniqueIDTypeLst = otaCancelRQ.getUniqueID();
		UniqueID otaUniqueID = new UniqueID();
		otaUniqueID.setID(btnCancelRQ.getCancelDetails().getReferenceId());
		otaUniqueIDTypeLst.add(otaUniqueID);

		List<VerificationType> otaVerificationLst = otaCancelRQ.getVerification();
		VerificationType otaVerificationType = new VerificationType();
		PersonName otaPersonName = new PersonName();
		EmailType otaEmailType = new EmailType();
		
		if (btnCancelRQ.getCancelDetails().getPersonName() != null) {
			otaPersonName.setSurname(btnCancelRQ.getCancelDetails().getPersonName().getLastName());
			otaEmailType.setValue(btnCancelRQ.getCancelDetails().getEmail());
		}

		otaVerificationType.setPersonName(otaPersonName);
		otaVerificationType.setEmail(otaEmailType);
		otaVerificationLst.add(otaVerificationType);
		
		TPAExtensionsType otaTPAExtensions = new TPAExtensionsType();
		CancelDates otaCancelDates = new CancelDates();
		
		otaTPAExtensions.setCancelDates(otaCancelDates);
		otaCancelRQ.setTPAExtensions(otaTPAExtensions);
		otaCancelRQ.setPOS(otaPOSType);
		
		/** Adding Desia cancel booking RQ for logging */
		rqRsLst.add(otaCancelRQ);
		
		logger.info("desia cancel booking request mapping done ---->");
		return otaCancelRQ;
	}
	
	/**
	 * Used to map the Desia booking cancellation RS to Bonton
	 * specific cancellation RS object.
	 * @param cancelRS Cancellation RS object returned by Desia API
	 * @param uuid Unique idenfier used to map RQ objects with their RS's.
	 * @return Cancellation RS object specific to Bonton API
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static BTNCancelRS cancelBeanRSMapper(OTACancelRS otaCancelRS, String uuid) throws Exception {
		logger.info("cancel response mapping started ---->");
		
		/** Adding Desia cancel booking response for logging */
		reqResMap.get(uuid).add(otaCancelRS);
		
		BTNCancelRS btnCancelRS = new BTNCancelRS();
		
		if (otaCancelRS.getErrors() != null) {
			BTNCancelRS.BTNError errElmnt = new BTNCancelRS.BTNError();
			
			List<ErrorType> otaErrorLst = otaCancelRS.getErrors().getError();
			StringBuilder errCode = new StringBuilder();
			StringBuilder errMsg = new StringBuilder();
			for (ErrorType otaErrorType : otaErrorLst) {
				if (errCode.length() != 0) {
					errCode.append(DesiaProperties.SEP2);
					errMsg.append(DesiaProperties.SEP2);
				}
				errCode.append(otaErrorType.getCode());
				errMsg.append(otaErrorType.getValue());
				
			}
			errElmnt.setCode(errCode.toString());
			errElmnt.setMessage(errMsg.toString());

			btnCancelRS.setBTNError(errElmnt);
			
			/** Adding Desia cancel booking response for logging */
			reqResMap.get(uuid).add(btnCancelRS);
			
			logger.info("cancel response contains error. Returning ---->");
			return btnCancelRS;
		}
		BTNCancelRS.Booking btnBooking = new BTNCancelRS.Booking();
		
		if (TransactionStatusType.CANCELLED.equals(otaCancelRS.getStatus())) {
			btnBooking.setStatus(TransactionStatusType.CANCELLED.toString());
		} else {
			btnBooking.setStatus(TransactionStatusType.PENDING_CANCELLATION.toString());
		}
		btnCancelRS.setBooking(btnBooking);
		
		/** Adding bonton cancel booking response for logging */
		reqResMap.get(uuid).add(btnBooking);
		
		logger.info("cancel response mapping done ---->");
		return btnCancelRS;
	}
	
	public static OTAHotelResRQ provisionalFinalRQMapper(OTAHotelResRS otaHotelResRS) throws Exception {
		logger.info("provisiona plus final booking request mapping started ---->");
		OTAHotelResRQ otaHotelResRQ = new OTAHotelResRQ();
		
		POSType otaPOSType = new POSType();
		
		SourceType otaSourceType = new SourceType();
		otaSourceType.setISOCurrency("INR");
		
		RequestorID otaRequestorID = new RequestorID();
		otaRequestorID.setID("1300001211");
		otaRequestorID.setMessagePassword("test@789");
		
		CompanyNameType otaCompanyNameType = new CompanyNameType();
		otaCompanyNameType.setCode("bontonsell");
		
		otaRequestorID.setCompanyName(otaCompanyNameType);
		otaSourceType.setRequestorID(otaRequestorID);
		List<SourceType> otaPOSTypeLst = otaPOSType.getSource();
		otaPOSTypeLst.add(otaSourceType);
		
		/** Tag goes to final booking */
		List<UniqueIDType> otaUniqueIDTypeLst = otaHotelResRQ.getUniqueID();
		UniqueIDType otaUniqueIDType = new UniqueIDType();
		
		/** Setting provisional booking id */
		otaUniqueIDType.setID(((UniqueIDType)((HotelReservation) otaHotelResRS.getHotelReservations().getHotelReservation().get(0)).getUniqueID().get(0)).getID());
		otaUniqueIDType.setType("23");
		otaUniqueIDTypeLst.add(otaUniqueIDType);
		
		HotelReservationsType otaHotelReservationsType = new HotelReservationsType();
		List<HotelReservationsType.HotelReservation> otaHotelReservationsTypeLst = otaHotelReservationsType.getHotelReservation();
		
		HotelReservation otaHotelReservation = new HotelReservation();
		ResGlobalInfoType otaResGlobalInfoType = new ResGlobalInfoType();
		
		GuaranteeType otaGuaranteeType = new GuaranteeType();
		otaGuaranteeType.setGuaranteeType("PrePay");
		
		otaResGlobalInfoType.setGuarantee(otaGuaranteeType);
		otaHotelReservation.setResGlobalInfo(otaResGlobalInfoType);
		otaHotelReservationsTypeLst.add(otaHotelReservation);
		
		otaHotelResRQ.setHotelReservations(otaHotelReservationsType);
		otaHotelResRQ.setPOS(otaPOSType);
		
		logger.info("provisiona plus final booking request mapping done ---->");
		return otaHotelResRQ;
	}
		
	public static OTAHotelResRS sendFinalBookingRQ(OTAHotelResRQ otaHotelResRQ) throws Exception {
		return bookingSEI.createBooking(otaHotelResRQ);
	}
	
	public static OTAHotelResRS sendProvisionalBookingRQ(OTAHotelResRQ otaHotelResRQ) throws Exception {
		return bookingSEI.createBooking(otaHotelResRQ);
	}
	
	public static OTACancelRS sendCancelRQ(OTACancelRQ otaCancelRQ) throws Exception {
		return bookingSEI.cancelBooking(otaCancelRQ);
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
			List<? super Object> reqResLst = reqResMap.get(uuid);
			@Override
			public void run() {
				logger.info("logging for {} operation id {} started --->", op, uuid);

				try {
					switch (op) {
					case DesiaProperties.SEARCH:
						DesiaDBConnection.insert(op, 
								XmlProcessor.getBeanInXml((BTNSearchRequest) reqResLst.get(0)),
								XmlProcessor.getBeanInXml((AvailabilityRQ) reqResLst.get(1)),
								XmlProcessor.getBeanInXml((AvailabilityRS) reqResLst.get(2)),
								XmlProcessor.getBeanInXml((BTNSearchResponse) reqResLst.get(3)), 
								supplier);
						break;
					case DesiaProperties.FINALBOOKING:
						DesiaDBConnection.insert(op, 
								XmlProcessor.getBeanInXml((BTNFinalBookingRQ) reqResLst.get(0)),
								XmlProcessor.getBeanInXml((OTAHotelResRQ) reqResLst.get(1)),
								XmlProcessor.getBeanInXml((OTAHotelResRS) reqResLst.get(2)),
								XmlProcessor.getBeanInXml((BTNFinalBookingRS) reqResLst.get(3)),
								supplier);
						break;
					case DesiaProperties.CONFIRM: 
						DesiaDBConnection.insert(op, 
								XmlProcessor.getBeanInXml((BTNConfirmRequest) reqResLst.get(0)),
								XmlProcessor.getBeanInXml((OTAHotelResRQ) reqResLst.get(1)),
								XmlProcessor.getBeanInXml((OTAHotelResRS) reqResLst.get(2)),
								XmlProcessor.getBeanInXml((BTNConfirmResponse) reqResLst.get(3)), 
								supplier);
						break;
					case DesiaProperties.CANCEL: {
						DesiaDBConnection.insert(op, 
								XmlProcessor.getBeanInXml((BTNCancelRQ) reqResLst.get(0)),
								XmlProcessor.getBeanInXml((OTACancelRQ) reqResLst.get(1)),
								XmlProcessor.getBeanInXml((OTACancelRS) reqResLst.get(2)),
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
				
				logger.info("logging for {} operation id {} completed --->", op, uuid);
			}});
	}

}