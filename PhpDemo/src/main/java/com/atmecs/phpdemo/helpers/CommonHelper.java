package com.atmecs.phpdemo.helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.atmecs.phpdemo.constants.Locators;

public class CommonHelper {

	private static WebElement element;

	public static WebElement findElement(WebDriver driver, String locatorType, String locatorValue) {
		try {
			switch (locatorType) {
			case "Xpath":
				element = driver.findElement(By.xpath(locatorValue));
				break;
			case "Id":
				element = driver.findElement(By.id(locatorValue));
				break;
			case "Name":
				element = driver.findElement(By.name(locatorValue));
				break;
			case "CssSeletor":
				element = driver.findElement(By.cssSelector(locatorValue));
				break;
			case "LinkText":
				element = driver.findElement(By.linkText(locatorValue));
				break;
			case "PartialLinkText":
				element = driver.findElement(By.partialLinkText(locatorValue));
				break;
			case "TagName":
				element = driver.findElement(By.tagName(locatorValue));
				break;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found" + e.getMessage());
		}
		return element;
	}

	public static void clickElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public static void SendKeys(WebDriver driver, WebElement element, String textToSend) {
		element.sendKeys(textToSend);
	}
	
	public static List<WebElement> findElements(WebDriver driver, String xpath) {
		List<WebElement> element_list = driver.findElements(By.xpath(xpath));
		return element_list;
	}
	public static void mouseMoveOver(WebDriver driver, String elementPath) {
		WebElement element = CommonHelper.findElement(driver, Locators.XPATH, elementPath);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
}
