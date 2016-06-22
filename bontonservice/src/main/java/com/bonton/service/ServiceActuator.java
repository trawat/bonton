package com.bonton.service;

import java.io.InputStream;
import java.util.List;

/**
 * Acts as a facade for the services provided by different
 * service provides.
 * @author Tirath
 */
public interface ServiceActuator {
	public String search(List<? extends ServiceProxy> serviceList, InputStream is) throws Exception;
	public String confirm(InputStream is) throws Exception;
	public String cancel(InputStream is) throws Exception;
	public String repricing(InputStream is) throws Exception;
}
