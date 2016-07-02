package com.bonton.service.adapter;

import com.bonton.service.ServiceProxy;
import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;

/**
 * This class act as an adapter and adapts to the services provided by 
 * Expedia service by implementing the proxy interface.
 * @author Tirath
 * @see ServiceProxy
 * @see 
 */
public class ExpediaServiceProxyAdapter  extends ServiceProxy {

	@Override
	public void search(BTNSearchRequest btnSearchRQ, String uuid, boolean moreThanOneProvider) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String confirmBooking(BTNConfirmRequest btnConfirmRQ, String uuid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancelBooking(BTNCancelRQ btnCancelRQ, String uuid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String repricing(BTNRepriceRequest btnRepriceRQ, String uuid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getServiceInstance() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
