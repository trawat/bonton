package com.hotelbeds.util;

public interface HBProperties {
	
	public static String API_KEY = "j7pcwypu6jw6qbax9v82b8ed";
	public static String SHARED_SECRET = "V8kRcXfhht";
	public static final String USER_AGENT = "hotel-api-sdk-java";
	
	public static String HB_SEARCH_HOTELS_END_POINT = "https://api.test.hotelbeds.com/hotel-api/1.0/hotels";
	public static String HB_REPRICE_BOOKING_END_POINT = "https://api.test.hotelbeds.com/hotel-api/1.0/checkrates?rateKey={rateKey}";
	public static String HB_CANCEL_BOOKING_END_POINT = "https://api.test.hotelbeds.com/hotel-api/1.0/bookings/{refId}?cancellationFlag={flag}";
	public static String HB_CONFIRM_BOOKING_END_POINT = "https://api.test.hotelbeds.com/hotel-api/1.0/bookings";
	
	public static final String RATE_KEY = "rateKey";
	public static final String REF_ID = "refId";
	public static final String CNCL_FLG = "flag";
	
    public static final String DEFAULT_LANGUAGE = "ENG";
    public static final String API_KEY_HEADER_NAME = "Api-Key";
    public static final String SIGNATURE_HEADER_NAME = "X-Signature";
    public static final String UTF8 = "UTF-8";
    
}
