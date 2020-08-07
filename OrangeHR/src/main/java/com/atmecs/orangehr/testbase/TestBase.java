package com.atmecs.orangehr.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import com.atmecs.orangehr.constants.FilePaths;
import com.atmecs.orangehr.reports.LogReports;
import com.atmecs.orangehr.utils.PropertyReader;

public class TestBase {

LogReports log = new LogReports();

	Properties baseProperty;
	String url;
	String browser;
	String os;

	public static WebDriver driver;

	@BeforeTest
	public void invokeBrowser() {

		baseProperty = PropertyReader.readProperties(FilePaths.CONFIG_FILE);

		url = baseProperty.getProperty("Url");
		browser = baseProperty.getProperty("Browser");

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", FilePaths.CHROME_DRIVER);
			driver = new ChromeDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BasicConfigurator.configure();

	}
}
