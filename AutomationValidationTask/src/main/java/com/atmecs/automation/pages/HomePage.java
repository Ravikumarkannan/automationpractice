package com.atmecs.automation.pages;

import org.openqa.selenium.WebDriver;

import com.atmecs.automation.helpers.ValidationHelper;

public class HomePage {
	
	public  static void toolTipValidation(WebDriver driver,String tooltip,String tooltipTitle) {
		ValidationHelper.validateAttribute(driver, tooltip, "title", tooltipTitle);
	}
}
