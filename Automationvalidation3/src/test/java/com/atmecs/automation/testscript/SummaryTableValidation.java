package com.atmecs.automation.testscript;

/**
 * @author Ravikumar.Kannan
 * @Test Scenario Id:TS_003
 * @Test Case Id:TC_015
 */

import java.util.Properties;
import org.testng.annotations.Test;
import com.atmecs.automation.constants.FilePath;
import com.atmecs.automation.helpers.CommonHelpers;
import com.atmecs.automation.logger.Loggers;
import com.atmecs.automation.pages.SummaryPage;
import com.atmecs.automation.testbase.TestBase;
import com.atmecs.automation.utils.PropertyReader;

/**********Scenario3:Summary Table Validation**********/

public class SummaryTableValidation extends TestBase {
	Loggers log = new Loggers();
	Properties path;
	Properties data;

	@Test
	public void validateTable() throws Exception {
		
		log.info("Scenario 3 started..." +"\n");
		
		path = PropertyReader.readProperties(FilePath.SUMMARYTABLE_FILE);
		data = PropertyReader.readProperties(FilePath.SUMMARYTABLE_VALID_FILE);
		
		SummaryPage.validteSummaryTable(driver, path.getProperty("loc_cart"), path.getProperty("loc_checkout"),path.getProperty("loc_totalprice"), data.getProperty("val_totalprice"));
		CommonHelpers.clickElement(driver, path.getProperty("loc_checkOut"));
		
		log.info("Scenario 3 completed..." +"\n");
	}
}