package com.hotelbeds.util;

import java.nio.charset.Charset;


public interface BontonProperties {

	public static final String HOTELBEDS = "HB";
	public static final String EXPEDIA = "EXPEDIA";
	public static final String DESIA = "DESIA";
	
	
	public static final String EXPEDIA_GET_HOTELS_END_POINT = "";
	public static final String HOTELBEDS_GET_HOTELS_END_POINT = "https://api.test.hotelbeds.com/hotel-api/1.0/hotels";
	public static final String DESIA_GET_HOTELS_END_POINT = "";
	
	public static final String FILE_WRITE_DIRECTORY = "D:\\";
	public static final String JDBC_URL = "";
	public static final String JDBC_USERNAME = "";
	public static final String JDBC_PASSWORD = "";
    public static final int REST_TEMPLATE_READ_TIME_OUT = 5000;
    public static final String HB_HOTEL_API_SERVICE = "HB_HOTEL_API_SERVICE";
    public static final String EXPEDIA_HOTEL_API_SERVICE = "EXPEDIA_HOTEL_API_SERVICE";
    public static final String DESIA_HOTEL_API_SERVICE = "DESIA_HOTEL_API_SERVICE";
    
    public static final String APPLICATION_JSON_HEADER = "application/json";
	public static final String APPLICATION_XML_HEADER = "/xml";
	public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String CONTENT_LENGTH_HEADER = "Content-Length";
    public static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
    public static final String DEFAULT_LANGUAGE = "ENG";
    public static final String API_KEY_HEADER_NAME = "Api-Key";
    public static final String SIGNATURE_HEADER_NAME = "X-Signature";
    public static final Charset UTF8 = Charset.forName("UTF-8");
    public static final String SERVICE_TEMPORARILY_DOWN = "<h1>Service Temporarily Down</h1>";
	
}
