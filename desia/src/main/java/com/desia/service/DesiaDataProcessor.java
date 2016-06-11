package com.desia.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bonton.utility.desia.Hotels;
import com.desia.artifacts.OTAHotelAvailRS;
import com.desia.artifacts.RatePlanType;
import com.desia.artifacts.RoomStayType.RoomRates.RoomRate;
import com.desia.artifacts.RoomTypeType;

public class DesiaDataProcessor {
	
	public static Hotels getHBDataReponseInAggregationFormat(OTAHotelAvailRS rs) {
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
	
	
}
