package com.atmecs.automationpractice.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ValidationHelper {

	public static boolean display_status;
	public static boolean enable_status;
	public static String actual_text;

	public static boolean validateText(WebElement element, String expectedText) {

		actual_text = element.getText();
		try {
			Assert.assertEquals(actual_text, expectedText);
			System.out.println(actual_text + " is present");
			return true;
		} catch (AssertionError assertionError) {
			System.out.println(actual_text + " is not present");
			return false;
		}
	}

	public static boolean validateImage(WebDriver driver, String locator_value) {

		display_status = CommonHelpers.findElement(driver, locator_value).isDisplayed();
		try {
			Assert.assertEquals(display_status, true);
			System.out.println(CommonHelpers.findElement(driver, locator_value).getAttribute("src") + " is displayed");
			return true;
		} catch (AssertionError assertionError) {
			System.out.println(
					CommonHelpers.findElement(driver, locator_value).getAttribute("src") + " is not displayed");
			return false;
		}
	}

	public static boolean validateButton(WebDriver driver, String locator_value) {

		enable_status = CommonHelpers.findElement(driver, locator_value).isEnabled();
		try {
			Assert.assertEquals(enable_status, true);
			System.out.println(CommonHelpers.findElement(driver, locator_value).getText() + "button is enabled");
			return true;
		} catch (AssertionError assertionError) {
			System.out.println(CommonHelpers.findElement(driver, locator_value).getText() + " button is disabled");
			return false;
		}
	}

	public static boolean validateAttribute(WebElement element, String attribute, String expectedAttribute) {
		String actual = element.getAttribute(attribute);
		try {
			Assert.assertEquals(actual, expectedAttribute);
			System.out.println("expected attribute:" + actual);
		} catch (AssertionError e) {
			System.out.println("attribute not present" + e.getMessage());
		}
		return false;

	}

	public static void CheckImage(WebDriver driver, WebElement element) throws Exception {
		String imgage_attribute = element.getAttribute("src");

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				element);
		if (!ImagePresent) {
			System.out.println(imgage_attribute + "Image not displayed.");
		} else {
			System.out.println(imgage_attribute + "Image displayed.");
		}
	}
	
	public static boolean checkText(WebDriver driver, String locator_value, String expectedText) {

		actual_text = CommonHelpers.findElement(driver, locator_value).getText();
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
