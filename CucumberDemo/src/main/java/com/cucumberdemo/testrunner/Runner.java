package com.cucumberdemo.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "features", glue = {"com.cucumberdemo.stepdefinition"})
public class Runner {
	

}
