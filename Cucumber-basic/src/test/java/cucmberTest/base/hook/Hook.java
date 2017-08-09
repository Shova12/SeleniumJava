package cucmberTest.base.hook;

import cucmberTest.base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hook extends BaseUtil{
	private  BaseUtil base;
	
	public Hook(BaseUtil base){
		this.base = base;
	}
		
	


	@Before
	 public void InitilizeTest(){
		
		System.out.println("Opening the browser: MOCK");
		
		//Passing the dummy webdriver
		base.StepsInfo = "ChromeDriver";
	 }
	 
	 @After
	 public void TearnDownTest(Scenario scenario){
		 if(scenario.isFailed()){
			 //screenshot code
			 System.out.print(scenario.getName());
			 
		 }
		 
		 
		 System.out.println("Closing the browser: MOCK");
	 }
	
}
