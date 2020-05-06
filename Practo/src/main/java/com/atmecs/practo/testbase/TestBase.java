package com.atmecs.practo.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.atmecs.practo.constants.FilePath;
import com.atmecs.practo.utils.PropertyReader;

public class TestBase {

	public static WebDriver driver;
	public String url;
	public String browser;

	@BeforeTest
	public void invokeBrowser() {
		
		Properties properties = PropertyReader.readProperty(FilePath.CONFIG_FILE);
		url = properties.getProperty("Url");
		browser = properties.getProperty("Browser");

		System.setProperty("webdriver.chrome.driver", FilePath.CHROME_FILE);
		driver = new ChromeDriver();
		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
