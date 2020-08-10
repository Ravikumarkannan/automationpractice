package com.atmecs.helperclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ParallelDemo2 {
	
	public static WebDriver driver;

	@Test
	public void launch() {
		
		BrowserFactory browserFactory = BrowserFactory.getInstance();
		
		browserFactory.setDriver("chrome");
		
		driver = browserFactory.getDriver();
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
}
