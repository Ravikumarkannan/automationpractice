package com.atmecs.automation.testscript;

import java.util.Properties;
import org.testng.annotations.Test;
import com.atmecs.automation.constants.FilePath;
import com.atmecs.automation.helpers.CommonHelpers;
import com.atmecs.automation.logger.Loggers;
import com.atmecs.automation.pages.FilterCategoryPage;
import com.atmecs.automation.propertyreader.PropertyReader;
import com.atmecs.automation.testbase.TestBase;

public class ProductCategoryValidation extends TestBase {
	
	static Loggers log = new Loggers();
	static Properties loc;
	static Properties val;
	
	@Test
	public void validateTshirt() throws Exception {
		
		loc = PropertyReader.readProperties(FilePath.FILTER_CATEGORY_FILE);
		val = PropertyReader.readProperties(FilePath.VALID_FILE);
		
		log.info("Scenario1 started....");
		
		CommonHelpers.mouseMoveOver(driver, loc.getProperty("loc_women"));
		CommonHelpers.clickElement(driver, loc.getProperty("loc_tshirt"));
		FilterCategoryPage.filterByCategory(driver, loc.getProperty("loc_product_img"), loc.getProperty("loc_product_price"), loc.getProperty("loc_product_name"), val.getProperty("val_tshirt_price"), val.getProperty("val_tshirt_name"));
		
		CommonHelpers.mouseMoveOver(driver, loc.getProperty("loc_women"));
		CommonHelpers.clickElement(driver, loc.getProperty("loc_blouse"));
		FilterCategoryPage.filterByCategory(driver, loc.getProperty("loc_product_img"), loc.getProperty("loc_product_price"), loc.getProperty("loc_product_name"), val.getProperty("val_blouse_price"), val.getProperty("val_blouse_name"));
		
		CommonHelpers.mouseMoveOver(driver, loc.getProperty("loc_women"));
		CommonHelpers.clickElement(driver, loc.getProperty("loc_casualDress"));
		FilterCategoryPage.filterByCategory(driver, loc.getProperty("loc_product_img"), loc.getProperty("loc_product_price"), loc.getProperty("loc_product_name"), val.getProperty("val_casual_price"), val.getProperty("val_casual_name"));
	
		CommonHelpers.mouseMoveOver(driver, loc.getProperty("loc_women"));
		CommonHelpers.clickElement(driver, loc.getProperty("//a[@title='Evening Dresses']"));
		FilterCategoryPage.filterByCategory(driver, loc.getProperty("loc_product_img"), loc.getProperty("loc_product_price"), loc.getProperty("loc_product_name"), val.getProperty("val_evening_price"), val.getProperty("val_evening_name"));
		
		CommonHelpers.mouseMoveOver(driver, loc.getProperty("loc_women"));
		CommonHelpers.clickElement(driver, loc.getProperty("//a[@title='Summer Dresses']"));
		FilterCategoryPage.filterByCategory(driver, loc.getProperty("loc_product_img1"), loc.getProperty("loc_product_price1"), loc.getProperty("loc_product_name1"), val.getProperty("val_summer_price1"), val.getProperty("val_summer_name1"));
		
		CommonHelpers.mouseMoveOver(driver, loc.getProperty("loc_women"));
		CommonHelpers.clickElement(driver, loc.getProperty("//a[@title='Summer Dresses']"));
		FilterCategoryPage.filterByCategory(driver, loc.getProperty("loc_product_img2"), loc.getProperty("loc_product_price2"), loc.getProperty("loc_product_name2"), val.getProperty("val_summer_price2"), val.getProperty("val_summer_name2"));
	}	
}
