package com.atmes.practo.test;

import java.util.Properties;

import org.testng.annotations.Test;

import com.atmecs.practo.constants.FilePath;
import com.atmecs.practo.pages.PhoneProductPage;
import com.atmecs.practo.testbase.TestBase;
import com.atmecs.practo.utils.PropertyReader;

public class ProductValidation extends TestBase{

	@Test
	public void validateProducts() {
		
		Properties path = PropertyReader.readProperty(FilePath.LOCATOR_FILE);
		
		PhoneProductPage.validateProducts(driver, path.getProperty("phone"), path.getProperty("phone_img"), path.getProperty("phone_title"));
	}
}
