
package com.bonton.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.service.Service;
import com.bonton.service.ServiceActuator;
import com.bonton.util.BTNUtility;

/**
 * Entry point into Bonton Service application.
 * @author Tirath
 */
public class BontonService implements Service {
	
	private static final Logger logger = LoggerFactory.getLogger(BontonService.class);
	
	private final ServiceActuator actuator = new ServiceActuatorImpl();
	
	public BontonService() {}
	
	/**
	 * Bonton APIs search operation.
	 */
	@Override
	public String search(HttpServletRequest request) throws Exception {
		logger.info("hotel search request received ---->");
		
		String responseXml = "";
		try {
			responseXml = actuator.search(BTNUtility.getEnabledEndPointsList(), request.getInputStream());
		} catch(Exception exception) {
			logger.error("Exception in BontonService : {}", exception);
		}
		logger.info("hotel search request served ---->");
		return responseXml;
	}

	/**
	 * Bonton APIs confirm booking operation.
	 */
	@Override
	public String confirmBooking(HttpServletRequest request) throws Exception {
		logger.info("hotel provisional/ confirm booking request received ---->");
		
		String responseXml = "";
		try {
			responseXml = actuator.confirm(request.getInputStream());
		} catch (Exception exception) {
			logger.error("Exception while provisional/ confirm booking {}", exception);
		}
		logger.info("hotel provisional/ confirm booking request served ---->");
		return responseXml;
	}


	/**
	 * Bonton APIs cancel booking operation.
	 */
	@Override
	public String cancelBooking(HttpServletRequest request) throws Exception {
		logger.info("hotel cancel booking request received ---->");
		
		String responseXml = "";
		try {
			responseXml = actuator.cancel(request.getInputStream());
		} catch(Exception exception) {
			logger.error("Exception while cancel Booking {}", exception);
		}
		logger.info("hotel cancel booking request served ---->");
		return responseXml;
	}

	/**
	 * Bonton APIs reprice operation.
	 */
	@Override
	public String repricing(HttpServletRequest request) throws Exception {
		logger.info("hotel reprice booking request received ---->");
		
		String responseXml = null;
		try {
			responseXml = actuator.repricing(request.getInputStream());
			
		} catch(Exception exception) {
			logger.error("Exception while checking rate for Key {}", exception);
		}
		logger.info("hotel reprice booking request served ---->");
		return responseXml;
	}

	@Override
	public String finalBooking(HttpServletRequest request) throws Exception {
		logger.info("hotel final booking request received ---->");
		
		String responseXml = null;
		try {
			responseXml = actuator.finalBooking(request.getInputStream());
			
		} catch(Exception exception) {
			logger.error("Exception while making the final booking	 {}", exception);
		}
		logger.info("hotel final booking request served ---->");
		return responseXml;
	}

	@Override
	public String provisionalFinalBooking(HttpServletRequest request) throws Exception {
		logger.info("hotel final plus provisional booking request received ---->");
		
		String responseXml = null;
		try {
			responseXml = actuator.provisionalFinalBooking(request.getInputStream());
			
		} catch(Exception exception) {
			logger.error("Exception while making the final booking	 {}", exception);
		}
		logger.info("hotel final plus provisional booking request served ---->");
		return responseXml;
	}
}
	
		