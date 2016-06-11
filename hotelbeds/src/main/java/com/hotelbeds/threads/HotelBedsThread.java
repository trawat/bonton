package com.hotelbeds.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.utility.artifacts.BTNSearchRequest;
import com.hotelbeds.beans.SearchBean;
import com.hotelbeds.service.HBServiceHelper;
import com.hotelbeds.util.HBProperties;


public class HotelBedsThread extends Thread {
	private static Logger logger = LoggerFactory.getLogger(HotelBedsThread.class);
	
	private BTNSearchRequest searchBean = null;
	private String responseData = "";
	private Boolean responseFethedAndWrittenToFile = false;
	//This requestID is used as File HB Response File
	private String requestId = "";
	private String responseMessage = "";
	private String responseCode = "";
	
	public HotelBedsThread() {}
	
	public HotelBedsThread(BTNSearchRequest searchBean, String requestId) {
		this.searchBean = searchBean;
		this.requestId = requestId;
		this.start();
	}
	
	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	
	
	public void run() {
		HBServiceHelper requestSender = new HBServiceHelper();
		try {
			logger.debug("Getting HB Hotel Data ");
			String resultDataInJson = requestSender.getHotelsDataJson(searchBean, requestId);
			if(resultDataInJson != null && !resultDataInJson.equals(HBProperties.SERVICE_TEMPORARILY_DOWN)) {
				this.responseFethedAndWrittenToFile = requestSender.writeResponseDataInAggregationFormat(resultDataInJson, requestId);
				setResponseMessage(HBProperties.RESPONSE_MESSAGE_OK);
				setResponseCode(HBProperties.RESPONSE_CODE_200);
				setResponseFethedAndWrittenToFile(true);
			}
		}catch(Exception e) {
			setResponseFethedAndWrittenToFile(false);
			setResponseData(HBProperties.SERVICE_TEMPORARILY_DOWN);
			logger.error(e.getStackTrace().toString());
		}
	}
	
	

	public BTNSearchRequest getXmlRequestObj() {
		return searchBean;
	}

	public void setXmlRequestObj(BTNSearchRequest xmlRequestObj) {
		this.searchBean = xmlRequestObj;
	}

	public Boolean isResponseFethedAndWrittenToFile() {
		return responseFethedAndWrittenToFile;
	}

	public void setResponseFethedAndWrittenToFile(Boolean responseFethedAndWrittenToFile) {
		this.responseFethedAndWrittenToFile = responseFethedAndWrittenToFile;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

	public String getResponseData() {
		return this.responseData;
	}
	
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Boolean getResponseFethedAndWrittenToFile() {
		return responseFethedAndWrittenToFile;
	}

}
