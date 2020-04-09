package com.atmecs.orangehrm.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonHelper {

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
	
	public static void mouseMoveOver(WebDriver driver, String elementPath) {
		WebElement element = driver.findElement(By.xpath(elementPath));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
}
