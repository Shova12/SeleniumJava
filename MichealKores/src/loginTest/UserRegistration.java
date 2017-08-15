package loginTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class UserRegistration {
	public static void main(String[] args) throws InterruptedException  {
		String browserType = "firefox";

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
		
		
		System.out.println(driver.toString());
		
		driver.manage().window().maximize();
		
		driver.get("https://www.michaelkors.com/");
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
		if(driver.findElement(By.xpath(".//*[@id='contentLeft']/p")).isDisplayed()){
			
			driver.findElement(By.xpath(".//*[@id='cls_headerAd']")).click();
			
		}
		
		
		driver.findElement(By.linkText("Sign In")).click();
		/*
		WebElement element = driver.findElement(By.linkText("Sign In"));
		Actions action = new Actions(driver);
		
		action.moveToElement(element).moveToElement(driver.findElement(By.linkText("create an account")));
		action.click();*/
		
		System.out.println("Title: "+driver.getTitle());
		System.out.println("I am in registred page");
		
		Thread.sleep(2000);
		try{
			
			WebElement element = driver.findElement(By.xpath(".//*[@id='email_address']"));
			if(element.isDisplayed()){
				element.click();
				System.out.println("Entered");
				
			}
			else{
				
			}
			
		}
		catch(Exception e ){
			System.out.println(e.getMessage());
			
		}
		
		
			
		
		WebElement list = driver.findElement(By.id("country"));
		Select selectSize = new Select(list);
		List<WebElement> selectCount = selectSize.getOptions();
		int listSize = selectCount.size();
		System.out.println("Size of list: "+listSize);
		
		/*for(int i=0; i<listSize; i++){
			String s = selectSize.getOptions().get(i).getText();
			System.out.println("The list"+s);
			
		}*/
		
		selectSize.selectByVisibleText("United States");
		//select.selectByVisibleText("Barbados");
		
		driver.findElement(By.xpath(".//*[@id='email_address']")).sendKeys("utesttester10@gmail.com");
		driver.findElement(By.xpath(".//*[@id='confirm_email_address']")).sendKeys("utesttester10@gmail.com");
		driver.findElement(By.xpath(".//*[@id='first_name']")).sendKeys("Tester");
		driver.findElement(By.xpath(".//*[@id='last_name']")).sendKeys("Tester");
		driver.findElement(By.xpath(".//*[@id='phone_number']")).sendKeys("4157568458");
		driver.findElement(By.xpath(".//*[@id='mobile_number']")).sendKeys("4157568458");
		driver.findElement(By.xpath(".//*[@id='postal_code']")).sendKeys("04587");
		
		Thread.sleep(2000);
		
		//DROPDOWN Menu	
		WebElement frame = driver.findElement(By.xpath(".//*[@class='fields_container month_date']/div[1]"));
		frame.click();
		WebElement selectFromDropdownM = (new WebDriverWait(driver, 20))
				  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='fields_container month_date']/div[1]/ul")));
		System.out.println(selectFromDropdownM);
		driver.findElement(By.xpath(".//*[@class='fields_container month_date']/div[1]/ul/li[3]/a")).click();
		
		/*Select select = new Select(driver.findElement(By.xpath(".//*[@class='fields_container month_date']/div[1]/ul")));
		select.selectByVisibleText("01 - January");*/
		
		
		
		WebElement dateOfBirth = driver.findElement(By.xpath(".//*[@class='fields_container month_date']/div[2]"));
		dateOfBirth.click();
		WebElement selectFromDropdownDB = (new WebDriverWait(driver, 20))
				  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='fields_container month_date']/div[2]/ul")));
		System.out.println(selectFromDropdownDB.getText());
		driver.findElement(By.xpath(".//*[@class='fields_container month_date']/div[2]/ul/li[3]/a")).click();
		
		//gender
		driver.findElement(By.xpath(".//*[@class='fields_container']")).click();
		//driver.findElement(By.xpath(".//*[@class='fields_container']/div/ul/li[2]")).click();
		
		
		
		driver.findElement(By.xpath(".//*[@class='password_fields_container']/div[1]/div[2]")).sendKeys("Abcd1234");
		driver.findElement(By.xpath(".//*[@id='confirm_password']")).sendKeys("Abcd1234");
		try{
			WebElement e1 = driver.findElement(By.xpath(".//*[@class='password_fields_container']/div[3]/div/ul"));
		
			if(e1.isDisplayed()){
				e1.click();
				driver.findElement(By.xpath(".//*[@class='password_fields_container']/div[3]/div/ul/li[3]")).click();
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		driver.findElement(By.xpath(".//*[@id='security_question_answer']")).sendKeys("mango");
		driver.findElement(By.xpath(".//*[@id='terms-conditions']")).click();
		driver.findElement(By.xpath(".//*[@class='register_account']")).submit();
	
		
		driver.close();
		System.out.println("Successful Execution");

	}

	
}
	
