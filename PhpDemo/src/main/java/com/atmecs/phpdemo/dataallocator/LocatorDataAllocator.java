package com.atmecs.phpdemo.dataallocator;

import java.util.Properties;

import com.atmecs.phpdemo.constants.FilePaths;
import com.atmecs.phpdemo.utils.PropertyReader;

public class LocatorDataAllocator {

	Properties properties;

	public String php_logo;
	public String main_menu;
	public String img_home;
	public String img_admin1;
	public String img_admin2;
	public String openMenu;
	public String openMenu_mute;
	public String openMenu_minimize;
	public String dropdown_choose;
	public String dropdown_yes;

	public void getHomePageProperty() {
		properties = PropertyReader.readProperties(FilePaths.HOMEPAGE_FILE);

		php_logo = properties.getProperty("loc_php_logo");
		main_menu = properties.getProperty("loc_php_mainMenu");
		img_home = properties.getProperty("loc_img_home");
		img_admin1 = properties.getProperty("loc_img_administrator1");
		img_admin2 = properties.getProperty("loc_img_administrator2");
		openMenu = properties.getProperty("loc_openMenu");
		openMenu_mute = properties.getProperty("loc_openMenu_mute");
		openMenu_minimize = properties.getProperty("loc_minimizeWindow");
		dropdown_choose=properties.getProperty("loc_dropdown_choose");
		dropdown_yes=properties.getProperty("loc_dropdown_yes");
	}

}
