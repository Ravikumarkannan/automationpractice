package com.atmecs.automationpractice.testscript;

import org.testng.annotations.Test;
import com.atmecs.automationpractice.pages.HomePageValidationHelper;
import com.atmecs.automationpractice.testbase.TestBase;

public class HomePageValidation extends TestBase {

	@Test
	public void validateHomePage() throws Exception {
		HomePageValidationHelper.validateHomePage(driver);
	}
}
