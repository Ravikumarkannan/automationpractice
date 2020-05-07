package com.atmecs.practo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.practo.Helpers.CommonHelpers;

public class PhoneProductPage {

	public static void validateProducts(WebDriver driver,String phone,String img,String tilte) {
		CommonHelpers.clickElement(driver, phone);
		
		List<WebElement> images = CommonHelpers.findElements(driver, img);
		List<WebElement> titles = CommonHelpers.findElements(driver, tilte);
		for(int i=0; i<images.size(); i++) {
			images.get(i).isDisplayed();
			System.out.println(images.get(i).getAttribute("src")+ " is present");
			
			System.out.println(titles.get(i).getText());
		}
		
		
	}
}
