package com.atmecs.automationpractice.dataallocator;

import java.util.Properties;
import com.atmecs.automationpractice.constants.FilePath;
import com.atmecs.automationpractice.utils.PropertyReader;

public class LocatorDataAllocator {
	Properties properties;

	public String logo;

	public String women;
	public String tops;
	public String tshirt;
	public String blouse;
	public String women_casual_dress;
	public String women_evening_dress;
	public String women_summer_dress;

	public String dresses;
	public String casual_dress;
	public String evening_dress;
	public String summer_dress;

	public String tshirt_menu;
	
	public String image_dress;
	public String bestSeller;
	
	public String search_box;
	public String search_button;
	public String filter_mainmenu;
	public String selected_option;
	
	public void getLocatorData() {
		properties = PropertyReader.readProperties(FilePath.HOMEPAGE_FILE);

		logo = properties.getProperty("loc_logo");

		women = properties.getProperty("loc_women");
		tops = properties.getProperty("loc_tops");
		tshirt = properties.getProperty("loc_tshirt");
		blouse = properties.getProperty("loc_blouse");
		women_casual_dress = properties.getProperty("loc_casual_women");
		women_evening_dress = properties.getProperty("loc_evening_women");
		women_summer_dress = properties.getProperty("loc_summer_women");

		dresses = properties.getProperty("loc_dresses");
		casual_dress = properties.getProperty("loc_casual");
		evening_dress = properties.getProperty("loc_evening");
		summer_dress = properties.getProperty("loc_summer");

		tshirt_menu = properties.getProperty("loc_tshirt_menu");
		
		image_dress = properties.getProperty("loc_image_dress");
		bestSeller = properties.getProperty("loc_bestSeller");
		
		search_box = properties.getProperty("loc_searchBox");
		search_button = properties.getProperty("loc_seachButton");
		
		filter_mainmenu = properties.getProperty("loc_filter_mainmenu");
		selected_option = properties.getProperty("loc_selected_option");
	}
}
