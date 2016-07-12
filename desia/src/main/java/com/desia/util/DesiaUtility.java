package com.desia.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Desia utility class
 * @author Tirath
 */
public class DesiaUtility {
	
	private DesiaUtility() {}
	
	private static Properties properties = null;
	static {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream(DesiaProperties.BTN_PROP_FILE_NAME);

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
