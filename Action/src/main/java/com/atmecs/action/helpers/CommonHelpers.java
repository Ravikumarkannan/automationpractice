package com.atmecs.action.helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonHelpers {
	
		public static void clickElement(WebDriver driver, String xpath) {
			driver.findElement(By.xpath(xpath)).click();
		}

		public static void sendKeys(WebDriver driver, String xpath, String text) {
			driver.findElement(By.xpath(xpath)).sendKeys(text);
		}
		
		public static List<WebElement> findElements(WebDriver driver, String xpath) {
			List<WebElement> element_list = driver.findElements(By.xpath(xpath));
			return element_list;
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
}
