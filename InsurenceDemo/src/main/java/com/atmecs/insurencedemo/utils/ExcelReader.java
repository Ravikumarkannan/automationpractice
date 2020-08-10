package com.atmecs.insurencedemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static File file;
	static FileInputStream fis;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static String readData(String path, String sheetName, int row, int cell) {
		String value = null;

		file = new File(path);
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the given path" + e.getMessage());
		}

		workbook = new XSSFWorkbook();
		sheet = workbook.getSheet(sheetName);
		value = sheet.getRow(row).getCell(cell).getStringCellValue();

		return value;
	}
}
