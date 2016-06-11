package com.bonton.config;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import org.slf4j.LoggerFactory;

import com.bonton.service.ServiceProxy;
import com.bonton.service.adapter.DesiaServiceProxyAdapter;
import com.bonton.util.BontonProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 */
public class BontonConfig {
	
	private static OkHttpClient restTemplate = null;
	private static int readTimeout = BontonProperties.REST_TEMPLATE_READ_TIME_OUT;
    private static int connectTimeout = BontonProperties.REST_TEMPLATE_READ_TIME_OUT;
    private static int connectionRequestTimeout = BontonProperties.REST_TEMPLATE_READ_TIME_OUT;
	private static boolean initialised = false;
	private static ExecutorService executorService = null;
    private static ObjectMapper mapper = null;
    private static RequestInterceptor logger = null;//new LoggingRequestInterceptor(LoggerFactory.getLogger(BontonConfigImpl.class));
    
    /**
     * This method initializes the configuration required for Http calls.
     */
    public static void init() {
		if(initialised == false) {
			logger = new RequestInterceptor(LoggerFactory.getLogger(BontonConfig.class));
	        restTemplate = new OkHttpClient.Builder()
	        .writeTimeout(connectionRequestTimeout, TimeUnit.MILLISECONDS)
	        .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
	        .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
	        .addInterceptor(logger)
	        .build();
	        
	        initialised = true;
	        executorService = Executors.newFixedThreadPool(8);
	        mapper = new ObjectMapper();
	        mapper.findAndRegisterModules();
		}
    }
    
    /**
     * This method is used to check which points are enabled out of Desia , Expedia 
     * @return Map of Enabled End Points with value true or false
     */
    public static Map<String,Boolean> getEnabledEndPoints() {
		
    	Map<String,Boolean> enabledApiServiceMap = new HashMap<String,Boolean>();
    	
    	enabledApiServiceMap.put(BontonProperties.HB_HOTEL_API_SERVICE, new Boolean(true));
    	enabledApiServiceMap.put(BontonProperties.EXPEDIA_HOTEL_API_SERVICE, new Boolean(false));
    	enabledApiServiceMap.put(BontonProperties.DESIA_HOTEL_API_SERVICE, new Boolean(false));
    	
		return enabledApiServiceMap;
		
    }
    
    public static List<? extends ServiceProxy> getEnabledEndPointsList() {
		
    	List<ServiceProxy> enabledApiServiceList = new LinkedList<>();
    	
    	if (true) {
    		//enabledApiServiceList.add(new HBServiceProxyAdapter());
    		enabledApiServiceList.add(new DesiaServiceProxyAdapter());
    	}
    	if (false) {System.out.println();}
    	if (false) {System.out.println();}
    	
		return enabledApiServiceList;
		
    }
	
	public static OkHttpClient getRestTemplate() {
		return restTemplate;
	}

	public static void setRestTemplate(OkHttpClient restTemplate) {
		BontonConfig.restTemplate = restTemplate;
	}

	public static int getReadTimeout() {
		return readTimeout;
	}

	public static void setReadTimeout(int readTimeout) {
		BontonConfig.readTimeout = readTimeout;
	}

	public static int getConnectTimeout() {
		return connectTimeout;
	}

	public static void setConnectTimeout(int connectTimeout) {
		BontonConfig.connectTimeout = connectTimeout;
	}

	public static int getConnectionRequestTimeout() {
		return connectionRequestTimeout;
	}

	public static void setConnectionRequestTimeout(int connectionRequestTimeout) {
		BontonConfig.connectionRequestTimeout = connectionRequestTimeout;
	}

	/**
	 * Before each Http client calls this method can be used to check whether Configuration
	 * is initialized or not
	 */
	public static boolean isInitialised() {
		return initialised;
	}

	public static void setInitialised(boolean initialised) {
		BontonConfig.initialised = initialised;
	}


}
