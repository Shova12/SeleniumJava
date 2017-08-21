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
		
		driver.manage().window().maximize();
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//System.out.println(driver.findElement(By.xpath(".//*[@id='main-content']")));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='main-content']"))); //.//*[@id='etNewWidthContainer']
		
		
		
		//List<WebElement>lst1 = element.findElements(By.xpath(".//table[@class='quoteB col_1 txt12']"));
		//List<WebElement>lst1 = element.findElements(By.xpath(".//*[@class='fLeft colRPad']"));
		//List<WebElement> rowList = element.findElements(By.xpath(".//*[@class='fLeft colRPad']/tbody/tr"));
		//List<WebElement> colList = element.findElements(By.xpath(".//*[@class='quoteB col_1 txt12']/tbody/tr/td"));
		
		//System.out.println("Row: "+rowList.size());
		//System.out.println("Column: "+colList.size());
		
		
		
		String tr = ".//*[@class='fLeft colRPad']/table/tbody/tr";
		//String tr = ".//*[@class='quoteB col_1 txt12']/tbody/tr";
		String part1 = "[";
		String part2 = "]";
		//String td = "/td";
		String part3 = "[";
		String part4 = "]";
		
		List<WebElement> rowList = element.findElements(By.xpath(tr));
		
		
		for(int i=1;i<=rowList.size();i++){
			String td = tr+part1+i+part2+"/td";
			List<WebElement> colList = element.findElements(By.xpath(td));
			for(int j=1; j<=colList.size();j++){
				String finalxpath = td+part3+j+part4;
				String tableData = driver.findElement(By.xpath(finalxpath)).getText();
				System.out.println("Row :"+i +", Col:"+j +" = " + tableData);
			}
			
			//System.out.println("\n");
				
		}
		
		
		
		/*List<WebElement> rowList2 = element.findElements(By.xpath(".//*[@class='fLeft']/table/tbody/tr"));
		System.out.println("RowCount: "+rowList2.size());*/
		
		
		System.out.println("LEFT TABLE ");
		String tr2 = ".//*[@class='fLeft']/table/tbody/tr";
		String part5 = "[";
		String part6 = "]";
		String part7 = "[";
		String part8 = "]";
		
		List<WebElement> rowList2 = element.findElements(By.xpath(tr2));
		System.out.println("RowCount: "+rowList2.size());
		
		for(int i=1; i<=rowList2.size();i++){
			String td = tr2+part5+i+part6+"/td";
			List<WebElement> colList2 = element.findElements(By.xpath(td)); 
			//System.out.println("ColumnCount: "+colList2.size());
			for(int j=1; j<=colList2.size();j++){
				String finalxpath2 = td+part7+j+part8;
				String tableValue = driver.findElement(By.xpath(finalxpath2)).getText();
				System.out.println("Row: "+i+" Col: "+j+"= "+tableValue);	
				
			}
			
		}
		
		
		/*//Print Row value
		for(int i=0;i<rowList.size();i++){
			System.out.println("valueR:"+ rowList.get(i).getText());
			
		}
	
		//Print Column  value
		for(int i=0;i<colList.size();i++){
			System.out.println("value:"+ colList.get(i).getText());	
			
		}
		*/
		
		//List<WebElement>lst2 = element.findElements(By.xpath(".//table[@class='quoteB col_1 txt12']"));
		
		
		driver.close();
		System.out.print("Successful Execution");
		
	}

}
