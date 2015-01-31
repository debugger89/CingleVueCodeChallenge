package com.cinglevue.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cinglevue.utils.PropertyHandler;

public class TestCommands {

	private WebDriver driver;

	final static Logger logger = Logger.getLogger(TestCommands.class);
	private int timeOut;

	public TestCommands(WebBrowser browser) {
		this.driver = browser.getDriver();
		init();
	}

	private void init() {
		
		PropertyHandler handler = new PropertyHandler("/execution.properties");
		String timeout = handler.getProperty("TIMEOUT");	
		this.timeOut = Integer.parseInt(timeout);
	}

	public void navigateToURL(String url) {

		try {
			driver.navigate().to(url);

			logger.info("Opened the URL " + url + " successfully.");
		} catch (Exception e) {
			logger.error(e);
		}

	}

	public void type(By byLocator, String text) {

		WebElement element = findElement(byLocator);

		element.sendKeys(text);
		logger.info("Typed the value " + text + " in to object " + byLocator);

	}

	public void pressKeys(By byLocator, Keys key) {

		WebElement element = findElement(byLocator);

		element.sendKeys(key);
		logger.info("Pressed the key " + key + " in to object " + byLocator);

	}
	
	public int getObjectCount(By byLocator) {

		int count = driver.findElements(byLocator).size();

		logger.info("Got element count for the object " + byLocator + " as "+count);
		return count;

	}
	
	public void waitForElement(By byLocator) {

		findElement(byLocator);
		logger.info("Waited for the object " + byLocator + " to appear.");
	}

	private WebElement findElement(By byLocator) {

		WebElement element = (new WebDriverWait(driver, timeOut))
				.until(ExpectedConditions.presenceOfElementLocated(byLocator));

		return element;

	}

}
