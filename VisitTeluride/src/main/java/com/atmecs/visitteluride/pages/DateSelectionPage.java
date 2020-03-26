package com.atmecs.visitteluride.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.visitteluride.constants.FilePath;
import com.atmecs.visitteluride.helpers.CommonHelpers;
import com.atmecs.visitteluride.utils.PropertyReader;

public class DateSelectionPage {

	static Properties path = new Properties();

	public static void sendDate(WebDriver driver, String arrival, String arrivalDate, String departure,
			String departureDate) {

		path = PropertyReader.readProperty(FilePath.DATEPICKER_FILE);
		CommonHelpers.sendKeys(driver, arrival, arrivalDate);
		CommonHelpers.click(driver, path.getProperty("loc_active1"));
		CommonHelpers.click(driver, path.getProperty("loc_active2"));
		CommonHelpers.sendKeys(driver, departure, departureDate);
	}

	public static void pickDate(WebDriver driver, String datebox, String datePath, String date) {
		path = PropertyReader.readProperty(FilePath.DATEPICKER_FILE);
		CommonHelpers.click(driver, datebox);
		List<WebElement> dateList = driver.findElements(By.xpath(datePath));
		for (int count = 0; count < dateList.size(); count++) {
			if (dateList.get(count).getText().equalsIgnoreCase(date)) {
				dateList.get(count).click();
			}
		}
	}

	public static void selectDate(WebDriver driver, String year, String month, String day) {
		path = PropertyReader.readProperty(FilePath.DATEPICKER_FILE);
		CommonHelpers.click(driver, path.getProperty("loc_arrival"));
		CommonHelpers.click(driver, path.getProperty("loc_month"));

		if (!driver.findElement(By.xpath(path.getProperty("loc_year"))).getText().equals(year)) {
			do {
				CommonHelpers.click(driver, path.getProperty("loc_nextyear"));
			} while (driver.findElement(By.xpath(path.getProperty("loc_year"))).getText().equalsIgnoreCase(year));
		}
		CommonHelpers.click(driver, path.getProperty("loc_arrival"));
		
		if(!driver.findElement(By.xpath(path.getProperty("loc_month"))).getText().equalsIgnoreCase(month)) {
			do {
				CommonHelpers.click(driver, path.getProperty("loc_nextmonth"));
			} while(driver.findElement(By.xpath(path.getProperty("loc_month"))).getText().equalsIgnoreCase(month));
		}
		
		List<WebElement> dateList = driver.findElements(By.xpath(path.getProperty("loc_arrival_date")));
		for (int count = 0; count < dateList.size(); count++) {
			if (dateList.get(count).getText().equalsIgnoreCase(day)) {
				dateList.get(count).click();
			}
		}
		
	}
}