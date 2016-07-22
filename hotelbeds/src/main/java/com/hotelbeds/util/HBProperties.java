package com.hotelbeds.util;

/**
 * Contains HotelBeds specific constant fields.
 * @author Tirath
 */
public interface HBProperties {
	
	public static String API_KEY = "j7pcwypu6jw6qbax9v82b8ed";
	public static String SHARED_SECRET = "V8kRcXfhht";
	public static final String USER_AGENT = "hotel-api-sdk-java";
	
	public static String HB_SEARCH_HOTELS_END_POINT = "https://api.test.hotelbeds.com/hotel-api/1.0/hotels";
	public static String HB_REPRICE_BOOKING_END_POINT = "https://api.test.hotelbeds.com/hotel-api/1.0/checkrates?rateKey={rateKey}";
	public static String HB_REPRICE_POST_END_POINT = "https://api.test.hotelbeds.com/hotel-api/1.0/checkrates";
	public static String HB_CANCEL_BOOKING_END_POINT = "https://api.test.hotelbeds.com/hotel-api/1.0/bookings/{refId}?cancellationFlag={flag}";
	public static String HB_CONFIRM_BOOKING_END_POINT = "https://api.test.hotelbeds.com/hotel-api/1.0/bookings";
	
	public static final String RATE_KEY = "rateKey";
	public static final String REF_ID = "refId";
	public static final String CNCL_FLG = "flag";
	
    public static final String DEFAULT_LANGUAGE = "ENG";
    public static final String API_KEY_HEADER_NAME = "Api-Key";
    public static final String SIGNATURE_HEADER_NAME = "X-Signature";
    public static final String UTF8 = "UTF-8";
    
    public static final String HB = "HOTELBEDS";
    public static final String RATE_TYPE = "BOOKABLE";
    
    /** Used in HotelBeds Search operations */
    public static final String SEP1 = "~";
    public static final String SEP2 = "|";
    public static final String REC = "1";
    public static final String SPLIT = "\\|";
    
    /** HotelBeds operation/ function names */
    public static final String SEARCH = "Search";
    public static final String REPRICE = "Reprice";
    public static final String CONFIRM = "Confirm";
    public static final String CANCEL = "Cancel";
    
    public static final String BTN_PROP_FILE_NAME = "bonton.properties";
    
    /** Host and its properties used for request and response logging purpose */
    public static final String LOGGINGHOST = "log.host";
    public static final String LOGGINGPORT = "log.port";
    public static final String LOGGINGDB = "log.db";
    public static final String LOGGINGUNAME = "log.username";
    public static final String LOGGINGUPWD = "log.password";
    public static final String LOGGINGDRVR = "";
    
    /** 
     * Below constants are not used directly but are present to represent
     * various possible and common combination of noOfRooms~adults~children
     * R - no of Rooms, A - no of Adults, C - no of Childrens
     */
    public static final String tilda = "~";
    
    public static final String _0 = "0";
    public static final String _1 = "1";
    public static final String _2 = "2";
    public static final String _3 = "3";
    
    public static final String _0_ = _0 + tilda;
    public static final String _1_ = _1 + tilda;
    public static final String _2_ = _2 + tilda;
    public static final String _3_ = _3 + tilda;
    
    public static final String _0_0 = _0_ + _0;
    public static final String _1_1 = _1_ + _1;
    public static final String _2_2 = _2_ + _2;
    public static final String _3_3 = _3_ + _3;
    
    public static final String _0_0_ = _0_0 + tilda;
    public static final String _1_1_ = _1_1 + tilda;
    public static final String _2_2_ = _2_2 + tilda;
    public static final String _3_3_ = _3_3 + tilda;
    
    public static final String _0_0_0 = _0_0_ + _0;
    public static final String _1_1_1 = _1_1_ + _1;
    public static final String _2_2_2 = _2_2_ + _2;
    public static final String _3_3_3 = _3_3_ + _3;
    
    
    public static final String EMPTY = "";
}
