package com.bigsmall.runner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bigsmall.pageObjects.AboutUs;
import com.bigsmall.pageObjects.ContactPage;
import com.bigsmall.pageObjects.HomePage;
import com.bigsmall.pageObjects.ProductSearchPage;
import com.bigsmall.pageObjects.SigninPage;
import com.bigsmall.pageObjects.TrackOrderPage;
import com.bigsmall.reusableComponents.BaseClass;
import com.bigsmall.utilities.ExcelUtils;
import com.bigsmall.utilities.ExtentUtils;
import com.relevantcodes.extentreports.ExtentReports;

public class Runner extends BaseClass {

	ProductSearchPage ps;
	HomePage hm;
	SigninPage sp;
	ContactPage cp;
	TrackOrderPage tp;
	AboutUs ap;

	@BeforeTest
	public void setup() throws InterruptedException, IOException {
		log = Logger.getLogger(Runner.class.getName());
		report = new ExtentReports(
				pro.getProperty("extentPath") + "ExtentReport_" + System.currentTimeMillis() + ".html");
	}

	@BeforeMethod
	public void initilize() {
		driver = initialize();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.debug("driver is intialized.");
	}

	@AfterMethod
	public void close() {
		driver.close();
		driver = null;
	}

	@Test(priority = 1)
	public void navigateToBaseURL() throws InterruptedException {
		test = report.startTest("Validating Base URL");
		String baseUrl = pro.getProperty("baseURL");
		driver.get(baseUrl);
		assertEquals(baseUrl, driver.getCurrentUrl(), "Browser is Navigated to some another URL.");
		Thread.sleep(2000);
		ExtentUtils.pass(driver, test, "Browser is Navigated to the Given Url", log);
		log.debug("Test 1 completed.");
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 2)
	public void validateHomePage() throws InterruptedException {
		test = report.startTest("Validating Home Page");
		driver.navigate().to(pro.getProperty("baseURL"));
		hm = new HomePage(driver, log, test);
		hm.validateTitle();
		hm.validateLogo();
		hm.validateSearchBox();
		ExtentUtils.pass(driver, test, "Test completed.", log);
		log.debug("Test 2 completed.");
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 6)
	public void signInCheck() throws InterruptedException {
		test = report.startTest("Sign In Check");
		driver.navigate().to(pro.getProperty("baseURL"));
		log.debug("Base Url opened");
		Thread.sleep(2000);
		sp = new SigninPage(driver, log, test);
		String user = null;
		String password = null;
		try {
			user = ExcelUtils.getCellData(pro.getProperty("excelPath"), "Sheet1", 1, 0);
			password = ExcelUtils.getCellData(pro.getProperty("excelPath"), "Sheet1", 1, 1);
		} catch (IOException e) {
			log.warn("Excel file is not found!!!");
			e.printStackTrace();
		}
		if (user.equals(null) && password.equals(null))
			log.warn("user and password can't be null.");
		else {
			sp.signIn(user, password);
		}

		if (driver.getPageSource().contains("To continue, let us know you're not a robot.")
				|| driver.getTitle().equals("Account– Bigsmall.in")) {
			ExtentUtils.pass(driver, test, "Successfully Signed in", log);
			assertTrue(true);
		} else {
			ExtentUtils.fail(driver, test, "SignIn Failed", log);
			assertTrue(false, "Failed to sign in verification!");
		}
		log.debug("Test 6 completed.");
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 5)
	public void checkWishList() throws InterruptedException {
		test = report.startTest("Checking WishList");
		driver.navigate().to(pro.getProperty("baseURL"));
		hm = new HomePage(driver, log, test);
		hm.wishList();
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 3)
	public void checkSignIn() throws InterruptedException {
		test = report.startTest("Validate Sign In Page");
		driver.navigate().to(pro.getProperty("baseURL"));
		hm = new HomePage(driver, log, test);
		hm.signin();
		log.debug("Test 3 completed.");
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 4)
	public void searchAndAddProduct() throws InterruptedException {
		test = report.startTest("Validating Searching And Adding a Product into cart");
		driver.navigate().to(pro.getProperty("baseURL"));
		hm = new HomePage(driver, log, test);
		hm.search("Heart-Key Beaded Charm Bracelet");
		log.debug("Product name entered.");
		Thread.sleep(3000);

		ps = new ProductSearchPage(driver, log, test);
		ps.selectBracelet();
		ExtentUtils.pass(driver, test, "Product is added to cart", log);
		log.debug("Test 4 completed.");
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 7)
	public void checkAvailablity() {
		driver.navigate().to(pro.getProperty("baseURL"));
		test = report.startTest("Check Availablity to postal code");
		ps = new ProductSearchPage(driver, log, test);
		ps.clickNew();
		log.debug("Test 7 completed.");
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 8)
	public void contactUs() throws InterruptedException {
		driver.navigate().to(pro.getProperty("baseURL"));
		test = report.startTest("Validate Contact Us");
		cp = new ContactPage(driver, log, test);
		cp.contactUs();
		log.debug("Test 8 completed.");
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 9)
	public void trackOrder() throws InterruptedException {
		driver.navigate().to(pro.getProperty("baseURL"));
		test = report.startTest("Track Your Order");
		tp = new TrackOrderPage(driver, log, test);
		tp.track("abc@gmail.com", "26478483");
		log.debug("Test 9 completed.");
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 10)
	public void aboutUs() throws InterruptedException {
		driver.navigate().to(pro.getProperty("baseURL"));
		test = report.startTest("About Us Page");
		ap = new AboutUs(driver, log, test);
		ap.validatePage();
		log.debug("Test 10 completed.");
		report.endTest(test);
		report.flush();
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		if (driver != null)
			driver.quit();
		report.flush();
	}
}
