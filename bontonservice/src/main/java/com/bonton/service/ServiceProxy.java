package com.bonton.service;

import java.io.InputStream;

import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;

public abstract class ServiceProxy {
	public abstract String search(InputStream is, String uuid, boolean moreThanOneProvider) throws Exception;
	
	public abstract String confirmBooking(String supplier, BTNConfirmRequest confirmBean) throws Exception;
	
	public abstract String cancelBooking(String supplier, BTNConfirmRequest request) throws Exception;
	
	public abstract String repricing(String supplier, BTNRepriceRequest repriceBean) throws Exception;
}
