package com.bonton.service;

import java.io.InputStream;

import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.desia.service.DesiaService;
import com.hotelbeds.service.HBService;

public abstract class ServiceProxy {
	public abstract void search(InputStream is, String uuid, boolean moreThanOneProvider) throws Exception;
	
	public abstract String confirmBooking(String supplier, BTNConfirmRequest confirmBean) throws Exception;
	
	public abstract String cancelBooking(String supplier, BTNCancelRQ cancelBean) throws Exception;
	
	public abstract String repricing(String supplier, BTNRepriceRequest repriceBean) throws Exception;
	
	/* Implementers can return their specific types */
	//public abstract <T> T getServiceInstance() throws Exception;
	
//	public <T> T getServiceInstance(Class<? extends ServiceProxy> spaClass) throws Exception {
//		if (spaClass.equals(HBServiceProxyAdapter.class)) {
//			
//		} else if (spaClass.equals(DesiaServiceProxyAdapter.class)) {
//			
//		} else if (spaClass.equals(ExpediaServiceProxyAdapter.class)) {}
//	}
	
	public HBService getHBServiceInstance() {
		return null;
	}
	public DesiaService getDesiaServiceInstance() {
		return null;
	}
//	public ExpediaService getExpediaServiceInstance() {
//		return null;
//	}
	
}
