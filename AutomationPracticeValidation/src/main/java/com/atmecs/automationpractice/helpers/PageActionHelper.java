package com.atmecs.automationpractice.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageActionHelper {
	public static String selected_value;
	public static void dropDown(WebDriver driver, String mainMenu, String subMenu, String action) throws Exception {

		if (action.equalsIgnoreCase("select")) {
			WebElement element = CommonHelpers.findElement(driver, mainMenu);
			Select select = new Select(element);
			select.selectByVisibleText(subMenu);
		} else if (action.equalsIgnoreCase("click")) {
			CommonHelpers.clickElement(driver, CommonHelpers.findElement(driver, mainMenu));
			CommonHelpers.clickElement(driver, CommonHelpers.findElement(driver, subMenu));
		} else if (action.equalsIgnoreCase("mouseover")) {
			CommonHelpers.mouseMoveOver(driver, mainMenu);
			CommonHelpers.clickElement(driver, CommonHelpers.findElement(driver, subMenu));
		}
	}

	public static void scrollDown(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void slider(WebDriver driver,String xpath) {
		WebElement element = CommonHelpers.findElement(driver, xpath);
		Actions slider = new Actions(driver);
		slider.dragAndDropBy(element, 10, 20);
	}
}
