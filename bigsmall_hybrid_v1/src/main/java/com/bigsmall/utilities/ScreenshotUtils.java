package com.bigsmall.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	public static String capture(WebDriver driver, String destpath) {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
	
		File dest = new File(destpath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			System.out.println("Couldn't capture screenshot!");
			e.printStackTrace();
		}
		return destpath;
	}
}
