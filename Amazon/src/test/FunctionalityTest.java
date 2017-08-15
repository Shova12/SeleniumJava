package test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionalityTest {
	

	static WebDriver driver = new FirefoxDriver();
	public static void main(String[] args) {
		
				
				driver.get("https://www.amazon.com");
				System.out.println("The title: "+driver.getTitle());
				driver.manage().window().maximize();
				

				String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
				String actualTitle = driver.getTitle();
				
				if (expectedTitle.equals(actualTitle)){
					System.out.println("The title verifed and correct title is displayed on page");
					
				}
				else{
					System.out.println("The title verification failed and incorrect title is displayed on page");
				}
				
				//verify searchTextBox is presence
				
				WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
				searchTextBox.isDisplayed();
				System.out.println(searchTextBox);
				
				
				searchTextBox.clear();
				searchTextBox.sendKeys("Laptops");
				
				
				
				/*//convert webElement to String by .get()
				String searchText = searchTextBox.getText();
				System.out.println("Search: "+searchText);
				*/
				
				
				//verify submit button
				
				boolean goButtonIsPresence = driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")).isDisplayed();
				boolean goButtonIsEnabled = driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")).isEnabled();
				
				if(goButtonIsPresence== true && goButtonIsEnabled==true ){
					driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")).submit();
				}
				
				System.out.println(driver.getTitle());
				
				//verify search item
				//Assert.assertEquals(( driver.getPageSource().contains("Laptops")),true);
					
				WebDriverWait wait = new WebDriverWait(driver,10); 
				WebElement itemDetail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='result_0']/div/div/div/div[2]/div[2]/div[1]/a/h2")));
				System.out.println(itemDetail.getText());
				itemDetail.click();
				
				//WebDriverWait wait = new WebDriverWait(driver,10);
				
				/*//Add on cart
				WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
				addToCart.click();
				
				WebElement itemInCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='nav-cart']/span[1]")));
				itemInCart.click();
				//String numberOfItems = itemInCart.getText();
				//int y = Integer.parseInt(numberOfItems);
				
				System.out.println("The number of items: "+itemInCart );
				//System.out.println("The number of items: "+ y);
		*/		
				FunctionalityTest testObj = new FunctionalityTest();
				try {
					testObj.addcart1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int []a={2,3};
				testObj.calculation(a);
				

				/*String parentWindowHandle = driver.getWindowHandle();
				
				Set<String> childWindowHandles = driver.getWindowHandles();
				Iterator <String> iterator  =  childWindowHandles.iterator ();
				String subWindowHandler = null;
				while (iterator.hasNext()){
				    subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler); // switch to popup window
				
				/*System.out.println("Title:"+ driver.getTitle());

				Now you are in the popup window, perform necessary actions here

				driver.switchTo().window(parentWindowHandle);
				
			
				driver.findElement(By.id(".//*[@id='text0']")).sendKeys("SHASHI");
				
				driver.findElement(By.xpath(".//*[@id='kat_optin']/div/label/span")).click();*/
				
				driver.close();
				System.out.println("Successful execution");

				}
				
			
			public void addcart1() throws InterruptedException {
				WebDriverWait wait = new WebDriverWait(driver,50);
				//driver.findElement(By.id("add-to-cart-button")).click();
				WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
				addToCart.click();
				//System.out.println("The title after adding item: "+driver.getTitle());
				
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(".//*[@id='nav-cart-count']")).click();
				
				Thread.sleep(2000);
				Select addMoreItems = new Select(driver.findElement(By.xpath(".//*[@class='a-native-dropdown a-button-span8']")));
				List<WebElement> countList = addMoreItems.getOptions(); 
				int listSize = countList.size();
				System.out.println("The list is "+listSize);
				addMoreItems.selectByVisibleText("2");
				
			}

			
			
			public void  calculation(int[] input){
				WebElement price = driver.findElement(By.xpath(".//*[@id='gutterCartViewForm']/div[3]/div[2]/div/div[1]/p/span/span[2]"));
				System.out.println("The price :"+price.getText());
				String stringPrice = price.getText();
				String replacePrice = stringPrice.replaceAll("[$,]", "");
				double priceOfItems = Double.parseDouble(replacePrice);
				
				System.out.println("DoublePrice: "+priceOfItems);
				
				WebElement updatedItems = driver.findElement(By.xpath(".//*[@class='a-native-dropdown a-button-span8']"));
				
				//double []input = null ;
				
				for(int i=0; i<input.length;i++){
					double subTotalPrice = priceOfItems*input[i];
					System.out.println("The Updated Price is " +subTotalPrice);
				}
				
			}


}
