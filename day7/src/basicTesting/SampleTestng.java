package basicTesting;

import org.testng.annotations.Test;

public class SampleTestng {
	
	
	
	@Test
	public void openBrowser(){
		
		System.out.println("Open browser");
		
	}
	

	@Test(priority =2)
	public void openBrowser1(){
		
		System.out.println("Open browser1");
		
	}

	@Test(priority =1)
	public void openBrowser2(){
		
		System.out.println("Open browser2");
		
	}

}
