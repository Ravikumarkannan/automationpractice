package com.atmecs.ap.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.atmecs.ap.constants.FilePaths;
import com.atmecs.ap.utils.PropertyReader;

public class TestBase {

	public static WebDriver driver;
	String baseUrl;
	String browser;

	@BeforeTest
	public void invokeBrowser() {
		Properties property = PropertyReader.readProperty(FilePaths.CONFIG_FILE);
		baseUrl = property.getProperty("Url");
		browser = property.getProperty("Browser"); 

		System.setProperty("webdriver.chrome.driver", FilePaths.CHROME_FILE);

		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();

		driver.get(baseUrl);
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
}
