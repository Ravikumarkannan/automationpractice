package com.atmecs.heatclinic.tests;

import java.util.Properties;

import org.testng.annotations.Test;

import com.atmecs.heatclinic.constants.FilePaths;
import com.atmecs.heatclinic.helpers.CommonHelpers;
import com.atmecs.heatclinic.helpers.PageActions;
import com.atmecs.heatclinic.testbase.TestBase;
import com.atmecs.heatclinic.utils.PropertyReader;

public class PurchaseMerchandice extends TestBase{

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
}
