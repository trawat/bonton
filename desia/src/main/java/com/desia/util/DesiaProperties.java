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
	public static final String SRCH_CHE_LVL = "Live";
	public static final String SRCH_HTL_PRMTN_TYPE = "HOTEL";
	public static final String SRCH_HTL_PRMTN_NAME = "AllPromotions";
	public static final String RATE_TYPE = "BOOKABLE";
	
    /** Used in Desia Search operations */
    public static final String TILDA = "~";
    public static final String PIPE = "|";
    public static final String PIPESPLIT = "\\|";
    public static final String SPACESPLIT = "\\s+";
    public static final String COMMA = ",";
    public static final String DASH = "-";
    public static final String HASH = "#";
    public static final String DHASH = "##";
    public static final String ONE = "1";
    
    
    /** Desia operation/ function names */
    
    /** City Search */
    public static final String SEARCH = "Search";
    
    /** Hotel Search */
    public static final String REPRICE = "Reprice";
    
    /** Provisional plus final */
    public static final String CONFIRM = "Confirm";
    public static final String FINAL = "Final";
    public static final String CANCEL = "Cancel";
    public static final String PROVISIONAL = "Provisional";
    
    public static final String BTN_PROP_FILE_NAME = "bonton.properties";
    
    /** Host and its properties used for request and response logging purpose */
    public static final String LOGGINGHOST = "log.host";
    public static final String LOGGINGPORT = "log.port";
    public static final String LOGGINGDB = "log.db";
    public static final String LOGGINGUNAME = "log.username";
    public static final String LOGGINGUPWD = "log.password";
    public static final String LOGGINGDRVR = "";
    public static final String LOGGINGDESIAFLG = "log.Desia";
    public static final String YES = "Y";
    public static final String NO = "N";
    
    public static final String DESIA = "7";
    
    public static final String ADULTCD = "AD";
    public static final String CHILDCD = "CH";
    public static final String ADULTAGECD = "10";
    public static final String CHILDAGECD = "8";
    
    public static final String EMPTY = "";
}
