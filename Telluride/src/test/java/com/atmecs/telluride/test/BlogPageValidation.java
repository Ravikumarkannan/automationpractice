package com.atmecs.telluride.test;

import org.testng.annotations.Test;

import com.atmecs.telluride.pages.BlogPageHelper;
import com.atmecs.telluride.reports.ExtentReport;
import com.atmecs.telluride.reports.LogReport;
import com.atmecs.telluride.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class BlogPageValidation extends TestBase {

	BlogPageHelper blog = new BlogPageHelper();
	LogReport log = new LogReport();

	@Test
	public void blogPageValidation() throws Exception {
		ExtentReport.test = ExtentReport.extent.startTest("blogPageValidation");
		log.info("Blog page validation started..");

		blog.getBlogPage(driver);

		blog.validateDropDown(driver);

		blog.validateImages(driver);

		blog.ValidateBlogLinks(driver);
		
		ExtentReport.test.log(LogStatus.PASS, "blog page validation done");

	}
}
