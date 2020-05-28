package com.atmecs.ninjakart.homepage;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.ninjakart.constants.Filepath;
import com.atmecs.ninjakart.helpers.CommonHelpers;
import com.atmecs.ninjakart.testbase.TestBase2;
import com.atmecs.ninjakart.utils.PropertyReader;

public class ProductValidation extends TestBase2{

	Properties path;
	@Test
	public void valiateProduct() {
		path = PropertyReader.readProperties(Filepath.LOCATOR_HOMEPAGE);
		
		CommonHelpers.clickElement(driver, path.getProperty("loc.phone"));
		
		List<WebElement> titles = CommonHelpers.findElements(driver, path.getProperty("loc.titles"));
		
		Assert.assertEquals(titles.get(0).getText(), "HTC Touch HD");
		Assert.assertEquals(titles.get(1).getText(), "iPhone");
		Assert.assertEquals(titles.get(2).getText(), "Palm Treo Pro");
	}
	
}
