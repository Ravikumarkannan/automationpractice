package com.atmecs.insurencedemo.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.atmecs.insurencedemo.constants.FilePaths;
import com.atmecs.insurencedemo.helpers.CommonHelpers;
import com.atmecs.insurencedemo.utils.PropertyReader;

public class WindowHandler {

	Properties path;
	
	public void navigateToWebservice(WebDriver driver) {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_FILEUPLOAD);
		
		CommonHelpers.clickElement(driver, path.getProperty("loc.webservice"));
	}
	
	public String getWindow(WebDriver driver) {
		String driver1 = driver.getWindowHandle();
		return driver1;
	}
	
	public void switchToLinks(WebDriver driver,String link) {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_FILEUPLOAD);
		CommonHelpers.clickElement(driver, link);
	}
	
	public void switchToParent(WebDriver driver) {
		
		driver.switchTo().parentFrame();
	}
}
