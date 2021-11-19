package com.bigsmall.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageUI {
	public HomePageUI(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='header-item header-item--logo qwer']")
	@CacheLookup
	public static WebElement logo;

	@FindBy(xpath = "//div[@role='navigation']//input[@name='q']")
	@CacheLookup
	public static WebElement searchBox;

	// div[@class='header-item header-item--icons
	// small--hide']//a[@href='/account/login']
	@FindBy(xpath = "//div[@class='header-item header-item--icons small--hide']//a[@href='/account/login']")
	@CacheLookup
	public static WebElement signin;

//	//div[@class='site-nav__icons']//a[@href='#swym-wishlist']
//	@FindBy(css="a.site-nav__link.site-nav__link--icon.swym-wishlist.wishlistlink")
//	public static WebElement wishList;
	public static By wishList = By.cssSelector("div[class= 'site-nav site-nav--icons'] i.fa.fa-heart");

	@FindBy(xpath = "//div[@class='header-item header-item--icons small--hide']//a[@href='/cart']")
	@CacheLookup
	public static WebElement cart;

	@FindBy(xpath = "//div[@role='navigation']//a[@href ='/collections/new-unique-gifts']")
	@CacheLookup
	public static WebElement navNew;

	@FindBy(css = "div[class='footer_links grid-item grid__item medium-up--one-third hidden-sm hidden-xs'] a[href='/pages/contact-us']")
	@CacheLookup
	public static WebElement contact;

	@FindBy(css = "div[class='footer_links grid-item grid__item medium-up--one-third hidden-sm hidden-xs'] a[href='/pages/track-your-order']")
	@CacheLookup
	public static WebElement trackOrder;

	@FindBy(css = "div[class='grid-item grid__item medium-up--one-sixth'] a[href='/pages/about-us']")
	public static WebElement AboutUs;
}
