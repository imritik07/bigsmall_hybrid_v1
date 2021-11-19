package com.bigsmall.uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPageUI {
	public ProductSearchPageUI(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='header-item header-item--logo qwer']")
	@CacheLookup
	public static WebElement logo;

	// div[@id='snize-search-results-grid-mode']//li[@id='snize-product-6235536261318']
	@FindBy(css = "a[href='/products/key-heart-beaded-charm-bracelet']")
	@CacheLookup
	public static WebElement bracelet;

	// div[@class='js-qty']//span[@class='js--qty-adjuster js--add']
	@FindBy(xpath = "//div[@class='js-qty']//span[@class='js--qty-adjuster js--add']")
	@CacheLookup
	public static WebElement addQty;

	@FindBy(xpath = "//button[@class='btn btn--full add-to-cart spice-submit-button']")
	@CacheLookup
	public static WebElement addToCart;

	@FindBy(xpath = "//div[@id='CartDrawer']//*[contains(text(),'Your cart is currently empty.')]")
	@CacheLookup
	public static WebElement statusCart;

	@FindBy(css = "a[href='/products/lemon-printed-file-organizer']")
	@CacheLookup
	public static WebElement lamonFileOrganiser;

	@FindBy(css = "div#price-field")
	@CacheLookup
	public static WebElement pricefileOrg;

	@FindBy(css = "input#PostalCode")
	@CacheLookup
	public static WebElement txtPinCode;

	@FindBy(css = "button.codbutton.btn.button")
	@CacheLookup
	public static WebElement btnCheck;

	@FindBy(css = "p#PostalCodeCheckerAvailability")
	@CacheLookup
	public static WebElement msg;
}
