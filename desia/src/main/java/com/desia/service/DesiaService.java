package com.desia.service;

import java.util.HashMap;
import java.util.Map;

import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.desia.artifacts.OTAHotelAvailRQ;
import com.desia.artifacts.OTAHotelAvailRS;

public class DesiaService {
	/* Holds unique uuid and generated common response object as key-value */
	private static final Map<String, BTNSearchResponse> rqRsMap = new HashMap<>();
	
	public void search(BTNSearchRequest btnSearchRequest, String uuid) throws Exception {
		DesiaServiceHelper desiaHelper = new DesiaServiceHelper();
		OTAHotelAvailRQ otaHotelAvailRQ = desiaHelper.searchBeanRequestMapper(btnSearchRequest);
		
		OTAHotelAvailRS otaHotelAvailRS = desiaHelper.sendSearchRequest(otaHotelAvailRQ);
		
		BTNSearchResponse btnSearchResponse = desiaHelper.searchBeanResponseMapper(otaHotelAvailRS);
		rqRsMap.put(uuid, btnSearchResponse);
	}
	
	public String repricing(BTNRepriceRequest repricingBean) throws Exception {
		DesiaServiceHelper client = new DesiaServiceHelper();
		//return client.recheckHotelPricingAndGetResult(repricingBean);
		return null;
	}
	
	public BTNSearchResponse getAvailabilityRS(String uuid) {
		return rqRsMap.get(uuid);
	}
}
