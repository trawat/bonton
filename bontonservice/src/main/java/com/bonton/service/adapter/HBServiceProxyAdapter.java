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
	public void search(BTNSearchRequest requestBean, String uuid, boolean moreThanOneProvider) throws Exception {
		/** To help us with unique key for each request */
		hBService.search(requestBean, uuid);
	}

	@Override
	public String confirmBooking(String supplier, BTNConfirmRequest confirmBean) throws Exception {
		return hBService.confirmBooking(confirmBean);
	}

	@Override
	public String cancelBooking(String supplier, BTNCancelRQ cancelBean) throws Exception {
		return hBService.cancelBooking(cancelBean);
	}

	@Override
	public String repricing(String supplier, BTNRepriceRequest repricingBean) throws Exception {
		return hBService.repricing(repricingBean);
	}

	@Override
	public HBService getServiceInstance() {
		return hBService;
	}	
}
