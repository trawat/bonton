package com.hotelbeds.util;
import java.nio.charset.Charset;

import okhttp3.MediaType;

public interface HBProperties {
	
	public static String API_KEY = "j7pcwypu6jw6qbax9v82b8ed";
	public static String SHARED_SECRET = "V8kRcXfhht";
	public static String HB_GET_HOTELS_END_POINT = "https://api.test.hotelbeds.com/hotel-api/1.0/hotels";
	public static String HB_REPRICING_RATE_KEY_GET_URL = "https://api.test.hotelbeds.com/hotel-api/1.0/checkrates";
	public static String HB_CANCEL_BOOKING_URL = "https://api.hotelbeds.com/hotel-api/1.0/bookings";
	public static String HB_CONFIRM_BOOKING_POST_URL = "https://api.test.hotelbeds.com/hotel-api/0.2/bookings";
	
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	public static final MediaType XML = MediaType.parse("application/xml; charset=utf-8");
	public static final String APPLICATION_JSON_HEADER = "application/json";
	public static final String APPLICATION_XML_HEADER = "/xml";
	public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String CONTENT_LENGTH_HEADER = "Content-Length";
    public static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
    public static final String DEFAULT_LANGUAGE = "ENG";
    public static final String API_KEY_HEADER_NAME = "Api-Key";
    public static final String SIGNATURE_HEADER_NAME = "X-Signature";
    public static final Charset UTF8 = Charset.forName("UTF-8");
    
    public static final String INVALID_RATE_KEY = "Invalid Rate Key";
    public static final String RESPONSE_MESSAGE_OK = "OK";
    public static final String RESPONSE_CODE_200 = "200";
    
    public static final String SERVICE_TEMPORARILY_DOWN = "<h1>Service Temporarily Down</h1>";
    public static final String FILE_WRITE_DIRECTORY = "D:\\";
    
}
