package com.atmecs.phpdemo.dataallocator;

import java.util.Properties;
import com.atmecs.phpdemo.constants.FilePaths;
import com.atmecs.phpdemo.utils.PropertyReader;

public class ValidationDataAllocator {

	Properties properties;

	public String demo;
	public String pricing;
	public String features;
	public String products;
	public String documents;
	public String hosting;
	public String company;
	public String login;

	public void geValidationProperty() {
		properties = PropertyReader.readProperties(FilePaths.VALID_FILE);

		demo = properties.getProperty("val_mainmenu_demo");
		pricing = properties.getProperty("val_mainmenu_pricing");
		features = properties.getProperty("val_mainmenu_features");
		products = properties.getProperty("val_mainmenu_product");
		documents = properties.getProperty("val_mainmenu_docs");
		hosting = properties.getProperty("val_mainmenu_hosting");
		company = properties.getProperty("val_mainmenu_company");
		login = properties.getProperty("val_mainmenu_login");
	}
}
