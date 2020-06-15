package com.atmecs.insurencedemo.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ValidationHelper {

	public static void CheckImage(WebDriver driver, String path) throws Exception {
		String imgage_attribute = driver.findElement(By.xpath(path)).getAttribute("src");

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				driver.findElement(By.xpath(path)));
		if (!ImagePresent) {
			System.out.println(imgage_attribute + "Image not displayed.");
		} else {
			System.out.println(imgage_attribute + "Image displayed.");
		}
	}
	
	public static boolean checkText(WebDriver driver, String locator_value, String expectedText) {

		String actual_text = driver.findElement(By.xpath(locator_value)).getText();
		try {
			Assert.assertEquals(actual_text, expectedText);
			System.out.println(actual_text + " is present");
			return true;
		} catch (AssertionError assertionError) {
			System.out.println(actual_text + " is not present");
			return false;
		}
	}
}
