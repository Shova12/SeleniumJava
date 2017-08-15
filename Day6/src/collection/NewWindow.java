package collection;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewWindow {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ajaxWidget-products_c_widget_cmp-0']/div[6]/a/div[2]/img]"));
		//to handle the browser that open in new browser
		Set<String> window = driver.getWindowHandles();
		
		//switch is used to change focus
		for(String windowname: window){
		}
	}
	

}
