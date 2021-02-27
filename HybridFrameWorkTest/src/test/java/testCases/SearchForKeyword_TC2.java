package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClass.DriverInstance;
import pages.searchQueryPage;
import utilities.excelUtility;

public class SearchForKeyword_TC2 extends DriverInstance
{
	@Test(dataProvider = "search")
	public void searchForKeyword (String Keyword) throws Exception
	{
		searchQueryPage sq = new searchQueryPage(driver);
		sq.SearchKeyword(Keyword);
		sq.clickSearchButton();
	}
	
	
	@DataProvider
	  public Object[][] search() throws Exception 
	{
		  utilities.excelUtility.setExcelFile("./src/test/resources/testData/TestData.xlsx", "LoginTest");
		  String TestCaseName = "SearchKeyword";
		  int TestCaseRow = excelUtility.getRowContains(TestCaseName, 0);
		  Object[][] tablearray = excelUtility.getTableData("./src/test/resources/testData/TestData.xlsx", "LoginTest", TestCaseRow);
		  return (tablearray);
	    //return new Object[][]
	}
}

