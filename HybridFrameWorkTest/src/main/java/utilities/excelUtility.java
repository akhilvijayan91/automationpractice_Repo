package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility {

	private static FileInputStream excelfile;
	private static XSSFWorkbook excelworkbook;
	private static XSSFSheet excelsheet;
	private static XSSFCell excelcell;
	private static XSSFRow excelrow;
	
// load excel file
	
	public static void setExcelFile (String Path, String SheetName) throws Exception
	{
		try {
			
			excelfile = new FileInputStream(Path);
			
			excelworkbook = new XSSFWorkbook(excelfile);
			
			excelsheet = excelworkbook.getSheet(SheetName);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
			
		}
			
		}
	
// test case row number
		
	public static int getRowContains(String TestCaseName, int ColumnNum)
	{
		int i = 0;
		
		try {
			
			int rowCount =  excelsheet.getLastRowNum();
			
			for (i = 0; i <=rowCount; i++) {
				
				if (excelUtility.getCellData(i, ColumnNum).equalsIgnoreCase(TestCaseName)) {
					break;
				}
				
			}
			
			return i;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
			
		}
		
		
	}
	
	// To get cell data
	
	public static String getCellData(int RowNum, int ColNum)
	{
		String CellData=null;
		
		try {
			
			excelcell = excelsheet.getRow(RowNum).getCell(ColNum);
			
			 CellData = excelcell.getStringCellValue();
			 return CellData;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			return "";
			
		}
		
	}
	
	// to get the rowdata
	
	public static Object[][] getTableData(String FilePath, String SheetName, int TestCaseRow) throws Exception
	
	{
		excelfile = new FileInputStream(FilePath);
		
		excelworkbook = new XSSFWorkbook(excelfile);
		
		excelsheet = excelworkbook.getSheet(SheetName);
		
		int rowcount = excelsheet.getLastRowNum();
		
		
		int k = NextTestCaserowcount (TestCaseRow, rowcount);
		
		int noOfCols = (excelsheet.getRow(TestCaseRow).getLastCellNum())-1;
		int noOfRows=(k-TestCaseRow);

		
		String [][] tabarray = new String [noOfRows][noOfCols];
		
				try {
					int ci = 0;
					while (TestCaseRow<k) {
						
						int cj = 0;
						int StartCol = 1;
						
						int totalCols = (excelsheet.getRow(TestCaseRow).getLastCellNum())-1;
						
						for (int j = StartCol; j <= totalCols; j++,cj++) {
							tabarray[ci][cj]=getCellData(TestCaseRow,j);
						}
						
						ci++;
						TestCaseRow++;
					}
					
										
				} catch (Exception e) {
					// TODO: handle exception
					
					throw e;
				}
				
		return (tabarray);
	}
	
	
	public static int NextTestCaserowcount (int TestCaseRow, int rowcount)
	
	{
		int i;
		for (i = TestCaseRow+1; i < rowcount; i++) {
			
			if (excelUtility.getCellData(i, 0)!= "") {
					
					break;
				
			}
			
		}
		
		
		return i;
		
	}
		
	
}

