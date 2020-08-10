package com.atmecs.insurencedemo.tests;

import org.testng.annotations.Test;

import com.atmecs.insurencedemo.pages.HomePage;
import com.atmecs.insurencedemo.testbase.TestBase;

public class HomePageValidation extends TestBase {

	HomePage home = new HomePage();
	
	@Test
	public void validateHomePage() throws Exception {
		home.loginValidation(driver, "demouser@gmail.com", "demouser");
		home.linkTextValidtion(driver,"https://demo.borland.com/InsuranceWebExtJS/notImplYet.jsf");
		home.imageValidation(driver);
	}
}
