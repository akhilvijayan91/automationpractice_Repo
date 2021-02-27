package testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClass.DriverInstance;
import pages.loginPage;
import utilities.excelUtility;

public class ValidateLogin_TC1 extends DriverInstance{
  @Test(dataProvider = "login")
  public void validateLogin(String Username, String Password) throws IOException, Exception {
	  loginPage lp = new loginPage(driver);
	  lp.clickSignIn_link();
	  Thread.sleep(3000);
	  lp.enterUserName(Username);
	  lp.enterPassword(Password);
	  lp.clickSignInButton();
	  
  }
  
  @DataProvider
  public Object[][] login() throws Exception {
	  utilities.excelUtility.setExcelFile("./src/test/resources/testData/TestData.xlsx", "LoginTest");
	  String TestCaseName = "UserLogin";
	  int TestCaseRow = excelUtility.getRowContains(TestCaseName, 0);
	  Object[][] tablearray = excelUtility.getTableData("./src/test/resources/testData/TestData.xlsx", "LoginTest", TestCaseRow);
	  return (tablearray);
    //return new Object[][]
    
    
  }
}
