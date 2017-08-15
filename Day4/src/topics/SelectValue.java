package topics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectValue {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		//Sync. script with application: 2 ways 
		//1. implicit: Global wait
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get("https://www.bedbathandbeyond.com");
		
		//Session handling: if we are not sure about what going
		try{
			if(driver.findElement(By.xpath(".//*[@id='dialoghead']/img")).isEnabled()){
				driver.findElement(By.xpath(".//*[@id='themeWrapper']/div[7]/div[1]/a/span")).click();
			}
			else{
				
				System.out.println("No pop");
			}
			
		}
		catch(Exception e){
			System.out.println("Keep running"+e.getMessage());
		}
		
		driver.findElement(By.xpath(".//*[@id='shipToLink']")).click();
		
		WebElement element = driver.findElement(By.xpath(".//select[@id='selIntlCountry']"));
		//return webElement(type) in Selenium
		
		Select sel = new Select(element);

		sel.selectByVisibleText("Afghanistan");
	}

}
