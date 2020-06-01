package com.atmecs.action.test;

import java.util.Properties;

import org.testng.annotations.Test;

import com.atmecs.action.constants.FilePaths;
import com.atmecs.action.helpers.ActionHelpers;
import com.atmecs.action.helpers.CommonHelpers;
import com.atmecs.action.testbase.TestBase;
import com.atmecs.action.utils.PropertyReader;

public class Register extends TestBase {

	Properties path;

	@Test
	public void enterPersonalDetails() {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_HOMEPAGE);

		CommonHelpers.sendKeys(driver, path.getProperty("loc.firstname"), "customer");
		CommonHelpers.sendKeys(driver, path.getProperty("loc.lastname"), "customer");

		ActionHelpers.copy(driver, path.getProperty("loc.lastname"));
		ActionHelpers.paste(driver, path.getProperty("loc.email"));

		ActionHelpers.tab(driver);
		ActionHelpers.tab(driver);

		ActionHelpers.mouseMoveOver(driver, path.getProperty("loc.choose"));

		CommonHelpers.scrollDown(driver, path.getProperty("loc.scroll"));

	}

	@Test(dependsOnMethods = "enterPersonalDetails")
	public void enterQualificationDetails() throws Exception {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_HOMEPAGE);

		CommonHelpers.dropDown(driver, path.getProperty("loc.skill"), "Android");
		CommonHelpers.dropDown(driver, path.getProperty("loc.country"), "India");
	}

	@Test(dependsOnMethods = "enterQualificationDetails")
	public void enterPassword() {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_HOMEPAGE);

		CommonHelpers.sendKeys(driver, path.getProperty("loc.password1"), "password1");
		CommonHelpers.sendKeys(driver, path.getProperty("loc.password2"), "password2");
	}

	@Test(dependsOnGroups = "enterPassword")
	public void submitForm() {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_HOMEPAGE);

		CommonHelpers.clickElement(driver, path.getProperty("loc.submit"));
	}

	@Test(enabled = false)
	public void refreshForm() {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_HOMEPAGE);

		CommonHelpers.clickElement(driver, path.getProperty("loc.refresh"));
	}
	
	
}
