package com.hotelbeds.beans.repricing;


public class HBRepriceJsonDataContainer {

	private AuditData auditData;
	private com.hotelbeds.beans.repricing.Hotel hotel;
	
	public AuditData getAuditData() {
		return auditData;
	}
	public void setAuditData(AuditData auditData) {
		this.auditData = auditData;
	}
	public com.hotelbeds.beans.repricing.Hotel getHotel() {
		return hotel;
	}
	public void setHotel(com.hotelbeds.beans.repricing.Hotel hotel) {
		this.hotel = hotel;
	}
}