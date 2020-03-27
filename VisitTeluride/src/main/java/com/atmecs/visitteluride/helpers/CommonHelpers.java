package com.atmecs.visitteluride.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonHelpers {

	public static void click(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void sendKeys(WebDriver driver, String xpath, String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	public static void mouseMoveOver(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void scrollDown(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void dropDown(WebDriver driver, String mainMenu, String subMenu) throws Exception {
		WebElement element = driver.findElement(By.xpath(mainMenu));
		Select select = new Select(element);
		select.selectByVisibleText(subMenu);
	}
	
	public static WebDriver switchToFrame(WebDriver driver,String path) {
		WebDriver iframe = driver.switchTo().frame(driver.findElement(By.xpath(path)));
		return iframe;
	}
}
