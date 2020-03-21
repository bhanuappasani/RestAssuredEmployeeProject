package basicrestserviceautomation;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC4_GET_ALL_RESPONSE_HEADERS {
	
	@Test
	public void getALLResponseHeader() {
		
		//Request Base URI
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET, "users");
		
		//Print All Header in the Response on the console window
		Headers allHeaders = response.getHeaders();
		for(Header header:allHeaders) {
			
			System.out.println(header.getName()+" - "+header.getValue());
		}
			
	}

}
