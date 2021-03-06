package com.bonton.service.adapter;

import com.bonton.service.ServiceProxy;
import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNFinalBookingRQ;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.desia.service.DesiaService;

/**
 * This class act as an adapter and adapts to the services provided by 
 * Desia service by implementing the proxy interface.
 * @author Tirath
 * @see ServiceProxy
 * @see DesiaService
 */
public class DesiaServiceProxyAdapter  extends ServiceProxy {
	private final DesiaService desiaService;
	
	public DesiaServiceProxyAdapter() {
		desiaService = new DesiaService();
	}
	
	@Override
	public void search(BTNSearchRequest btnSearchRQ, String uuid, boolean moreThanOneProvider) throws Exception {
		/** To help us with unique key for each request */
		desiaService.search(btnSearchRQ, uuid);
	}

	@Override
	public String confirmBooking(BTNConfirmRequest btnConfirmRQ, String uuid) throws Exception {
		return desiaService.confirmBooking(btnConfirmRQ, uuid);
	}
	
	/**
	 * This method is to trigger provisional and final booking in one request.
	 * @param btnConfirmRQ Provisional booking request
	 * @param uuid Unique identifier to request and response logging
	 * @return Bonton final booking response returned from Desia.
	 * @throws Exception In case, the request fails to hit the Desia API or some 
	 * RQ-RS mapping exception occurs.
	 */
	public String provisionalBooking(BTNConfirmRequest btnConfirmRQ, String uuid) throws Exception {
		return desiaService.provisionalBooking(btnConfirmRQ, uuid);
	}
	
	@Override
	public String cancelBooking(BTNCancelRQ btnCancelRQ, String uuid) throws Exception {
		return desiaService.cancelBooking(btnCancelRQ, uuid);
	}

	@Override
	public String repricing(BTNRepriceRequest btnRepriceRQ, String uuid) throws Exception {
		return desiaService.repricing(btnRepriceRQ, uuid);
	}
	
	public String finalBooking(BTNFinalBookingRQ btnFinalBookingRQ, String uuid) throws Exception {
		return desiaService.finalBooking(btnFinalBookingRQ, uuid);
	}
	
	@Override
	public DesiaService getServiceInstance() {
		return desiaService;
	}
}
