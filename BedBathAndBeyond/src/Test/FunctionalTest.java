package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import files.PropertiesFiles;
import junit.framework.Assert;

public class FunctionalTest {
	public static void main(String[] args) throws IOException {
		PropertiesFiles prop = new PropertiesFiles();
		String browserType = prop.browserType();
	
		
		WebDriver driver = null;
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
		
		System.out.println(driver.toString());
		
		driver.manage().window().maximize();
		
		driver.get("https://www.bedbathandbeyond.com");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement searchField = driver.findElement(By.id("searchFormInput"));
		
		System.out.println(searchField.getTagName());
		
		searchField.sendKeys("Blender");
		
		driver.findElement(By.className("searchFormButton")).submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		
		driver.findElement(By.xpath(".//*[@id='row1']/div[1]/div[2]/a/img")).click();
		System.out.println(driver.getTitle());
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		/*
		 *for clicking on  point in chrome
		 WebElement element = driver.findElement(By.xpath(".//*[@id='row1']/div[1]/div[2]/div[2]/div[1]/a"));
		 
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		
		*/
		
		
		
		
		WebElement addToCartButton=  driver.findElement(By.xpath(".//*[@id='buttonRedesign']/div/input"));
		
		
		if(addToCartButton.isEnabled()){
			System.out.println("The button is enabled");
			addToCartButton.click();
			
		}
		else{
			System.out.println("The button is not enabled");
		}
		
		
		
		 
		//driver.switchTo().alert().dismiss();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.switchTo().activeElement();
		WebElement cart = driver.findElement(By.xpath(".//*[@id='cartItems']"));
		cart.click();
		if(cart.equals(1)){
			System.out.println("the item no is 1");
		}else{
			System.out.println("The cart is empty");
		}
	
		driver.close();
		System.out.println("Completed Succesfully!!");
	}

}
