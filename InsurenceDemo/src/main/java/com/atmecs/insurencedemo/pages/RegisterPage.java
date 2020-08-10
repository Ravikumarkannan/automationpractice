package com.atmecs.insurencedemo.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.insurencedemo.constants.FilePaths;
import com.atmecs.insurencedemo.helpers.PageActionHelpers;
import com.atmecs.insurencedemo.utils.PropertyReader;

public class RegisterPage {

	Properties path;

	public void validateTitle(WebDriver driver, String expTitle) {
		
		path = PropertyReader.readProperties(FilePaths.LOCATOR_REGISTER);
		driver.findElement(By.xpath(path.getProperty("loc.signup"))).click();

		String actTitle = driver.getTitle();

		try {
			Assert.assertEquals(actTitle, expTitle);
		} catch (AssertionError e) {
			System.out.println("Assertion failure" + e.getCause());
		}
	}

	public void userRegisteration(WebDriver driver, String fname, String lname, String email, String street,
			String city, String state, String postal, String password) throws Exception {

		path = PropertyReader.readProperties(FilePaths.LOCATOR_REGISTER);

		driver.findElement(By.xpath(path.getProperty("loc.fname"))).sendKeys(fname);
		driver.findElement(By.xpath(path.getProperty("loc.lname"))).sendKeys(lname);
		driver.findElement(By.xpath(path.getProperty("loc.email"))).sendKeys(email);
		driver.findElement(By.xpath(path.getProperty("loc.street"))).sendKeys(street);
		driver.findElement(By.xpath(path.getProperty("loc.city"))).sendKeys(city);
		
		PageActionHelpers.dropDown(driver, path.getProperty("loc.state"), state);
		
		driver.findElement(By.xpath(path.getProperty("loc.pincode"))).sendKeys(postal);
		driver.findElement(By.xpath(path.getProperty("loc.password"))).sendKeys(password);
		driver.findElement(By.xpath(path.getProperty("loc.signupbtn"))).click();

	}

	public void validateInformation(WebDriver driver) {
		
		path = PropertyReader.readProperties(FilePaths.LOCATOR_REGISTER);
		
		driver.findElement(By.xpath(path.getProperty("loc.continue"))).click();
	}
}
