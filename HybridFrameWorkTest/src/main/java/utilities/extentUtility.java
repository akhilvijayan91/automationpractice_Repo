package utilities;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;

public class extentUtility {
	  WebDriver driver;
	  static ExtentReports extent;
	  public static ExtentTest logger;
		  
	  public static void CreateExtentInstance(String classname) {
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
		  Date now = new Date();
		  String timeStamp = sdf.format(now);
		  ExtentSparkReporter spark = new ExtentSparkReporter("./ExtendReports/" + classname + timeStamp + "report.html");
		  extent = new ExtentReports();
		  extent.attachReporter(spark);
		  logger = extent.createTest(classname);
		  spark.config().setReportName("AutomationPracticeReport");
		  spark.config().setDocumentTitle("ReportTitle");
		  spark.config().setTheme(Theme.STANDARD);		  
	  }
	  
	 
	  public static void PrintResult (ITestResult result, WebDriver driver) throws IOException {
		  if (result.getStatus()== ITestResult.SUCCESS)
		  {
			  logger.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.GREEN));
		  }
		  else if (result.getStatus()== ITestResult.SKIP)
		  {
			  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.ORANGE));
		  }  
		  else
		  {
			  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName()+"Testcase failed due to the below issues", ExtentColor.RED));
			  logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtility.Returnpath(driver)).build());
			 
		  } 
		  
		  extent.flush();
		
	  }	  

}
