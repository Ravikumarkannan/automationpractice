package com.atmecs.konakart.pages;

import org.openqa.selenium.WebDriver;
import com.atmecs.konakart.constants.LocatorTypes;
import com.atmecs.konakart.dataallocators.LocatorDataAllocator;
import com.atmecs.konakart.helpers.CommonHelpers;
import com.atmecs.konakart.helpers.PageActionsHelper;
import com.atmecs.konakart.helpers.ProductDataGetter;
import com.atmecs.konakart.helpers.ValidationHelper;

public class HomePageHelper {
	static LocatorDataAllocator loc = new LocatorDataAllocator();
	public static String selectValue;

	public static void searchProduct(WebDriver driver, String category, String product,String titleExp,String priceExp) throws Exception {
		loc.getHomepageData();

		switch (category) {
		case "Computer":
			selectValue = CommonHelpers.findElements(driver, loc.getdropDownList()).get(1).getAttribute("value");
			PageActionsHelper.dropDown(driver, LocatorTypes.ID, loc.getDropDownMainMenu(), selectValue, "value");
			break;
		case "Games":
			selectValue = CommonHelpers.findElements(driver, loc.getdropDownList()).get(2).getAttribute("value");
			PageActionsHelper.dropDown(driver, LocatorTypes.ID, loc.getDropDownMainMenu(), selectValue, "value");
			break;
		case "DVD":
			selectValue = CommonHelpers.findElements(driver, loc.getdropDownList()).get(3).getAttribute("value");
			PageActionsHelper.dropDown(driver, LocatorTypes.ID, loc.getDropDownMainMenu(), selectValue, "value");
			break;
		case "Software":
			selectValue = CommonHelpers.findElements(driver, loc.getdropDownList()).get(4).getAttribute("value");
			PageActionsHelper.dropDown(driver, LocatorTypes.ID, loc.getDropDownMainMenu(), selectValue, "value");
			break;
		case "Electronics":
			selectValue = CommonHelpers.findElements(driver, loc.getdropDownList()).get(5).getAttribute("value");
			PageActionsHelper.dropDown(driver, LocatorTypes.ID, loc.getDropDownMainMenu(), selectValue, "value");
			break;
		case "Home":
			selectValue = CommonHelpers.findElements(driver, loc.getdropDownList()).get(6).getAttribute("value");
			PageActionsHelper.dropDown(driver, LocatorTypes.ID, loc.getDropDownMainMenu(), selectValue, "value");
			break;
		case "Gifts":
			selectValue = CommonHelpers.findElements(driver, loc.getdropDownList()).get(7).getAttribute("value");
			PageActionsHelper.dropDown(driver, LocatorTypes.ID, loc.getDropDownMainMenu(), selectValue, "value");
			break;
		}
		CommonHelpers.sendKeys(driver, CommonHelpers.findElement(driver, LocatorTypes.ID, loc.getSearchBox()), product);
		CommonHelpers.clickElement(driver, CommonHelpers.findElement(driver, LocatorTypes.ID, loc.getSearchButton()));
		ValidationHelper.imageValidation(ProductDataGetter.getImageStatus(driver, LocatorTypes.XPATH, loc.getProductImage()));
		ValidationHelper.textValidation(ProductDataGetter.getAttribute(driver, LocatorTypes.XPATH, loc.getProductTitle()), titleExp);
		ValidationHelper.textValidation(ProductDataGetter.getAttribute(driver, LocatorTypes.XPATH, loc.getProductPrice()), priceExp);
		System.err.println("\n");
	}
}