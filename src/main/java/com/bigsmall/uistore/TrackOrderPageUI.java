package com.bigsmall.uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackOrderPageUI {
	public TrackOrderPageUI(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#ola_email")
	public static WebElement email;

	@FindBy(css = "input#ola_orderNumber")
	public static WebElement orderNum;

	@FindBy(css = "input#ola_submitButton")
	public static WebElement find;

	@FindBy(css = "div#ola_orderHeaderContent")
	public static WebElement response;
}
