package Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
		
		System.out.println(driver.toString());
		
		driver.manage().window().maximize();
	
		driver.get("https://www.bedbathandbeyond.com");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement searchField = driver.findElement(By.id("searchFormInput"));
		
		System.out.println(searchField.getTagName());
		
		searchField.sendKeys("Bath mat");
		
		driver.findElement(By.className("searchFormButton")).submit();
		
		
		//driver.findElement(By.xpath(".//*[@id='row1']/div[1]/div[2]/a/img")).click();  
		
		
		String part1 = ".//*[@id='row1']";
		String part2 = "//*[@class='productImage lazyLoad loadingGIF']";
		
		driver.findElement(By.xpath(part1+part2)).click();
		
		//driver.findElement(By.xpath(".//*[@id='row1']/div[1]/div[2]/a/img")).click();
		System.out.println(driver.getTitle());
		
		/*WebElement selectTextBox = (new WebDriverWait(driver, 20))
				  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='selectProductSize")));
		System.out.println(selectTextBox);*/
		

		/*If select option style is shown then we can use Select other wise then just click
		 * 
		 * Select selectSize = new Select(selectTextBox);
		 
		List<WebElement> countList = selectTextBox.getOptions();
		
		List<WebElement> selectCount = selectSize.getOptions();
		int listSize = selectCount.size();
		//print size of list
		System.out.println("The size is "+listSize);*/
		
		WebElement dropDownMenu = driver.findElement(By.xpath(".//*[@class='dropDownWrapper']"));
		
		dropDownMenu.click();
		driver.findElement(By.xpath(".//*[@class='dropDownOptions']/li[2]/a")).click();
		
		
		//choose color
		/*driver.findElement(By.xpath(".//*[@title='AQUA BLUE']")).click();
		System.out.println("The COLOUR is selected.");*/
		System.out.println("CHOOSE COLOR");
		WebElement color = driver.findElement(By.xpath(".//*[@class='registryDataItemsWrap listDataItemsWrap']"));
				
		List<WebElement> colorCount = color.findElements(By.xpath(".//ul[@class='width_5 swatches clearfix']/li"));
				
		System.out.println("Size: "+colorCount.size());
		for(int i=1; i<colorCount.size();i++){
			String var = driver.findElement(By.xpath(".//ul[@class='width_5 swatches clearfix']/li")).getAttribute("data-attr"); // COULDN"T GET VALUE IN XPATH IN STRING
			System.out.println(".//ul[@class='width_5 swatches clearfix']/li["+i+"]"+"Color: "+var);
			//System.out.println("Color: " +colorCount.get(i).getText());
				
		}
				
		WebElement colorChoose = driver.findElement(By.xpath(".//ul[@class='width_5 swatches clearfix']/li[2]"));
		colorChoose.click();

		
		
	//Add to cart
		WebElement addToCartButton=  driver.findElement(By.xpath(".//*[@id='buttonRedesign']/div/input"));
		
		
		if(addToCartButton.isEnabled()){
			System.out.println("The button is enabled");
			addToCartButton.submit();
			System.out.println("The item is added to cart");
			
		}
		else{
			System.out.println("The button is not enabled");
		}
		
		/*
		Thread.sleep(2000);
		
		WebElement cartAfterAddingItems = driver.findElement(By.xpath(".//*[@id='cartItems']"));
		cartAfterAddingItems.click();
		if(cartAfterAddingItems.equals(1)){
			System.out.println("the item no is 1");
		}else{
			System.out.println("The cart is empty");
		}*/
	
		driver.close();
		System.out.println("Completed Succesfully!!");
	}

	

}
