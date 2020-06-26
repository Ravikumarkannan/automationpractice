package com.atmecs.telluride.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.atmecs.telluride.constants.FilePath;
import com.atmecs.telluride.utils.PropertyReader;

public class TestBase {

	public static WebDriver driver;

	@BeforeTest
	public void invokeBrowser() {

		Properties configProperty = PropertyReader.readProperties(FilePath.CONFIG_FILE);
		System.setProperty("webdriver.chrome.driver", FilePath.CHROME_DRIVER);

		String url = configProperty.getProperty("url");
		String browser = configProperty.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		driver.get(url);

		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	}
}
