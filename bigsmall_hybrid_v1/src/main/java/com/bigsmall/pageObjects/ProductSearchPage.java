package com.bigsmall.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bigsmall.uistore.HomePageUI;
import com.bigsmall.uistore.ProductSearchPageUI;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentTest;

public class ProductSearchPage {
	WebDriver driver;
	ExtentTest test;
	Logger log;

	public ProductSearchPage(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}

	public void selectBracelet() throws InterruptedException {
		Thread.sleep(2000);
		ProductSearchPageUI.bracelet.click();
		log.debug("clicked On product");
		Thread.sleep(3000);
		ProductSearchPageUI.addQty.click();
		Thread.sleep(1000);
		ProductSearchPageUI.addQty.click();
		log.debug("selecting the quantity");
		Thread.sleep(1000);
		ProductSearchPageUI.addToCart.click();
		log.debug("clicked on Add to cart");
		Thread.sleep(2000);
	}

	public void clickNew() {
		HomePageUI.navNew.click();
		ProductSearchPageUI.lamonFileOrganiser.click();

		String price = ProductSearchPageUI.pricefileOrg.getText();
		log.info("Price of Lamon File Organizer: " + price);

		ProductSearchPageUI.txtPinCode.sendKeys("462026");
		ProductSearchPageUI.btnCheck.click();

		log.info("Status: " + ProductSearchPageUI.msg.getText());
		ExtentUtils.pass(driver, test, "Details Fetched Successfully.", log);
	}
}
