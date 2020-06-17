package com.atmecs.insurencedemo.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.insurencedemo.constants.FilePaths;
import com.atmecs.insurencedemo.helpers.CommonHelpers;
import com.atmecs.insurencedemo.helpers.PageActionHelpers;
import com.atmecs.insurencedemo.helpers.ValidationHelper;
import com.atmecs.insurencedemo.utils.ExcelReader;
import com.atmecs.insurencedemo.utils.PropertyReader;

public class PurchasePage {

	Properties path;

	public void chooseAutoQuote(WebDriver driver) throws Exception {

		path = PropertyReader.readProperties(FilePaths.LOCATOR_PURCHASE);

		PageActionHelpers.dropDown(driver, path.getProperty("loc.autoquote"), "Auto Quote");

	}

	public void enterVehicleInfo(WebDriver driver, String zipcode, String email) {

		path = PropertyReader.readProperties(FilePaths.LOCATOR_PURCHASE);

		CommonHelpers.sendKeys(driver, path.getProperty("loc.zipcode"), zipcode);
		CommonHelpers.sendKeys(driver, path.getProperty("loc.email"), email);
		CommonHelpers.clickElement(driver, path.getProperty("loc.vehicle"));
	}

	public void navigateToNextPage(WebDriver driver) {

		path = PropertyReader.readProperties(FilePaths.LOCATOR_PURCHASE);

		CommonHelpers.clickElement(driver, path.getProperty("loc.nextBtn"));
	}
	
	public void enterPersonalInfo(WebDriver driver, String age) {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_PURCHASE);
		
		CommonHelpers.sendKeys(driver, path.getProperty("loc.age"), age);
		CommonHelpers.clickElement(driver, path.getProperty("loc.gender"));
		CommonHelpers.clickElement(driver, path.getProperty("loc.drivingRecord"));
	}
	
	public void enterAutomobileInfo(WebDriver driver, String year) {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_PURCHASE);
		
		CommonHelpers.sendKeys(driver, path.getProperty("loc.year"),year );
		CommonHelpers.clickElement(driver, path.getProperty("loc.make"));
		CommonHelpers.explicitWait(driver, path.getProperty("loc.toyota"));
		
		CommonHelpers.clickElement(driver, path.getProperty("loc.toyota"));
		CommonHelpers.clickElement(driver, path.getProperty("loc.model"));
		CommonHelpers.explicitWait(driver, path.getProperty("loc.camry"));
		
		CommonHelpers.clickElement(driver, path.getProperty("loc.camry"));
		CommonHelpers.clickElement(driver, path.getProperty("loc.financial"));
	}
	
	public void verifyFinalInfo(WebDriver driver , String expectedData) {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_PURCHASE);
		
		List<WebElement> finalInfo = CommonHelpers.findElements(driver, path.getProperty("loc.finalInfo"));
		
		for(int count=0; count<7; count++) {
			Assert.assertEquals(finalInfo.get(count).getText(), ExcelReader.readData(expectedData, count, 0));
		}
	}
}
