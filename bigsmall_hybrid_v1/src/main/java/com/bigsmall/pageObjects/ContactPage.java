package com.bigsmall.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.uistore.ContactPageUI;
import com.bigsmall.uistore.HomePageUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;

public class ContactPage {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public ContactPage(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}

	public void contactUs() throws InterruptedException {
		HomePageUI.contact.click();
		if (driver.getTitle().equals("Contact Us– Bigsmall.in")) {
			log.debug("Navigated to Contact Page");
			ContactPageUI.txtName.sendKeys("Ram");
			ContactPageUI.txtEmail.sendKeys("ram@gmail.com");
			ContactPageUI.txtMsg.sendKeys("I want to know about the return policy");
			ContactPageUI.send.click();
			log.debug("Filled the details and clicked on send.");
			Thread.sleep(2000);
			ExtentUtils.pass(driver, test, "Message sent successfully.", log);
		} else {
			ExtentUtils.fail(driver, test, "Couldn't navigate to Contact Page", log);
		}
	}
}
