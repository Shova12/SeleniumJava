package Test;




import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import files.PropertiesFiles;



public class functionalityTest {


	public static void main(String[] args) throws IOException {
		PropertiesFiles prop = new PropertiesFiles();
		String browserType = prop.browserType();
		System.out.println(browserType);

		String childWindow ;
		WebDriver driver = null;
		if(browserType.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\wamp\\www\\driverforSelenium\\chromedriver.exe");
			driver = new ChromeDriver();
		
		}
		 else if (browserType.equals("firefox")){
			System.setProperty("webdriver.marionette", "C:\\wamp\\www\\driverforSelenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		
		}
		else if (browserType.equals("internetExplorer")){
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		
		}
		
		System.out.println(driver.toString());
		
		driver.manage().window().maximize();
		
		driver.get("https://www.bedbathandbeyond.com");
		driver.findElement(By.id("searchFormInput")).sendKeys("Baby and Kids");
		
		driver.findElement(By.className("searchFormButton")).submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='row1']/div[1]/div[2]/a/img")).click();
		
		driver.findElement(By.xpath(".//*[@id='prodForm']/div[3]/div[7]/a")).click();
		
		driver.switchTo().activeElement();
		
		/*String parentWindowHandle = driver.getWindowHandle();
		
		Set<String> childWindowHandles = driver.getWindowHandles();
		Iterator <String> iterator  =  childWindowHandles.iterator ();
		String subWindowHandler = null;
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		
		System.out.println("Title:"+ driver.getTitle());

		Now you are in the popup window, perform necessary actions here

		driver.switchTo().window(parentWindowHandle);*/
		
	
		driver.findElement(By.id(".//*[@id='text0']")).sendKeys("SHASHI");
		
		driver.findElement(By.xpath(".//*[@id='kat_optin']/div/label/span")).click();
		//driver.close();
		System.out.println("Thumb up!!");
	}
	

}
