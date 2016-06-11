package com.hotelbeds.beans.repricing.json;

import java.util.List;

public class Rates {
	
	private String rateKey;
	private String rateClass;
	private String rateType;
	private String net;
	private int allotment;
	private String rateCommentsId;
	private String paymentType;
	private boolean packaging;
	private String boardCode;
	private String boardName;
	
	
	List<com.hotelbeds.beans.repricing.CancellationPolicies> cancellationPolicies;
	com.hotelbeds.beans.repricing.Taxes taxes ;
	
	private int rooms;
	private int adults;
	private int children;
	private String rateup;
	
	//"rateKey":"20160630|20160704|W|148|56324|DBT.DX|FIT-RO|BB||1~1~0||N@-1866758284","rateClass":"NOR","rateType":"BOOKABLE","net":"282.44","allotment":10,"rateCommentsId":"148|14309|1","paymentType":"AT_WEB","packaging":false,"boardCode":"BB","boardName":"BED AND BREAKFAST"
   // "rooms":1,"adults":1,"children":0,"rateup":"28.24"
	
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
	public String getRateup() {
		return rateup;
	}
	public void setRateup(String rateup) {
		this.rateup = rateup;
	}
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
	public boolean isPackaging() {
		return packaging;
	}
	public void setPackaging(boolean packaging) {
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
	public List<com.hotelbeds.beans.repricing.CancellationPolicies> getCancellationPolicies() {
		return cancellationPolicies;
	}
	public void setCancellationPolicies(List<com.hotelbeds.beans.repricing.CancellationPolicies> cancellationPolicies) {
		this.cancellationPolicies = cancellationPolicies;
	}
	public com.hotelbeds.beans.repricing.Taxes getTaxes() {
		return taxes;
	}
	public void setTaxes(com.hotelbeds.beans.repricing.Taxes taxes) {
		this.taxes = taxes;
	}
	
	
	
	
	
	
}
