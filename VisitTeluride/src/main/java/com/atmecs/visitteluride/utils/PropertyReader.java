package com.atmecs.visitteluride.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	static Properties properties;

	public static Properties readProperty(String filePath) {

		properties = new Properties();
		try {
			properties.load(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the given path" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Input output expection" + e.getMessage());
		}
		return properties;
	}
}
