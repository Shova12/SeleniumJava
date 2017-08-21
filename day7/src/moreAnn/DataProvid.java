package moreAnn;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvid{
	
	 @Test(dataProvider = "data")
	  public void endingpoint(String name1, String name2,String name3) {
		  System.out.println("Ending same as Main in Java"+name1+name2);
	 }
	 
	 @DataProvider(name = "data")
	 public String[][] getData(){
		 //i means iteration
		 //j means no.of arguments or parameters
		 String [][]a = new String[2][3];
		 a[0][0] = "name01";
		 a[0][1] = "name11";
		 a[0][2] = "name02";
		 
		 a[1][0] = "name01";
		 a[1][1] = "name11";
		 a[1][2] = "name22";
		 
		return a;
		 
		 
		 
	 }

}
