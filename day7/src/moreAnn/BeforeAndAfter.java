package moreAnn;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BeforeAndAfter {
	
 //BeforeTest and AfterTest is in class level,so it will execute once.
  
  @BeforeTest
  public void doLogin() {
	  System.out.println("User logged in.");
	  
  }
  
 
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Execute before method");
		
  }
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("Execute after method");
		
  }
  
  @Test(priority =1)
  public void openBrowser1() {
	  System.out.println("Open browser");
		
  }
  
  @Test(priority =2)
  public void openBrowser2() {
	  System.out.println("Open browser");
		
  }

  @AfterTest
  public void logout() {
	  System.out.println("User logged out.");
	  
  }

}
