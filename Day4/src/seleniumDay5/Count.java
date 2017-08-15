package seleniumDay5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Count {

	public static void main(String[] args) {
		WebDriver driver= new FirefoxDriver();
		driver.get("https://applitools.com/landing/free-account-qa/?");
		//findElements will return lots of elements
		//we use List
		WebElement element = driver.findElement(By.xpath("//*[@class='landing']"));
		List<WebElement> lst = element.findElements(By.xpath("//*[@class='tshirt-container']/ul"));
		
		for(int i=0;i<lst.size();i++){
			System.out.println("value:"+ lst.get(i).getText());
			
		}
		//xpath index start from 1(reading ). however, arraylist index start from 0(enter)
		

	}

}
