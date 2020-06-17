package com.atmecs.insurencedemo.tests;

import org.testng.annotations.Test;

import com.atmecs.insurencedemo.pages.PurchasePage;
import com.atmecs.insurencedemo.testbase.TestBase;

public class PurchaseQuote extends TestBase {

	PurchasePage purchase = new PurchasePage();
	
	@Test(priority = 1)
	public void purchasQuote() throws Exception {
		
		purchase.chooseAutoQuote(driver);
	}
	
	@Test(priority = 2)
	public void entervehicleInformation() {
		
		purchase.enterVehicleInfo(driver, "678934", "demoemail.gmail.com");
	}
	
	@Test(priority = 3)
	public void enterPersonalInformation() {
		
		purchase.enterPersonalInfo(driver, "25");
	}
	
	@Test(priority = 4)
	public void enterAutomobileInformation() {
		
		purchase.enterAutomobileInfo(driver, "2000");
	}
	
	
}
