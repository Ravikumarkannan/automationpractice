package com.atmecs.insurencedemo.tests;

import org.testng.annotations.Test;

import com.atmecs.insurencedemo.pages.RegisterPage;
import com.atmecs.insurencedemo.testbase.TestBase;

public class UserRegisteration extends TestBase {

	RegisterPage register = new RegisterPage();

	@Test(priority = 1)
	public void titleValidation() {

		register.validateTitle(driver, "InsuranceWeb: Sign up");

	}

	@Test(priority = 2)
	public void register() throws Exception {

		register.userRegisteration(driver, "demo", "user", "demomail1@yahoo.com", "demostreet", "paris", "California",
				"123456", "123456");
	}

}
