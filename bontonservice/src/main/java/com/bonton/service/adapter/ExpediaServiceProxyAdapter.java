package com.bonton.service.adapter;

import java.io.InputStream;

import com.bonton.service.ServiceProxy;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;

public class ExpediaServiceProxyAdapter  extends ServiceProxy{

	@Override
	public String search(InputStream is) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
