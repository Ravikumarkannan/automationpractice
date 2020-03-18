package com.atmecs.automation.pages;

import org.openqa.selenium.WebDriver;
import com.atmecs.automation.helpers.ValidationHelper;

public class FilterCategoryPage {
	
	public static void filterByCategory(WebDriver driver,String pathImg,String pathPrice,String pathName,String valPrice,String valName ) throws Exception {
		
		ValidationHelper.CheckImage(driver, pathImg);
		ValidationHelper.checkText(driver, pathPrice,valPrice);
		ValidationHelper.checkText(driver, pathName,valName);
	}
}
