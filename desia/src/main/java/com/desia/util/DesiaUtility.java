package com.desia.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desia utility class
 * @author Tirath
 */
public class DesiaUtility {
	private static final Logger logger = LoggerFactory.getLogger(DesiaUtility.class);
	
	private DesiaUtility() {
		//To avoid instantiablity
	}
	
	private static Properties properties = null;
	static {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream(DesiaProperties.BTN_PROP_FILE_NAME);

		properties = new Properties();
		try {
			properties.load(input);
		} catch (IOException e) {
			logger.error("{} occured while loading property file", e);
		}
	}
	
	public static String getProperty(String key) {
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
	
	public static String getEmptyOrValue(String data) {
		return null != data? data: DesiaProperties.EMPTY;
	}
}
