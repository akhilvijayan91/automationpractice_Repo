package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class utilityFetchproperty {
	
	public static String fetchpropertyvalue (String key) throws IOException
	{
		FileInputStream file = new FileInputStream("./config/config.properties");
		
		Properties property = new Properties();
		
		property.load(file);
		
		return property.get(key).toString();
	}

	public static String fetchlocatoralue (String key) throws IOException
	{
		FileInputStream file = new FileInputStream("./config/elements.properties");
		
		Properties property = new Properties();
		
		property.load(file);
		
		return property.get(key).toString();
	}
}
