package com.atmecs.automation.pages;

import org.openqa.selenium.WebDriver;
import com.atmecs.automation.helpers.CommonHelpers;
import com.atmecs.automation.helpers.ValidationHelper;

public class SummaryPage  {

	public static void validteSummaryTable(WebDriver driver, String cart, String checkout, String totalPrice,String expPrice) {
		CommonHelpers.mouseMoveOver(driver, cart);
		CommonHelpers.clickElement(driver, checkout);
		ValidationHelper.checkText(driver, totalPrice, expPrice);
	}
	
}