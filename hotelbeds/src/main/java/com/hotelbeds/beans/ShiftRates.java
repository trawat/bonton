package com.hotelbeds.beans;

import java.io.Serializable;

public class ShiftRates implements Serializable {

	public String getRateKey() {
		return rateKey;
	}
	public void setRateKey(String rateKey) {
		this.rateKey = rateKey;
	}
	public String getRateClass() {
		return rateClass;
	}
	public void setRateClass(String rateClass) {
		this.rateClass = rateClass;
	}
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	public String getNet() {
		return net;
	}
	public void setNet(String net) {
		this.net = net;
	}
	public String getSellingRate() {
		return sellingRate;
	}
	public void setSellingRate(String sellingRate) {
		this.sellingRate = sellingRate;
	}
	public boolean isHotelMandatory() {
		return hotelMandatory;
	}
	public void setHotelMandatory(boolean hotelMandatory) {
		this.hotelMandatory = hotelMandatory;
	}
	public int getAllotment() {
		return allotment;
	}
	public void setAllotment(int allotment) {
		this.allotment = allotment;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	private String rateKey = "";
	private String rateClass = "";
	private String rateType = "";
	private String net = "";
	private String sellingRate = "";
	private boolean hotelMandatory;
	private int allotment;
	private String checkIn = "";
	private String checkOut = "";
	
}
