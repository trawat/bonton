package com.desia.util;

import java.io.IOException;
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
	private static ClassLoader classLoader = null;
	
	static {
		classLoader = Thread.currentThread().getContextClassLoader();
		properties = new Properties();
	}
	
	public static String getProperty(String key) {
		try {
			properties.load(classLoader.getResourceAsStream(DesiaProperties.BTN_PROP_FILE_NAME));
		} catch (IOException e) {
			logger.error("{} occured while loading property file", e);
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
	
	public static String getEmptyOrValue(String data) {
		return null != data? data: DesiaProperties.EMPTY;
	}
}
