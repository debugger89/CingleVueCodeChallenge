package com.cinglevue.elementlocators;

import org.openqa.selenium.By;

/**
 * The Class HomePage.
 * Contains the By object locators for the web elements.
 */
public class HomePage {

	/** The search box input field locator. */
	public static By searchBoxInputField = By.cssSelector("input[placeholder='Search Site']");
	
	/** The company logo link locator. */
	public static By companyLogoLink = By.cssSelector("a#logo");
	
}
