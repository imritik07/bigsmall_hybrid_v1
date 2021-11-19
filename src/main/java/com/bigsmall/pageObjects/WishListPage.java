package com.bigsmall.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class WishListPage {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public WishListPage(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}

}
