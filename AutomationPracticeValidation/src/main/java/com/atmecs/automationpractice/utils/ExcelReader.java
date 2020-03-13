package com.atmecs.automationpractice.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static File file;
	public static FileInputStream fis;
	
	public static String readData(String path, String sheetName, int row, int column) throws Exception {
	
		String data=null;
		file = new File(path);
		fis=new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = (XSSFSheet) wb.getSheetAt(1);
		XSSFCell cell = sheet.getRow(row).getCell(column);
		data = cell.toString();
		return data;
	}
}