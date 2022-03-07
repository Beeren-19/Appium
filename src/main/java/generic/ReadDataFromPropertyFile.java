package generic;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static String readDataPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("../Appium/src/test/resources/DesiredCapabalities.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
}
