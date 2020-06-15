package com.atmecs.insurencedemo.tests;

import com.atmecs.insurencedemo.pages.HomePage;
import com.atmecs.insurencedemo.testbase.TestBase;

public class HomePageValidation extends TestBase {

	HomePage home = new HomePage();
	
	public void validateHomePage() throws Exception {
		home.loginValidation(driver, "demouser@gmail.com", "demouser");
		home.linkTextValidtion(driver,"notImplYet.jsf");
		home.imageValidation(driver);
	}
}
