@search
Feature: As a user I should be able to search the webpage and get search results.

  Scenario: Search for query
    Given A new "Firefox" browser window is open
    When I open "http://www.cinglevue.com" I must be navigated to the homepage
    When I search for query "Resources" in the search box
    Then More than "10" search results must be visible
 