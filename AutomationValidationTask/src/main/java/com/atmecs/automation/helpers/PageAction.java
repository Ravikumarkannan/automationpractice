package com.atmecs.automation.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageAction {
	
	public static void dropDown(WebDriver driver, String mainMenu, String subMenu) throws Exception {
		WebElement element = CommonHelpers.findElement(driver, mainMenu);
		Select select = new Select(element);
		select.selectByVisibleText(subMenu);
	}

	public static void scrollDown(WebDriver driver, String locatorValue) {
		WebElement element = CommonHelpers.findElement(driver, locatorValue);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
