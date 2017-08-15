package Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import files.PropertiesFiles;

public class NegativeLoginFormTest {
	static WebDriver driver;


	public static void main(String[] args) throws IOException {
		PropertiesFiles prop = new PropertiesFiles();
		String browserType = prop.browserType();
	
		
		
		if(browserType.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\wamp\\www\\driverforSelenium\\chromedriver.exe");
			driver = new ChromeDriver();
		
		}
		 else if (browserType.equals("firefox")){
			//System.setProperty("webdriver.gekco.driver", "C:\\wamp\\www\\driverforSelenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		
		}
		else if (browserType.equals("internetExplorer")){
			System.setProperty("webdriver.ie.driver", "C:\\wamp\\www\\driverforSelenium\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		
		}
		else if (browserType.equals("phantomjs")){
			System.setProperty("webdriver.phantomjs.driver", "C:\\wamp\\www\\driverforSelenium\\phantomjs.exe");
			driver = new InternetExplorerDriver();
		
		}
		
		
		driver.manage().window().maximize();
		
		driver.get("https://www.bedbathandbeyond.com");
		driver.findElement(By.xpath(".//span[@class='icon icon-user marRight_5']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		NegativeLoginFormTest logintest = new  NegativeLoginFormTest();
		
		logintest.emailCheck();
		
		
		driver.close();
		System.out.println("Successful Execution");

	}

	
	public void emailCheck(){
		
		WebElement newEmail = driver.findElement(By.id("newEmail"));
		newEmail.sendKeys("utestester1.com");
		driver.findElement(By.id("newEmailBtn")).submit();
		/*if(newEmail.equals("utestester10@gmail.com")){
			driver.findElement(By.id("newEmailBtn")).submit();
			WebElement message = driver.findElement(By.xpath(".//label[@class='error']"));
			System.out.println("Message: "+message);
			
			
		}
		else{
			System.out.println("failed");
		
		}*/
	}
	

}
