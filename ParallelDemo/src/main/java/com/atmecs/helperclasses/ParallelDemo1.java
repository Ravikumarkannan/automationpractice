package com.atmecs.helperclasses;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.constants.Filepaths;
import com.atmecs.pageactions.PageActionHelper;
import com.atmecs.utils.PropertyReader;

public class ParallelDemo1 {
	
	public static WebDriver driver;
	public String url;
	
	Properties config_properties;
	Properties path_propProperties;

	@Test
	@Parameters({ "userName", "password" })
	public void logIn(String userName, String password) {

		config_properties = PropertyReader.readProperties(Filepaths.CONFIG_FILE);
		path_propProperties = PropertyReader.readProperties(Filepaths.HOMEPAGE_LOCATOR);
		
		url = config_properties.getProperty("Url");
		
		BrowserFactory browserFactory = BrowserFactory.getInstance();
		browserFactory.setDriver("chrome");
		
		driver = browserFactory.getDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		PageActionHelper.sendKeys(driver, path_propProperties.getProperty("loc.username"), userName);
		PageActionHelper.sendKeys(driver, path_propProperties.getProperty("loc.password"), password);
		PageActionHelper.clickElement(driver, path_propProperties.getProperty("loc.login_btn"));
		
	}
}
