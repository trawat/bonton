package com.bonton.service.adapter;

import java.io.InputStream;
import java.util.UUID;

import com.bonton.service.ServiceProxy;
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
	public String search(InputStream is) throws Exception {
		BTNSearchRequest requestBean = XmlProcessor.getSearchBean(is);
		if (requestBean == null) {
			return "<h1>Invalid Request<h1>";
		}
		/** To help us with unique key for each request */
		return hBService.search(requestBean, UUID.randomUUID().toString());
	}

	@Override
	public String confirmBooking(String supplier, BTNConfirmRequest confirmBean) throws Exception {
		return hBService.confirmBooking(confirmBean);
	}

	@Override
	public String cancelBooking(String supplier, BTNConfirmRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String repricing(String supplier, BTNRepriceRequest repricingBean) throws Exception {
		return hBService.repricing(repricingBean);
	}

}
