package com.bonton.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.config.BontonConfig;
import com.bonton.service.Service;
import com.bonton.service.ServiceActuator;
import com.bonton.util.BTNProperties;

public class BontonService implements Service {
	
	private static final Logger logger = LoggerFactory.getLogger(BontonService.class);
	
	public BontonService() {
		BontonConfig.init();
	}
	
	@Override
	public String search(HttpServletRequest request) throws Exception {
		String responseXml = "";

		try {
			ServiceActuator actuator = new ServiceActuatorImpl();
			responseXml = actuator.search(BontonConfig.getEnabledEndPointsList(), request.getInputStream());
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
			ServiceActuator actuator = new ServiceActuatorImpl();
			responseXml = actuator.confirm(request.getInputStream());
		} catch (Exception exception) {
			logger.error("Exception while confirm booking {}", exception);
			return BTNProperties.SERVICE_TEMPORARILY_DOWN;
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
			
		} catch(Exception e) {
			logger.error("Exception while checking rate for Key ");
		}
		return responseXml;
	}
}
	
		