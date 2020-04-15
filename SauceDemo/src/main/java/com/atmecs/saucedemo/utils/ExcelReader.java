package com.atmecs.saucedemo.utils;

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

	public static double readData(String path, int row, int cell) {
		double value;

		file = new File(path);
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the given path" + e.getMessage());
		}

		workbook = new XSSFWorkbook();
		sheet = workbook.getSheetAt(0);
		value = (int)sheet.getRow(row).getCell(cell).getNumericCellValue();

		return value;
	}
}
