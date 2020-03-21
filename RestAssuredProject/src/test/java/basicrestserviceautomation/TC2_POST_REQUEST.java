package basicrestserviceautomation;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC2_POST_REQUEST {
	
	
	@Test
	public void userRegistration() {
		
		//Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//JSONObject is a class that represents a simple JSON
		JSONObject requestParams = new JSONObject();
		
		//We can add Key-Value pairs using the put method
		requestParams.put("FirstName", "Bhanu");
		requestParams.put("LastName", "Appasani");
		requestParams.put("UserName", "Bhanu");
		requestParams.put("Password", "Bhanu123");
		requestParams.put("Email", "Bhanu@gmail.com");
		
		//Add a header stating to the Request
		httpRequest.header("Content-Type", "application/json");
		
		//Add the Json to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		//Response Object
		Response response = httpRequest.request(Method.POST,"/register");
		
		//Print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response is: "+responseBody);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
			System.out.println("Status code is: "+statusCode);
			
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
		
	}

}
