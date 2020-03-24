package com.atmecs.automation.utils;

import org.openqa.selenium.WebDriver;
import com.atmecs.automation.helpers.CommonHelpers;

public class FileHandler {

	public static void uploadFile(WebDriver driver, String path ,String filePath) {
		CommonHelpers.SendKeys(driver, path, filePath);
	}
}
