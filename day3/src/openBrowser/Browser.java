package openBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	public static void main(String[] args) {
		WebDriver driver = null;
		
		String browserType = "chrome";
		
		if(browserType.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver","C:\\wamp\\www\\driverforSelenium\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}else if(browserType.equals("Firefox")){
			
			System.setProperty("webdriver.gecko.driver","C:\\wamp\\www\\driverforSelenium\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}else if(browserType.equals("ie")){
			System.setProperty("webdriver.ie.driver","");
			driver = new InternetExplorerDriver();
		}
		
		
		System.out.println(driver.toString());
		
		driver.manage().window().maximize();
		
		driver.get("http://www.gmail.com"); //to get basic url
		System.out.println(driver.getTitle());
		
		//driver.navigate().to("");// navigating url on same tab
		
		//driver.close();// only close current window(tab or browser) only
		
		driver.quit();// close all browser

	}

}
