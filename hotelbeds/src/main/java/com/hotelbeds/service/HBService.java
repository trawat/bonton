package com.hotelbeds.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNCancelRQ;
import com.bonton.utility.artifacts.BTNCancelRS;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNConfirmResponse;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNRepriceResponse;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.hotelbeds.AvailabilityRQ;
import com.bonton.utility.hotelbeds.AvailabilityRS;
import com.bonton.utility.hotelbeds.BookingCancellationRS;
import com.bonton.utility.hotelbeds.BookingRQ;
import com.bonton.utility.hotelbeds.BookingRS;
import com.bonton.utility.hotelbeds.CheckRateRS;
import com.bonton.utility.processor.XmlProcessor;
import com.hotelbeds.util.HBClient;

public class HBService {
	private static Logger logger = LoggerFactory.getLogger(HBService.class);
	
	/* Holds unique uuid and generated common response object as key-value */
	private static final Map<String, BTNSearchResponse> rqRsMap = new HashMap<>();
	
	
	public void search(BTNSearchRequest searchBean, String uuid) throws Exception {
		AvailabilityRQ availabilityRQ = HBServiceHelper.searchBeanRequestMapper(searchBean);
		logger.debug("hb availability request {}", XmlProcessor.getBeanInXml(availabilityRQ));
		AvailabilityRS availabilityRS = HBClient.postSearch(availabilityRQ);
		logger.debug("hb availability response {}", XmlProcessor.getBeanInXml(availabilityRS));
		BTNSearchResponse btnSearchResponse = HBServiceHelper.searchBeanResponseMapper(availabilityRS);
		logger.debug("btn-hb availability response {}", XmlProcessor.getBeanInXml(btnSearchResponse));
		rqRsMap.put(uuid, btnSearchResponse);
	}
	
	public String confirmBooking(BTNConfirmRequest confirmBean) throws Exception {
		BookingRQ bookingRQ = HBServiceHelper.confirmBeanRequestMapper(confirmBean);
		BookingRS bookingRS = HBClient.postConfirmBooking(bookingRQ);
		
		BTNConfirmResponse btnConfirmResponse = HBServiceHelper.confirmBeanResponseMapper(bookingRS);
		return XmlProcessor.getBeanInXml(btnConfirmResponse);
	}
	
	public String cancelBooking(BTNCancelRQ cancelBean) throws Exception {
		BookingCancellationRS cancelRS = HBClient.postCancelBooking(cancelBean);

		BTNCancelRS btnCancelRS = HBServiceHelper.cancelBeanResponseMapper(cancelRS);
		return XmlProcessor.getBeanInXml(btnCancelRS);
	}
	
	public String repricing(BTNRepriceRequest repricingBean) throws Exception {
		CheckRateRS repriceRS = HBClient.postRepricing(repricingBean);
		logger.debug("hb reprice response {}", XmlProcessor.getBeanInXml(repriceRS));
		BTNRepriceResponse btnRepriceRS = HBServiceHelper.repriceBeanResponseMapper(repriceRS);
		
		return XmlProcessor.getBeanInXml(btnRepriceRS);
	}
	
	public BTNSearchResponse getAvailabilityRS(String uuid) {
		return rqRsMap.get(uuid);
	}
}
