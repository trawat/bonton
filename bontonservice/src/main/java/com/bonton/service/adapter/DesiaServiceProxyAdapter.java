package com.bonton.service.adapter;

import java.io.InputStream;
import java.util.UUID;

import com.bonton.service.ServiceProxy;
import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.processor.XmlProcessor;
import com.desia.service.DesiaService;


public class DesiaServiceProxyAdapter  extends ServiceProxy {
	private final DesiaService desiaService;
	
	public DesiaServiceProxyAdapter() {
		desiaService = new DesiaService();
	}
	
	@Override
	public void search(InputStream is, String uuid, boolean moreThanOneProvider) throws Exception {
		BTNSearchRequest requestBean = XmlProcessor.getBTNSearchRQBean(is);
//		if (requestBean == null) {
//			return "<h1>Invalid Request<h1>";
//		}
		/** To help us with unique key for each request */
		desiaService.search(requestBean, uuid);
	}

	@Override
	public String confirmBooking(String supplier, BTNConfirmRequest confirmBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String repricing(String supplier, BTNRepriceRequest repriceBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancelBooking(String supplier, BTNCancelRQ cancelBean)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
