package com.desia.util;

/**
 * Contains Desia specific constant fields.
 * @author Tirath
 */
public interface DesiaProperties {
	
	public static String DUSERNAME = "bontonnet";
	public static String DPASSWORD = "test@567";
	public static final String DPROPERTYID = "1300001210";
	
    /** Used in Desia Search operations */
    public static final String SEP1 = "~";
    public static final String SEP2 = "|";
    public static final String SPLIT = "\\|";
    
    /** Desia operation/ function names */
    public static final String SEARCH = "Search";
    public static final String REPRICE = "Reprice";
    public static final String CONFIRM = "Provisional";
    public static final String FINALBOOKING = "FinalBooking";
    public static final String CANCEL = "Cancel";
    
    public static final String BTN_PROP_FILE_NAME = "bonton.properties";
    
}
