package com.selenium.testng.dependson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DependsOn {

	public static WebDriver driver;
	
	@Test
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/index.html");
		driver.manage().window().maximize();
	}
	
	@Test(dependsOnMethods = "invokeBrowser")
	public void login() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	}
	
	@Test(dependsOnMethods = "login")
	public void buyProduct() {
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
	}
	
}
