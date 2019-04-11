package com.zoopla.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
	
	FileInputStream fis;
	public static Workbook wb;
	public Excel() throws EncryptedDocumentException, IOException 
	{
		fis = new FileInputStream("D://NaveenAssignments//zoopla.Assignment//src//test//java//com//zoopla//testdata//Input_Testdata.xlsx");
		wb = WorkbookFactory.create(fis);
	}
	public int rowCount(String sheetName)
	{
		return wb.getSheet(sheetName).getLastRowNum();
	}
	public int rowCount(String sheetName,int rowCount)
	{
		return wb.getSheet(sheetName).getRow(rowCount).getLastCellNum();
	}
	
	
	public String getData(String sheetName,int rowCount,int cellCount)
	{
		String data = wb.getSheet(sheetName).getRow(rowCount).getCell(cellCount).getStringCellValue();
		return data;
	}
	
	
	
}
