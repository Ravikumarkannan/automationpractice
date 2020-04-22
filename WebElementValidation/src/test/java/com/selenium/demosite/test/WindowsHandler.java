package com.selenium.demosite.test;

import java.util.Collection;
import java.util.Properties;

import org.testng.annotations.Test;

import com.atmecs.demosite.constants.FilePath;
import com.atmecs.demosite.helpers.PageActions;
import com.atmecs.demosite.pages.WindowsHandlingPage;
import com.atmecs.demosite.testbase.TestBase;
import com.atmecs.demosite.utils.PropertyReader;

public class WindowsHandler extends TestBase {

	Properties path;
	
	@Test
	public void getWebelements() {
		path = PropertyReader.readProperties(FilePath.LOCATOR_WINDOWS);
		
		WindowsHandlingPage.navigateToMultipleWindows(driver, path.getProperty("loc_switchto"), path.getProperty("loc_windows"), path.getProperty("loc_multiple"), path.getProperty("loc_click"));
		Collection<String> windows = PageActions.getWindows(driver);
		System.out.println(windows.size());
		
		for(String handle : windows)
		{
		driver.switchTo().window(handle);
		}
		driver.close();
		
		driver.switchTo().defaultContent();
	}
}
