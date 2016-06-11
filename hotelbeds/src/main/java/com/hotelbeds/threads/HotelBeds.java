package com.hotelbeds.threads;

import com.bonton.utility.artifacts.BTNSearchRequest;


public class HotelBeds {
	
	private HotelBedsThread hbThread = null;
	
    public HotelBeds() {
		
	}
	
	public HotelBeds(BTNSearchRequest xmlRequestObj, String requestId) {
		hbThread = new HotelBedsThread(xmlRequestObj, requestId);
	}
	
	public void setHbThread(HotelBedsThread hbThread) {
		this.hbThread = hbThread;
	}

	
	public HotelBedsThread getHbThread() {
		return hbThread;
	}
	
	
}
