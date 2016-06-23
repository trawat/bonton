package com.bonton.util;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.service.ServiceProxy;
import com.bonton.service.adapter.DesiaServiceProxyAdapter;
import com.bonton.service.adapter.HBServiceProxyAdapter;

/**
 * Bonton utility class to hold common utility methods.
 * @author Tirath
 */
public class BTNUtility {
	private static final Logger logger = LoggerFactory.getLogger(BTNUtility.class);

	private BTNUtility() {}

	/* Fetch the list of active services */
	public static List<? extends ServiceProxy> getEnabledEndPointsList() {
		List<ServiceProxy> enabledApiServiceList = new LinkedList<>();
		if (true) {
			enabledApiServiceList.add(new HBServiceProxyAdapter());
		}
		if (false) {
			enabledApiServiceList.add(new DesiaServiceProxyAdapter());
		}
		if (false) {System.out.println();}    	
		return enabledApiServiceList;
	}
}
