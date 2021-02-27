package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import utilities.extentUtility;
import utilities.utilityFetchproperty;

public class searchQueryPage 
{

		public WebDriver driver;
		public static WebElement ele;
		public searchQueryPage(WebDriver driver) 
		{
		this.driver = driver;
		}
		
		public void SearchKeyword (String Keyword) throws Exception 
		{
	
			extentUtility.logger.log(Status.INFO, "Search Query");
			ele = driver.findElement(By.xpath(utilityFetchproperty.fetchlocatoralue("search_field")));
			ele.sendKeys(Keyword);
		}
		
		public void clickSearchButton () throws Exception 
		{
			
			extentUtility.logger.log(Status.INFO, "Click Search Button");
			ele = driver.findElement(By.xpath(utilityFetchproperty.fetchlocatoralue("submit_search_btn")));
			ele.click();
		}


}


