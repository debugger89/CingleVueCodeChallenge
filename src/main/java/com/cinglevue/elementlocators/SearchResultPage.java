package com.cinglevue.elementlocators;

import org.openqa.selenium.By;

/**
 * The Class SearchResultPage.
 * Contains the By object locators for the web elements.
 */
public class SearchResultPage {

	/** The Search results heading label locator. */
	public static By SearchResultsHeadingLabel = By.xpath("//h1[contains(text(),'Search Results')]");
	
	/** The Result article locator. */
	public static By ResultArticle = By.cssSelector("article.search-result");
	
}
