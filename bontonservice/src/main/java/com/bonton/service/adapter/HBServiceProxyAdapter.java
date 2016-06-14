package com.bonton.service.adapter;

import java.io.InputStream;

import com.bonton.service.ServiceProxy;
import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.processor.XmlProcessor;
import com.hotelbeds.service.HBService;

public class HBServiceProxyAdapter extends ServiceProxy {
	private final HBService hBService;
	
	
	public HBServiceProxyAdapter() {
		hBService = new HBService();
	}

	@Override
	public void search(InputStream is, String uuid, boolean moreThanOneProvider) throws Exception {
		BTNSearchRequest requestBean = XmlProcessor.getBTNSearchRQBean(is);
//		if (requestBean == null) {
//			return "<h1>Invalid Request<h1>";
//		}
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

	public HBService getHBServiceInstance() {
		return hBService;
	}
}
