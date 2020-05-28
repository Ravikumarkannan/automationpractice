package com.atmecs.ninjakart.testbase;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.atmecs.ninjakart.constants.Filepath;
import com.atmecs.ninjakart.utils.PropertyReader;

public class TestBase2 {

	public WebDriver driver;

	@BeforeTest
	@Parameters({ "browser" })
	public void openBrowser(String browser) throws Exception {
		Properties property = PropertyReader.readProperties(Filepath.CONFIG_FILE);
		String baseUrl = property.getProperty("Url");

		URL nodeURL = new URL("http://192.168.43.135:4444/wd/hub");

		if (browser.equalsIgnoreCase("Chrome")) {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			System.out.println("Chrome Browser Initiated");
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(nodeURL,capabilities);
		}
		else  if(browser.equalsIgnoreCase("Firefox")) {
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			System.out.println("Firefox Browser Initiated");
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(nodeURL,capabilities);
		}
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
