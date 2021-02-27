package baseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.extentUtility;
import utilities.utilityFetchproperty;

public class DriverInstance {
	public WebDriver driver;
	public static String browsername=null;
	
	@BeforeClass
	public void initiateDriverInstance() throws IOException
	{
		browsername = utilityFetchproperty.fetchpropertyvalue("browsername");
		switch (browsername) {
		case "Chrome":
			 WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
			break;
		case "Firefox":
			 WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
			break;
		case "Edge":
			 WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			  driver = new InternetExplorerDriver();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
			break;
		}
		
		driver.get(utilityFetchproperty.fetchpropertyvalue("url"));
		driver.manage().window().maximize();
		
		String classname = this.getClass().getSimpleName();
		extentUtility.CreateExtentInstance(classname);
	}
	
	@AfterMethod
	public void closeDriverInstance(ITestResult result) throws IOException
	{
		
		extentUtility.PrintResult(result, driver);
		driver.quit();
		
	}

}
