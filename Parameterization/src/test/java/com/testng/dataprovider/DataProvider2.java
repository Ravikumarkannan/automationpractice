package com.testng.dataprovider;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.testng.base.TestBase;

public class DataProvider2 extends TestBase{

	@Test(dataProvider = "provideCredentials",dataProviderClass = InvokeClass.class)
	public void test(String userName, String password) throws Exception {

		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		
		String act_userName = driver.findElement(By.id("user-name")).getAttribute("value");
		String act_password = driver.findElement(By.id("password")).getAttribute("value");

		Assert.assertEquals(userName, act_userName);
		Assert.assertEquals(password, act_password);
		
		driver.findElement(By.id("user-name")).clear();
		driver.findElement(By.id("password")).clear();
		Thread.sleep(2000);
	}

}
