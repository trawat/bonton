package com.bonton.service.adapter;

import java.io.InputStream;
import java.util.UUID;

import com.bonton.service.ServiceProxy;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.processor.XmlProcessor;

public class DesiaServiceProxyAdapter  extends ServiceProxy {
	private final DesiaService desiaService;
	
	@Override
	public String search(InputStream is) throws Exception {
		BTNSearchRequest requestBean = XmlProcessor.getSearchBean(is);
		if (requestBean == null) {
			return "<h1>Invalid Request<h1>";
		}
		/** To help us with unique key for each request */
		return desiaService.search(requestBean, UUID.randomUUID().toString());
	}

	@Override
	public String confirmBooking(String supplier, BTNConfirmRequest confirmBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancelBooking(String supplier, BTNConfirmRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String repricing(String supplier, BTNRepriceRequest repriceBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
