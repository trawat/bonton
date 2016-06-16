package com.desia.service;

import java.util.HashMap;
import java.util.Map;

import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNCancelRS;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNConfirmResponse;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNRepriceResponse;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.processor.XmlProcessor;
import com.desia.artifacts.booking.OTACancelRQ;
import com.desia.artifacts.booking.OTACancelRS;
import com.desia.artifacts.booking.OTAHotelResRQ;
import com.desia.artifacts.booking.OTAHotelResRS;
import com.desia.artifacts.search.OTAHotelAvailRQ;
import com.desia.artifacts.search.OTAHotelAvailRS;


public class DesiaService {
	/* Holds unique uuid and generated common response object as key-value */
	private static final Map<String, BTNSearchResponse> rqRsMap = new HashMap<>();
	
	public void search(BTNSearchRequest btnSearchRequest, String uuid) throws Exception {
		OTAHotelAvailRQ otaHotelAvailRQ = DesiaServiceHelper.searchBeanRequestMapper(btnSearchRequest);
		
		OTAHotelAvailRS otaHotelAvailRS = DesiaServiceHelper.sendSearchRequest(otaHotelAvailRQ);
		
		BTNSearchResponse btnSearchResponse = DesiaServiceHelper.searchBeanResponseMapper(otaHotelAvailRS);
		rqRsMap.put(uuid, btnSearchResponse);
	}
	
	public String confirmBooking(BTNConfirmRequest btnConfirmRQ) throws Exception {
		OTAHotelResRQ otaHotelResRQ = DesiaServiceHelper.confirmBeanRequestMapper(btnConfirmRQ);
		
		OTAHotelResRS otaHotelResRS = DesiaServiceHelper.sendConfirmRequest(otaHotelResRQ);
		
		BTNConfirmResponse btnConfirmResponse = DesiaServiceHelper.confirmBeanResponseMapper(otaHotelResRS);
		return XmlProcessor.getBeanInXml(btnConfirmResponse);
	}
	
	public String cancelBooking(BTNCancelRQ btnCancelRQ) throws Exception {
		OTACancelRQ otaCancelRQ = DesiaServiceHelper.cancelBeanRequestMapper(btnCancelRQ);

		OTACancelRS otaCancelRS = DesiaServiceHelper.sendCancelRequest(otaCancelRQ);

		BTNCancelRS btnCancelRS = DesiaServiceHelper.cancelBeanResponseMapper(otaCancelRS);
		return XmlProcessor.getBeanInXml(btnCancelRS);
	}
	
	public String repricing(BTNRepriceRequest btnRepriceRQ) throws Exception {
		OTAHotelResRQ otaHotelResRQ = DesiaServiceHelper.repriceBeanRequestMapper(btnRepriceRQ);

		OTAHotelResRS otaHotelResRS = DesiaServiceHelper.sendRepriceRequest(otaHotelResRQ);

		BTNRepriceResponse btnRepriceResponse = DesiaServiceHelper.repriceBeanResponseMapper(otaHotelResRS);
		return XmlProcessor.getBeanInXml(btnRepriceResponse);
	}
	
	public BTNSearchResponse getAvailabilityRS(String uuid) {
		return rqRsMap.get(uuid);
	}
}
