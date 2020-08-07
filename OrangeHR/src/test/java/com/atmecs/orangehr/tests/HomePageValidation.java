package com.atmecs.orangehr.tests;

import java.util.Properties;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.orangehr.constants.FilePaths;
import com.atmecs.orangehr.pages.HomePageHelper;
import com.atmecs.orangehr.testbase.TestBase;
import com.atmecs.orangehr.utils.PropertyReader;

public class HomePageValidation extends TestBase {

	static Properties path;

	@Test
	@Parameters({ "userName", "password" })
	public void validatePurchase( String userName , String password) throws Exception {

		path = PropertyReader.readProperties(FilePaths.HOMEPAGE_LOCATOR);

		HomePageHelper.login(driver, path.getProperty("loc.username"), path.getProperty("loc.password"), userName, password, path.getProperty("loc.login_btn"));

	}
}
