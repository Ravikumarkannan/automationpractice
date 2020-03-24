package com.atmecs.automation.testscript;

/**
 * @author Ravikumar.Kannan
 * @Test ScenarioId:TS_001
 * @Test CaseId:TC001,TC002,TC003,TC004,TC005
 */

import java.util.Properties;
import org.testng.annotations.Test;
import com.atmecs.automation.constants.FilePath;
import com.atmecs.automation.logger.Loggers;
import com.atmecs.automation.pages.CategoryFilterPage;
import com.atmecs.automation.testbase.TestBase;
import com.atmecs.automation.utils.PropertyReader;

/**********Scenario1:SubCategory Products Validation**********/

public class ProductCategoryValidation extends TestBase {

	Loggers log = new Loggers();
	Properties path;
	Properties data;

	@Test
	public void validateTshirts() throws Exception {
		
		path = PropertyReader.readProperties(FilePath.FILTER_CATEGORY_FILE);
		data = PropertyReader.readProperties(FilePath.CATEGORY_VALID_FILE);
		
		log.info("Scenario 1 started..." +"\n");
		
		CategoryFilterPage.validateByCategory(driver, path.getProperty("loc_tshirt"), path.getProperty("loc_product_img"),path.getProperty("loc_product_price"), path.getProperty("loc_product_name"),data.getProperty("val_tshirt_price"), data.getProperty("val_tshirt_name"));
		
		CategoryFilterPage.validateByCategory(driver, path.getProperty("loc_blouse"), path.getProperty("loc_product_img"),path.getProperty("loc_product_price"), path.getProperty("loc_product_name"),data.getProperty("val_blouse_price"), data.getProperty("val_blouse_name"));
		
		CategoryFilterPage.validateByCategory(driver, path.getProperty("loc_casualDress"), path.getProperty("loc_product_img"),path.getProperty("loc_product_price"), path.getProperty("loc_product_name"),data.getProperty("val_casual_price"), data.getProperty("val_casual_name"));
		
		CategoryFilterPage.validateByCategory(driver, path.getProperty("loc_eveningDress"), path.getProperty("loc_product_img"),path.getProperty("loc_product_price"), path.getProperty("loc_product_name"),data.getProperty("val_evening_price"), data.getProperty("val_evening_name"));
		
		CategoryFilterPage.validateByCategory(driver, path.getProperty("loc_summerDress"), path.getProperty("loc_product_img"),path.getProperty("loc_product_price"), path.getProperty("loc_product_name"),data.getProperty("val_summer_price1"), data.getProperty("val_summer_name1"));
		
		CategoryFilterPage.validateByCategory(driver, path.getProperty("loc_summerDress"), path.getProperty("loc_summer_img2"),path.getProperty("loc_summer_price2"), path.getProperty("loc_summer_name2"),data.getProperty("val_summer_price2"), data.getProperty("val_summer_name2"));
		
		CategoryFilterPage.validateByCategory(driver, path.getProperty("loc_summerDress"), path.getProperty("loc_summer_img3"),path.getProperty("loc_summer_price3"), path.getProperty("loc_summer_name3"),data.getProperty("val_summer_price3"), data.getProperty("val_summer_name3"));
		
		log.info("Scenario 1 completed..." +"\n");
	}
}
