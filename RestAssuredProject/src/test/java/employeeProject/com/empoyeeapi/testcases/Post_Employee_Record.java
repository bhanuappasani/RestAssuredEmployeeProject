/******************************************************
Test Name:Create new record in database 
URI: http://dummy.restapiexample.com/api/v1/create
Request Type: POST
Request Payload(Body): {"name":"XXXXX","salary":"XXXX","age":"XX"}
********* Validations **********
Response Payload(Body) : {"name":"XXXXX","salary":"XXXX","age":"XX"}
Status Code : 200
Status Line : HTTP/1.1 200 OK
Content Type : application/json;charset=utf-8
Server Type :  nginx/1.16.0
Content Encoding : gzip
**********************************************************/

package employeeProject.com.empoyeeapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import employeeProject.com.empoyeeapi.base.TestBase;
import employeeProject.com.empoyeeapi.utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Post_Employee_Record extends TestBase {
	
	
	String empName = RestUtils.empName();
	String empSal = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	
	
	@BeforeClass
	void createEmployee() {
		
		logger.info("*********Post_Employee_Record**********");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		//JSONObject is a class that represents a simple JSON. We can add Key-Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", empName);
		requestParams.put("salary", empSal);
		requestParams.put("age", empAge);
		
		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");
		
		// Add the Json to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		
		response = httpRequest.request(Method.POST, "/create");
		
	}

	@Test
	void checkResposeBody()
	{
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empName), true);
		Assert.assertEquals(responseBody.contains(empSal), true);
		Assert.assertEquals(responseBody.contains(empAge), true);
		
	}
		
	@Test
	void checkStatusCode()
	{
		int statusCode = response.getStatusCode(); // Getting status code
		Assert.assertEquals(statusCode, 200);
		
	}
		
	@Test
	void checkstatusLine()
	{
		String statusLine = response.getStatusLine(); // Getting status Line
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
	}
	
	@Test
	void checkContentType()
	{
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "application/json;charset=utf-8");
		
	}

	@Test
	void checkserverType()
	{
		String serverType = response.header("Server");
		Assert.assertEquals(serverType, "nginx/1.16.0");
		
	}

	@Test
	void checkcontentEncoding()
	{
		String contentEncoding = response.header("Content-Encoding");
		Assert.assertNotEquals(contentEncoding, "gzip");

	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished Post_Employee_Record **********");
	}
		
}
