package com.atmecs.practo.pages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.atmecs.practo.Helpers.CommonHelpers;

public class LoginPage {

	public static void navigateToLogin(WebDriver driver, String dropdown, String login) {
		CommonHelpers.clickElement(driver, dropdown);
		CommonHelpers.clickElement(driver, login);
	}

	public static void login(WebDriver driver, String userEmail, String Password, String dataUserEmail,
			String dataPassword, String login) {

		CommonHelpers.sendKeys(driver, userEmail, dataUserEmail);
		CommonHelpers.sendKeys(driver, Password, dataPassword);
		CommonHelpers.clickElement(driver, login);
	}
	
	public static void getCookies(WebDriver driver) throws IOException{
		
		File file = new File("cookies.data");
		
		FileWriter writter = new FileWriter(file);
		@SuppressWarnings("resource")
		BufferedWriter bwritter = new BufferedWriter(writter);
		for(Cookie ck: driver.manage().getCookies()) {
			System.out.println((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
			bwritter.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
		}
		
		bwritter.close();
		writter.close();
	}
	
	public static void deleteCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}
	
	public static void addCookies(WebDriver driver) {
		
	}
}
