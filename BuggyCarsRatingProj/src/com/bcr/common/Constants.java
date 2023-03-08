package com.bcr.common;

public class Constants {
	
	/** Timeout for finding page element in seconds */
    public static final long FIND_ELEMENT_TIMEOUT = 10;
    
	/** PATHS */
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String CONFIG_PROP = USER_DIR + "\\src\\com\\bcr\\testdata\\config.properties";
    
    /** WebDrivers */
    public static final String CHROME_DRIVER = USER_DIR + "\\driver\\chromedriver.exe";

}
