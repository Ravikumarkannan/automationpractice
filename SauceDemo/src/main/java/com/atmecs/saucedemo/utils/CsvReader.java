package com.atmecs.saucedemo.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class CsvReader {

	public static String[] readCsvFile(String filePath) throws FileNotFoundException, IOException {

		CSVReader reader = new CSVReader(new FileReader(filePath));
		List<String[]> data = reader.readAll();
		System.out.println("size"+data.size());
		Iterator<String[]> list = data.iterator();
		String[] values = null;
		while (list.hasNext()) {
			values = list.next();
		}
		return values;
	}
}
