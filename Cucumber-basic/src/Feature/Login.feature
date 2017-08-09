
Feature: LoginFeature
	This feature deals with the login functionality of the application


Scenario: Login with correct username and password
Given I navigate at login page
And I enter the user email address as Email:admin
And I verfiy the count of my salary digits for Dollar 5000
And I entered following for Login
	| username| password		 |
	| admin	  | adminPassword|
And I click login button
Then I should see the userform page

Scenario Outline: Login with correct username and password from Scenario Outline
Given I navigate at login page
And I enter <username> and <password>	
And I click login button
Then I should see the userform page

Examples:
	| username| password		 |
	| tester	| abcd1234 		 |
	| testerp	| abcd12345 	 |
	
Scenario: Login with incorrect username and password
Given I navigate at login page
And I entered following for Login
	| username| password		 |
	| admin	  | adminPassword|
And I click login button
Then I should see the error message
	