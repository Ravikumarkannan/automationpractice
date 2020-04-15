package com.atmecs.saucedemo.pages;

import org.openqa.selenium.WebDriver;

import com.atmecs.saucedemo.helpers.CommonHelpers;

public class HomePage {

	public static void login(WebDriver driver,String locUserName,String locPassword,String userName,String password,String locLogin) {
		CommonHelpers.sendKeys(driver, locUserName, userName);
		CommonHelpers.sendKeys(driver, locPassword, password);
		CommonHelpers.clickElement(driver, locLogin);
		
	}
}
