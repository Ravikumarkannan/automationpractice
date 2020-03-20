package com.atmecs.automation.pages;

import org.openqa.selenium.WebDriver;

import com.atmecs.automation.helpers.CommonHelpers;
import com.atmecs.automation.helpers.ValidationHelper;
import com.atmecs.automation.logger.Loggers;

public class FeedBackPage {
	
	static Loggers log = new Loggers();
	
	public static void validateFeedBack(WebDriver driver,String email,String dataEmail, String textarea,String text,String file,String dataFile,String confirm,String confirmText) {
		CommonHelpers.SendKeys(driver, email, dataEmail);
		CommonHelpers.SendKeys(driver, textarea, text);
		ValidationHelper.checkText(driver, file, dataFile);
		ValidationHelper.checkText(driver, confirm, confirmText);
		log.info("Feed back validation is done");
	}
}
