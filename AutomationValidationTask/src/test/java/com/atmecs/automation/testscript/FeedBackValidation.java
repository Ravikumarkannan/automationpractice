package com.atmecs.automation.testscript;

/**
 * @author Ravikumar.Kannan
 * @Test Scenario Id:TS_004
 * @Test Case Id:TC_016,TC_017
 */

import java.util.Properties;

import org.testng.annotations.Test;

import com.atmecs.automation.constants.FilePath;
import com.atmecs.automation.helpers.CommonHelpers;
import com.atmecs.automation.helpers.PageAction;
import com.atmecs.automation.logger.Loggers;
import com.atmecs.automation.pages.FeedBackPage;
import com.atmecs.automation.testbase.TestBase;
import com.atmecs.automation.utils.FileHandler;
import com.atmecs.automation.utils.PropertyReader;

/**********Scenario4:FeedBack Validation**********/

public class FeedBackValidation extends TestBase{
	
	Loggers log = new Loggers();
	Properties path;
	Properties data;
	Properties tdata;
	
	@Test
	public void validateFeedBack() throws Exception {
		path = PropertyReader.readProperties(FilePath.FEEDBACK_FILE);
		data = PropertyReader.readProperties(FilePath.FEEDBACK_VALID_FILE);
		tdata = PropertyReader.readProperties(FilePath.FEEDBACK_TEST_FILE);
		
		log.info("Scenario 4 started..." +"\n");
		

		CommonHelpers.clickElement(driver, path.getProperty("loc_contact"));
		PageAction.dropDown(driver, path.getProperty("loc_sub_drdn"), "Customer service");
		FileHandler.uploadFile(driver, path.getProperty("loc_upload"), tdata.getProperty("test_filepath"));
		FeedBackPage.validateFeedBack(driver, path.getProperty("loc_email"), tdata.getProperty("test_email"), path.getProperty("loc_textarea"), tdata.getProperty("test_feedback"), path.getProperty("loc_filename"), data.getProperty("val_filename"),path.getProperty("loc_confirm"),tdata.getProperty("test_confirm"));
		CommonHelpers.clickElement(driver, path.getProperty("loc_send_btn"));
		
		log.info("Scenario 4 completed..." +"\n");
		
	}
}
