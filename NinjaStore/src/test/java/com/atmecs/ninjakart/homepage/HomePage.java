package com.atmecs.ninjakart.homepage;

import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.ninjakart.constants.Filepath;
import com.atmecs.ninjakart.helpers.CommonHelpers;
import com.atmecs.ninjakart.pages.HomepageHelper;
import com.atmecs.ninjakart.testbase.TestBase;
import com.atmecs.ninjakart.testbase.TestBase2;
import com.atmecs.ninjakart.utils.PropertyReader;

public class HomePage extends TestBase {

	Properties path;

	@Test(dataProvider = "provideCredentials")
	public void login(String userName, String password) {
		path = PropertyReader.readProperties(Filepath.LOCATOR_HOMEPAGE);
		HomepageHelper.userLogin(driver, path.getProperty("loc.myaccount"), path.getProperty("loc.login"));
		CommonHelpers.sendKeys(driver, path.getProperty("loc.email"), userName);
		CommonHelpers.sendKeys(driver, path.getProperty("loc.password"), password);
		CommonHelpers.clickElement(driver, path.getProperty("loc.btn.login"));
	}
	
	@DataProvider(name = "provideCredentials")
	public Object[][] provideData() {

		return new Object[][] { { "newcustomer1@yahoo.com", "newcustomer1" }, };
	}
}
