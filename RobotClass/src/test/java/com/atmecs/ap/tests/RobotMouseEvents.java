package com.atmecs.ap.tests;

import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import com.atmecs.ap.constants.FilePaths;
import com.atmecs.ap.helpers.CommonHelpers;
import com.atmecs.ap.pages.RobotClass;
import com.atmecs.ap.testbase.TestBase;
import com.atmecs.ap.utils.PropertyReader;

public class RobotMouseEvents extends TestBase {

	Properties path = new Properties();
	Properties tdata = new Properties();

	@Test
	public void uploadFile() throws Exception {

		path = PropertyReader.readProperty(FilePaths.ROBOT_FILE);

		CommonHelpers.click(driver, path.getProperty("loc_contactus"));
		RobotClass.mouseWheel();
		CommonHelpers.dropDown(driver, path.getProperty("loc_subject"), "Customer service");
		CommonHelpers.sendKeys(driver, path.getProperty("loc_email"), "demo@email.com");
		CommonHelpers.sendKeys(driver, path.getProperty("loc_textarea"), "improve your service");

		RobotClass.clickFile();
		RobotClass.chooseFile();
		RobotClass.uploadFile(driver, path.getProperty("loc_send"));
	}
}
