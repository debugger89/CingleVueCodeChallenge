package com.cinglevue.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags= "@search", features="src/test/resources")
public class CucumberRunner {

}
