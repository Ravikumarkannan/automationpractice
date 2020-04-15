package com.atmecs.saucedemo.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.saucedemo.constants.FilePath;
import com.atmecs.saucedemo.helpers.CommonHelpers;
import com.atmecs.saucedemo.helpers.TestngListener;
import com.atmecs.saucedemo.pages.HomePage;
import com.atmecs.saucedemo.testbase.TestBase;
import com.atmecs.saucedemo.utils.CsvReader;
import com.atmecs.saucedemo.utils.PropertyReader;

@Listeners(TestngListener.class)
public class HomePageValidation extends TestBase {

	Properties path;
	Properties data;

	@Parameters({ "userName", "password" })
	@Test(priority = 1)
	public void login(String userName, String password) {

		path = PropertyReader.readProperties(FilePath.LOCATOR_HOMEPAGE);
		HomePage.login(driver, path.getProperty("loc_username"), path.getProperty("loc_password"), userName, password,path.getProperty("loc_login"));
	}

	@Test(priority = 2)
	public void validateHomePage() throws FileNotFoundException, IOException {

		String[] data = CsvReader.readCsvFile(FilePath.VALID_HOMEPAGE);
		List<WebElement> prices = CommonHelpers.findElements(driver, path.getProperty("loc_product_price"));
		System.out.println("data" + data.length);
		for(int i=0; i<data.length; i++) {
			Assert.assertEquals(prices.get(i).getText(), data[i]);
			System.out.println(data[i]+"present");
		}
	}
	
	@Test(priority = 3)
	public void navigateToCart() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File("./screenshots/newts.png"));
		System.out.println("screenshot taken");
	}
}
