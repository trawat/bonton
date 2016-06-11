package com.hotelbeds.beans;

import java.io.Serializable;

public class HBJsonDataContainer implements Serializable {
	
	private AuditData auditData;
	private com.hotelbeds.jsonbeans.Hotels hotels;
	public AuditData getAuditData() {
		return auditData;
	}
	public void setAuditData(AuditData auditData) {
		this.auditData = auditData;
	}
	public com.hotelbeds.jsonbeans.Hotels getHotels() {
		return hotels;
	}
	public void setHotels(com.hotelbeds.jsonbeans.Hotels hotels) {
		this.hotels = hotels;
	}
	
}
