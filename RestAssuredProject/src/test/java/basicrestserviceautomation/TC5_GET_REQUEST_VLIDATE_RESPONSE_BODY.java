package basicrestserviceautomation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC5_GET_REQUEST_VLIDATE_RESPONSE_BODY {
	
	@Test
	public void getCityWeatherDetails() {
		
		//Request base URI
		RestAssured.baseURI =  "http://restapi.demoqa.com/utilities/weather/city/";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET, "Delhi");
		
		//Validate the Response and print the response in console window
		String responseBody = response.body().asString();
		Assert.assertEquals(responseBody.contains("Delhi"),true);
			System.out.println("Response Body is: "+responseBody);
	}

}
