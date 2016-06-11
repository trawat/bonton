package com.bonton.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.config.BontonConfig;
import com.bonton.service.Service;
import com.bonton.service.ServiceVisitor;
import com.bonton.util.BontonProperties;
import com.hotelbeds.util.BontonConfigImpl;

public class BontonService implements Service {
	
	private static final Logger logger = LoggerFactory.getLogger(BontonService.class);
	
	public BontonService() {
		BontonConfig.init();
	}
	
	@Override
	public String search(HttpServletRequest request) throws Exception {
		String responseXml = "";

		try {
			ServiceVisitor visitor = new ServiceVisitorImpl();
			responseXml = visitor.search(BontonConfig.getEnabledEndPointsList(), request.getInputStream());
		} catch(Exception e) {
			logger.error("Exception in BontonService : {}", e);
			//TODO: return proper http error
		}

		return responseXml;
	}

	@Override
	public String confirmBooking(HttpServletRequest request) throws Exception {
		String responseXml = "";

		try {
			ServiceVisitor visitor = new ServiceVisitorImpl();
			responseXml = visitor.confirm(request.getInputStream());
		} catch (Exception exception) {
			logger.error("Exception while confirm booking {}", exception);
			return BontonProperties.SERVICE_TEMPORARILY_DOWN;
		}

		return responseXml;
	}


	@Override
	public String cancelBooking(HttpServletRequest request) throws Exception {
		String responseXml = "";

		try {
			ServiceVisitor visitor = new ServiceVisitorImpl();
			responseXml = visitor.cancel(request.getInputStream());
		} catch(Exception exception) {
			logger.error("Exception while cancel Booking {}", exception);
		}

		return responseXml;
	}

	@Override
	public String repricing(HttpServletRequest request) throws Exception {
		String requestBody = null;
		String responseXml = null;
		String rateKey = null;
		
		Map<String,String> requestDataMap = null;
		try {
			ServiceVisitor visitor = new ServiceVisitorImpl();
			responseXml = visitor.repricing(request.getInputStream());
			
		} catch(Exception e) {
			logger.error("Exception while checking rate for Key " + rateKey + "   Exception is "+e.getStackTrace());
		}
		return responseXml;
	}
}
	
		