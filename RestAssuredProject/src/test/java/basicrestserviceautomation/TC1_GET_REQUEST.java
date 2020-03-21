package basicrestserviceautomation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC1_GET_REQUEST {

	@Test
	void getWeatherDetails() {
		
		//Specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"/Toronto");
		
		//Print Response in Console Window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		
		//Status code validation
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
			System.out.println("Status code is: "+statusCode);
		
		//Status line validation
		String statusLine = response.statusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
			System.out.println("Status line is: "+statusLine);
	}
}
