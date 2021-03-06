package com.bonton.service;

import com.bonton.service.adapter.ExpediaServiceProxyAdapter;
import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNFinalBookingRQ;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;

/**
 * This class acts as a proxy interface for the services provided by 
 * different service providers.
 * @author Tirath
 * @see HBServiceProxyAdapter, 
 * @see DesiaServiceProxyAdapter, 
 * @see ExpediaServiceProxyAdapter
 */
public abstract class ServiceProxy {
	public abstract void search(BTNSearchRequest btnSearchRQ, String uuid, boolean moreThanOneProvider) throws Exception;
	
	public abstract String confirmBooking(BTNConfirmRequest btnConfirmRQ, String uuid) throws Exception;
	
	public abstract String cancelBooking(BTNCancelRQ btnCancelRQ, String uuid) throws Exception;
	
	public abstract String repricing(BTNRepriceRequest btnRepriceRQ, String uuid) throws Exception;
	
	/** Specific to Desia API */
	public String provisionalBooking(BTNConfirmRequest btnConfirmRQ, String uuid) throws Exception {
		/** Override in case of Desia */
		return null;
	}
	
	/** Specific to Desia API */
	public String finalBooking(BTNFinalBookingRQ btnFinalBookingRQ, String uuid) throws Exception {
		/** Override in case of Desia */
		return null;
	}
	
	/** Implementers can return their specific types */
	public abstract Object getServiceInstance() throws Exception;
	
}
