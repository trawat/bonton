package com.hotelbeds.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNConfirmResponse;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.hotelbeds.AvailabilityRQ;
import com.bonton.utility.hotelbeds.AvailabilityRS;
import com.bonton.utility.hotelbeds.BookingRS;
import com.bonton.utility.processor.XmlProcessor;
import com.hotelbeds.beans.CancellationBean;
import com.hotelbeds.util.BeanUtil;

public class HBService {
	private static Logger logger = LoggerFactory.getLogger(HBServiceHelper.class); 
	
	/* Holds unique uuid and generated common response object as key-value */
	private static final Map<String, BTNSearchResponse> rqRsMap = new HashMap<>();
	
	
	public void search(BTNSearchRequest searchBean, String uuid) throws Exception {
		//SearchBean searchBean = BeanUtil.getHotelSearchBean(requestXml);
		HBServiceHelper client = new HBServiceHelper();
		AvailabilityRQ availabilityRQ = client.searchBeanRequestMapper(searchBean);
		
		String hbSearchResXml = client.sendRequest(availabilityRQ);
		
		logger.debug("hbSearchResXml {}", hbSearchResXml);
		AvailabilityRS availabilityRS = XmlProcessor.getHBSearchRSBean(hbSearchResXml);
		//rqRsMap.put(uuid, availabilityRS);
		BTNSearchResponse btnSearchResponse = client.searchBeanResponseMapper(availabilityRS);
		rqRsMap.put(uuid, btnSearchResponse);
		//return XmlProcessor.getBeanInXml(btnSearchResponse);
		
	}
	
	public String confirmBooking(BTNConfirmRequest confirmBean) throws Exception {
		HBServiceHelper client = new HBServiceHelper();
		String hbConfirmResXml = client.sendBookingConfirmationAndGetResult(confirmBean);
		
		logger.debug("hbConfirmResXml {}", hbConfirmResXml);
		BookingRS bookingRS = XmlProcessor.getHBConfirmRSBean(hbConfirmResXml);
		
		BTNConfirmResponse btnConfirmResponse = client.confirmBeanResponseMapper(bookingRS);
		return XmlProcessor.getBeanInXml(btnConfirmResponse);
	}
	
	public String cancelBooking(String requestXml) throws Exception {
		CancellationBean cancellationBean = BeanUtil.getHotelCancellationBean(requestXml);
		HBServiceHelper client = new HBServiceHelper();
		return client.sendCancelBookingRequestAndGetResult(cancellationBean);
	}
	
	public String repricing(BTNRepriceRequest repricingBean) throws Exception {
		HBServiceHelper client = new HBServiceHelper();
		return client.recheckHotelPricingAndGetResult(repricingBean);
	}
	
	public BTNSearchResponse getAvailabilityRS(String uuid) {
		return rqRsMap.get(uuid);
	}
}
