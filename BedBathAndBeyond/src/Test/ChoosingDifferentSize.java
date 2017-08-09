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
import org.openqa.selenium.support.ui.Select;

import files.PropertiesFiles;
import junit.framework.Assert;

public class ChoosingDifferentSize {

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
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		driver.findElement(By.xpath(".//*[@id='row1']/div[1]/div[2]/a/img")).click();
		System.out.println(driver.getTitle());
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement selectTextBox =driver.findElement(By.xpath(".//select[@id='selectProductSize']"));
		
		//verify if selectbox is presence or not
		/*try{
			if(selectTextBox.isEnabled()){
				//selectSize.selectByIndex(2);
				System.out.println("Textbox Presence and text is passed");
			}
			else{
				System.out.println("Textbox is not Presence");
			
			}
		}
		catch(Exception e){
			System.out.println("No text passed."+e.getMessage());
			
		}*/
		
		//print list
		Select selectSize = new Select(selectTextBox);
		List<WebElement> selectCount = selectSize.getOptions();
		int listSize = selectCount.size();
		//print size of list
		System.out.println("The size is "+listSize);
		
		//for printing list of options:
		for(int i=0; i<listSize; i++){
				String s = selectCount.get(i).getText();
				System.out.println("List: "+ s);
			
				//checking if contains string
				if(s.contains("Select a Size")){
					selectSize.selectByIndex(i);
					break;
				}
				
		}	
		
		driver.findElement(By.xpath(".//*[@title='AQUA BLUE']")).click();
			
		
		
		
		 /*for clicking on  point in chrome
		 WebElement element = driver.findElement(By.xpath(".//*[@id='row1']/div[1]/div[2]/div[2]/div[1]/a"));
		 
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		
		
		
		
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='row1']/div[1]/div[2]/div[2]/div[1]/a")));
		System.out.println(myDynamicElement);
		
		WebDriverWait wait = new WebDriverWait(driver,0);
		WebElement itemTitle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='row1']/div[1]/div[2]/div[2]/div[1]/a")));
		System.out.println(itemTitle.getText());
		itemTitle.click();
		
		WebElement itemDetailColor = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='prodForm']/div[3]/div[6]/fieldset/div/ul/li[1]/div")));
		System.out.println(itemDetailColor.getText());
		itemDetailColor.click();
		
		
		
		System.out.println("Title: "+ driver.getTitle());*/
		
		WebElement addToCartButton=  driver.findElement(By.xpath(".//*[@id='buttonRedesign']/div/input"));
		
		
		if(addToCartButton.isEnabled()){
			System.out.println("The button is enabled");
			addToCartButton.submit();
			
		}
		else{
			System.out.println("The button is not enabled");
		}
		
		
		
		 
		//driver.switchTo().alert().dismiss();
		
	
		
		//driver.switchTo().activeElement();
		
		WebElement cart = driver.findElement(By.xpath(".//*[@id='shoppingCartItems']']"));
		cart.click();
		
		if(cart.equals(1)){
			System.out.println("the item no is 1");
		}
		else{
			System.out.println("The cart is empty");
		}
	
		driver.close();
		System.out.println("Completed Succesfully!!");
	}

}


