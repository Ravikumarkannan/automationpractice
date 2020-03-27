package com.atmecs.visitteluride.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.atmecs.visitteluride.constants.FilePath;
import com.atmecs.visitteluride.helpers.CommonHelpers;
import com.atmecs.visitteluride.helpers.Waits;
import com.atmecs.visitteluride.loggers.Loggers;
import com.atmecs.visitteluride.pages.IframePage;
import com.atmecs.visitteluride.testbase.TestBase;
import com.atmecs.visitteluride.utils.PropertyReader;

public class IframeActions extends TestBase {

	Loggers log = new Loggers();
	Properties path = new Properties();
	Properties tdata = new Properties();

	@Test
	public void iframeValidation() throws Exception {

		path = PropertyReader.readProperty(FilePath.IFRAME_FILE);

		/*Robot class Key board events*/
		CommonHelpers.click(driver, "//input[@id=\"arrivalDate\"]");
		IframePage.keyboardEvents();
		
		/* validation iframe1*/
		CommonHelpers.switchToFrame(driver, path.getProperty("loc_iframe"));
		CommonHelpers.scrollDown(driver, path.getProperty("loc_email"));
		IframePage.iframe1Validation(driver, path.getProperty("loc_email"), path.getProperty("loc_country"),"demomail.com", "India", path.getProperty("loc_submit"));
		WebDriver iframe_chat = CommonHelpers.switchToFrame(driver, "//iframe[@id='navis_chalk_button']");
		Waits.waitByElementClickable(driver, path.getProperty("loc_chat"));
		CommonHelpers.click(driver, path.getProperty("loc_chat"));

		/* validation iframe2*/
		iframe_chat.switchTo().defaultContent();
		Waits.waitByElementVisible(driver, "//iframe[@id='navis_chalk_app']");
		CommonHelpers.switchToFrame(driver, "//iframe[@id='navis_chalk_app']");
		IframePage.iframe2Validation(driver, path.getProperty("loc_name"), path.getProperty("loc_email_chat"),path.getProperty("loc_phone"), "ravi", "useremail", "1234", path.getProperty("loc_submit_chat"));
		CommonHelpers.click(driver, path.getProperty("loc_minimize"));
	}
}