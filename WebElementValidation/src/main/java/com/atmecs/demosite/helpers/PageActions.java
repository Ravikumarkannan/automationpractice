package com.atmecs.demosite.helpers;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageActions {

	public static void mouseOver(WebDriver driver, String path) {
		WebElement element = driver.findElement(By.xpath(path));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		;
	}

	public static void dropDown(WebDriver driver, String mainMenu, String subMenu) throws Exception {
		WebElement element = driver.findElement(By.xpath(mainMenu));
		Select select = new Select(element);
		select.selectByVisibleText(subMenu);
	}

	public static void scrollDown(WebDriver driver, String locatorValue) {
		WebElement element = driver.findElement(By.xpath(locatorValue));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static Collection<String> getWindows(WebDriver driver) {
		Collection<String> windows = driver.getWindowHandles();
		return windows;
	}
}
