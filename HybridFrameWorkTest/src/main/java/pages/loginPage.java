package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import utilities.extentUtility;
import utilities.utilityFetchproperty;

public class loginPage {
	public WebDriver driver;
	public static WebElement ele;
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSignIn_link() throws IOException
	{
		
		extentUtility.logger.log(Status.INFO, "Click sign in Link");
		ele = driver.findElement(By.xpath(utilityFetchproperty.fetchlocatoralue("loginpage_signin_link")));
		ele.click();
	}
	
	public void enterUserName(String userName) throws IOException
	{
		
		extentUtility.logger.log(Status.INFO, "Enter Username");
		ele = driver.findElement(By.xpath(utilityFetchproperty.fetchlocatoralue("loginpage_username_field")));
		ele.sendKeys(userName);
	}
	
	public void enterPassword(String passWord) throws IOException
	{
		extentUtility.logger.log(Status.INFO, "Enter Password");
		ele = driver.findElement(By.xpath(utilityFetchproperty.fetchlocatoralue("loginpage_password_field")));
		ele.sendKeys(passWord);
	}
	
	public void clickSignInButton() throws IOException
	{
		extentUtility.logger.log(Status.INFO, "Click SignIn button");
		ele = driver.findElement(By.xpath(utilityFetchproperty.fetchlocatoralue("signin_btn")));
		ele.click();
	}
		
}
