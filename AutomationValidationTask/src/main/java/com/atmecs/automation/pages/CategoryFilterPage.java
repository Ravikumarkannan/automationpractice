package com.atmecs.automation.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.atmecs.automation.constants.FilePath;
import com.atmecs.automation.helpers.CommonHelpers;
import com.atmecs.automation.helpers.ValidationHelper;
import com.atmecs.automation.logger.Loggers;
import com.atmecs.automation.utils.PropertyReader;

public class CategoryFilterPage {

	static Loggers log = new Loggers();
	static Properties path;
	public static void validateByCategory(WebDriver driver, String Subcategory, String pathImg, String pathPrice,String pathName, String valPrice, String valName) throws Exception {
		path = PropertyReader.readProperties(FilePath.FILTER_CATEGORY_FILE);
		
		CommonHelpers.mouseMoveOver(driver, path.getProperty("loc_women"));
		CommonHelpers.clickElement(driver, Subcategory);
		ValidationHelper.CheckImage(driver, pathImg);
		ValidationHelper.checkText(driver, pathPrice, valPrice);
		ValidationHelper.checkText(driver, pathName, valName);
		
		log.info(CommonHelpers.findElement(driver, Subcategory).getAttribute("title")  + " Product is Validated");
	}
}

