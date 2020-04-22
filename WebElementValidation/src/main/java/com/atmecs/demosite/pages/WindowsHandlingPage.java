package com.atmecs.demosite.pages;

import org.openqa.selenium.WebDriver;

import com.atmecs.demosite.helpers.CommonHelpers;
import com.atmecs.demosite.helpers.PageActions;

public class WindowsHandlingPage {

	public static void navigateToMultipleWindows(WebDriver driver, String switchTo, String windows,
			String multipleWindows, String click) {
		PageActions.mouseOver(driver, switchTo);
		CommonHelpers.clickElement(driver, windows);
		CommonHelpers.clickElement(driver, multipleWindows);
		CommonHelpers.clickElement(driver, click);
	}

}
