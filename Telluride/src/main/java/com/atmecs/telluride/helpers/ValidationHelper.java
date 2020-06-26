package com.atmecs.telluride.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class ValidationHelper {

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
	
	public static void validateAttribute(WebDriver driver,String path,String attribute, String expectedAttribute) {
		
		SoftAssert softAssertion = new SoftAssert();
		String act_attribute = driver.findElement(By.xpath(path)).getAttribute(attribute);
		try {
			softAssertion.assertEquals(act_attribute, expectedAttribute);
			System.out.println(act_attribute+"validated");
		}
		catch(AssertionError assertionError){
			System.out.println("Expected attribute not matched");
		}
	}
}
