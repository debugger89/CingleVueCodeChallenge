package com.cinglevue.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The Class WebBrowser.
 */
public class WebBrowser {

	/** The web driver. */
	private WebDriver driver;

	/**
	 * Instantiates a new web browser.
	 *
	 * @param browser the browser type
	 */
	public WebBrowser(String browser) {

		if ("Firefox".equals(browser)) {
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Cannot create a instance of "
					+ browser + " as a webdriver instance.");
		}
	}

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Sets the driver.
	 *
	 * @param driver the new web driver
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Maximize the browser.
	 */
	public void maximize(){
		driver.manage().window().maximize();
	}
	
	/**
	 * Quit the browser.
	 */
	public void quit(){
		driver.quit();
	}

}
