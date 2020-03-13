package com.atmecs.automationpractice.testscript;

import org.testng.annotations.Test;
import com.atmecs.automationpractice.pages.HomePageImagesPage;
import com.atmecs.automationpractice.testbase.TestBase;

public class HomePageImageValidation extends TestBase {

	@Test
	public void validateHomePage() throws Exception {
		HomePageImagesPage.validateHomePageImages(driver);
		
	}
}
