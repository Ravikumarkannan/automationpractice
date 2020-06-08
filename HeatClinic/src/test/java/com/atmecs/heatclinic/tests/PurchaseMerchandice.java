package com.atmecs.heatclinic.tests;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.heatclinic.constants.FilePaths;
import com.atmecs.heatclinic.helpers.CommonHelpers;
import com.atmecs.heatclinic.helpers.PageActions;
import com.atmecs.heatclinic.testbase.TestBase;
import com.atmecs.heatclinic.utils.PropertyReader;

public class PurchaseMerchandice extends TestBase {

	Properties path;

	@Test
	public void addProduct() {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_MERCHANDISE);
		PageActions.mouseMoveOver(driver, path.getProperty("loc.merchandise"));

		CommonHelpers.clickElement(driver, path.getProperty("loc.mens"));
		CommonHelpers.clickElement(driver, path.getProperty("loc.color"));
		CommonHelpers.clickElement(driver, path.getProperty("loc.black"));

	}

	@Test
	public void modifyProduct() throws Exception {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_MERCHANDISE);

		CommonHelpers.clickElement(driver, path.getProperty("loc.title"));
		PageActions.dropDown(driver, path.getProperty("loc.size"), "S");

	}

	@Test
	public void validateAccount() {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_MERCHANDISE);
		
		CommonHelpers.clickElement(driver, path.getProperty("loc.account"));
		
		CommonHelpers.explicitWait(driver, path.getProperty("loc.myaccount"));
		CommonHelpers.clickElement(driver, path.getProperty("loc.myaccount"));
		
		String email = driver.findElement(By.xpath(path.getProperty("loc.email"))).getAttribute("value");
		String firstName = driver.findElement(By.xpath(path.getProperty("loc.fname"))).getAttribute("value");
		String lastName = driver.findElement(By.xpath(path.getProperty("loc.lastname"))).getAttribute("value");

		Assert.assertEquals(email, "demouser@gmail.com");
		Assert.assertEquals(firstName, "demo");
		Assert.assertEquals(lastName, "user");
		
	}

	@Test
	public void validateFooters() {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_MERCHANDISE);

		List<WebElement> footers = CommonHelpers.findElements(driver, path.getProperty("loc.footer"));

		PageActions.scrollDown(driver, path.getProperty("loc.footer"));

		Assert.assertEquals(footers.get(0), "About Us");
		Assert.assertEquals(footers.get(1), "Contact Us");
		Assert.assertEquals(footers.get(2), "Privacy Policy");
	}
}
