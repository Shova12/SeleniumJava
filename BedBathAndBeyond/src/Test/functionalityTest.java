package Test;




import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
		//driver.findElement(By.xpath(".//*[@class='personalize']")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='personalizationOffered clearfix cb fl']/a")));
		
		WebElement clickButton = driver.findElement(By.xpath(".//*[@class='personalizationOffered clearfix cb fl']/a"));
		if(clickButton.isEnabled()){
			System.out.println("The button is found");
			clickButton.click();
			if(clickButton.isSelected()){
				System.out.println(" Selection");
				
			}
			else{
				System.out.println("Button is not clicked");
			}
		}
		else{
			System.out.println("Button is not found");
		}
		
		List<WebElement> y = driver.findElements(By.tagName("iframe"));
		System.out.println("size: "+y.size());
		
		/*for(int i=0; i<y.size(); i++){
			
			System.out.println("Value:"+y.get(i).getText());
			
		}*/
			
		
		//how to focus on pop up 
		
		/*WebDriverWait frame = new WebDriverWait(driver,20)
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(".//*[@id='wrap']/div")));*/
		
		WebElement frame = driver.findElement(By.xpath(".//iframe[contains(@id,'katori_xdm_modal')]"));
		frame.click();
		//driver.switchTo().frame(frame);
		
		//System.out.println(driver.findElement(By.xpath(".//*[@id='text0'] ")).getText());
		
		//driver.close();
		System.out.println("Successful!!");
	}
	

}
