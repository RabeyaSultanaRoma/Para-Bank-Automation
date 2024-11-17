 package com.excel.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.schema.XQuerySchemaTypeSystem;


public class ExcelManager {
	public String getReadExcelData(int RowNum, int ColNum) throws Exception {
		File file = new File("./src/test/resources/Login Test data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		String value;
		//XSSFWorkbook wb = new XSSFWorkbook(fis);
		//XSSFSheet sht = wb.getSheet("valid Login");
		//int totalRowCount = sht.getPhysicalNumberOfRows();
		//System.out.println(totalRowCount);
 		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {
			for (Cell cell : row) {
				if(row.getRowNum()==RowNum && cell.getColumnIndex()==ColNum) {
					//value = cell.getStringCellValue();
					//System.out.println(value);
					
				}
			}
		}
		value = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
		return value;
	}
	public static void main(String[] args) throws Exception {
		ExcelManager em = new ExcelManager();
		em.getReadExcelData(2,1);
	}
}
