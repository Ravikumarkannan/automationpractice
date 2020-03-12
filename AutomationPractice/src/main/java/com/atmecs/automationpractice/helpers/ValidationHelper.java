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

	public static boolean validateImage(WebElement element) {

		display_status = element.isDisplayed();
		try {
			enable_status = element.isEnabled();
			Assert.assertEquals(enable_status, true);
			System.out.println(element.getAttribute("src") + " is displayed");
			return true;
		} catch (AssertionError assertionError) {
			System.out.println(element.getAttribute("src") + " is not displayed");
			return false;
		}
	}

	public static boolean validateButton(WebElement element) {

		try {
			enable_status = element.isEnabled();
			Assert.assertEquals(enable_status, true);
			System.out.println(element.getText() + " is enabled");
			return true;
		} catch (AssertionError assertionError) {
			System.out.println(element.getText() + " is disabled");
			return false;
		}
	}

	public static boolean validateAttribute(WebDriver driver, String path, String attribute, String expectedAttribute) {
		String actual = CommonHelpers.findElement(driver, path).getAttribute(attribute);
		try {
			Assert.assertEquals(actual, expectedAttribute);
			System.out.println("expected attribute:" + actual);
		} catch (AssertionError e) {
			System.out.println("attribute not present" + e.getMessage());
		}
		return false;

	}

	public static void CheckImage(WebDriver driver, String xpath) throws Exception {
		WebElement ImageFile = CommonHelpers.findElement(driver, xpath);

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				ImageFile);
		if (!ImagePresent) {
			System.out.println("Image not displayed.");
		} else {
			System.out.println("Image displayed.");
		}
	}
}
