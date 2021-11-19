package com.bigsmall.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	//defining an object for properties class
	public static Properties pro;

	public ReadConfig() {
		if (pro==null) {
			File src= new File("./configuration/config.properties");
			FileInputStream fis;
			
			try {
				fis = new FileInputStream(src);
				pro=  new Properties();
				pro.load(fis);
			} catch (FileNotFoundException e) {
				System.out.println("Unable to locate the config.properties file!!!");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Exception occured!!!");
				e.printStackTrace();
			}
		}
	}
}
