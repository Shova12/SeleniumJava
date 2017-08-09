package cucmberTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import cucmberTest.base.BaseUtil;
import cucmberTest.transformation.EmailTransformation;
import cucmberTest.transformation.SalaryCountTransformer;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.And;

public class Steps extends BaseUtil{
	private BaseUtil base;
	
	public Steps(BaseUtil base){
		this.base = base;
	}
	@Given("^I navigate at login page$")
	  public void iNavigateAtLoginPage() throws Throwable {
		System.out.println("This will naviagte to login page");
		  //throw new PendingException();
	  }

	  /*@And("^I entered username admin and password admin$")
	  public void iEnteredUsernameAdminAndPasswordAdmin() throws Throwable {
		  System.out.println("Entered user name and password");
		  //throw new PendingException();
	  }*/
	


	@And("^I entered username \"(.*?)\" and password \"(.*?)\"$")
	public void iEnteredUsernameAndPassword(String username, String password) throws Throwable {
		//throw new PendingException();
		
	}
	  
	  @And("^I click login button$")
		public void iClickLoginButton() throws Throwable {
		  System.out.println("Click on button");
		  //throw new PendingException();
		}

	  
	  @Then("^I should see the userform page$")
	  public void iShouldSeeTheUserformPage() throws Throwable {
		  System.out.println("The broswer is "+base.StepsInfo);
		  System.out.println("In userform page");
		  //throw new PendingException();
	  }

	@And("^I entered following for Login$")
	public void iEnteredFollowingForLogin(DataTable table) throws Throwable {
		/*List <List<String>> data =table.raw();
		System.out.println( "Username: "+ data.get(0).get(0).toString());
		System.out.println("Password: "+data.get(0).get(1).toString());*/

			class User{
				public String username;
				public String password;
				
				public User(String userName, String passWord){
					
					username = userName;
					password = passWord;
				}
				
			}
			List<User>number = new ArrayList<User>();	
			number = table.asList(User.class);
			
			for(User user: number){
				System.out.println("USERNAME: "+ user.username);
				System.out.println("PASSWORD: "+ user.password);
			}
			
		
	}

	@And("^I enter ([^\"]*) and ([^\"]*)$")
	public void iEnterUsernameAndPassword(String userName, String passWord) throws Throwable {
		System.out.println("USERNAME:" + userName);
		System.out.println(" PASSWORD:" + passWord);
	}

	/*@And("^I entered <username> and <password>$")
	public void iEnteredUsernameAndPassword() throws Throwable {
		throw new PendingException();
	}*/

	
	
	
	@Then("^I should see the error message$")
	public void iShouldSeeTheErrorMessage() throws Throwable {
		throw new PendingException();
	}
	
	@And("^I enter the user email address as Email:([^\"]*)$")
	public void iEnterTheUserEmailAddressAsEmailAdmin(@Transform(EmailTransformation.class)String email) throws Throwable {
		
		System.out.println("The email address is "+email);
	}
	
	@And("^I verfiy the count of my salary digits for Dollar (\\d+)$")
	public void iVerfiyTheCountOfMySalaryDigitsForDollar(@Transform(SalaryCountTransformer.class)int salary) throws Throwable {
		System.out.println("Salary "+ salary);
	
		
	}
	
	class User{
		public String username;
		public String password;
		
		public User(String userName, String passWord){
			
			username = userName;
			password = passWord;
		}
		
	}

	
			
}