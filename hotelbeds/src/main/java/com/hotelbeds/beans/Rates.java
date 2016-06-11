package com.hotelbeds.beans;

import java.io.Serializable;
import java.util.List;

public class Rates implements Serializable {
	
	private String rateKey = "";
	private String rateClass = "";
	private String rateType = "";
	private String net = "";
	private String sellingRate = "";
	private boolean hotelMandatory;
	private int allotment;
	private String rateCommentsId = "";
	private String paymentType = "";
	private String packaging = "";
	private String boardCode = "";
	private String boardName = "";
	private List<CancellationPolicies> cancellatioPolicies;
	private Taxes taxes;
	
	private int rooms;
	private int adults;
	private int children;
	private String childrenAges = "";
	
	List<Offers> offers;
	List<ShiftRates> shiftRates;
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
	public String getRateCommentsId() {
		return rateCommentsId;
	}
	public void setRateCommentsId(String rateCommentsId) {
		this.rateCommentsId = rateCommentsId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public List<CancellationPolicies> getCancellatioPolicies() {
		return cancellatioPolicies;
	}
	public void setCancellatioPolicies(List<CancellationPolicies> cancellatioPolicies) {
		this.cancellatioPolicies = cancellatioPolicies;
	}
	public Taxes getTaxes() {
		return taxes;
	}
	public void setTaxes(Taxes taxes) {
		this.taxes = taxes;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public int getAdults() {
		return adults;
	}
	public void setAdults(int adults) {
		this.adults = adults;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public String getChildrenAges() {
		return childrenAges;
	}
	public void setChildrenAges(String childrenAges) {
		this.childrenAges = childrenAges;
	}
	public List<Offers> getOffers() {
		return offers;
	}
	public void setOffers(List<Offers> offers) {
		this.offers = offers;
	}
	public List<ShiftRates> getShiftRates() {
		return shiftRates;
	}
	public void setShiftRates(List<ShiftRates> shiftRates) {
		this.shiftRates = shiftRates;
	}
	
}
