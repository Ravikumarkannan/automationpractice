package com.atmecs.orangehr.pages;

import org.openqa.selenium.WebDriver;

import com.atmecs.orangehr.helpers.CommonHelpers;


public class HomePageHelper {

	public static void login(WebDriver driver,String xpath_userName,String xpath_password,String data_userName,String data_password,String login) {
		CommonHelpers.sendKeys(driver, xpath_userName, data_userName);
		CommonHelpers.sendKeys(driver, xpath_password, data_password);
		CommonHelpers.clickElement(driver, login);
	}
}
