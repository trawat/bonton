package com.desia.util;

/**
 * Contains Desia specific constant fields.
 * @author Tirath
 */
public interface DesiaProperties {
	
	public static String DUSERNAME = "bontonsell";
	public static String DPASSWORD = "test@789";
	public static final String DPROPERTYID = "1300001211";
	public static final String CURRENCY = "INR";
	
    /** Used in Desia Search operations */
    public static final String SEP1 = "~";
    public static final String SEP2 = "|";
    public static final String SPLIT = "\\|";
    public static final String SPLITSTR = "\\s+";
    public static final String COMMA = ",";
    
    /** Desia operation/ function names */
    public static final String SEARCH = "Search";
    public static final String REPRICE = "Reprice";
    public static final String CONFIRM = "Provisional";
    public static final String FINALBOOKING = "FinalBooking";
    public static final String CANCEL = "Cancel";
    public static final String PROVFINAL = "ProvFinal";
    
    public static final String BTN_PROP_FILE_NAME = "bonton.properties";
    
    /** Host and its properties used for request and response logging purpose */
    public static final String LOGGINGHOST = "log.host";
    public static final String LOGGINGPORT = "log.port";
    public static final String LOGGINGDB = "log.db";
    public static final String LOGGINGUNAME = "log.username";
    public static final String LOGGINGUPWD = "log.password";
    public static final String LOGGINGDRVR = "";
    
    public static final String DESIA = "DESIA";
    
    public static final String ADULTCD = "AD";
    public static final String CHILDCD = "CH";
    public static final String ADULTAGECD = "10";
    public static final String CHILDAGECD = "8";
    
    public static final String EMPTY = "";
}
