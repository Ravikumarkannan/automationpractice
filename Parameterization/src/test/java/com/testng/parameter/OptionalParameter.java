package com.testng.parameter;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.selenium.testng.base.TestBase;

public class OptionalParameter extends TestBase{

	@Test
	public void validateCredentials(@Optional("standard_user") String userName) {
		
		driver.findElement(By.id("user-name")).sendKeys(userName);
		String act_userName = driver.findElement(By.id("user-name")).getAttribute("value");
		
		Assert.assertEquals(userName, act_userName);
	}
}
