package com.atmecs.ninjakart.helpers;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListener implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+"started..");
	}
	
	 public void onTestSuccess(ITestResult result) {
		 System.out.println("Test method: " +result.getName()+"success");
	 }
	 
	 public void onTestFailure(ITestResult result) {
		 System.out.println("Test method: " +result.getName()+"failured");
	 }
	 
	 public void onTestSkipped(ITestResult result) {
		 System.out.println("Test method: " +result.getName()+"skipped");
	 }
	 
	 public void onStart(ITestContext context) {
		 System.out.println("test started");
	 }
	 
	 public void onFinish(ITestContext context) {
		 System.out.println("test finished");
	 }
}
