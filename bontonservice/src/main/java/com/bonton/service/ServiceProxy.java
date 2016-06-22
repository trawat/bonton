package com.bonton.service;

import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;

/**
 * This class acts as a proxy interface for the services provided by 
 * different service providers.
 * @author Tirath
 */
public abstract class ServiceProxy {
	public abstract void search(BTNSearchRequest requestBean, String uuid, boolean moreThanOneProvider) throws Exception;
	
	public abstract String confirmBooking(String supplier, BTNConfirmRequest confirmBean) throws Exception;
	
	public abstract String cancelBooking(String supplier, BTNCancelRQ cancelBean) throws Exception;
	
	public abstract String repricing(String supplier, BTNRepriceRequest repriceBean) throws Exception;
	
	/* Implementers can return their specific types */
	public abstract Object getServiceInstance() throws Exception;
	
}
