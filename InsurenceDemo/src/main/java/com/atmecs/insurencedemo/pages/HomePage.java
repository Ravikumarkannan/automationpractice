package com.atmecs.insurencedemo.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.insurencedemo.constants.FilePaths;
import com.atmecs.insurencedemo.helpers.ValidationHelper;
import com.atmecs.insurencedemo.utils.PropertyReader;

public class HomePage {

	Properties path;

	public void loginValidation(WebDriver driver, String userName, String password) {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_HOMEPAGE);

		driver.findElement(By.xpath(path.getProperty("loc.email"))).sendKeys(userName);
		driver.findElement(By.xpath(path.getProperty("loc.password"))).sendKeys(password);
	}

	public void linkTextValidtion(WebDriver driver, String expectedData) {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_HOMEPAGE);
		
		String link1 = driver.findElement(By.xpath(path.getProperty("loc.linktext1"))).getAttribute("href");
		
		try {
			Assert.assertEquals(link1, expectedData);
		} catch (AssertionError e) {
			System.out.println("assertion error" + e.getMessage());
		}
	}
	
	public void imageValidation(WebDriver driver) throws Exception {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_HOMEPAGE);
		
		ValidationHelper.CheckImage(driver, path.getProperty("loc.titleimg"));
	}
}
