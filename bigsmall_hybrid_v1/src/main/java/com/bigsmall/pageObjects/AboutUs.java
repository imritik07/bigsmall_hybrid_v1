package com.bigsmall.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.uistore.HomePageUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;

public class AboutUs {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public AboutUs(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}

	public void validatePage() throws InterruptedException {
		HomePageUI.AboutUs.click();
		log.debug("clicked on About us");
		Thread.sleep(3000);
		if (driver.getTitle().equals("About us– Bigsmall.in")) {
			ExtentUtils.pass(driver, test, "Page Title is verfied", log);
		} else {
			ExtentUtils.fail(driver, test, "Page Title is verfication failed.", log);
		}
	}
}
