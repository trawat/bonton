package com.bonton.beans.hb;

import java.util.List;

public class HotelDataRequest {

	private String checkin = "";
	private String checkOut = "";
	private String shiftDays = "";
	private List<Occupancies> occupancies = null;
	private String jsonString = "";
	
	public String getJsonString() {
		return jsonString;
	}
	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public String getShiftDays() {
		return shiftDays;
	}
	public void setShiftDays(String shiftDays) {
		this.shiftDays = shiftDays;
	}
	public List<Occupancies> getOccupancies() {
		return occupancies;
	}
	public void setOccupancies(List<Occupancies> occupancies) {
		this.occupancies = occupancies;
	}
	
	public static HotelDataRequest createHotelRequestDataObj(String jsonString) {
		HotelDataRequest requestData = new HotelDataRequest();
		requestData.setJsonString(jsonString);
		return requestData;
	}
}
