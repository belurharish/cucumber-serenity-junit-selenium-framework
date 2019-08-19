package dataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Read/write the property file and return the required value
 * @author Harisha.P
 */
public class PropertyReader {
	/**
	 * Read the property file and return the required value
	 * @param propKey
	 * @return property value
	 */
	public static String read(String propKey){
		File file = new File("./src/main/resources/application.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(propKey);
	}
}
