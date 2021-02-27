package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	public static String Returnpath(WebDriver driver) throws IOException
	{
		    String path = System.getProperty("user.dir")+"/Screenshot/"+ System.currentTimeMillis()+".jpg";
		    
		    TakesScreenshot ts=(TakesScreenshot)driver;
		    File source=ts.getScreenshotAs(OutputType.FILE);
		    File destination=new File(path);
		    FileUtils.copyFile(source,destination);
		    return path;
	}

}
