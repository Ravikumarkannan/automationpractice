package com.atmecs.automation.testscript;

import java.util.Properties;

import org.testng.annotations.Test;

import com.atmecs.automation.constants.FilePath;
import com.atmecs.automation.logger.Loggers;
import com.atmecs.automation.pages.HomePage;
import com.atmecs.automation.testbase.TestBase;
import com.atmecs.automation.utils.PropertyReader;

public class TooltipValidation extends TestBase {

	Loggers log = new Loggers();
	Properties path;
	Properties vdata;
	
	@Test
	public void validateTooltip() {
		
		path = PropertyReader.readProperties(FilePath.TOOLTIP_FILE);
		vdata = PropertyReader.readProperties(FilePath.TOOLTIP_VALID_FILE);
		
		//soft assertion
		HomePage.toolTipValidation(driver, path.getProperty("loc_signin"), vdata.getProperty("val_signIn"));
		HomePage.toolTipValidation(driver, path.getProperty("loc_cart"), vdata.getProperty("val_cart"));
		HomePage.toolTipValidation(driver, path.getProperty("loc_logo"), vdata.getProperty("val_logo"));
		HomePage.toolTipValidation(driver, path.getProperty("loc_tops"), vdata.getProperty("val_tops"));
		HomePage.toolTipValidation(driver, path.getProperty("loc_contact"), vdata.getProperty("val_contact"));
	}
}