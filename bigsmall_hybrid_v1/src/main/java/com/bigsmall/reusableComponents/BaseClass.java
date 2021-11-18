package com.bigsmall.reusableComponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bigsmall.uistore.ContactPageUI;
import com.bigsmall.uistore.HomePageUI;
import com.bigsmall.uistore.ProductSearchPageUI;
import com.bigsmall.uistore.SigninPageUI;
import com.bigsmall.uistore.TrackOrderPageUI;
import com.bigsmall.utilities.ReadConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass extends ReadConfig {
	static public WebDriver driver;
	public static Logger log;
	public static ExtentTest test;
	public static ExtentReports report;

	public static WebDriver initialize() {
		if (driver == null) {
			if (pro.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + pro.getProperty("chromepath"));
				driver = new ChromeDriver();
			} else if (pro.getProperty("browser").equals("firefox")) {
				System.out.println("not implemented yet.");
			} else if (pro.getProperty("browser").equals("IE")) {
				System.out.println("not implemented yet.");
			}
		}
		new ProductSearchPageUI(driver);
		new SigninPageUI(driver);
		new HomePageUI(driver);
		new ContactPageUI(driver);
		new TrackOrderPageUI(driver);

		return driver;
	}
}
