package com.atmecs.automationpractice.pages;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.atmecs.automationpractice.constants.FilePath;
import com.atmecs.automationpractice.dataallocator.LocatorDataAllocator;
import com.atmecs.automationpractice.dataallocator.ValidationDataAllocator;
import com.atmecs.automationpractice.helpers.CommonHelpers;
import com.atmecs.automationpractice.helpers.ValidationHelper;
import com.atmecs.automationpractice.utils.PropertyReader;

public class HomePageFooterPage {
	static Properties loc_properties;
	static Properties val_properties;
	static LocatorDataAllocator loc = new LocatorDataAllocator();
	static ValidationDataAllocator val = new ValidationDataAllocator();
	
	public static void validatePopularProducts(WebDriver driver) throws Exception {
		
		loc_properties = PropertyReader.readProperties(FilePath.HOMEPAGE_FOOTER_FILE);
		val_properties = PropertyReader.readProperties(FilePath.FOOTER_VALID_FILE);
		
		List<WebElement> footer_elements = CommonHelpers.findElements(driver,loc_properties.getProperty("loc_homepage_footer"));
		ValidationHelper.validateText(footer_elements.get(0), val_properties.getProperty("val_special"));
		ValidationHelper.validateText(footer_elements.get(1), val_properties.getProperty("val_newProduct"));
		ValidationHelper.validateText(footer_elements.get(2), val_properties.getProperty("val_bestSeller"));
		ValidationHelper.validateText(footer_elements.get(3), val_properties.getProperty("val_ourStore"));
		ValidationHelper.validateText(footer_elements.get(4), val_properties.getProperty("val_contact"));
		ValidationHelper.validateText(footer_elements.get(5), val_properties.getProperty("val_terms"));
		ValidationHelper.validateText(footer_elements.get(6), val_properties.getProperty("val_about"));
		ValidationHelper.validateText(footer_elements.get(7), val_properties.getProperty("val_site"));
		
		List<WebElement> social_block = CommonHelpers.findElements(driver,loc_properties.getProperty("loc_socialblock"));
		ValidationHelper.validateAttribute(social_block.get(0), "href", val_properties.getProperty("val_facebook"));
		ValidationHelper.validateAttribute(social_block.get(1), "href", val_properties.getProperty("val_twitter"));
		ValidationHelper.validateAttribute(social_block.get(2), "href", val_properties.getProperty("val_youtube"));
		ValidationHelper.validateAttribute(social_block.get(3), "href", val_properties.getProperty("val_google"));
		
		CommonHelpers.SendKeys(driver, CommonHelpers.findElement(driver, loc_properties.getProperty("loc_newsletter")), "demosite@gmail.com");
	}
}