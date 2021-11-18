package com.bigsmall.uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPageUI {
	public SigninPageUI(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	// css = input#CustomerEmail.input-full
	//input[@id='CustomerEmail']
	@FindBy(css = "input#CustomerEmail.input-full")
	@CacheLookup
	public static WebElement txtEmail;
	
	//div[@id='CustomerLoginForm']//input[@name='customer[password]']
	// input#CustomerPassword.input-full
	@FindBy(css = "input#CustomerPassword.input-full")
	@CacheLookup
	public static WebElement txtPassword;
	
	@FindBy(xpath = "//div[@id='CustomerLoginForm']//input[@value='Sign In']")
	@CacheLookup
	public static WebElement btnSignin;
	
	
}
