package com.atmecs.insurencedemo.tests;

import org.testng.annotations.Test;

import com.atmecs.insurencedemo.pages.WindowHandler;
import com.atmecs.insurencedemo.testbase.TestBase;

public class WindowHandles extends TestBase{

	WindowHandler  handler = new WindowHandler();
	
	@Test(priority = 1)
	public void navigateToWebservice(){
		
		handler.navigateToWebservice(driver);
		
	}
	
	@Test(priority = 2)
	public void openMultipleWindow() {
		handler.switchToLinks(driver, "//a[text()='WSDL1.1']");
	}
	
	@Test(priority = 3)
	public void getParentWindow() {
		handler.switchToParent(driver);
	}
	
	@Test(priority = 4)
	public void openMultipleWindow1() {
		handler.switchToLinks(driver, "//a[text()='WSDL2.0']");
	}
}
