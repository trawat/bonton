package com.bonton.service;

import java.io.InputStream;

import com.bonton.service.impl.ServiceActuatorImpl;

/**
 * Acts as a facade for the services provided by different
 * service providers.
 * @author Tirath
 * @see ServiceActuatorImpl
 */
public interface ServiceActuator {
	public String search(InputStream is) throws Exception;
	public String confirm(InputStream is) throws Exception;
	public String cancel(InputStream is) throws Exception;
	public String repricing(InputStream is) throws Exception;
	public String finalBooking(InputStream is) throws Exception;
	public String provisionalFinalBooking(InputStream is) throws Exception;
}
