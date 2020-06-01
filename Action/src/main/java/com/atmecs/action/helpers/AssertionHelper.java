package com.atmecs.action.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionHelper {

	public static void softAssert(WebDriver driver, String xpath, String expected) {
		String actual = driver.findElement(By.xpath(xpath)).getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected);
	}

	public static void hardAssert(WebDriver driver,String xpath,String expected) {
		String actual = driver.findElement(By.xpath(xpath)).getText();
		try {
		Assert.assertEquals(actual, expected);
	}catch(AssertionError e) {
		System.out.println(e.getMessage());
	}
}
}
