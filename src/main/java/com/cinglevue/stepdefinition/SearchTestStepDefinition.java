package com.cinglevue.stepdefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.cinglevue.elementlocators.HomePage;
import com.cinglevue.elementlocators.SearchResultPage;
import com.cinglevue.selenium.TestCommands;
import com.cinglevue.selenium.WebBrowser;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * The Class SearchTestStepDefinition.
 * This class contains the feature definition commands for the feature files.
 */
public class SearchTestStepDefinition {
	
	/** The web browser. */
	private WebBrowser browser;
	
	/** The test commands. */
	private TestCommands commands;
	
	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(TestCommands.class);

	
	@Given("^A new \"(.*)\" browser window is open$")
	public void browserSelect(String browserType) {
		browser = new WebBrowser(browserType);
		browser.maximize();
		commands = new TestCommands(browser);
	}
	
	
	@When("^I open \"(.*)\" I must be navigated to the homepage$")
	public void openWebpage(String url) {
		commands.navigateToURL(url);
		commands.waitForElement(HomePage.companyLogoLink);
	}
	
	
	@When("^I search for query \"(.*)\" in the search box$")
	public void searchQuery(String searchQuery) {
		commands.type(HomePage.searchBoxInputField, searchQuery);
		commands.pressKeys(HomePage.searchBoxInputField, Keys.ENTER);
	}
	
	
	@Then("^More than \"([0-9]+)\" search results must be visible$")
	public void verifyResults(int expectedResultCount) {
		
		commands.waitForElement(SearchResultPage.SearchResultsHeadingLabel);
		
		int actualResultCount = commands.getObjectCount(SearchResultPage.ResultArticle);
		if(actualResultCount < expectedResultCount){
			Assert.fail("Actual result count : "+actualResultCount+" is less than the expected result count "+expectedResultCount+"");
		}
	}
	
	/**
	 * Executes after each scenario.
	 */
	@After
	public void afterScenario(){
		
		browser.quit();
	}
	
}
