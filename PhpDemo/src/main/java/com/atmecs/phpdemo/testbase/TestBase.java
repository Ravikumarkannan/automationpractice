package com.atmecs.phpdemo.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.atmecs.phpdemo.constants.FilePaths;
import com.atmecs.phpdemo.utils.PropertyReader;

public class TestBase {
	Properties properties;
	public WebDriver driver;
	String baseUrl;
	String browser;

	@BeforeTest
	public void invokeBrowser() {

		properties = PropertyReader.readProperties(FilePaths.CONFIG_FILE);

		baseUrl = properties.getProperty("URL");
		browser = properties.getProperty("Browser");

		System.setProperty("webdriver.chrome.driver", FilePaths.CHROME_FILE);
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		driver.get(baseUrl);
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
}
