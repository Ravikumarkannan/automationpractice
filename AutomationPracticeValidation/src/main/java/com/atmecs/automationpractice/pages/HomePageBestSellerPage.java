package com.atmecs.automationpractice.pages;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.atmecs.automationpractice.constants.FilePath;
import com.atmecs.automationpractice.helpers.CommonHelpers;
import com.atmecs.automationpractice.helpers.ValidationHelper;
import com.atmecs.automationpractice.utils.ExcelReader;
import com.atmecs.automationpractice.utils.PropertyReader;

public class HomePageBestSellerPage {
	
	static Properties loc_properties;
	static Properties val_properties;	
	
	public static void validateBestSellerProducts(WebDriver driver) throws Exception {
		
		loc_properties = PropertyReader.readProperties(FilePath.HOMEPAGE_BESTSELLER_FILE);
		val_properties = PropertyReader.readProperties(FilePath.BESTSELLER_VALID_FILE);
		
		CommonHelpers.clickElement(driver, CommonHelpers.findElement(driver, loc_properties.getProperty("loc_btn_bestseller")));
		
		List<WebElement> product_image = CommonHelpers.findElements(driver, loc_properties.getProperty("loc_best_img"));
		List<WebElement> product_price = CommonHelpers.findElements(driver,loc_properties.getProperty("loc_best_price"));
		List<WebElement> product_name = CommonHelpers.findElements(driver,loc_properties.getProperty("loc_best_name"));
		
		for (int imageCount = 0; imageCount < product_image.size(); imageCount++) {
			ValidationHelper.CheckImage(driver, product_image.get(imageCount));
		}
		
//		for(int price_count = 0; price_count<product_price.size(); price_count++) {
//			System.out.println("Price"+product_price.get(price_count).getText());
//			System.out.println("Title"+product_name.get(price_count).getText());
//			String data=ExcelReader.readData(FilePath.BESTSELLER_VALID_FILE, "Sheet1", price_count, price_count);
//			System.out.println("excel"+data);
//		}
	}
}
