package com.bigsmall.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentUtils {
	public static void pass(WebDriver driver, ExtentTest test, String msg, Logger log) {
		test.log(LogStatus.PASS, "Passed: "+msg);
		log.debug(msg);
		ScreenshotUtils.capture(driver, System.getProperty("user.dir")+"/screenshots/pass/"+System.currentTimeMillis()+".png");
	}
	
	public static void fail(WebDriver driver, ExtentTest test, String msg, Logger log){
		String screenPath= ScreenshotUtils.capture(driver, System.getProperty("user.dir")+"/screenshots/fail/"+System.currentTimeMillis()+".png");
		test.log(LogStatus.FAIL, "Failed: "+msg);
		test.log(LogStatus.FAIL, test.addScreenCapture(screenPath));
		log.debug(msg);
	}
	public static void skip(WebDriver driver, ExtentTest test, String msg, Logger log) {
		test.log(LogStatus.SKIP, "Skipped: "+msg);
	}
}

