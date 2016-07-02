package com.bonton.service.adapter;

import com.bonton.service.ServiceProxy;
import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.hotelbeds.service.HBService;

/**
 * This class act as an adapter and adapts to the services provided by 
 * Hotel Beds service by implementing the proxy interface.
 * @author Tirath
 * @see ServiceProxy
 * @see HBService
 */
public class HBServiceProxyAdapter extends ServiceProxy {
	private final HBService hBService;
	
	
	public HBServiceProxyAdapter() {
		hBService = new HBService();
	}

	@Override
	public void search(BTNSearchRequest btnSearchRQ, String uuid, boolean moreThanOneProvider) throws Exception {
		/** To help us with unique key for each request */
		hBService.search(btnSearchRQ, uuid);
	}

	@Override
	public HBService getServiceInstance() {
		return hBService;
	}

	@Override
	public String confirmBooking(BTNConfirmRequest btnConfirmRQ, String uuid) throws Exception {
		return hBService.confirmBooking(btnConfirmRQ, uuid);
	}

	@Override
	public String cancelBooking(BTNCancelRQ btnCancelRQ, String uuid) throws Exception {
		return hBService.cancelBooking(btnCancelRQ, uuid);
	}

	@Override
	public String repricing(BTNRepriceRequest btnRepriceRQ, String uuid) throws Exception {
		return hBService.repricing(btnRepriceRQ, uuid);
	}	
}
