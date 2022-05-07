package files;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class fileReader {

	public static int rowCount;
	public static Sheet mySheet;

	public void fileRead(String filePath, String fileName, String sheetName) throws IOException {

		// Create an object of File class to open xlsx file

		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook myWorkBook = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file

		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class

			myWorkBook = new XSSFWorkbook(inputStream);

		}

		// Check condition if the file is xls file

		if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of HSSFWorkbook class

			myWorkBook = new HSSFWorkbook(inputStream);

		}

		// Read sheet inside the workbook by its name

		mySheet = myWorkBook.getSheet(sheetName);

		// Find number of rows in excel file

		rowCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();

	}

	public static int getRowcount() {

		return rowCount;
	}

	public static Sheet getsheet() {
		return mySheet;
	}
}
