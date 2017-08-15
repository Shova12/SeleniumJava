package countTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CountTable {
	
	WebDriver driver = new FirefoxDriver();
	
	
	public static void main(String[] args) throws InterruptedException {
		CountTable count = new CountTable();
		count.countTable();
		

	}
	public void countTable() throws InterruptedException{
		/*driver.get("https://www.etrade.wallst.com/");
		WebElement investmentChoice = driver.findElement(By.xpath("//*[@href = 'https://us.etrade.com/what-we-offer/investment-choices']"));
		Actions act = new Actions(driver);
		act.moveToElement(investmentChoice).build().perform();
		driver.findElement(By.xpath(""));*/
		/*driver.get("https://us.etrade.com/what-we-offer/investment-choices/stocks");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='topFiveList']//span[@data-symbol ='IBM']")).click();*/
		
		driver.get("https://www.etrade.wallst.com/v1/stocks/snapshot/snapshot.asp?ChallengeUrl=https://idp.etrade.com/idp/SSO.saml2&reinitiate-handshake=0&prospectnavyear=2011&AuthnContext=prospect&env=PRD&symbol=IBM&rsO=new&country=US");
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='etNewWidthContainer']"))));
		//List<WebElement> lst = element.findElements(By.xpath(".//table[@class='quoteB col_1 txt12']"));
		
		
		List<WebElement>lst1 = element.findElements(By.xpath(".//table[@class='quoteB col_1 txt12']"));
		//List<WebElement>lst1 = element.findElements(By.xpath(".//*[@class='fLeft colRPad']"));
		
		System.out.println("Size: "+lst1.size());
		
		for(int i=0;i<lst1.size();i++){
			//for(int j=0; j<lst1.size();i++){
			System.out.println("value:"+ lst1.get(i).getText());
			
			//}	
		}
		
		List<WebElement>lst2 = element.findElements(By.xpath(".//table[@class='quoteB col_1 txt12']"));
		
		
		driver.close();
		System.out.print("Successful Execution");
		
	}

}
