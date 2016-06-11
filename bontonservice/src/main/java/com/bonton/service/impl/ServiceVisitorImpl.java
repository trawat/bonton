package com.bonton.service.impl;

import java.io.InputStream;
import java.util.List;

import com.bonton.service.ServiceProxy;
import com.bonton.service.ServiceVisitor;
import com.bonton.service.adapter.HBServiceProxyAdapter;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.processor.XmlProcessor;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;

public class ServiceVisitorImpl implements ServiceVisitor {
	
	@Override
	public String search(List<? extends ServiceProxy> serviceList, InputStream is) throws Exception {
		for (ServiceProxy sp : serviceList) {
			return sp.search(is);
		}
		return null;
	}
	
	@Override
	public String confirm(InputStream is) throws Exception {
		BTNConfirmRequest confirmBean = XmlProcessor.getConfirmBean(is);
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
		BTNRepriceRequest repriceBean = XmlProcessor.getRepriceBean(is);
		String supplier = repriceBean.getSupplier();
		
		if ("HotelBeds".equalsIgnoreCase(supplier)) {
			return new HBServiceProxyAdapter().repricing(supplier, repriceBean);
		}
		return null;
	}
	
}
