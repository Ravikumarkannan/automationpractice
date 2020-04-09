package com.atmecs.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.orangehrm.helper.CommonHelper;
import com.atmecs.orangehrm.helper.Waits;

public class WebTablePage {

	public static void login(WebDriver driver,String xpath_userName,String xpath_password,String data_userName,String data_password,String login) {
		CommonHelper.sendKeys(driver, xpath_userName, data_userName);
		CommonHelper.sendKeys(driver, xpath_password, data_password);
		CommonHelper.clickElement(driver, login);
	}
	
	public static void navigateToJobTitles(WebDriver driver,String admin,String job,String jobTitles) {
		CommonHelper.clickElement(driver, admin);
		CommonHelper.mouseMoveOver(driver, job);
		Waits.clickable(driver, jobTitles);
		CommonHelper.clickElement(driver, jobTitles);
	}
	
	public static void getTable(WebDriver driver,String title,String body) {
		List <WebElement> list = CommonHelper.findElements(driver, title);
		List <WebElement> list_body = CommonHelper.findElements(driver, body);
		
		for(int count=0; count<list.size(); count++) {
			System.out.println(list.get(count).getText());
		}
		
		for(int count=0; count<list_body.size(); count++) {
			System.out.println(list_body.get(count).getText());
		}
	}
	
	public static void deleteJobTitle(WebDriver driver,String checkBox,String delete) {
		CommonHelper.clickElement(driver, checkBox);
		CommonHelper.clickElement(driver, delete);
		driver.switchTo().alert().accept();
	}
}
