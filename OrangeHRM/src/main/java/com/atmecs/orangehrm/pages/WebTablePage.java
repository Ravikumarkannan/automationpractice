package com.atmecs.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
	
	public static void validateTable(WebDriver driver,String title,String body) {
		List <WebElement> list = CommonHelper.findElements(driver, title);
		List <WebElement> list_body = CommonHelper.findElements(driver, body);
		
		Assert.assertEquals(list.get(1).getText(), "Job Title");
		Assert.assertEquals(list.get(2).getText(), "Job Description");
		
		Assert.assertEquals(list_body.get(0).getText(), "AssistantManager");
		Assert.assertEquals(list_body.get(1).getText(), "CEO");
		Assert.assertEquals(list_body.get(2).getText(), "Finance Manager");
		Assert.assertEquals(list_body.get(3).getText(), "HR Executive");
		Assert.assertEquals(list_body.get(4).getText(), "HR Manager");
		Assert.assertEquals(list_body.get(5).getText(), "IT Executive");
		Assert.assertEquals(list_body.get(6).getText(), "Manger");
		Assert.assertEquals(list_body.get(6).getText(), "Mgr");
		Assert.assertEquals(list_body.get(6).getText(), "Sales Executivems");
		
	}
	
	public static void deleteJobTitle(WebDriver driver,String checkBox,String delete,String deleteBox) {
		CommonHelper.clickElement(driver, checkBox);
		CommonHelper.clickElement(driver, delete);
		Waits.clickable(driver, deleteBox);
		CommonHelper.clickElement(driver, deleteBox);
	}
	
	public static void addJobTitle(WebDriver driver,String addBtn,String jobTitle,String title,String saveBtn) {
		CommonHelper.clickElement(driver, addBtn);
		Waits.explicitWait(driver, jobTitle);
		CommonHelper.sendKeys(driver, jobTitle, title);
		CommonHelper.clickElement(driver, saveBtn);
	}
}
