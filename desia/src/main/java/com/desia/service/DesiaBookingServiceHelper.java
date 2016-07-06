package com.desia.service;

import java.util.LinkedList;
import java.util.List;

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
import com.desia.artifacts.booking.BasicPropertyInfoType;
import com.desia.artifacts.booking.CompanyNameType;
import com.desia.artifacts.booking.GuestCountType;
import com.desia.artifacts.booking.HotelReservationsType;
import com.desia.artifacts.booking.HotelReservationsType.HotelReservation;
import com.desia.artifacts.booking.OTACancelRQ;
import com.desia.artifacts.booking.OTACancelRS;
import com.desia.artifacts.booking.OTAHotelResRQ;
import com.desia.artifacts.booking.OTAHotelResRS;
import com.desia.artifacts.booking.POSType;
import com.desia.artifacts.booking.RatePlanType;
import com.desia.artifacts.booking.ResCommonDetailType.TimeSpan;
import com.desia.artifacts.booking.RoomStayType.RatePlans;
import com.desia.artifacts.booking.RoomStayType.RoomRates.RoomRate.GuestCounts.GuestCount;
import com.desia.artifacts.booking.RoomStayType.RoomTypes;
import com.desia.artifacts.booking.RoomStaysType;
import com.desia.artifacts.booking.RoomTypeType;
import com.desia.artifacts.booking.RoomStaysType.RoomStay;
import com.desia.artifacts.booking.SourceType;
import com.desia.artifacts.booking.SourceType.RequestorID;
import com.desia.artifacts.booking.TGBookingServiceEndPoint;
import com.desia.artifacts.booking.TGBookingServiceEndPointImplService;
import com.desia.artifacts.booking.TaxesType;
import com.desia.artifacts.booking.TotalType;
import com.desia.artifacts.booking.UniqueIDType;
import com.desia.handler.MessageHandler;

public class DesiaBookingServiceHelper {
	private static Logger logger = LoggerFactory.getLogger(DesiaSearchServiceHelper.class);
	
	private static final TGBookingServiceEndPointImplService bookingSIB = new TGBookingServiceEndPointImplService();
	private static TGBookingServiceEndPoint bookingSEI = null;
	
	
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
	
	/**
	 * Used to map Bonton provisional booking RQ object to Desia
	 * specific provisional booking RQ object.
	 * @param btnConfirmRQ Bonton provisional booking RQ object
	 * @param uuid Unique idenfier used to map RQ objects with their RS's.
	 * @return Desia specific provisional booking RQ object
	 * @throws Exception In case any mapping error occurs
	 * @author Tirath
	 */
	public static OTAHotelResRQ provisionalBeanRQMapper(BTNConfirmRequest btnConfirmRQ) throws Exception {
		logger.info("confirm request mapping started ---->");
		OTAHotelResRQ otaHotelResRQ = new OTAHotelResRQ();
		POSType otaPOSType = new POSType();
		
		SourceType otaSourceType = new SourceType();
		otaSourceType.setISOCurrency("INR");
		
		RequestorID otaRequestorID = new RequestorID();
		otaRequestorID.setID("1300001210");
		otaRequestorID.setMessagePassword("test@567");
		
		CompanyNameType otaCompanyNameType = new CompanyNameType();
		otaCompanyNameType.setCode("bontonnet");
		
		otaRequestorID.setCompanyName(otaCompanyNameType);
		otaSourceType.setRequestorID(otaRequestorID);
		List<SourceType> otaPOSTypeLst = otaPOSType.getSource();
		otaPOSTypeLst.add(otaSourceType);
		
		/** Tag goes to final booking */
		List<UniqueIDType> otaUniqueIDTypeLst = otaHotelResRQ.getUniqueID();
		UniqueIDType otaUniqueIDType = new UniqueIDType();
		otaUniqueIDType.setID("");
		otaUniqueIDType.setType("");
		//otaUniqueIDTypeLst.add(otaUniqueIDType); //TODO: for final
		
		HotelReservationsType otaHotelReservationsType = new HotelReservationsType();
		List<HotelReservationsType.HotelReservation> otaHotelReservationsTypeLst = otaHotelReservationsType.getHotelReservation();
		
		HotelReservation otaHotelReservation = new HotelReservation();
		RoomStaysType otaRoomStaysType = new RoomStaysType();
		List<RoomStaysType.RoomStay> otaRoomStayLst = otaRoomStaysType.getRoomStay();
		
		List<BTNConfirmRequest.Rooms.Room> btnRoomLst = btnConfirmRQ.getRooms().getRoom();
		for (BTNConfirmRequest.Rooms.Room btnRoom : btnRoomLst) {
			String rateKey = btnRoom.getUniqueKey();
			rateKey = "2016-07-29|2016-07-30|0000014662| 0000040508| 73680.0| 0.0";
			String[] rateKeyAry = rateKey.split("\\|");
			
			
			List<BTNConfirmRequest.Rooms.Room.Paxes.Pax> btnPaxLst = btnRoom.getPaxes().getPax();
			for (BTNConfirmRequest.Rooms.Room.Paxes.Pax btnPax : btnPaxLst) {
				
			}
		}
		RoomStay otaRoomStay = new RoomStay();
		
		RoomTypes otaRoomTypes = new RoomTypes();
		List<RoomTypeType> otaRoomTypeLst = otaRoomTypes.getRoomType();
		
		RoomTypeType otaRoomTypeType = new RoomTypeType();
		otaRoomTypeType.setNumberOfUnits(1);
		otaRoomTypeType.setRoomTypeCode(value);
		
		
		RatePlans otaRatePlans = new RatePlans();
		List<RatePlanType> otaRatePlanLst = otaRatePlans.getRatePlan();
		
		RatePlanType otaRatePlanType = new RatePlanType();
		otaRatePlanType.setRatePlanCode("");
		
		GuestCountType otaGuestCountType = new GuestCountType();
		List<GuestCountType.GuestCount> otaGuestCountTypeLst = otaGuestCountType.getGuestCount();
		GuestCount otaGuestCount = new GuestCount();
		otaGuestCount.setAgeQualifyingCode(value);
		otaGuestCount.setCount(value);
		otaGuestCount.setResGuestRPH(value);
		
		TimeSpan otaTimeSpan = new TimeSpan();
		otaTimeSpan.setStart(value);
		otaTimeSpan.setStart(value);
		
		TotalType otaTotalType = new TotalType();
		otaTotalType.setAmountBeforeTax(value);
		
		TaxesType otaTaxesType = new TaxesType();
		otaTaxesType.setAmount(value);
		
		otaTotalType.setTaxes(otaTaxesType);
		
		BasicPropertyInfoType otaBasicPropertyInfoType = new BasicPropertyInfoType();
		otaBasicPropertyInfoType.setHotelCode(value);
		
		otaRoomStay.setBasicPropertyInfo(otaBasicPropertyInfoType);
		otaRoomStay.setTotal(otaTotalType);
		otaRoomStay.setTimeSpan(otaTimeSpan);
		otaRoomStay.setGuestCounts(otaGuestCountType);
		otaRoomStay.setRatePlans(otaRatePlans);
		otaRoomTypeLst.add(otaRoomTypeType);
		otaRoomStay.setRoomTypes(otaRoomTypes);
		otaRoomStayLst.add(otaRoomStay);
		otaHotelReservation.setRoomStays(otaRoomStaysType);
		otaHotelReservationsTypeLst.add(otaHotelReservation);
		otaHotelResRQ.setHotelReservations(otaHotelReservationsType);
		otaHotelResRQ.setPOS(otaPOSType);
		
		logger.info("confirm request mapping done ---->");
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
	public static BTNConfirmResponse provisionalBeanRSMapper(OTAHotelResRS otaHotelResRS) throws Exception {
		logger.info("confirm response mapping started ---->");
		BTNConfirmResponse btnConfirmRS = new BTNConfirmResponse();
		
		/* Add appropriate mapping here. */
		
		logger.info("confirm response mapping done ---->");
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
	public static OTACancelRQ cancelBeanRequestMapper(BTNCancelRQ btnCancelRQ) throws Exception {
		logger.info("confirm request mapping started ---->");
		OTACancelRQ otaCancelRQ = new OTACancelRQ();
		
		/* Add appropriate mapping here. */
		
		logger.info("confirm response mapping done ---->");
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
	public static BTNCancelRS cancelBeanResponseMapper(OTACancelRS otaCancelRS) throws Exception {
		logger.info("cancel response mapping started ---->");
		BTNCancelRS btnCancelRS = new BTNCancelRS();
		
		/* Add appropriate mapping here. */
		
		logger.info("cancel response mapping done ---->");
		return btnCancelRS;
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
}