package Issue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Snapdeal {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://snapdeal.com");
		//driver.findElement(By.xpath(".//a[text()= 'Arrow']")).click();

		JavascriptExecutor execute = (JavascriptExecutor)driver;
		execute.executeScript("arugments[0].click()", arg1);
		
	}

}
