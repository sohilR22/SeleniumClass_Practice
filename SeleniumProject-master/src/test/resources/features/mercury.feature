@author:Sohail 
@userstory:ang11
Feature: Validation of Mercury tours WEb Page 

To make sure all functionality of page working fine. Customer shold able book flight successfully. 
User name and password for the login page are the same which is mercury.


 Background:
	  Given open the chrome browser
	And user shold navigate to mercury home page successfully


@Login 		
Scenario: Validation of mercury login page
	And user Should  provide  validate credentional 
	And user should click to the login button  
	
	
	
@Main 
Scenario: Validation of main buttons for Mercury web page 	
	And Validation of Home button
	And Validation of Flighs button
	And Validation of Hotels button
	And Validation of Car Rentals button
	And Validation of Cruises button
	And Validation of Destinations 
	And Validation of Vacation 


	
	@Register
	Scenario: Validation of the registeration page for the new costomer 
		When user provide his/her contact informaton
		Then user provide his/her mailling address
	And  customer provide his/her user informaton
	
	@Flight		
	Scenario: Validation of new flight details for client 
	When user provide flight detail information 
	Then user choose prefernces for flight catagories 
	And user choose airline 
		
		
		
		
		
		
		
		
		
	
	
	
	
	
 
	
	

	