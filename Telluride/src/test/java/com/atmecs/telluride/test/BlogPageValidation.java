package com.atmecs.telluride.test;


import org.testng.annotations.Test;

import com.atmecs.telluride.pages.BlogPageHelper;
import com.atmecs.telluride.testbase.TestBase;

public class BlogPageValidation extends TestBase{

	BlogPageHelper blog = new BlogPageHelper();
	
	@Test
	public void blogPageValidation() throws Exception {
		
		blog.getBlogPage(driver);
		
		blog.validateDropDown(driver);
		
		blog.validateImages(driver);
		
		blog.ValidateBlogLinks(driver);
		
	}
}
