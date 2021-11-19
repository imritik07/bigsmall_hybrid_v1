package com.bigsmall.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		
		int rowCount= ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}
	public static int getCellCount(String xlfile, String xlsheet, int rowNum) throws IOException {
		fi= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		
		row= ws.getRow(rowNum);
		int cellCount= row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}
	public static String getCellData(String xlfile, String xlsheet, int row, int cell) throws IOException
	{
		fi= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		
		String cellValue= ws.getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		fi.close();
		return  cellValue;
	}
	
	public static void  setCellData(String xlfile, String xlsheet, int rowNum, int colNum, String value) throws IOException
	{
		fi= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		
		row= ws.getRow(rowNum);
		cell= row.createCell(colNum);
		// setting the value
		cell.setCellValue(value);
		fo= new FileOutputStream(xlfile);
		
		wb.close();
		fo.close();
		fi.close();
	}
		
}
