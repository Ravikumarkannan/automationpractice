package com.atmecs.visitteluride.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.atmecs.visitteluride.constants.FilePath;
import com.atmecs.visitteluride.loggers.Loggers;
import com.atmecs.visitteluride.utils.PropertyReader;

public class TestBase {
	
	Loggers log = new Loggers();
	public static WebDriver driver;
	String baseUrl;
	String browser;
	
	@BeforeTest
	public void invokeBrowser() {
		Properties property = PropertyReader.readProperty(FilePath.CONFIG_FILE);
		baseUrl = property.getProperty("Url");
		browser = property.getProperty("Browser");
		
		System.setProperty("webdriver.chrome.driver", FilePath.CHROME_FILE);
		
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		
		log.info("Browser started...");
		driver.get(baseUrl);
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
}
