package Test;




import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import files.PropertiesFiles;



public class functionalityTest {


	public static void main(String[] args) throws IOException, InterruptedException {
		PropertiesFiles prop = new PropertiesFiles();
		String browserType = prop.browserType();
		System.out.println(browserType);

	
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
		
		driver.findElement(By.xpath("(.//*[@id='row1']//a/img)[1]")).click();
		
		driver.findElement(By.xpath(".//*[@class='personalizationOffered clearfix cb fl']")).click();
		
		Thread.sleep(2000);
		int y = driver.findElements(By.tagName("iframe")).size();
		System.out.println("size: "+y);
			
		
		//how to focus on pop up 
		driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='kat_alert']/div/div")));
		
		System.out.println(driver.findElement(By.xpath(".//*[@id='text0'] ")).getText());
		
		//driver.close();
		System.out.println("Thumb up!!");
	}
	

}
