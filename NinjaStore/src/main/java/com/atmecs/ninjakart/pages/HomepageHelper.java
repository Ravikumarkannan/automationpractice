package com.atmecs.ninjakart.pages;

import org.openqa.selenium.WebDriver;

import com.atmecs.ninjakart.helpers.CommonHelpers;

public class HomepageHelper {

	public static void userLogin(WebDriver driver,String myaccount,String login) {
		CommonHelpers.clickElement(driver, myaccount);
		CommonHelpers.clickElement(driver, login);
	}
}
