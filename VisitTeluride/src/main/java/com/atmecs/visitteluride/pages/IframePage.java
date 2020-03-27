package com.atmecs.visitteluride.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import com.atmecs.visitteluride.helpers.CommonHelpers;
import com.atmecs.visitteluride.helpers.Waits;

public class IframePage {

	public static void iframe1Validation(WebDriver driver,String email,String country,String emailData,String CountryData,String submit) throws Exception {
		CommonHelpers.sendKeys(driver, email, emailData);
		CommonHelpers.dropDown(driver, country, CountryData);
		CommonHelpers.click(driver, submit);
	}
	
	public static void iframe2Validation(WebDriver driver,String name,String email,String phone,String nameData,String emailData,String phoneData,String submit){
		
		Waits.waitByElementClickable(driver, name);
		CommonHelpers.sendKeys(driver, name, nameData);
		CommonHelpers.sendKeys(driver, email, emailData);
		CommonHelpers.sendKeys(driver, phone, phoneData);
		CommonHelpers.click(driver, submit);
	}
	
	public static void keyboardEvents() throws Exception {
		Robot key = new Robot();
		
		key.keyPress(KeyEvent.VK_A);
		key.keyRelease(KeyEvent.VK_A);
		key.keyPress(KeyEvent.VK_B);
		key.keyRelease(KeyEvent.VK_B);
		key.keyPress(KeyEvent.VK_C);
		key.keyRelease(KeyEvent.VK_C);
		key.keyPress(KeyEvent.VK_SHIFT);
		key.keyPress(KeyEvent.VK_2);
		key.keyRelease(KeyEvent.VK_SHIFT);
		key.keyRelease(KeyEvent.VK_2);
		
	}
}
