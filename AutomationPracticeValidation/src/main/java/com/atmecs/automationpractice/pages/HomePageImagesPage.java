package com.atmecs.automationpractice.pages;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.atmecs.automationpractice.constants.FilePath;
import com.atmecs.automationpractice.helpers.CommonHelpers;
import com.atmecs.automationpractice.helpers.ValidationHelper;
import com.atmecs.automationpractice.utils.PropertyReader;

public class HomePageImagesPage {

	static Properties loc_properties;
	static Properties val_properties;	
	public static void validateHomePageImages(WebDriver driver) throws Exception {
		
		loc_properties = PropertyReader.readProperties(FilePath.HOMEPAGE_IMAGE_FILE);

		ValidationHelper.CheckImage(driver, CommonHelpers.findElement(driver, loc_properties.getProperty("loc_img_logo"))); //logo validation

		List<WebElement> image_module = CommonHelpers.findElements(driver, loc_properties.getProperty("loc_img_module"));  //module set1 image validation
		for (int imageCount = 1; imageCount < image_module.size() - 1; imageCount++) {
			ValidationHelper.CheckImage(driver, image_module.get(imageCount));
		}
		ValidationHelper.CheckImage(driver,CommonHelpers.findElement(driver, loc_properties.getProperty("loc_img_module1")));
		ValidationHelper.CheckImage(driver,CommonHelpers.findElement(driver, loc_properties.getProperty("loc_img_module2")));

		List<WebElement> image_product = CommonHelpers.findElements(driver, loc_properties.getProperty("loc_img_dress"));  //All product image valiation
		for (int imageCount = 0; imageCount < image_product.size(); imageCount++) {
			ValidationHelper.CheckImage(driver, image_product.get(imageCount));
		}

		List<WebElement> image_module2 = CommonHelpers.findElements(driver,loc_properties.getProperty("loc_img_module_foot")); //module set2 image validation
		for (int imageCount = 0; imageCount < image_module2.size(); imageCount++) {
			ValidationHelper.CheckImage(driver, image_module2.get(imageCount));
		}
	}
}
