package com.atmecs.action.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelpers {

	public static void mouseMoveOver(WebDriver driver, String elementPath) {
		WebElement element = driver.findElement(By.xpath(elementPath));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void copy(WebDriver driver, String element) {
		WebElement copyElement = driver.findElement(By.xpath(element));
		copyElement.click();
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
	}

	public static void paste(WebDriver driver, String element) {
		WebElement pasteElement = driver.findElement(By.xpath(element));
		pasteElement.click();
		Actions action = new Actions(driver);

		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
	}

	public static void tab(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		action.release().perform();
	}

}
