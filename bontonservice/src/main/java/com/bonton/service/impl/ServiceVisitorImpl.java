package com.bonton.service.impl;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import com.bonton.service.ServiceProxy;
import com.bonton.service.ServiceVisitor;
import com.bonton.service.adapter.HBServiceProxyAdapter;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.processor.XmlProcessor;

public class ServiceVisitorImpl implements ServiceVisitor {
	
	@Override
	public String search(List<? extends ServiceProxy> serviceList, InputStream is) throws Exception {
		String unikeyId = UUID.randomUUID().toString();
		for (ServiceProxy sp : serviceList) {
			return sp.search(is, unikeyId, false);
		}
		return null;
	}
	
	@Override
	public String confirm(InputStream is) throws Exception {
		BTNConfirmRequest confirmBean = XmlProcessor.getBTNConfirmRQBean(is);
		String supplier = confirmBean.getSupplier();
		
		if ("HotelBeds".equalsIgnoreCase(supplier)) {
			return new HBServiceProxyAdapter().confirmBooking(supplier, confirmBean);
		}
		
		return null;
	}

	@Override
	public String cancel(InputStream is) throws Exception {
		return null;
	}

	@Override
	public String repricing(InputStream is) throws Exception {
		BTNRepriceRequest repriceBean = XmlProcessor.getBTNRepriceRQBean(is);
		String supplier = repriceBean.getSupplier();
		
		if ("HotelBeds".equalsIgnoreCase(supplier)) {
			return new HBServiceProxyAdapter().repricing(supplier, repriceBean);
		}
		return null;
	}
	
}
