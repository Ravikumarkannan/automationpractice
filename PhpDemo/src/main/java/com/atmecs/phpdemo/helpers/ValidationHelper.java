package com.atmecs.phpdemo.helpers;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ValidationHelper {

	public static boolean display_status;
	public static boolean enable_status;
	public static String actual_text;

	public static boolean validateText(WebElement element , String expectedText) {
		
		actual_text = element.getText();
		try {
			Assert.assertEquals(actual_text, expectedText);
			System.out.println(actual_text  +" is present");
			return true;
		} catch (AssertionError assertionError) {
			System.out.println(actual_text  +" is not present");
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
}
