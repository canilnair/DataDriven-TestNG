package com.anil.framework.DataDriven;

import java.io.FileInputStream;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	// URL to get the binary - http://poi.apache.org/download.html
	// Binary Name:poi-bin-xxx.zip
	// Extract the binary
	// Add all the jars from the location you extracted to the build path
	// Also add all the jars from lib, do no add the jar file of log4j
	// Also add all the jars from ooxml-lib
	// Only works for Excel 2007+

	public static void main(String[] args) {

		XSSFWorkbook ExcelWBook;
		XSSFSheet ExcelWSheet;
		XSSFCell Cell;
		StopWatch watch = new StopWatch();

		// Location of the excel file
		String path = "/Users/anair/Documents/Software/Selenium/ExcelReaderDataFile/ExcelData.xlsx";
		String sheetName = "Sheet1";

		try {
			watch.start();
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);

			Cell = ExcelWSheet.getRow(2).getCell(2);
			String cellData = Cell.getStringCellValue();
			System.out.println("Cell Data : " + cellData);
			double totaltime = (double)watch.getTime()/1000;
			System.out.println("Total time taken is : " + totaltime);
			watch.reset();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
