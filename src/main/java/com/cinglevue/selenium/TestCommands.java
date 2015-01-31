package com.cinglevue.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cinglevue.utils.PropertyHandler;

/**
 * The Class TestCommands.
 * This class contains the commands for the feature definition files. 
 */
public class TestCommands {

	/** The web driver. */
	private WebDriver driver;

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(TestCommands.class);
	
	/** The time out. */
	private int timeOut;

	/**
	 * Instantiates a new test commands.
	 *
	 * @param browser the browser
	 */
	public TestCommands(WebBrowser browser) {
		this.driver = browser.getDriver();
		init();
	}

	/**
	 * Initializes the execution parameters.
	 */
	private void init() {
		
		PropertyHandler handler = new PropertyHandler("/execution.properties");
		String timeout = handler.getProperty("TIMEOUT");	
		this.timeOut = Integer.parseInt(timeout);
	}

	/**
	 * Navigate to a given url.
	 *
	 * @param url the url
	 */
	public void navigateToURL(String url) {

		try {
			driver.navigate().to(url);

			logger.info("Opened the URL " + url + " successfully.");
		} catch (Exception e) {
			logger.error(e);
		}

	}

	/**
	 * Type on a web element.
	 *
	 * @param byLocator the by locator
	 * @param text the text
	 */
	public void type(By byLocator, String text) {

		WebElement element = findElement(byLocator);

		element.sendKeys(text);
		logger.info("Typed the value " + text + " in to object " + byLocator);

	}

	/**
	 * Press keys on a web element.
	 *
	 * @param byLocator the by locator
	 * @param key the key
	 */
	public void pressKeys(By byLocator, Keys key) {

		WebElement element = findElement(byLocator);

		element.sendKeys(key);
		logger.info("Pressed the key " + key + " in to object " + byLocator);

	}
	
	/**
	 * Gets the object count of a web element.
	 *
	 * @param byLocator the by locator
	 * @return the object count
	 */
	public int getObjectCount(By byLocator) {

		int count = driver.findElements(byLocator).size();

		logger.info("Got element count for the object " + byLocator + " as "+count);
		return count;

	}
	
	/**
	 * Wait for element in the web page.
	 *
	 * @param byLocator the by locator
	 */
	public void waitForElement(By byLocator) {

		findElement(byLocator);
		logger.info("Waited for the object " + byLocator + " to appear.");
	}

	/**
	 * Find element in the web page.
	 *
	 * @param byLocator the by locator
	 * @return the web element
	 */
	private WebElement findElement(By byLocator) {

		WebElement element = (new WebDriverWait(driver, timeOut))
				.until(ExpectedConditions.presenceOfElementLocated(byLocator));

		return element;

	}

}
