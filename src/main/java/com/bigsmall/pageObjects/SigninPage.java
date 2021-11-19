package com.bigsmall.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.uistore.HomePageUI;
import com.bigsmall.uistore.SigninPageUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;

public class SigninPage {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public SigninPage(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}

	public void signIn(String email, String pwd) throws InterruptedException {
		Thread.sleep(2000);
		HomePageUI.signin.click();
		log.debug("Signin Page opened");
		Thread.sleep(3000);
		
		if (driver.getTitle().equals("Account– Bigsmall.in")) {
		SigninPageUI.txtEmail.clear();
		SigninPageUI.txtEmail.sendKeys(email);
		log.debug("Entered the email");
		Thread.sleep(1000);
		SigninPageUI.txtPassword.clear();
		SigninPageUI.txtPassword.sendKeys(pwd);
		log.debug("Entered the Password");
		Thread.sleep(1000);
		SigninPageUI.btnSignin.click();
		Thread.sleep(3000);
		ExtentUtils.pass(driver, test, "clicked on SignIn", log);
		}
		else {
			ExtentUtils.fail(driver, test, "Couldn't find the Sign in Page.", log);
		}
	}
}
