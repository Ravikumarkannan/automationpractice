package com.atmecs.heatclinic.tests;

import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.heatclinic.constants.FilePaths;
import com.atmecs.heatclinic.helpers.CommonHelpers;
import com.atmecs.heatclinic.helpers.PageActions;
import com.atmecs.heatclinic.testbase.TestBase;
import com.atmecs.heatclinic.utils.PropertyReader;

public class PurchaseOrder extends TestBase {

	Properties path;
	
	@Test
	@Parameters({"email","password"})
	public void login(String email,String password) {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_PURCHASE);
		
		CommonHelpers.clickElement(driver, path.getProperty("loc.login"));
		CommonHelpers.sendKeys(driver, path.getProperty("loc.email"), email);
		CommonHelpers.sendKeys(driver, path.getProperty("loc.password"), password);
		CommonHelpers.clickElement(driver, path.getProperty("loc.loginbtn"));
	}
	
	@Test
	public void searchProducts() {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_PURCHASE);
		
		CommonHelpers.sendKeys(driver, path.getProperty("loc.search"), "hot");
		CommonHelpers.clickElement(driver, path.getProperty("loc.searchicon"));
	}
	
	@Test(dependsOnMethods = "login" )
	public void checkOut() {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_PURCHASE);
		
		PageActions.scrollDown(driver, path.getProperty("loc.product"));
		CommonHelpers.explicitWait(driver, path.getProperty("loc.product"));
		CommonHelpers.clickElement(driver, path.getProperty("loc.product"));
		driver.switchTo().alert().accept();
		CommonHelpers.clickElement(driver, path.getProperty("loc.addtocart"));
		
		CommonHelpers.explicitWait(driver, path.getProperty("loc.viewcart"));
		CommonHelpers.clickElement(driver, path.getProperty("loc.viewcart"));
		
		CommonHelpers.clickElement(driver, path.getProperty("loc.checkout"));
	}
	
	@Test(dependsOnMethods = "checkOut")
	public void enterAddress() throws Exception {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_PURCHASE);
		
		CommonHelpers.sendKeys(driver, path.getProperty("loc.name"), "Newuser");
		CommonHelpers.sendKeys(driver, path.getProperty("loc.address1"), "cross street");
		CommonHelpers.sendKeys(driver, path.getProperty("loc.address2"), "rayapet");
		CommonHelpers.sendKeys(driver, path.getProperty("loc.city"), "chennai");
		PageActions.dropDown(driver, path.getProperty("loc.state"), "AR");
		CommonHelpers.sendKeys(driver, path.getProperty("loc.postal"), "12345");
		CommonHelpers.sendKeys(driver, path.getProperty("loc.phone"), "6567898765");
		CommonHelpers.clickElement(driver, path.getProperty("loc.continue"));
	}
	
	@Test(dependsOnMethods = "enterAddress")
	public void placeOrder() {
		path = PropertyReader.readProperties(FilePaths.LOCATOR_PURCHASE);
		
		CommonHelpers.clickElement(driver, path.getProperty("loc.cod"));
		CommonHelpers.clickElement(driver, path.getProperty("loc.continue"));
		CommonHelpers.clickElement(driver, path.getProperty("loc.placeorder"));
	}
}
