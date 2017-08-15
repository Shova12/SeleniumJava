package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import files.PropertiesFiles;
import junit.framework.Assert;

public class RegisterForm {

	
	public static void main(String[] args) throws IOException, InterruptedException {
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
		
		
		driver.manage().window().maximize();
		
		driver.get("https://www.bedbathandbeyond.com");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//span[@class='icon icon-user marRight_5']")).click();
		
		Thread.sleep(2000);
		
		String expectedS = driver.getPageSource();
		
		if(expectedS.contains("New Customers")){
			System.out.println("Passed New Customers");
		}
		else{
			System.out.println("Failed");
		}
		
		Thread.sleep(2000);
		WebElement newEmail = driver.findElement(By.id("newEmail"));
		if(newEmail.isEnabled()){
			newEmail.sendKeys("utestester10@gmail.com");
			System.out.println("The text box is enabled and ready to click on button");
		}
		else{
			System.out.println("......");
		}

		
		driver.findElement(By.id("newEmailBtn")).submit();
		
		Thread.sleep(2000);
		
		try{
			
			boolean expected = driver.findElement(By.xpath(".//*[@id='content']")).isDisplayed();
			
			Assert.assertEquals("Passed", expected, true);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("firstName")).sendKeys("Tester");
		
		driver.findElement(By.id("lastName")).sendKeys("TesterP");
		
		driver.findElement(By.id("basePhoneFull")).sendKeys("4152514586");
		
		driver.findElement(By.id("cellPhoneFull")).sendKeys("4152514587");
		
		WebElement dropDown1 = driver.findElement(By.xpath(".//select[@id='challengeQuestion1']"));
		Select select1 = new Select(dropDown1);
		select1.selectByVisibleText("What is the name of your first crush?");
		driver.findElement(By.id("challengeAnswer1")).sendKeys("PalitestingPalitestingPalitestingPalitesting");
		
		WebElement dropDown2 = driver.findElement(By.xpath(".//select[@id='challengeQuestion2']"));
		Select select2 = new Select(dropDown2);
		select2.selectByVisibleText("What is your nickname?");
		driver.findElement(By.id("challengeAnswer2")).sendKeys("kalihisepareki");
		System.out.println("Answer is given");
		
		driver.findElement(By.id("showPassword")).click();
		
		driver.findElement(By.id("password")).sendKeys("Abcd1234");
		
		driver.findElement(By.id("cPassword")).sendKeys("Abcd1234");
		driver.findElement(By.id("createAccontBtn")).submit();
		
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
		System.out.println("Successful Execution");
			
		
	}

	
}
