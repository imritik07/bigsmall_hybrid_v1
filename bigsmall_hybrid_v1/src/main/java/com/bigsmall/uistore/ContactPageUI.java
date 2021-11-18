package com.bigsmall.uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPageUI {
	public ContactPageUI(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='footer_links grid-item grid__item medium-up--one-third hidden-sm hidden-xs'] a[href='/pages/contact-us']")
	@CacheLookup
	public static WebElement contact;

	@FindBy(css = "input#ContactFormName-page-contact-template-0")
	@CacheLookup
	public static WebElement txtName;

	@FindBy(css = "input#ContactFormEmail-page-contact-template-0")
	@CacheLookup
	public static WebElement txtEmail;

	@FindBy(css = "textarea#ContactFormMessage-page-contact-template-0")
	@CacheLookup
	public static WebElement txtMsg;

	@FindBy(css = "button[class='btn']")
	@CacheLookup
	public static WebElement send;

}
