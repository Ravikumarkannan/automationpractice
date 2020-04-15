package com.atmecs.saucedemo.helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
