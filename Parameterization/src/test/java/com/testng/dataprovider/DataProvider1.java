package com.testng.dataprovider;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.testng.base.TestBase;

public class DataProvider1 extends TestBase {

	@Test(dataProvider = "provideCredentials")
	public void test(String userName, String password) {

		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		
		String act_userName = driver.findElement(By.id("user-name")).getAttribute("value");
		String act_password = driver.findElement(By.id("password")).getAttribute("value");

		Assert.assertEquals(userName, act_userName);
		Assert.assertEquals(password, act_password);
	}

	@DataProvider(name = "provideCredentials")
	public Object[][] provideData() {

		return new Object[][] { { "standard_user", "secret_sauce" }, };
	}
}
