package com.atmecs.telluride.reports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	public void startReport() {

		extent = new ExtentReports("./Telluride/test-output/ExtentReport.html", true);
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));

	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {

		String date = new SimpleDateFormat("yyyyMMhhmmss").format(new Date());

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/test-output/FailedTestsScreenshots/" + screenshotName
				+ "-" + date + ".png";

		File finalDesti = new File(destination);
		FileHandler.copy(source, finalDesti);
		return destination;

	}

	@AfterMethod
	public static void getReport(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentReport.test.log(LogStatus.FAIL, "Test case" + result.getName() + " is failed");
			ExtentReport.test.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());

			String screenshot = ExtentReport.getScreenshot(ExtentReport.driver, result.getName());

			ExtentReport.test.log(LogStatus.FAIL, ExtentReport.test.addScreenCapture(screenshot));
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			ExtentReport.test.log(LogStatus.SKIP, "Test case" + result.getName() + "is skipped");
		}
		
		ExtentReport.extent.endTest(ExtentReport.test);
	}
	
	@AfterTest
	public void getClose() {
		ExtentReport.extent.flush();
	}
}
