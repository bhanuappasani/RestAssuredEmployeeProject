package basicrestserviceautomation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC3_GET_REQUEST_CHECK_HEADER {

	
	@Test
	public void jsonPlaceHolder() {
		
		//Request Base URI
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET, "users");
		
		//Print Response on the console window
		String responseBody = response.body().asString();
		System.out.println("Response Body is: "+responseBody);
		
		//Validate the Headers
		//Content-Type validation
		String contentType = response.getHeader("Content-Type");
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
			System.out.println("Content Type Header value is: "+contentType);
		
		//Content-Encoding validation
		String contentEncoding = response.header("Content-Encoding");
		Assert.assertEquals(contentEncoding, "gzip");
			System.out.println("Content Type Header value is: "+contentEncoding);
	}
}
