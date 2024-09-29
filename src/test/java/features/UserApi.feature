@UserApi
Feature: user api 

	@GetAllUsers
	Scenario: Get all user details
	 Given User wants to display all user details
	 When User calls the "GetAll" API with valid "getAllUsersApi"
	 Then The user gets status code "200" in response body


  @Post
  Scenario Outline: Add a new user with valid request body giving all required fields and valid authentication
    Given User creates a valid "post" request body with "<user_first_name>"  "<user_last_name>" "<user_contact_number>" "<user_email_id>" "<plotNumber>" "<Street>" "<state>" "<Country>" "<zipCode>" for "<id/f_name>"
    When User calls the "post" API with valid "CreateUserApi"
    Then The user gets status code "201" in response body
    
Examples: 
	|user_first_name | user_last_name | user_contact_number| user_email_id               |plotNumber |Street | state  | Country|zipCode|id/f_name|
	|Abhiveer 			 | Aggarwal	 			| 7262340003				 | abhiveer.aggarwal@gmail.com |p1-68      |Blossom| Oregon | USA    |78253	|id|
	|Damini   			 | Gupta		 			| 9923400031				 | damini.gupta@gmail.com      |p1-67      |Cactus | Florida| USA    |78245	|f_name|
	

@GetUserById
	Scenario: Get user details for specific id
	 Given User wants to display all user details
	 When User calls the "GetById" API with valid "getUserById"
	 Then The user gets status code "200" in response body
	 
@GetUserByFirstName
	Scenario: Get user details for specific first name
	 Given User wants to display all user details
	 When User calls the "GetByFName" API with valid "getUserByFirstNameApi"
	 Then The user gets status code "200" in response body

@Put
Scenario Outline: Update user details for specific id
	 Given Update a user with following parametes "<first_name_put>"  "<last_name_put>" "<contact_number_put>" "<email_id_put>" "<plotNumber_put>" "<Street_put>" "<state_put>" "<Country_put>" "<zipCode_put>"  
	 When User calls the "put" API with valid "UpdateUserApi"
	 Then The user gets status code "200" in response body
	 
Examples: 
	|first_name_put | last_name_put | contact_number_put| email_id_put             |plotNumber_put |Street_put | state_put | Country_put|zipCode_put|
	|Rohit 			    | Sarkar	 			| 7262341113				| rohit.sarkar@gmail.com   |p1-66          |BlossomEnclave   | California| USA         |78250   	|	 


@DelUserById
	Scenario: Delete user for specific id
	 Given User wants to delete user
	 When User calls the "DelById" API with valid "delUserByIdApi"
	 Then The user gets status code "200" in response body
	 
@DelUserByFirstName
	Scenario: Delete user for specific first name
	 Given User wants to delete user
	 When User calls the "DelByFname" API with valid "delUserByFirstNameApi"
	 Then The user gets status code "200" in response body
