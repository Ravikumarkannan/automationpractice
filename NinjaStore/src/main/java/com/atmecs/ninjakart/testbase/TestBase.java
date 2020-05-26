package com.atmecs.ninjakart.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.atmecs.ninjakart.constants.Filepath;
import com.atmecs.ninjakart.utils.PropertyReader;

public class TestBase {

	public static WebDriver driver;

	String baseUrl;

//	@Parameters({ "browser" })
//	@BeforeTest
	public void invokeBrowser(String browser) {

		Properties property = PropertyReader.readProperties(Filepath.CONFIG_FILE);

		baseUrl = property.getProperty("Url");
		
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", Filepath.CHROME_DRIVER);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", Filepath.IE_DRIVER);
			driver = new InternetExplorerDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",Filepath.GECKO_DRIVER);
			driver = new FirefoxDriver();
		}
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
}
