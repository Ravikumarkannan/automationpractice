package com.atmecs.practo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static Properties properties;
	
	public static Properties readProperty(String filePath) {
		
		properties = new Properties();
		
		try {
			properties.load(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the given location"+e.getCause());
		} catch (IOException e) {
			System.out.println("File input output exception"+e.getCause());
		}
		return properties;
		
	}
}
