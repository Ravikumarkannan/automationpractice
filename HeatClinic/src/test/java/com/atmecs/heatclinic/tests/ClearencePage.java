package com.atmecs.heatclinic.tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.atmecs.heatclinic.constants.FilePaths;
import com.atmecs.heatclinic.helpers.CommonHelpers;
import com.atmecs.heatclinic.testbase.TestBase;
import com.atmecs.heatclinic.utils.PropertyReader;

public class ClearencePage extends TestBase{

	Properties path;
	
	@Test
	public void filterProducts() {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_CLEARENCE);
		
		CommonHelpers.clickElement(driver, path.getProperty("loc.clearence"));
		CommonHelpers.clickElement(driver, path.getProperty("loc.dropdown"));
		CommonHelpers.clickElement(driver, path.getProperty("loc.lowtohigh"));
		
		
	}
	
	@Test
	public void logOut() {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_CLEARENCE);
		
		CommonHelpers.clickElement(driver, path.getProperty("loc.account"));
		CommonHelpers.clickElement(driver, path.getProperty("loc.myaccount"));
		CommonHelpers.clickElement(driver, path.getProperty("loc.logout"));
	}
}
