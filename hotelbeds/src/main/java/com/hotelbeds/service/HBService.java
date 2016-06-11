package com.hotelbeds.service;

import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.bonton.utility.artifacts.BTNSearchResponse;
import com.bonton.utility.hotelbeds.AvailabilityRQ;
import com.bonton.utility.processor.XmlProcessor;
import com.hotelbeds.beans.CancellationBean;
import com.hotelbeds.util.BeanUtil;

public class HBService {
	
	public String search(BTNSearchRequest searchBean, String requestId) throws Exception {
		//SearchBean searchBean = BeanUtil.getHotelSearchBean(requestXml);
		HBServiceHelper client = new HBServiceHelper();
		AvailabilityRQ availabilityRQ = client.searchBeanRequestMapper(searchBean);
		
		String hbSearchResXml = client.sendRequest(availabilityRQ);
		
		BTNSearchResponse btnSearchResponse = client.searchBeanResponseMapper(hbSearchResXml);
		return XmlProcessor.getBeanInXml(btnSearchResponse);
		//return client.sendBookingConfirmationAndGetResult(confirmBean);
		
//		HotelBeds hbObject = new HotelBeds(searchBean, requestId);
//		HotelBedsThread hbThreadObj = hbObject.getHbThread();
//		if(hbThreadObj != null) {
//			hbThreadObj.join();
//		}
//		responseXml = 
//				FileProcessor.parseHBDataFileAndGetXMLResponse(HBProperties.FILE_WRITE_DIRECTORY + requestId + ".txt");
		
//		return responseXml;
	}
	
	public String confirmBooking(BTNConfirmRequest confirmBean) throws Exception {
		HBServiceHelper client = new HBServiceHelper();
		return client.sendBookingConfirmationAndGetResult(confirmBean);
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
}
