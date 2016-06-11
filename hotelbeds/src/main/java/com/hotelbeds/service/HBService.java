package com.hotelbeds.service;

import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.artifacts.BTNSearchRequest;
import com.hotelbeds.beans.CancellationBean;
import com.hotelbeds.beans.ConfirmBean;
import com.hotelbeds.beans.SearchBean;
import com.hotelbeds.threads.HotelBeds;
import com.hotelbeds.threads.HotelBedsThread;
import com.hotelbeds.util.BeanUtil;
import com.hotelbeds.util.FileProcessor;
import com.hotelbeds.util.HBProperties;

public class HBService {
	
	public String search(BTNSearchRequest searchBean, String requestId) throws Exception {
		//SearchBean searchBean = BeanUtil.getHotelSearchBean(requestXml);
		
		HotelBeds hbObject = new HotelBeds(searchBean, requestId);
		HotelBedsThread hbThreadObj = hbObject.getHbThread();
		if(hbThreadObj != null) {
			hbThreadObj.join();
		}
		String responseXml = 
				FileProcessor.parseHBDataFileAndGetXMLResponse(HBProperties.FILE_WRITE_DIRECTORY + requestId + ".txt");
		
		return responseXml;
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
