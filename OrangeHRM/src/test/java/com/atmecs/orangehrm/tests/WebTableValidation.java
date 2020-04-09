package com.atmecs.orangehrm.tests;

import java.util.Properties;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.orangehrm.constants.FilePaths;
import com.atmecs.orangehrm.pages.WebTablePage;
import com.atmecs.orangehrm.testbase.TestBase;
import com.atmecs.orangehrm.utils.PropertyReader;

public class WebTableValidation extends TestBase {

	static Properties path;

	@Test
	@Parameters({ "userName", "password" })
	public void validatePurchase(String userName, String password) throws Exception {

		path = PropertyReader.readProperties(FilePaths.LOCATOR_WEBTABLE);

		WebTablePage.login(driver, path.getProperty("loc_username"), path.getProperty("loc_password"), userName,password, path.getProperty("loc_login_btn"));
	
		WebTablePage.navigateToJobTitles(driver, path.getProperty("loc_admin"), path.getProperty("loc_job"), path.getProperty("loc_jobtitles"));
		
		WebTablePage.getTable(driver, path.getProperty("loc_webtable"),path.getProperty("l0c_webtable_body"));
		
		WebTablePage.deleteJobTitle(driver, path.getProperty("loc_checkbox"), path.getProperty("loc_delete_btn"));
	}

}
