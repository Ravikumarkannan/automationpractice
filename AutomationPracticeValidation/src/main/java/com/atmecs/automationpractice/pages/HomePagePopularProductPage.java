package com.atmecs.automationpractice.pages;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.atmecs.automationpractice.constants.FilePath;
import com.atmecs.automationpractice.dataallocator.LocatorDataAllocator;
import com.atmecs.automationpractice.dataallocator.ValidationDataAllocator;
import com.atmecs.automationpractice.helpers.CommonHelpers;
import com.atmecs.automationpractice.helpers.ValidationHelper;
import com.atmecs.automationpractice.utils.PropertyReader;

public class HomePagePopularProductPage {

	static Properties loc_properties;
	static Properties val_properties;
	static LocatorDataAllocator loc = new LocatorDataAllocator();
	static ValidationDataAllocator val = new ValidationDataAllocator();
	
	public static void validatePopularProducts(WebDriver driver) throws Exception {
		
		loc_properties = PropertyReader.readProperties(FilePath.HOMEPAGE_POPULAR_FILE);
		val_properties = PropertyReader.readProperties(FilePath.VALID_FILE);
		
		float float_price;
		float total_price=0;
		float val_totalPrice =196.37999f;
		
		List<WebElement> product_price = CommonHelpers.findElements(driver,loc_properties.getProperty("loc_price_product"));
		ValidationHelper.validateText(product_price.get(0), val_properties.getProperty("val_price_product1"));
		ValidationHelper.validateText(product_price.get(1), val_properties.getProperty("val_price_product2"));
		ValidationHelper.validateText(product_price.get(2), val_properties.getProperty("val_price_product3"));
		ValidationHelper.validateText(product_price.get(3), val_properties.getProperty("val_price_product4"));
		ValidationHelper.validateText(product_price.get(4), val_properties.getProperty("val_price_product5"));
		ValidationHelper.validateText(product_price.get(5), val_properties.getProperty("val_price_product6"));
		ValidationHelper.validateText(product_price.get(6), val_properties.getProperty("val_price_product7"));
		
		for (int priceCount = 0; priceCount < product_price.size(); priceCount++) {
			String price=product_price.get(priceCount).getText().replace("$", "");
			float_price = Float.valueOf(price);
			total_price = total_price+float_price;
		}		
		Assert.assertEquals(total_price, val_totalPrice);
		System.out.println("total price:"+total_price);
		}
}
