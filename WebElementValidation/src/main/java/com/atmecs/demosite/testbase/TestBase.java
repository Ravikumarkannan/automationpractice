package com.atmecs.demosite.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.atmecs.demosite.constants.FilePath;
import com.atmecs.demosite.utils.PropertyReader;



public class TestBase {

	public static WebDriver driver;

	String baseUrl;
	String browser;

	@BeforeTest
	public void invokeBrowser() {
		Properties property = PropertyReader.readProperties(FilePath.CONFIG_FILE);
		System.setProperty("webdriver.chrome.driver", FilePath.CHROME_DRIVER);
		baseUrl = property.getProperty("Url");
		browser = property.getProperty("Browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
}
