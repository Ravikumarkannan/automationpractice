package com.selenium.demosite.test;

import java.util.Properties;

import org.testng.annotations.Test;

import com.atmecs.demosite.constants.FilePath;
import com.atmecs.demosite.helpers.CommonHelpers;
import com.atmecs.demosite.helpers.PageActions;
import com.atmecs.demosite.testbase.TestBase;
import com.atmecs.demosite.utils.PropertyReader;

public class WebElementValidation extends TestBase{

	Properties path;
	@Test
	public void validateWebElements() throws Exception {
		path = PropertyReader.readProperties(FilePath.LOCATOR_HOMEPAGE);
		
		CommonHelpers.sendKeys(driver, path.getProperty("loc_firstname"), "Downey");
		
		CommonHelpers.sendKeys(driver, path.getProperty("loc_lastname"), "Stark");
		
		CommonHelpers.sendKeys(driver, path.getProperty("loc_address"), "Newyork");
		
		CommonHelpers.sendKeys(driver, path.getProperty("loc_email"), "demoemail@gmail.com");
		
		CommonHelpers.sendKeys(driver, path.getProperty("loc_mobile"), "123456177");
		
		CommonHelpers.clickElement(driver, path.getProperty("loc_gender"));
		
		CommonHelpers.clickElement(driver, path.getProperty("loc_hobby"));
		
		PageActions.dropDown(driver, path.getProperty("loc_skills"), "Java");
		
		PageActions.dropDown(driver, path.getProperty("loc_country"), "Albania");
		
	}
}
