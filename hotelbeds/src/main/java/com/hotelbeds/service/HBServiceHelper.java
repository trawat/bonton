package com.hotelbeds.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNCancelRS;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNConfirmResponse;
import com.bonton.utility.artifacts.BTNRepriceResponse;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.artifacts.BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate;
import com.bonton.utility.hotelbeds.AvailabilityRQ;
import com.bonton.utility.hotelbeds.AvailabilityRS;
import com.bonton.utility.hotelbeds.BookingCancellationRS;
import com.bonton.utility.hotelbeds.BookingRQ;
import com.bonton.utility.hotelbeds.BookingRS;
import com.bonton.utility.hotelbeds.CheckRateRS;

public class HBServiceHelper {
	
	private static Logger logger = LoggerFactory.getLogger(HBServiceHelper.class);
	
	/* To get the rate response sorted on the basis of board code */
	public static final Comparator<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate> rateListCmptr = 
	new Comparator<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate> () {

		@Override
		public int compare(Rate r1, Rate r2) {
			String brdOne = r1.getMealCode();
			String brdTwo = r2.getMealCode();
			return brdOne.compareTo(brdTwo);
		}};

	
	private HBServiceHelper() {}
	
	public static AvailabilityRQ searchBeanRequestMapper(BTNSearchRequest btnSearchRq) {
		AvailabilityRQ availabilityRQ = new AvailabilityRQ();
		
		/* To fetch the daily price break down */
		availabilityRQ.setDailyRate(btnSearchRq.getRequestDetails().getSearchHotelPriceRequest().isIncludePriceBreakdown());
		
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
	
	public static BTNSearchResponse searchBeanResponseMapper(AvailabilityRS availabilityRS) throws Exception {

		BTNSearchResponse btnSearchResponse = new BTNSearchResponse();

		if (availabilityRS.getError() != null) {
			BTNSearchResponse.BTNError errElmnt = new BTNSearchResponse.BTNError();
			errElmnt.setCode(availabilityRS.getError().getCode());
			errElmnt.setMessage(availabilityRS.getError().getMessage());

			btnSearchResponse.setBTNError(errElmnt);
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
			resHotel.setHotelName(hotel.getName());
			resHotel.setStarRating(hotel.getCategoryName());
			resHotel.setLatitude(hotel.getLatitude() == null? 0f: hotel.getLatitude());
			resHotel.setLongitude(hotel.getLongitude() == null? 0f: hotel.getLongitude());
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

			List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room> resRoomLst = resRoomOptions.getRoom();
			List<AvailabilityRS.Hotels.Hotel.Rooms.Room> roomLst = hotel.getRooms().getRoom();

			for (AvailabilityRS.Hotels.Hotel.Rooms.Room room : roomLst) {
				BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room resRoom = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room();
				resRoom.setRoomType(room.getName());
				resRoom.setSupplier("HOTELBEDS");

				List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate> resRateLst = resRoom.getRate();
				List<AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate> rateLst = room.getRates().getRate();
				
								
				for (AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate rate : rateLst) {
					/* Skip rate entry if rateType is not bookable. Other possibility is recheck */
//					if (!rate.getRateType().equals("BOOKABLE")) {
//						continue;
//					}
					
					BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate resRate = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate();
					resRate.setRateKey(rate.getRateKey());
					resRate.setPackaging(rate.getPackaging());
					resRate.setMealType(rate.getBoardName());
					
					/* Meal code contains board code. Should not be changes. Otherwise breaks the rate list
					 * sorting logic. Change the comparator logic if it must change. */
					resRate.setMealCode(rate.getBoardCode());
					resRate.setChildren(rate.getChildren());
					resRate.setAdults(rate.getAdults());
					resRate.setChildrenAges(rate.getChildrenAges());

					resRate.setSupplierPrice(rate.getNet());
					resRate.setOtaFee(0.0f);
					resRate.setOtaDiscountAmount(0.0f);

					BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.CancellationPolicies resCancPlcies = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.CancellationPolicies();
					List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.CancellationPolicies.CancellationPolicy> resCancPlcyLst = resCancPlcies.getCancellationPolicy();
					List<AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy> cancPlcyLst = rate.getCancellationPolicies().getCancellationPolicy();

					for (AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate.CancellationPolicies.CancellationPolicy cancPlcy : cancPlcyLst) {
						BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.CancellationPolicies.CancellationPolicy resCancPlcy = 
								new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.CancellationPolicies.CancellationPolicy();

						resCancPlcy.setAmount(cancPlcy.getAmount());
						resCancPlcy.setFrom(cancPlcy.getFrom());

						resCancPlcyLst.add(resCancPlcy);
					}

					BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates resDailyRates = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates();
					List<BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate> resDailyRateLst = resDailyRates.getDailyRate();

					List<AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate.DailyRates.DailyRate> dailyRateLst = rate.getDailyRates().getDailyRate();
					for (AvailabilityRS.Hotels.Hotel.Rooms.Room.Rates.Rate.DailyRates.DailyRate dailyRate : dailyRateLst) {
						BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate resDailyRate = new BTNSearchResponse.HotelOptions.Hotel.RoomOptions.Room.Rate.DailyRates.DailyRate();
						resDailyRate.setOffset(dailyRate.getOffset());
						resDailyRate.setDailyNet(dailyRate.getDailyNet());

						/* adding to the daily rate list */
						resDailyRateLst.add(resDailyRate);
					}
					resRate.setDailyRates(resDailyRates);
					resRate.setCancellationPolicies(resCancPlcies);
					
					resRateLst.add(resRate);
				}
				/* Sorted rate list */
				Collections.sort(resRateLst, rateListCmptr);
				resRoomLst.add(resRoom);				
			}
			resHotelLst.add(resHotel);
		}
		return btnSearchResponse;
	}
	
	public static BookingRQ confirmBeanRequestMapper(BTNConfirmRequest btnbookingRq) {		
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
		
		return bookingRQ;
	}
	
	public static BTNConfirmResponse confirmBeanResponseMapper(BookingRS bookingRS) throws Exception {
		BTNConfirmResponse btnConfirmResponse = new BTNConfirmResponse();
		
		if (bookingRS.getError() != null) {
			BTNConfirmResponse.BTNError errElmnt = new BTNConfirmResponse.BTNError();
			errElmnt.setCode(bookingRS.getError().getCode());
			errElmnt.setMessage(bookingRS.getError().getMessage());
			
			btnConfirmResponse.setBTNError(errElmnt);
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
	
	public static BTNCancelRS cancelBeanResponseMapper(BookingCancellationRS cancelRS) throws Exception {
		BTNCancelRS btnCancelRS = new BTNCancelRS();
		
		if (cancelRS.getError() != null) {
			BTNCancelRS.BTNError errElmnt = new BTNCancelRS.BTNError();
			errElmnt.setCode(cancelRS.getError().getCode());
			errElmnt.setMessage(cancelRS.getError().getMessage());
			
			btnCancelRS.setBTNError(errElmnt);
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
	
	public static BTNRepriceResponse repriceBeanResponseMapper(CheckRateRS checkRateRS) throws Exception {
		BTNRepriceResponse btnRepriceRs = new BTNRepriceResponse();

		if (checkRateRS.getError() != null) {
			BTNRepriceResponse.BTNError errElmnt = new BTNRepriceResponse.BTNError();
			errElmnt.setCode(checkRateRS.getError().getCode());
			errElmnt.setMessage(checkRateRS.getError().getMessage());

			btnRepriceRs.setBTNError(errElmnt);
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
		//  hotel.getZoneCode();
		//  hotel.getZoneName();
		//  hotel.getLatitude();
		//  hotel.getLongitude();  
		//  hotel.getCurrency();
		//  hotel.getTotalNet();
		//  total selling rate .... (need to add)

		BTNRepriceResponse.Hotel.Rooms resRooms = new BTNRepriceResponse.Hotel.Rooms();
		BTNRepriceResponse.Hotel.Rooms.Room resRoom = new BTNRepriceResponse.Hotel.Rooms.Room();
		
		List<CheckRateRS.Hotel.Rooms.Room> roomLst = hotel.getRooms().getRoom();
		for (CheckRateRS.Hotel.Rooms.Room room : roomLst) {
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
		}
		resRooms.setRoom(resRoom);
		resHotel.setRooms(resRooms);
		btnRepriceRs.setHotel(resHotel);
		
		return btnRepriceRs;
	}
		
}
