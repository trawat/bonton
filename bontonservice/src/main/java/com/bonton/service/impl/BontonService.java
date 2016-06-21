package com.bonton.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.service.Service;
import com.bonton.service.ServiceActuator;
import com.bonton.util.BTNUtility;

public class BontonService implements Service {
	
	private static final Logger logger = LoggerFactory.getLogger(BontonService.class);
	
	public BontonService() {}
	
	@Override
	public String search(HttpServletRequest request) throws Exception {
		String responseXml = "";

		try {
			ServiceActuator actuator = new ServiceActuatorImpl();
			responseXml = actuator.search(BTNUtility.getEnabledEndPointsList(), request.getInputStream());
		} catch(Exception exception) {
			exception.printStackTrace();
			logger.error("Exception in BontonService : {}", exception);
			//TODO: return proper http error
		}

		return responseXml;
	}

	@Override
	public String confirmBooking(HttpServletRequest request) throws Exception {
		String responseXml = "";

		try {
			ServiceActuator actuator = new ServiceActuatorImpl();
			responseXml = actuator.confirm(request.getInputStream());
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error("Exception while confirm booking {}", exception);
		}

		return responseXml;
	}


	@Override
	public String cancelBooking(HttpServletRequest request) throws Exception {
		String responseXml = "";

		try {
			ServiceActuator actuator = new ServiceActuatorImpl();
			responseXml = actuator.cancel(request.getInputStream());
		} catch(Exception exception) {
			exception.printStackTrace();
			logger.error("Exception while cancel Booking {}", exception);
		}

		return responseXml;
	}

	@Override
	public String repricing(HttpServletRequest request) throws Exception {
		String responseXml = null;
		
		try {
			ServiceActuator actuator = new ServiceActuatorImpl();
			responseXml = actuator.repricing(request.getInputStream());
			
		} catch(Exception exception) {
			exception.printStackTrace();
			logger.error("Exception while checking rate for Key {}", exception);
		}
		return responseXml;
	}
}
	
		