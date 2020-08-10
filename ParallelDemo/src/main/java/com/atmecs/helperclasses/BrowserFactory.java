package com.atmecs.helperclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public static BrowserFactory instance = null;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	public BrowserFactory() {

	}

	public static BrowserFactory getInstance() {
		if (instance == null) {
			instance = new BrowserFactory();
		}
		return instance;
	}

	public void setDriver(String browser) {

		if (browser == "chrome") {
			System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
			webDriver.set(new ChromeDriver());
		}

	}

	public WebDriver getDriver() {
		return webDriver.get();
	}
}
