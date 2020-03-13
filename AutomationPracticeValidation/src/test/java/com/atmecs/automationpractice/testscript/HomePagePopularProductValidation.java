package com.atmecs.automationpractice.testscript;

import org.testng.annotations.Test;
import com.atmecs.automationpractice.pages.HomePagePopularProductPage;
import com.atmecs.automationpractice.testbase.TestBase;

public class HomePagePopularProductValidation extends TestBase{

	@Test
	public void validateHomePage() throws Exception {
		HomePagePopularProductPage.validatePopularProducts(driver);
		
	}
}
