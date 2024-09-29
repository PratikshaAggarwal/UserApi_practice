package stepDefinitions;

import static io.restassured.RestAssured.given;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.createUser;
import pojo.userAddress;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefinition extends Utils{
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	static String postType;
	static String uid;
	static String first_name;
	
	TestDataBuild createUserData = new TestDataBuild();
	TestDataBuild updateUserData = new TestDataBuild();
	
	////POST METHOD
	@Given("User creates a valid {string} request body with {string}  {string} {string} {string} {string} {string} {string} {string} {string} for {string}")
	public void user_creates_a_valid_request_body_with_for(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11) throws IOException {
	    
		resspec = new ResponseSpecBuilder().build();
		
		 res=given().log().all().header("Content-Type", "application/json").
				  spec(requestSpecification())
				 .body(createUserData.createUserPayload( string2, string3, string4, string5, string6, string7, string8, string9, string10 ));
		 postType = string11;
	}


	


	
	
	@When("User calls the {string} API with valid {string}")
	public void user_calls_the_api_with_valid(String method, String endpoint) {
	  	
		if(method.equalsIgnoreCase("post"))
		{
			ApiResources resourceApi =	ApiResources.valueOf(endpoint);
			System.out.println("The api resource from enum is: " +	resourceApi.getResource() );
			
			response = res.when().post(resourceApi.getResource()).then()
					.spec(resspec).extract().response();
			
			String resp = response.asString();
			JsonPath js = new JsonPath(resp);
			System.out.println("The user id created is: " + js.get("user_id"));
			System.out.println("This post is to save: " + postType);
		  
				  if(postType.equalsIgnoreCase("id"))
				  {
					  
					  uid = js.get("user_id").toString() ;
					  System.out.println("The user id stored is: " + uid);
				  }
				 if(postType.equalsIgnoreCase("f_name"))
				  {
					  first_name = js.get("user_first_name") ;
					  System.out.println("The user first name stored is: " + first_name);
				  }
		  		
		}
		
		else if(method.equalsIgnoreCase("GetAll"))
		{
			ApiResources resourceApi =	ApiResources.valueOf(endpoint);
			System.out.println("The api resource from enum is: " +	resourceApi.getResource() );
			
			response = res.when().get(resourceApi.getResource()).then()
					.spec(resspec).extract().response();
			
		}
		
		else if(method.equalsIgnoreCase("GetById"))
		{
			ApiResources resourceApi =	ApiResources.valueOf(endpoint);
			System.out.println("The api resource from enum is: " +	resourceApi.getResource() );
			String getId;
			getId = resourceApi.getResource() + uid ;
			
			response = res.when().get(getId).then()
					.spec(resspec).extract().response();
		}
			
		
		else if( method.equalsIgnoreCase("GetByFName")  )
		{
			ApiResources resourceApi =	ApiResources.valueOf(endpoint);
			System.out.println("The api resource from enum is: " +	resourceApi.getResource() );
			String getfname;
			getfname = resourceApi.getResource() + first_name ;
			
			response = res.when().get(getfname).then()
					.spec(resspec).extract().response();
		}
		
		else if(method.equalsIgnoreCase("DelById")  )
		{
			ApiResources resourceApi =	ApiResources.valueOf(endpoint);
			System.out.println("The api resource from enum is: " +	resourceApi.getResource() );
			String getId;
			getId = resourceApi.getResource() + uid ;
			
			response = res.when().delete(getId).then()
					.spec(resspec).extract().response();
		}
		
		else if( method.equalsIgnoreCase("DelByFname"))
		{
			ApiResources resourceApi =	ApiResources.valueOf(endpoint);
			System.out.println("The api resource from enum is: " +	resourceApi.getResource() );
			String getfname;
			getfname = resourceApi.getResource() + first_name ;
			
			response = res.when().delete(getfname).then()
					.spec(resspec).extract().response();
		}
		
		else if(method.equalsIgnoreCase("put"))
		{
			ApiResources resourceApi =	ApiResources.valueOf(endpoint);
			System.out.println("The api resource from enum is: " +	resourceApi.getResource() );
			String getId;
			getId = resourceApi.getResource() + uid ;
			
			response = res.when().put(getId).then()
					.spec(resspec).extract().response();
		}
	}
	
	@Then("The user gets status code {string} in response body")
	public void the_user_gets_status_code_in_response_body(String stCode) {
			
		assertEquals(Integer.parseInt(stCode), response.getStatusCode()  );
		
		System.out.println("The status code is" + response.getStatusCode());
	}
	

	
	////////////////////////GET METHOD
	
	@Given("User wants to display all user details")
	public void user_wants_to_display_all_user_details() throws IOException {
	   
		resspec = new ResponseSpecBuilder().build();
		
		 res=given().log().all().header("Content-Type", "application/json").
				 
				 spec(requestSpecification());
				
		
		
	}
	
	//////////////////DELETE METHOD
	@Given("User wants to delete user")
	public void user_wants_to_delete_user() throws IOException {
		resspec = new ResponseSpecBuilder().build();
		
		 res=given().log().all().header("Content-Type", "application/json").
				 
				 spec(requestSpecification());
		
	}

	
	////////////PUT METHOD
	@Given("Update a user with following parametes {string}  {string} {string} {string} {string} {string} {string} {string} {string}")
	public void update_a_user_with_following_parametes(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) throws IOException {
	    
		resspec = new ResponseSpecBuilder().build();
		
		 res=given().log().all().header("Content-Type", "application/json").
				 
				 spec(requestSpecification())
				
					.body(updateUserData.createUserPayload(string, string2, string3, string4, string5, string6, string7, string8, string9 ));
		
		
	}
}
