package com.atmecs.phpdemo.testscript;

import org.testng.annotations.Test;
import com.atmecs.phpdemo.pages.HomePageHelper;
import com.atmecs.phpdemo.testbase.TestBase;

public class HomePageValidation extends TestBase {

	@Test
	public void validateHomePage() throws Exception {	
		HomePageHelper.homePageValidation(driver);
	}
}