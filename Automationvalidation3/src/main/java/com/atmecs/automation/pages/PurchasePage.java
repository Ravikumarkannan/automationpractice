package com.atmecs.automation.pages;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.atmecs.automation.constants.FilePath;
import com.atmecs.automation.helpers.CommonHelpers;
import com.atmecs.automation.helpers.PageAction;
import com.atmecs.automation.helpers.ValidationHelper;
import com.atmecs.automation.helpers.Waits;
import com.atmecs.automation.logger.Loggers;
import com.atmecs.automation.utils.PropertyReader;

public class PurchasePage {

	static Properties loc;
	static Loggers log = new Loggers();
	static String sub_category;

	public static void viewProduct(WebDriver driver, String subcategory, String imgPath) {

		loc = PropertyReader.readProperties(FilePath.PURCHASE_FILE);
		CommonHelpers.mouseMoveOver(driver, loc.getProperty("loc_dresses"));
		Waits.clickable(driver, subcategory);
		CommonHelpers.clickElement(driver, subcategory);
		sub_category = CommonHelpers.findElement(driver, subcategory).getAttribute("title");
		CommonHelpers.clickElement(driver, imgPath);
		log.info(sub_category + " Product viewed");
	}

	public static void updateProduct(WebDriver driver, String quantity, int qty, String sizePath, String sizeText,String colour) throws Exception {

		for (int count = 0; count < qty; count++) {
			CommonHelpers.clickElement(driver, quantity);
		}

		PageAction.dropDown(driver, sizePath, sizeText);

		if (colour.equalsIgnoreCase("blue")) {
			CommonHelpers.clickElement(driver, loc.getProperty("loc_colour_blue"));
		} else if (colour.equalsIgnoreCase("pink")) {
			CommonHelpers.clickElement(driver, loc.getProperty("loc_colour_pink"));
		}
		log.info(sub_category + " Product Updated");
	}

	public static void validateProduct(WebDriver driver, String addToCart, String qty, String size, String totalPrice,String expQty, String expSize, String expTotalPrice) throws Exception {

		CommonHelpers.clickElement(driver, addToCart);
		Waits.explicitWait(driver, qty);
		ValidationHelper.checkText(driver, qty, expQty);
		ValidationHelper.checkText(driver, size, expSize);
		ValidationHelper.checkText(driver, totalPrice, expTotalPrice);
		CommonHelpers.clickElement(driver, loc.getProperty("loc_continue"));
		Thread.sleep(2000);
		log.info(sub_category + " Product Validated");
	}

}
