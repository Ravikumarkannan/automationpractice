package com.atmecs.automationpractice.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import com.atmecs.automationpractice.constants.FilePath;
import com.atmecs.automationpractice.utils.PropertyReader;

public class TestBase {

	Properties properties;
	public static WebDriver driver;
	String baseUrl;
	String browser;

	@BeforeTest
	public void invokeBrowser() {

		properties = PropertyReader.readProperties(FilePath.CONFIG_FILE);

		baseUrl = properties.getProperty("Url");
		browser = properties.getProperty("Browser");

		System.setProperty("webdriver.chrome.driver", FilePath.CHROME_FILE);
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		driver.get(baseUrl);
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
}
