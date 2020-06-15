package com.atmecs.insurencedemo.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.atmecs.insurencedemo.constants.FilePaths;
import com.atmecs.insurencedemo.utils.PropertyReader;


public class TestBase {

	public static WebDriver driver;

	String baseUrl;

	@BeforeTest
	public void invokeBrowser() {

		Properties property = PropertyReader.readProperties(FilePaths.CONFIG_FILE);

		baseUrl = property.getProperty("Url");

		System.setProperty("webdriver.chrome.driver", FilePaths.CHROME_DRIVER);
		driver = new ChromeDriver();

		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
}
