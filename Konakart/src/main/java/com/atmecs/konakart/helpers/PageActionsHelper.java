package com.atmecs.konakart.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageActionsHelper {

	public static void dropDown(WebDriver driver, String locatorType, String mainMenu, String subMenu,String selectType) {
		WebElement element = CommonHelpers.findElement(driver, locatorType, mainMenu);
		Select select = new Select(element);
		
		if (selectType.equalsIgnoreCase("text")) {
			select.selectByVisibleText(subMenu);
		} else if (selectType.equalsIgnoreCase("value")) {
			select.selectByValue(subMenu);
		}
	}
}