package com.selenium.demosite.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.demosite.helpers.CommonHelpers;
import com.atmecs.demosite.testbase.TestBase;
import com.atmecs.demosite.utils.ExcelDataReader;

public class DataProviderTest extends TestBase{

	@Test(dataProvider = "userData")
	public void login(String userEmail) {
		CommonHelpers.sendKeys(driver, "//input[@id='email']", userEmail);
	}
	
	@DataProvider(name = "userData")
	public Object[][] userFormData() throws Exception
    {
        Object[][] data = ExcelDataReader.testData("./src/main/resources/useremail.xlsx", "sheet1");
        return data;
    }
	
}
