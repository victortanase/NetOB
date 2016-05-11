package com.ibm.Core;

import java.io.File;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Reporter;

/**
 * Class Description - This class provides wrapper functions for logging
 * 
 * @author 
 * 
 * @version 1.1

 */
public class CustomLogger {
	static Logger logger;
	
	static {
		logger = Logger.getLogger("NETOB_Automation");
		DOMConfigurator.configure(new File("files/log4j.xml").getAbsolutePath());
	}
	
	public static void logInfo(String message){
		logger.info(message);
		String dateInfo = DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd_hh:mm:ss");
		Reporter.log("[" + dateInfo + "] " + message + "</font>",3);
	}
	
	public static void logSuccess(String message){
		logger.info(message);
		String dateInfo = DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd_hh:mm:ss");
		Reporter.log("[" + dateInfo + "] " + message,1);	
	}
	
	public static void logError(String message){
		logger.error(message);
		String dateInfo = DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd_hh:mm:ss");
		Reporter.log("[" + dateInfo + "] " + message,1);	
	}
	public static void logTestAction(String message){
		logger.info(message);
		String dateInfo = DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd_hh:mm:ss");
		Reporter.log("[" + dateInfo + "] " + message,1);	
	}
}
