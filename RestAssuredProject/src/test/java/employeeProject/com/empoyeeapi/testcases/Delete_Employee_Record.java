/******************************************************
Test Name: Delete an employee record
URI: http://dummy.restapiexample.com/api/v1/delete/{id}
Request Type: DELETE
Request Payload(Body): NA
********* Validations **********
Response Payload(Body) : {"success":{"text":"successfully! deleted Records"}}
Status Code : 200
Status Line : HTTP/1.1 200 OK
Content Type : text/html; charset=UTF-8
Server Type :  nginx/1.14.1
Content Encoding : gzip
**********************************************************/

package employeeProject.com.empoyeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import employeeProject.com.empoyeeapi.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class Delete_Employee_Record extends TestBase{
	
	@BeforeTest
	void deleteEmployeeRecord() {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
		httpRequest = RestAssured.given();
		
		response = httpRequest.request(Method.GET, "/employees");
		
		//First get the JsonPath object instance from the Response interface
		JsonPath  jsonPathEvaluator = response.jsonPath();
		
		//Capture id
		String empID = jsonPathEvaluator.get("[0].id");
		
		response = httpRequest.request(Method.DELETE, "/delete/"+empID);
		
	}
	
	@Test
	void checkResposeBody()
	{
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("successfully! deleted Records"), true);

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
		logger.info("*********  Finished Delete_Employee_Record **********");
	}

}
