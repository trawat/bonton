package com.bonton.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

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
	private static Properties properties = null;
	
	private static final HBServiceProxyAdapter hbServicePxyAdpter = new HBServiceProxyAdapter();
	private static final DesiaServiceProxyAdapter desiaServicePxyAdpter = new DesiaServiceProxyAdapter();

	private BTNUtility() {/** Shouldn't be instantiated */}

	static {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream(BTNProperties.BTN_PROP_FILE_NAME);

		properties = new Properties();
		try {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	/** Fetch the list of active services */
	public static final List<? extends ServiceProxy> getEnabledEndPointsList(String supplier) {
		List<ServiceProxy> enabledApiServiceList = new LinkedList<>();
		
		List<String> endPointsIDs = null;
		
		if (isNotNullOrEmpty(supplier)) {
			endPointsIDs = BTNDBConnection.getEnabledEndPoints(supplier);
		} else {
			endPointsIDs = BTNDBConnection.getEnabledEndPoints();
		}
		
		int noOfEndpointIDs = endPointsIDs.size();
		
		for (int i = 0; i < noOfEndpointIDs; i++) {
			enabledApiServiceList.add(getProxyItem(endPointsIDs.get(i)));
		}

		return enabledApiServiceList;
	}
	
	public static final ServiceProxy getProxyItem(String id) {
		switch (id) {
		case BTNProperties.ID_FIVE:
			logger.info("HotelBeds service API is enabled");
			return hbServicePxyAdpter;
		case BTNProperties.ID_SEVEN:
			logger.info("Desia service API is enabled");
			return desiaServicePxyAdpter;
		}
		return null;
	}
	
	public static final void checkConnectivity() {
		BTNDBConnection.reInstateConnection();
	}
	
	public static boolean isNotNullOrEmpty(String data) {
		if (data != null) {
			if (data.trim().length() != 0) {
				return true;
			}
		}
		return false;
	}
}
