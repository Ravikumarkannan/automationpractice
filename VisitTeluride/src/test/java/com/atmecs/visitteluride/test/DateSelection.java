package com.atmecs.visitteluride.test;

import java.util.Properties;

import org.testng.annotations.Test;

import com.atmecs.visitteluride.constants.FilePath;
import com.atmecs.visitteluride.helpers.CommonHelpers;
import com.atmecs.visitteluride.loggers.Loggers;
import com.atmecs.visitteluride.pages.DateSelectionPage;
import com.atmecs.visitteluride.testbase.TestBase;
import com.atmecs.visitteluride.utils.PropertyReader;

public class DateSelection extends TestBase {

	Loggers log = new Loggers();
	Properties path = new Properties();
	Properties tdata = new Properties();

	@Test
	public void selectDate() {

		path = PropertyReader.readProperty(FilePath.DATEPICKER_FILE);
		tdata = PropertyReader.readProperty(FilePath.DATETEST_FILE);
		
		CommonHelpers.scrollDown(driver,path.getProperty("loc_arrival")); 

		/*
		 * Date selection by typing date 
		 * DateSelectionPage.sendDate(driver,path.getProperty("loc_arrival"), tdata.getProperty("test_arrival"),path.getProperty("loc_departure"), tdata.getProperty("test_departure"));
		 * CommonHelpers.click(driver, path.getProperty("loc_find"));
		 */

		/*
		 * Date selection by selecting any of the available dates
		 * DateSelectionPage.pickDate(driver,path.getProperty("loc_arrival"), path.getProperty("loc_arrival_date"), "29");
		 * DateSelectionPage.pickDate(driver, path.getProperty("loc_departure"),path.getProperty("loc_departure_date"),"30");
		 * CommonHelpers.click(driver,path.getProperty("loc_find"));
		 */
		
		/*Date selection by selecting year,month and date*/
		DateSelectionPage.selectDate(driver, "2021", "April 2021", "19");
	}
}
