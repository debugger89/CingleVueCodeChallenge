package com.cinglevue.elementlocators;

import org.openqa.selenium.By;

public class SearchResultPage {

	public static By SearchResultsHeadingLabel = By.xpath("//h1[contains(text(),'Search Results')]");
	
	public static By ResultArticle = By.cssSelector("article.search-result");
	
}
