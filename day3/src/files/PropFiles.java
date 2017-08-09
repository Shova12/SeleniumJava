package files;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropFiles {
	
	public static void main(String[]arg) throws IOException{
		FileInputStream stream = new FileInputStream("C:\\wamp\\www\\JavaProject\\Tektaraus\\day3\\src\\files\\Config.properties");
		
		Properties pro = new Properties();
	
		
		pro.load(stream);
		
		System.out.println(pro.getProperty("browserType"));
		
	}

}
