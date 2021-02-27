package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import utilities.extentUtility;
import utilities.utilityFetchproperty;

public class addToCartPage 
{
	public WebDriver driver;
	public static WebElement ele;
	public addToCartPage(WebDriver driver) 
	{
	this.driver = driver;
	}
	
	public void Finditems () throws Exception
	{
		extentUtility.logger.log(Status.INFO, "Find Items");
		ele = driver.findElement(By.xpath(utilityFetchproperty.fetchlocatoralue("add_printed_dress_link1")));
		ele.click();
	}
	
	public void AddingToCart () throws Exception 
	{
		extentUtility.logger.log(Status.INFO, "Add To Cart");
		ele = driver.findElement(By.xpath(utilityFetchproperty.fetchlocatoralue("add_to_cart_btn")));
		ele.click();
	}
	
	public void NextLinktoDresses () throws Exception
	{
		extentUtility.logger.log(Status.INFO, "List of Dresses");
		try 
			{
			ele = driver.findElement(By.xpath(utilityFetchproperty.fetchlocatoralue("add_printed_dress_link2")));
			} 
			catch (IOException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}

}
