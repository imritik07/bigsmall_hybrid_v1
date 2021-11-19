package com.bigsmall.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.uistore.HomePageUI;
import com.bigsmall.uistore.TrackOrderPageUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;

public class TrackOrderPage {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public TrackOrderPage(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}

	public void track(String email, String orderid) throws InterruptedException {
		HomePageUI.trackOrder.click();
		TrackOrderPageUI.email.sendKeys(email);
		TrackOrderPageUI.orderNum.sendKeys(orderid);
		TrackOrderPageUI.find.click();
		log.debug("Finding your order.");
		Thread.sleep(2000);
		if (driver.getTitle().equals("Track your order– Bigsmall.in")) {
			log.info("Status of your order: " + TrackOrderPageUI.response.getText());
			ExtentUtils.pass(driver, test, "Track order test success.", log);
		} else {
			log.info("Unable to fetch your order details.");
			ExtentUtils.fail(driver, test, "Track order test failed. Navigated to some another page", log);
		}
	}

}
