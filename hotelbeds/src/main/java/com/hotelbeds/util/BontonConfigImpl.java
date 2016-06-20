package com.hotelbeds.util;

import java.util.concurrent.TimeUnit;

import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;

/**
 *
 */
public class BontonConfigImpl {
	
	private static OkHttpClient restTemplate = null;
	private static int readTimeout = HBProperties.REST_TEMPLATE_READ_TIME_OUT;
    private static int connectTimeout = HBProperties.REST_TEMPLATE_READ_TIME_OUT;
    private static int connectionRequestTimeout = HBProperties.REST_TEMPLATE_READ_TIME_OUT;
	private static boolean initialised = false;
    private static ObjectMapper mapper = null;
    private static LoggingRequestInterceptor logger = null;//new LoggingRequestInterceptor(LoggerFactory.getLogger(BontonConfigImpl.class));
    
    /**
     * This method initializes the configuration required for Http calls.
     */
    public static void init() {
		if(initialised == false) {
			logger = new LoggingRequestInterceptor(LoggerFactory.getLogger(BontonConfigImpl.class));
	        restTemplate = new OkHttpClient.Builder()
	        .writeTimeout(connectionRequestTimeout, TimeUnit.MILLISECONDS)
	        .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
	        .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
	        .addInterceptor(logger)
	        .build();
	        
	        initialised = true;
	        mapper = new ObjectMapper();
	        mapper.findAndRegisterModules();
		}
    }
    
	public static OkHttpClient getRestTemplate() {
		return restTemplate;
	}

	public static void setRestTemplate(OkHttpClient restTemplate) {
		BontonConfigImpl.restTemplate = restTemplate;
	}

	public static int getReadTimeout() {
		return readTimeout;
	}

	public static void setReadTimeout(int readTimeout) {
		BontonConfigImpl.readTimeout = readTimeout;
	}

	public static int getConnectTimeout() {
		return connectTimeout;
	}

	public static void setConnectTimeout(int connectTimeout) {
		BontonConfigImpl.connectTimeout = connectTimeout;
	}

	public static int getConnectionRequestTimeout() {
		return connectionRequestTimeout;
	}

	public static void setConnectionRequestTimeout(int connectionRequestTimeout) {
		BontonConfigImpl.connectionRequestTimeout = connectionRequestTimeout;
	}

	/**
	 * Before each Http client calls this method can be used to check whether Configuration
	 * is initialized or not
	 */
	public static boolean isInitialised() {
		return initialised;
	}

	public static void setInitialised(boolean initialised) {
		BontonConfigImpl.initialised = initialised;
	}


}
