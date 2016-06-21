package com.bonton.util;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bonton.service.ServiceProxy;
import com.bonton.service.adapter.DesiaServiceProxyAdapter;
import com.bonton.service.adapter.HBServiceProxyAdapter;
import com.bonton.service.impl.BontonService;

public class BTNUtility {
	private static final Logger logger = LoggerFactory.getLogger(BontonService.class);

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
