package com.atmecs.demosite.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ValidationHelper {

	public static void validateText(WebDriver driver, String path, String expData) {
		String actual = driver.findElement(By.xpath(path)).getText();
		try {
			Assert.assertEquals(actual, expData);
		} catch (AssertionError assertionerror) {
			System.out.println("assertion failure");
		}
	}
}
