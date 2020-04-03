package com.testng.parameter;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.testng.base.TestBase;


public class ParameterTest extends TestBase{
	
	@Test
	@Parameters({"userName","password"})
	public void validateCredentials(String userName,String password) {
		
		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		String act_userName = driver.findElement(By.id("user-name")).getAttribute("value");
		String act_password = driver.findElement(By.id("password")).getAttribute("value");
		
		Assert.assertEquals(userName, act_userName);
		Assert.assertEquals(password, act_password);
	}
		
}
