package com.hotelbeds.service;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNCancelRS;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNConfirmRequest.Rooms.Room;
import com.bonton.utility.artifacts.BTNConfirmRequest.Rooms.Room.Paxes.Pax;
import com.bonton.utility.artifacts.BTNConfirmResponse;
import com.bonton.utility.artifacts.BTNError;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNRepriceResponse;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.hotelbeds.AvailabilityRQ;
import com.bonton.utility.hotelbeds.AvailabilityRS;
import com.bonton.utility.hotelbeds.BookingCancellationRS;
import com.bonton.utility.hotelbeds.BookingRS;
import com.bonton.utility.hotelbeds.CheckRateRS;
import com.bonton.utility.processor.XmlProcessor;
import com.hotelbeds.util.BontonConfigImpl;
import com.hotelbeds.util.HBProperties;

public class HBServiceHelper {
	
	private static Logger logger = LoggerFactory.getLogger(HBServiceHelper.class); 
	
	public HBServiceHelper() {}
	
	public AvailabilityRQ searchBeanRequestMapper(BTNSearchRequest btnSearchRq) {
		AvailabilityRQ availabilityRQ = new AvailabilityRQ();

		AvailabilityRQ.Destination destination = new AvailabilityRQ.Destination();
		destination.setCode(btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getItemDestination().getDestinationCode());
		//destination.setZone(searchBean.getRequestDetails().getSearchHotelPriceRequest().getItemDestination().getDestinationType());  

		availabilityRQ.setDestination(destination);

		AvailabilityRQ.Filter filter = new AvailabilityRQ.Filter();
		filter.setMinCategory(btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getMinStarRating());
		filter.setMaxCategory(btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getMaxStarRating());

		availabilityRQ.setFilter(filter);

		AvailabilityRQ.Stay stay = new AvailabilityRQ.Stay();
		stay.setCheckIn(btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getPeriodOfStay().getCheckInDate());
		stay.setCheckOut(btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getPeriodOfStay().getCheckOutDate());

		availabilityRQ.setStay(stay);

		List<BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room> roomLst = btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().getRooms().getRoom();
		
		AvailabilityRQ.Occupancies resOccupancies = new AvailabilityRQ.Occupancies(); 
		availabilityRQ.setOccupancies(resOccupancies);
		
		List<AvailabilityRQ.Occupancies.Occupancy> resOccupancyLst = availabilityRQ.getOccupancies().getOccupancy();
		
		for (BTNSearchRequest.RequestDetails.SearchHotelPriceRequest.Rooms.Room room : roomLst) {
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
		return availabilityRQ;
	}
	
	public BTNSearchResponse searchBeanResponseMapper(AvailabilityRS availabilityRS) throws Exception {
		
		BTNSearchResponse btnSearchResponse = new BTNSearchResponse();

		if (availabilityRS.getError() != null) {
			BTNError errElmnt = new BTNError();
			errElmnt.setCode(availabilityRS.getError().getCode());
			errElmnt.setMessage(availabilityRS.getError().getMessage());
			
			btnSearchResponse.setError(errElmnt);
			return btnSearchResponse;
		}
		
		/** do the appropriate mapping*/
		btnSearchResponse.setServiceRequestID("");
		btnSearchResponse.setServiceRequestID("");
		
		btnSearchResponse.setOptionsCount(availabilityRS.getHotels().getTotal());
		
		boolean onlyOnce = true;
		BTNSearchResponse.HotelOptions resHotelOptions = new  BTNSearchResponse.HotelOptions();
		btnSearchResponse.setHotelOptions(resHotelOptions);
		
		List<BTNSearchResponse.HotelOptions.Hotel> resHotelLst = btnSearchResponse.getHotelOptions().getHotel();
		List<AvailabilityRS.Hotels.Hotel> hotelLst = availabilityRS.getHotels().getHotel();
		
		for (AvailabilityRS.Hotels.Hotel hotel : hotelLst) {

			BTNSearchResponse.HotelOptions.Hotel resHotel = new BTNSearchResponse.HotelOptions.Hotel();
			resHotel.setHotelCode(hotel.getCode());
			resHotel.setStarRating(hotel.getCategoryName());
			resHotel.setLatitude(hotel.getLatitude());
			resHotel.setLongitude(hotel.getLongitude());
			resHotel.setFullAddress(hotel.getAddress());

			/* As this is common for all the hotels*/
			if (onlyOnce) {
				BTNSearchResponse.City city = new BTNSearchResponse.City();
				city.setCityCode(hotel.getDestinationCode());
				city.setCityName(hotel.getDestinationName());
				btnSearchResponse.setCity(city);
				onlyOnce = false;
			}
			
			BTNSearchResponse.HotelOptions.Hotel.RoomOptions resRoomOptions = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions();
			resHotel.setRoomOptions(resRoomOptions);
			
			List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room> resRoomLst = resHotel.getRoomOptions().getRoom();
			List<AvailabilityRS.Hotels.Hotel.Rooms.Room> roomLst = hotel.getRooms().getRoom();
			
			for (AvailabilityRS.Hotels.Hotel.Rooms.Room room : roomLst){

				BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room resRoom = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room();
				resRoom.setRoomDescription(room.getName());
				resRoom.setSupplier("HOTELBEDS");
				
				/* check this .. using first index for now*/
//				List<AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate> rateLst = room.getRates().getRate();
				AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate rate = room.getRates().getRate();
				BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.FinalPrice resFinalPrice = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.FinalPrice();
				
				//resRoom.set (rate.getNet());
				resRoom.setRateKey(rate.getRateKey());
				resRoom.setPackaging(rate.getPackaging());
				
				resFinalPrice.setSupplierPrice(rate.getNet());
				resFinalPrice.setOtaFee(0.0f);
				resFinalPrice.setOtaDiscountAmount(0.0f);
				
				BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.CancellationPolicies resCancPlcy = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.CancellationPolicies();
				resCancPlcy.setAmount(rate.getCancellationPolicies().getCancellationPolicy().getAmount());
				resCancPlcy.setFrom(rate.getCancellationPolicies().getCancellationPolicy().getFrom());
				
				resRoom.setFinalPrice(resFinalPrice);
				resRoom.setCancellationPolicies(resCancPlcy);
				resRoomLst.add(resRoom);
			}
			resHotelLst.add(resHotel);
		}


		// availabilityRS.getHotels().getHotel().getDestinationCode();
		// availabilityRS.getHotels().getHotel().getDestinationName();
		// availabilityRS.getHotels().getHotel().getCode();
		// availabilityRS.getHotels().getHotel().getCategoryName();
		// availabilityRS.getHotels().getHotel().getLongitude();
		// availabilityRS.getHotels().getHotel().getLatitude();
		// availabilityRS.getHotels().getHotel().getAddress();  
		// availabilityRS.getHotels().getHotel().getRooms().getRoom().getName();
		// availabilityRS.getHotels().getHotel().getRooms().getRoom().getRates().getRate().getNet();
		// availabilityRS.getHotels().getHotel().getRooms().getRoom().getRates().getRate().getRateKey();
		// availabilityRS.getHotels().getHotel().getRooms().getRoom().getRates().getRate().getPackaging();

		return btnSearchResponse;
	}
	
	public BTNConfirmResponse confirmBeanResponseMapper(BookingRS bookingRS) throws Exception {
		BTNConfirmResponse btnConfirmResponse = new BTNConfirmResponse();
		
		if (bookingRS.getError() != null) {
			BTNError errElmnt = new BTNError();
			errElmnt.setCode(bookingRS.getError().getCode());
			errElmnt.setMessage(bookingRS.getError().getMessage());
			
			btnConfirmResponse.setError(errElmnt);
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
		//hotel.getZoneCode() //setters not available
		//hotel.getZoneName()
		//hotel.getLatitude()
		//hotel.getLongitude()
		//hotel.getTotalNet()
		//hotel.getCurrency()
		
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
		
		
		return btnConfirmResponse;
	}
	
	public BTNCancelRS cancelBeanResponseMapper(BookingCancellationRS cancelRS) throws Exception {
		BTNCancelRS btnCancelRS = new BTNCancelRS();
		
		if (cancelRS.getError() != null) {
			BTNError errElmnt = new BTNError();
			errElmnt.setCode(cancelRS.getError().getCode());
			errElmnt.setMessage(cancelRS.getError().getMessage());
			
			btnCancelRS.setError(errElmnt);
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
		
		
		return btnCancelRS;
	}
	
	public BTNRepriceResponse repriceBeanResponseMapper(CheckRateRS repriceRS) throws Exception {
		BTNRepriceResponse btnRepriceRs = new BTNRepriceResponse();
		
		/* Add the appropriate mappings here */
		
		return btnRepriceRs;
	} 
	public String sendCancellation (BTNCancelRQ cancelBean) throws Exception {
		String result = "";
		String refId = cancelBean.getCancelDetails().getReferenceId();
		String flag = cancelBean.getCancelDetails().getCancelFlag();
		
		BontonConfigImpl.init();//get rid of this later
		try {
			Request.Builder requestBuilder = 
					new Request.Builder().headers(getHeadersForBookingOrCancellation("DELETE")).url(HBProperties.HB_CANCEL_BOOKING_URL + "/" + refId + "?cancellationFlag=" + flag);
			requestBuilder.delete();
			
			Response response = BontonConfigImpl.getRestTemplate().newCall(requestBuilder.build()).execute();
			try (ResponseBody body = response.body()) {
				BufferedSource source = body.source();
				source.request(Long.MAX_VALUE);
				Buffer buffer = source.buffer();
				Charset charset = HBProperties.UTF8;
				if (body.contentType() != null) {
					try {
						charset = body.contentType().charset(HBProperties.UTF8);
					} catch (UnsupportedCharsetException e) {
						// logger.log("Response body could not be decoded {}", e.getMessage());
					}
				}
				result = buffer.readString(charset);
//				if (response.headers().get(HBProperties.CONTENT_TYPE_HEADER).toLowerCase().startsWith(HBProperties.APPLICATION_JSON_HEADER)) {
//					return result;
//				} else {
//					//throw new HotelBedsConnectorException("Invalid response", "Wrong content type" + response.headers().get(HotelBedsProperties.CONTENT_TYPE_HEADER));
//				}
			} catch (IOException e) {
				if (e.getCause() != null && e.getCause() instanceof SocketTimeoutException) {
					//throw new HotelBedsConnectorException("Timeout", e.getCause().getMessage());
				} else {
					//throw new HotelBedsConnectorException("Error accessing API", e.getMessage());
				}
			}
		} catch (Exception e) {
			//throw new HotelBedsConnectorException(e.getClass().getName(), e.getMessage(), e);
		}
		return result;
	}
	
	private BTNSearchResponse searchBeanResponseMapper(String hbSearchResXml) throws Exception {
		AvailabilityRS availabilityRS = XmlProcessor.getHBSearchRSBean(hbSearchResXml);
		BTNSearchResponse btnSearchResponse = new BTNSearchResponse();
		
		/** do the appropriate mapping*/
		
		return btnSearchResponse;
	}
	
	public <T> String sendRequest(T rqObj) throws Exception {
		BontonConfigImpl.init();//get rid of this later
		
		String requestXML = XmlProcessor.getBeanInXml(rqObj);
		
		/* should be modified later **/
		
		logger.debug("Sending Request to get HB Htel Data {}", requestXML);
        Request.Builder requestBuilder = new Request.Builder().headers(getHeaders("POST")).url(HBProperties.HB_GET_HOTELS_END_POINT);
        requestBuilder.header("Accept", "application/xml");
        requestBuilder.post(RequestBody.create(HBProperties.XML, requestXML));
        
      //@TODO: this should be moved to HB. Copying temporarily to HB
        //Also check the response code in order to verify status
        Response response = BontonConfigImpl.getRestTemplate().newCall(requestBuilder.build()).execute();
        logger.debug("HB Hotel Data Response Code : "+response.code()+" : Response Message : "+response.message());
        
        
        try (ResponseBody body = response.body()) {
            BufferedSource source = body.source();
            source.request(Long.MAX_VALUE);
            Buffer buffer = source.buffer();
            Charset charset = HBProperties.UTF8;
            if (body.contentType() != null) {
                try {
                    charset = body.contentType().charset(HBProperties.UTF8);
                } catch (UnsupportedCharsetException e) {
                    logger.error("Response body could not be decoded {}", e.getMessage());
                }
            }
            return buffer.readString(charset);
        } catch (Exception e) {
        	logger.debug("Error {}", e);
        	throw e;
        }
	}
	
	public String getHotelsDataJson(BTNSearchRequest xmlRequestObj, String requestId) throws Exception {
			
			String requestJsonString = getSearchHotelsJsonRequestString(xmlRequestObj);
			StringBuilder stringBuilder = new StringBuilder();
			String result = "";
			BontonConfigImpl.init();
				//if (;) {
		            try {
		            	logger.debug("Sending Request to get HB Htel Data");
		                Request.Builder requestBuilder = new Request.Builder().headers(getHeaders("POST")).url(HBProperties.HB_GET_HOTELS_END_POINT);
		                requestBuilder.post(RequestBody.create(HBProperties.JSON, requestJsonString));
		                
		                
		                //@TODO: this should be moved to HB. Copying temporarily to HB
		                Response response = BontonConfigImpl.getRestTemplate().newCall(requestBuilder.build()).execute();
		                logger.debug("HB Hotel Data Response Code : "+response.code()+" : Response Message : "+response.message());
		                try (ResponseBody body = response.body()) {
		                    BufferedSource source = body.source();
		                    source.request(Long.MAX_VALUE);
		                    Buffer buffer = source.buffer();
		                    Charset charset = HBProperties.UTF8;
		                    if (body.contentType() != null) {
		                        try {
		                            charset = body.contentType().charset(HBProperties.UTF8);
		                        } catch (UnsupportedCharsetException e) {
		                            logger.error("Response body could not be decoded {}", e.getMessage());
		                        }
		                    }
		                    result = buffer.readString(charset);
		                    if (response.headers().get(HBProperties.CONTENT_TYPE_HEADER).toLowerCase().startsWith(HBProperties.APPLICATION_JSON_HEADER)) {
		                         return result;
		                    } else {
		                    	logger.error("Invalid response Wrong content type" + response.headers().get(HBProperties.CONTENT_TYPE_HEADER));
		                    }
		                }
		            } catch (IOException e) {
		                if (e.getCause() != null && e.getCause() instanceof SocketTimeoutException) {
		                	logger.error("Timeout {}", e);
		                	
		                } else {
		                	logger.error("Error accessing API", e.getMessage());
		                }
		                return HBProperties.SERVICE_TEMPORARILY_DOWN;
		            } catch (Exception e) {
		            	e.printStackTrace(System.out);
		            	throw e;
		            }
				//}
			return result;
	}
	
	public String sendBookingConfirmationAndGetResult(BTNConfirmRequest confirmBean) {
		String responseStr = "";
		String requestXmlString = getHotelBedsBookingConfirmationRequestXml(confirmBean);
		BontonConfigImpl.init();//get rid of this
		//if (BontonConfigImpl.isInitialised()) {
            try {
            	logger.debug("Sending Request to Booking Confirmation");
                Request.Builder requestBuilder = new Request.Builder().headers(getHeadersForBookingOrCancellation("POST")).url(HBProperties.HB_CONFIRM_BOOKING_POST_URL);
                requestBuilder.post(RequestBody.create(HBProperties.XML,requestXmlString));
                Response response = BontonConfigImpl.getRestTemplate().newCall(requestBuilder.build()).execute();
                logger.debug("HB Send Booking Confirmation Response Code : "+response.code()+" : Response Message : "+response.message());
                try (ResponseBody body = response.body()) {
                    BufferedSource source = body.source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer = source.buffer();
                    Charset charset = HBProperties.UTF8;
                    if (body.contentType() != null) {
                        try {
                            charset = body.contentType().charset(HBProperties.UTF8);
                        } catch (UnsupportedCharsetException e) {
                            logger.error("Response body could not be decoded {}", e.getMessage());
                        }
                    }
                    responseStr = buffer.readString(charset);
                    if (response.headers().get(HBProperties.CONTENT_TYPE_HEADER).toLowerCase().startsWith(HBProperties.APPLICATION_XML_HEADER)) {
                         return responseStr;
                    } else {
                    	logger.error("Invalid response Wrong content type" + response.headers().get(HBProperties.CONTENT_TYPE_HEADER));
                    }
                }
            } catch (IOException e) {
                if (e.getCause() != null && e.getCause() instanceof SocketTimeoutException) {
                	logger.error("Timeout", e.getCause().getMessage());
                	
                } else {
                	logger.error("Error accessing API", e.getMessage());
                }
                return HBProperties.SERVICE_TEMPORARILY_DOWN;
            } catch (Exception e) {
            	logger.error(e.getClass().getName(), e.getMessage(), e);
            	return HBProperties.SERVICE_TEMPORARILY_DOWN;
            }
		//}
		
		
		return responseStr;
	}
	
	
	public String sendRepricing(BTNRepriceRequest repricingBean) {
		String result = "";
		String rateKey = repricingBean.getRooms().getRoom().getUniqueKey();
		BontonConfigImpl.init();//get rid of this later
		try {
			Request.Builder requestBuilder = new Request.Builder().headers(getHeaders("GET")).url(HBProperties.HB_REPRICING_RATE_KEY_GET_URL+"?rateKey="+rateKey);

			Response response = BontonConfigImpl.getRestTemplate().newCall(requestBuilder.build()).execute();
			try (ResponseBody body = response.body()) {
				BufferedSource source = body.source();
				source.request(Long.MAX_VALUE);
				Buffer buffer = source.buffer();
				Charset charset = HBProperties.UTF8;
				if (body.contentType() != null) {
					try {
						charset = body.contentType().charset(HBProperties.UTF8);
					} catch (UnsupportedCharsetException e) {
						// logger.log("Response body could not be decoded {}", e.getMessage());
					}
				}
				result = buffer.readString(charset);
				
				logger.debug("Response body could not be decoded recheckHotelPricingAndGetResult {}", result);
				if (response.headers().get(HBProperties.CONTENT_TYPE_HEADER).toLowerCase().startsWith(HBProperties.APPLICATION_JSON_HEADER)) {
					return result;
				} else {
					//throw new HotelBedsConnectorException("Invalid response", "Wrong content type" + response.headers().get(HotelBedsProperties.CONTENT_TYPE_HEADER));
				}
			} catch (IOException e) {
				if (e.getCause() != null && e.getCause() instanceof SocketTimeoutException) {
					//throw new HotelBedsConnectorException("Timeout", e.getCause().getMessage());
				} else {
					//throw new HotelBedsConnectorException("Error accessing API", e.getMessage());
				}
			}
		} catch (Exception e) {
			//throw new HotelBedsConnectorException(e.getClass().getName(), e.getMessage(), e);
		}
		return result;
	}
	
	//TODO: modify this to throw exception and use loggers appropriately
	private String getSearchHotelsJsonRequestString(BTNSearchRequest bean) {
		String resultStr = "";
		if(bean != null) {
			String checkin = bean.getRequestDetails().getSearchHotelPriceRequest().getPeriodOfStay().getCheckInDate().toString();
			String checkout = bean.getRequestDetails().getSearchHotelPriceRequest().getPeriodOfStay().getCheckOutDate().toString();

			try {
				Date date1;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				date1 = sdf.parse(checkin);

				Date date2;
				date2 = sdf.parse(checkout);    

				if(date1.after(date2)){
					logger.error("checkIn must be prior to checkOut date");
				}

				else if(date2.before(date1)){
					logger.error("checkIn must be prior to checkOut date");
				}

				else if(date1.equals(date2)){
					logger.error("Dates can't have same values");
				}

				int numberOfRooms = 0;//bean.getRequestDetails().getSearchHotelPriceRequest().getRooms().getRoom().getNumberOfRooms();
				String minStarRating = bean.getRequestDetails().getSearchHotelPriceRequest().getMinStarRating();
				String maxStarRating = bean.getRequestDetails().getSearchHotelPriceRequest().getMaxStarRating();
				String destination = bean.getRequestDetails().getSearchHotelPriceRequest().getItemDestination().getDestinationCode();

				resultStr = "{\"occupancies\":[{\"rooms\":"+numberOfRooms+",\"children\":0,\"adults\":1,\"paxes\":[]}],\"stay\":{\"checkIn\":\""+checkin+"\",\"checkOut\":\""+checkout+"\"},\"destination\": {\"code\": \""+destination+"\"},\"filter\": {\"minCategory\": "+minStarRating+",\"maxCategory\": "+maxStarRating+"}}";
				logger.debug("json string {}", resultStr);
			}catch(Exception e) {
				logger.error("Error Parsing Data", e);
				e.printStackTrace();
			}
		}
		return resultStr;

	}
	
	private Headers getHeaders(String httpMethod) {
        Headers.Builder headersBuilder = new Headers.Builder();
        headersBuilder.add(HBProperties.API_KEY_HEADER_NAME, HBProperties.API_KEY);
        headersBuilder.add("User-Agent", "hotel-api-sdk-java, " + getClass().getPackage().getImplementationVersion());
        // Hash the Api Key + Shared Secret + Current timestamp in seconds
        headersBuilder.add(HBProperties.SIGNATURE_HEADER_NAME, DigestUtils.sha256Hex(HBProperties.API_KEY + HBProperties.SHARED_SECRET + System.currentTimeMillis() / 1000));
        headersBuilder.add("Accept", "application/json");
        headersBuilder.add("Content-Type", "application/json; charset=UTF-8");
        switch (httpMethod) {
            case "GET":
            case "POST":
                headersBuilder.add("Content-Type", HBProperties.APPLICATION_JSON_HEADER);
                break;
            case "DELETE":
                headersBuilder.add("Content-Type", HBProperties.APPLICATION_XML_HEADER);
                break;
            default:
                break;
        }
        return headersBuilder.build();
    }
	
	private Headers getHeadersForBookingOrCancellation(String httpMethod) {
        Headers.Builder headersBuilder = new Headers.Builder();
        headersBuilder.add(HBProperties.API_KEY_HEADER_NAME, HBProperties.API_KEY);
        headersBuilder.add("User-Agent", "hotel-api-sdk-java, " + getClass().getPackage().getImplementationVersion());
        // Hash the Api Key + Shared Secret + Current timestamp in seconds
        headersBuilder.add(HBProperties.SIGNATURE_HEADER_NAME, DigestUtils.sha256Hex(HBProperties.API_KEY + HBProperties.SHARED_SECRET + System.currentTimeMillis() / 1000));
        headersBuilder.add("Accept", "application/xml");
        headersBuilder.add("Content-Type", "application/xml; charset=UTF-8");
        switch (httpMethod) {
            case "GET":
            case "POST":
                headersBuilder.add("Content-Type", HBProperties.APPLICATION_XML_HEADER);
                break;
            case "DELETE":
                headersBuilder.add("Content-Type", HBProperties.APPLICATION_XML_HEADER);
                break;
            default:
                break;
        }
        return headersBuilder.build();
    }
	
	/**
	 * @param confirmBookingRequestObj
	 * @return request xml that will be sent to HotelBeds API for booking Confirmation
	 */
	public static String getHotelBedsBookingConfirmationRequestXml(BTNConfirmRequest confirmBean) {
		
		StringBuilder xmlString = new StringBuilder("");
		
		xmlString.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		xmlString.append("<bookingRQ xmlns=\"http://www.hotelbeds.com/schemas/messages\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
		xmlString.append("<holder name=\""+confirmBean.getPrinciplePax().getName()+"\" surname=\""+confirmBean.getPrinciplePax().getSurname()+"\"/>");
		xmlString.append("<clientReference>"+confirmBean.getClientReference()+"</clientReference>");
		xmlString.append("<rooms>");
		
		List<Room> roomLst = confirmBean.getRooms().getRoom();
		int rooms = roomLst.size();
		for (Room room : roomLst) {
			xmlString.append("<room rateKey=\""+room.getUniqueKey()+"\">");
			xmlString.append("<paxes>");
			List<Pax> paxLst = room.getPaxes().getPax();
			for (Pax p : paxLst) {
				xmlString.append("<pax roomId=\""+p.getRoomId()+"\""+" type=\""+p.getType()+"\" age=\""+p.getAge()+"\" name=\""+p.getName()+"\" surname=\""+p.getSurname()+"\"/>");
			}
			xmlString.append("</paxes>");
			xmlString.append("</room>");
		}
		
		xmlString.append("</rooms>");
		/*xmlString.append("<paymentData>");
		xmlString.append("<paymentCard>");
		xmlString.append("<cardType>"+cardType+"</cardType>");
		xmlString.append("<cardNumber>"+cardNumber+"</cardNumber>");
		xmlString.append("<expiryDate>"+expiryDate+"</expiryDate>");
		xmlString.append("<cardCVC>"+cardCVC+"</cardCVC>");
		xmlString.append(" </paymentCard>");
		xmlString.append("<contactData>");
		xmlString.append("<email>"+email+"</email>");
		xmlString.append("<phoneNumber>"+phoneNum+"</phoneNumber>");
		xmlString.append(" </contactData>");
		xmlString.append("</paymentData>");*/
		xmlString.append("</bookingRQ>");
		
		logger.debug(xmlString.toString());
		return xmlString.toString();
		
	}
	
}
