package com.atmecs.automation.helpers;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonHelpers {

	public static WebElement element;

	public static WebElement findElement(WebDriver driver, String locatorValue1) {
		try {
			String[] locatorType = locatorValue1.split(":", 2);
			switch (locatorType[0]) {
			case "Xpath":
				element = driver.findElement(By.xpath(locatorType[1]));
				break;
			case "Id":
				element = driver.findElement(By.id(locatorType[1]));
				break;
			case "Name":
				element = driver.findElement(By.name(locatorType[1]));
				break;
			case "CssSeletor":
				element = driver.findElement(By.cssSelector(locatorType[1]));
				break;
			case "LinkText":
				element = driver.findElement(By.linkText(locatorType[1]));
				break;
			case "PartialLinkText":
				element = driver.findElement(By.partialLinkText(locatorType[1]));
				break;
			case "TagName":
				element = driver.findElement(By.tagName(locatorType[1]));
				break;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found" + e.getMessage());
		}
		return element;
	}

	public static void clickElement(WebDriver driver, String elementPath) {
		Waits.explicitWait(driver, elementPath);
		CommonHelpers.findElement(driver, elementPath).click();
	}

	public static void SendKeys(WebDriver driver, String elementPath, String textToSend) {
		CommonHelpers.findElement(driver, elementPath).sendKeys(textToSend);
	}

	public static List<WebElement> findElements(WebDriver driver, String xpath) {
		List<WebElement> element_list = driver.findElements(By.xpath(xpath));
		return element_list;
	}

	public static void mouseMoveOver(WebDriver driver, String elementPath) {
		WebElement element = CommonHelpers.findElement(driver, elementPath);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
}
