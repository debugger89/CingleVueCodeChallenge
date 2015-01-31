package com.cinglevue.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebBrowser {

	private WebDriver driver;

	public WebBrowser(String browser) {

		if ("Firefox".equals(browser)) {
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Cannot create a instance of "
					+ browser + " as a webdriver instance.");
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void maximize(){
		driver.manage().window().maximize();
	}
	
	public void quit(){
		driver.quit();
	}

}
