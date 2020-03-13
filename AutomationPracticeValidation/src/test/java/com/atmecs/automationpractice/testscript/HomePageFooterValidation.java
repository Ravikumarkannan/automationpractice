package com.atmecs.automationpractice.testscript;

import org.testng.annotations.Test;
import com.atmecs.automationpractice.pages.HomePageFooterPage;
import com.atmecs.automationpractice.testbase.TestBase;

public class HomePageFooterValidation extends TestBase {
	@Test
	public void validateHomePage() throws Exception {
		HomePageFooterPage.validatePopularProducts(driver);

	}
}
