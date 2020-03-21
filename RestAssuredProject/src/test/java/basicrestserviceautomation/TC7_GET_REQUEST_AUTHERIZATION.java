package basicrestserviceautomation;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC7_GET_REQUEST_AUTHERIZATION {
	
	@Test
	public void requestAutherizationTest() {
		
		//Request Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//Basic Authentication Object
		PreemptiveBasicAuthScheme basicAuthenticate = new PreemptiveBasicAuthScheme();
		basicAuthenticate.setUserName("ToolsQA");
		basicAuthenticate.setPassword("TestPassword");
		
		//Send Authentication object to RestAssured authentication
		RestAssured.authentication = basicAuthenticate;
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"/");
		
		//Validate Status Code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
			System.out.println("Status Code is: "+statusCode);
		
		//Status line validation
		String statusLine = response.statusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
			System.out.println("Status line is: "+statusLine);		
			
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
	}

}
