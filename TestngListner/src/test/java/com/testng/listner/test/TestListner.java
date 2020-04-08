package com.testng.listner.test;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.testng.listner.helper.ITestListnerHelper;
import com.testng.listner.testbase.TestBase;
@Listeners(ITestListnerHelper.class)
public class TestListner extends TestBase {

	@Test
	public void login() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	}
	
	@Test
	public void logout() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	@Test
	public void purchase() {
		driver.findElement(By.xpath("//button[text()='ADD TO CART]")).click();
	}
	
}
