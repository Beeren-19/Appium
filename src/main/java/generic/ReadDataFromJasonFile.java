package generic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class ReadDataFromJasonFile {

	public String readDataJason(String key) throws IOException, ParseException
	{
		FileReader file=new FileReader("../Appium/src/test/resources/Desiredcapabilities.json");
		
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(file);
		HashMap jobj=(HashMap)obj;
		String value = jobj.get(key).toString();
		return value;
	}
}
