package com.hotelbeds.util;

import java.io.IOException;
import java.util.Properties;

/**
 * HotelBeds utility class
 * @author Tirath
 */
public class HBUtility {
	
	private HBUtility() {}
	
	private static Properties properties = null;
	private static ClassLoader classLoader = null;
	
	static {
		classLoader = Thread.currentThread().getContextClassLoader();
		properties = new Properties();
	}
	
	public static String getProperty(String key) {
		try {
			properties.load(classLoader.getResourceAsStream(HBProperties.BTN_PROP_FILE_NAME));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
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
