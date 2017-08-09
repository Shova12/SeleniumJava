package files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFiles { 
	//public static void main(String[]arg) throws IOException{
	public String browserType() throws IOException{
		String browserType = null;
			FileInputStream file;
			try {
				
				file = new FileInputStream ("C://wamp//www//JavaProject//Tektaraus//BedBathAndBeyond//src//files//Config.properties");
				Properties pro = new Properties();
				pro.load(file);
				
				browserType = pro.getProperty("browserType");
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return browserType;
	}
}
