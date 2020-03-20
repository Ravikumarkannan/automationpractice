package com.atmecs.automation.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public static void explicitWait(WebDriver driver, String path) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf((CommonHelpers.findElement(driver, path))));
	}

	public static void clickable(WebDriver driver, String path) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable((CommonHelpers.findElement(driver, path))));
	}
}
