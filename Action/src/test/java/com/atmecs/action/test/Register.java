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
	public void enterDetails() {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_HOMEPAGE);
		
		CommonHelpers.sendKeys(driver, path.getProperty("loc.firstname"), "customer");
		CommonHelpers.sendKeys(driver, path.getProperty("loc.lastname"), "customer");
		
		ActionHelpers.copy(driver, path.getProperty("loc.lastname"));
		ActionHelpers.paste(driver, path.getProperty("loc.email"));
		
		ActionHelpers.tab(driver);
		ActionHelpers.tab(driver);
		
		ActionHelpers.mouseMoveOver(driver, path.getProperty("loc.choose"));
		
	}
}
