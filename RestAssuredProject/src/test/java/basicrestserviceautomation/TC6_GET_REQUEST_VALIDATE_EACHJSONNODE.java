package basicrestserviceautomation;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC6_GET_REQUEST_VALIDATE_EACHJSONNODE {
	
	@Test
	public void getEachNodeOfJosnResponse() {
		
		//Request Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET, "Delhi");
		
		//Created Json Node variable
		JsonPath eachJsonNode = response.jsonPath();
		
		//Validate each Json Node in the response
		String city = eachJsonNode.get("City");
		Assert.assertEquals(city, "Delhi");
			System.out.println("City: "+city);
			
		String temp = eachJsonNode.get("Temperature");
		Assert.assertEquals(temp, "19 Degree celsius");
			System.out.println("Temperature: "+temp);
				
		String humidity = eachJsonNode.get("Humidity");
		Assert.assertEquals(humidity, "77 Percent");
			System.out.println("Humidity: "+humidity);
					
		String weather = eachJsonNode.get("WeatherDescription");
		Assert.assertEquals(weather, "mist");
			System.out.println("WeatherDescription: "+weather);
						
		String wind = eachJsonNode.get("WindSpeed");
		Assert.assertEquals(wind, "1.9 Km per hour");
			System.out.println("WindSpeed: "+wind);
							
		String windDirection = eachJsonNode.get("WindDirectionDegree");
		Assert.assertEquals(windDirection, "352 Degree");
			System.out.println("WindDirectionDegree: "+windDirection);
		
	}

}
