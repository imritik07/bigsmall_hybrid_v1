package com.bigsmall.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.bigsmall.uistore.HomePageUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePage {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public HomePage(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}

	public void validateLogo() throws InterruptedException {
		if (HomePageUI.logo.isDisplayed()) {
			ExtentUtils.pass(driver, test, "Logo is visible.", log);
			assertTrue(true);
		} else {
			ExtentUtils.fail(driver, test, "Logo is not visible.", log);
			assertTrue(false, "Logo is not displayed.");
		}
		Thread.sleep(3000);
	}

	public void validateTitle() {
		assertEquals(driver.getTitle(), "Gifts Online - Send Unique, Unusual Gifts in India, Buy Gifts– Bigsmall.in",
				"Title verification failed");
		ExtentUtils.pass(driver, test, "Title is Verified.", log);
	}

	public void validateSearchBox() throws InterruptedException {
		if (HomePageUI.searchBox.isDisplayed()) {
			ExtentUtils.pass(driver, test, "SearchBox is displayed.", log);
			assertTrue(true);
		} else {
			ExtentUtils.fail(driver, test, "Logo is not displayed.", log);
			assertTrue(false, "Logo is not displayed.");
		}
		Thread.sleep(3000);
	}

	public void search(String name) throws InterruptedException {
		HomePageUI.searchBox.sendKeys(name, Keys.ENTER);
		Thread.sleep(2000);
	}

	public void wishList() throws InterruptedException {
//		Actions a= new Actions(driver);
//		a.moveToElement(driver.findElement(HomePageUI.wishList)).click().build().perform();
		driver.findElement(HomePageUI.wishList).click();
		log.debug("clicked on the wishlist");
		Thread.sleep(3000);
		if (driver.getTitle().equals("My Wishlist - Bigsmall.in")) {
			ExtentUtils.pass(driver, test, "Navigated to wish list page", log);
			assertTrue(true);
		} else {
			ExtentUtils.fail(driver, test, "Couldn't Navigate to wish list page", log);
			assertTrue(false, "Couldn't navigated to the wishList Page.");
		}
	}

	public void signin() throws InterruptedException {
		HomePageUI.signin.click();
		Thread.sleep(1000);
		if (driver.getTitle().equals("Account– Bigsmall.in")) {
			ExtentUtils.pass(driver, test, "Navigated to Sign in page", log);
			assertTrue(true);
		} else {
			ExtentUtils.fail(driver, test, "Couldn't Navigate to Sign in page", log);
			assertTrue(false, "Couldn't navigated to the Sign inPage.");
		}
	}

	public void cart() {
		HomePageUI.cart.click();
		log.info(driver.getTitle());
	}
}
