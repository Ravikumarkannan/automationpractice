package com.atmecs.saucedemo.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.atmecs.saucedemo.testbase.TestBase;

public class TakeScreenShot extends TestBase {
	
//	@AfterMethod
	
	public void getScreenShot(ITestResult result) throws IOException {
	if(ITestResult.FAILURE==result.getStatus()) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File("./screenshots/"+result.getName()+".png"));
		System.out.println("screenshot taken");
	}
}
}
