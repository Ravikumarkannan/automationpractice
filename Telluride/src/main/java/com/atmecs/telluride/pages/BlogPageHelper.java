package com.atmecs.telluride.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.telluride.constants.FilePath;
import com.atmecs.telluride.helpers.CommonHelpers;
import com.atmecs.telluride.helpers.PageActionHelper;
import com.atmecs.telluride.helpers.ValidationHelper;
import com.atmecs.telluride.helpers.Waits;
import com.atmecs.telluride.utils.PropertyReader;

public class BlogPageHelper {

	Properties path;
	
	public void getBlogPage(WebDriver driver) {
		
		path = PropertyReader.readProperties(FilePath.BLOG_PAGE);
		
		PageActionHelper.scrollDown(driver, path.getProperty("loc.blogLink"));
		
		CommonHelpers.clickElement(driver, path.getProperty("loc.blogLink"));
	}
	
	public void validateDropDown(WebDriver driver) {
		
		path = PropertyReader.readProperties(FilePath.BLOG_PAGE);
		
		List<WebElement> options = CommonHelpers.findElements(driver, path.getProperty("loc.dropdown"));
		
		for(int count=0; count<options.size(); count++) {
			
			System.out.println("Dropdown options"+options.get(count).getText());
		}
	}
	
	
	public void validateImages(WebDriver driver) throws Exception {
		
		path = PropertyReader.readProperties(FilePath.BLOG_PAGE);
		
		Waits.waitByElementClickable(driver, path.getProperty("loc.blogImages"));
		
		List<WebElement> img_list = CommonHelpers.findElements(driver, path.getProperty("loc.blogImages"));
		
		for(int imgCount=0; imgCount<img_list.size(); imgCount++) {
			ValidationHelper.CheckImage(driver, img_list.get(imgCount));
		}
	}
	
	public void ValidateBlogLinks(WebDriver driver) {
		
		path = PropertyReader.readProperties(FilePath.BLOG_PAGE);
		
		List<WebElement> link_list = CommonHelpers.findElements(driver, path.getProperty("loc.footerLinks"));
		
		for(int linkCount=0; linkCount<link_list.size(); linkCount++) {
			
			System.out.println(link_list.get(linkCount).getAttribute("href"));
		}
	}
}
