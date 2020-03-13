package com.atmecs.automationpractice.testscript;

import org.testng.annotations.Test;
import com.atmecs.automationpractice.pages.HomePageBestSellerPage;
import com.atmecs.automationpractice.testbase.TestBase;

public class HomePageBestSellerValidation extends TestBase {
	@Test
	public void validateHomePage() throws Exception {
		HomePageBestSellerPage.validateBestSellerProducts(driver);

	}
}
