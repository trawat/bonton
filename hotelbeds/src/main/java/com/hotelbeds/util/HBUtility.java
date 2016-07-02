package com.hotelbeds.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * HotelBeds utility class
 * @author Tirath
 */
public class HBUtility {
	
	private HBUtility() {}
	
	private static Properties properties = null;
	static {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream(HBProperties.BTN_PROP_FILE_NAME);

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
}
