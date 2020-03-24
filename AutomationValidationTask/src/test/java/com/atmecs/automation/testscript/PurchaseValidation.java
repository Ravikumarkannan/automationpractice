package com.atmecs.automation.testscript;

/**
 * @author Ravikumar.Kannan
 * @Test Scenario Id:TS_002
 * @TestCase Id:TC_006,TC_007,TC_009,TC_010,TC_011,TC_012,TC_013,TC_014
 */

import java.util.Properties;
import org.testng.annotations.Test;
import com.atmecs.automation.constants.FilePath;
import com.atmecs.automation.logger.Loggers;
import com.atmecs.automation.pages.PurchasePage;
import com.atmecs.automation.testbase.TestBase;
import com.atmecs.automation.utils.PropertyReader;

/**********Scenario2:Purchase Product Validation**********/

public class PurchaseValidation extends TestBase{

	Loggers log = new Loggers();
	Properties path;
	Properties data;
	
	@Test
	public void validatePurchase() throws Exception {
		
		path = PropertyReader.readProperties(FilePath.PURCHASE_FILE);
		data = PropertyReader.readProperties(FilePath.PURCHASE_VALID_FILE);
		
		log.info("Scenario 2 started..." +"\n");
	
		PurchasePage.viewProduct(driver,path.getProperty("loc_casual"), path.getProperty("loc_product_img"));
		
		PurchasePage.updateProduct(driver, path.getProperty("loc_plusqty"),1, path.getProperty("loc_size_drdn"), "M","no option");
		
		PurchasePage.validateProduct(driver, path.getProperty("loc_addcart_btn"), path.getProperty("loc_qty"), path.getProperty("loc_size_color"), path.getProperty("loc_total"), data.getProperty("val_csl_qty"), data.getProperty("val_csl_size"), data.getProperty("val_csl_total"));
		
		PurchasePage.viewProduct(driver, path.getProperty("loc_evening"), path.getProperty("loc_product_img"));
		
		PurchasePage.updateProduct(driver, path.getProperty("loc_plusqty"), 2,path.getProperty("loc_size_drdn"), "L","pink");
		
		PurchasePage.validateProduct(driver, path.getProperty("loc_addcart_btn"), path.getProperty("loc_qty"), path.getProperty("loc_size_color"), path.getProperty("loc_total"), data.getProperty("val_eve_qty"), data.getProperty("val_eve_size"), data.getProperty("val_eve_total"));
		
		PurchasePage.viewProduct(driver, path.getProperty("loc_summer"), path.getProperty("loc_product_img"));
		
		PurchasePage.updateProduct(driver, path.getProperty("loc_plusqty"),3, path.getProperty("loc_size_drdn"), "L","blue");
		
		PurchasePage.validateProduct(driver, path.getProperty("loc_addcart_btn"), path.getProperty("loc_qty"), path.getProperty("loc_size_color"), path.getProperty("loc_total"), data.getProperty("val_smr_qty"), data.getProperty("val_smr_size"), data.getProperty("val_smr_total"));
		
		log.info("Scenario 2 Completed..." +"\n");
	}
}
