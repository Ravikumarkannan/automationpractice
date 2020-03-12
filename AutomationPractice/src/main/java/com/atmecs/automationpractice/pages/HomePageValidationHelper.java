package com.atmecs.automationpractice.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.automationpractice.dataallocator.LocatorDataAllocator;
import com.atmecs.automationpractice.dataallocator.ValidationDataAllocator;
import com.atmecs.automationpractice.helpers.CommonHelpers;
import com.atmecs.automationpractice.helpers.PageActionHelper;
import com.atmecs.automationpractice.helpers.ValidationHelper;

public class HomePageValidationHelper {
	static LocatorDataAllocator loc = new LocatorDataAllocator();
	static ValidationDataAllocator val = new ValidationDataAllocator();

	public static void validateHomePage(WebDriver driver) throws Exception {
		loc.getLocatorData();
		val.getValidationData();

		ValidationHelper.CheckImage(driver,  loc.logo);
		CommonHelpers.mouseMoveOver(driver, loc.women);
		ValidationHelper.validateText(CommonHelpers.findElement(driver, loc.women), val.women);

		ValidationHelper.validateText(CommonHelpers.findElement(driver, loc.tops), val.tops);
		ValidationHelper.validateText(CommonHelpers.findElement(driver, loc.tshirt), val.tshirt);
		ValidationHelper.validateText(CommonHelpers.findElement(driver, loc.blouse), val.blouse);

		ValidationHelper.validateText(CommonHelpers.findElement(driver, loc.women_casual_dress),val.women_casual_dress);
		ValidationHelper.validateText(CommonHelpers.findElement(driver, loc.women_evening_dress),val.women_evening_dress);
		ValidationHelper.validateText(CommonHelpers.findElement(driver, loc.women_summer_dress),val.women_summer_dress);

		CommonHelpers.mouseMoveOver(driver, loc.dresses);
		ValidationHelper.validateText(CommonHelpers.findElement(driver, loc.dresses), val.dresses);
		ValidationHelper.validateText(CommonHelpers.findElement(driver, loc.casual_dress), val.casual_dress);
		ValidationHelper.validateText(CommonHelpers.findElement(driver, loc.evening_dress), val.evening_dress);

		ValidationHelper.validateText(CommonHelpers.findElement(driver, loc.summer_dress), val.summer_dress);
		ValidationHelper.validateText(CommonHelpers.findElement(driver, loc.tshirt_menu), val.tshirt_menu);

		List<WebElement> image_list = CommonHelpers.findElements(driver, loc.image_dress);
		for (int imageCount = 0; imageCount < image_list.size(); imageCount++) {
			ValidationHelper.validateImage(image_list.get(imageCount));
		}

		CommonHelpers.clickElement(driver, CommonHelpers.findElement(driver, loc.bestSeller));
		ValidationHelper.validateButton(CommonHelpers.findElement(driver, loc.bestSeller));

		CommonHelpers.SendKeys(driver, CommonHelpers.findElement(driver, loc.search_box), "Dress");
		CommonHelpers.clickElement(driver, CommonHelpers.findElement(driver, loc.search_button));
		ValidationHelper.validateAttribute(driver, loc.search_box, "value", val.SearchText);
		
		PageActionHelper.dropDown(driver, loc.filter_mainmenu, "Price: Lowest first", "select");
		ValidationHelper.validateText(CommonHelpers.findElement(driver, loc.selected_option), "Price: Lowest first");
	}
}
