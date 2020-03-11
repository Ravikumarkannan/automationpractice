package com.atmecs.phpdemo.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.atmecs.phpdemo.constants.Locators;

public class PageActions {
	public static void dropDown(WebDriver driver, String mainMenu, String subMenu, String action) throws Exception {

		if (action.equalsIgnoreCase("select")) {
			WebElement element = CommonHelper.findElement(driver, Locators.XPATH, mainMenu);
			Select select = new Select(element);
			System.out.println(select.isMultiple());
			select.selectByVisibleText(subMenu);
		} else if (action.equalsIgnoreCase("click")) {
			CommonHelper.clickElement(driver, CommonHelper.findElement(driver, Locators.XPATH, mainMenu));
			CommonHelper.clickElement(driver, CommonHelper.findElement(driver, Locators.XPATH, subMenu));
		} else if (action.equalsIgnoreCase("mouseover")) {
			CommonHelper.mouseMoveOver(driver, mainMenu);
			CommonHelper.clickElement(driver, CommonHelper.findElement(driver, Locators.XPATH, subMenu));
		}
	}

}