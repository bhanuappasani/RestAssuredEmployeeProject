
  
/******************************************************
Test Name:Get a single employee data
URI: http://dummy.restapiexample.com/api/v1/employee/{id}
Request Type: GET
Request Payload(Body): NA
********* Validations **********
Status Code : 200
Status Line : HTTP/1.1 200 OK
Content Type : application/json;charset=utf-8
Server Type :  nginx/1.16.0
Content Encoding : gzip
Content Length <800
 *********************************************************/


package employeeProject.com.empoyeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import employeeProject.com.empoyeeapi.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Get_All_Employees extends TestBase {
	
	
	@BeforeClass
	public void getAllEmployees() {
		
		logger.info("********* Getting All Employees **********");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		httpRequest = RestAssured.given();
		
		response = httpRequest.request(Method.GET, "/employees");
				
	}
	
	
	@Test
	public void checkResponseBody() {
		
		logger.info("********* Checking Response Body **********");
		
		String responseBody = response.getBody().asString();
		logger.info("Response Body: "+responseBody);
		Assert.assertTrue(responseBody!=null);
		
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("***********  Checking Status Code **********");
		
		int statusCode = response.getStatusCode(); // Getting status code
		logger.info("Status Code is ==>" + statusCode); //200
		Assert.assertEquals(statusCode, 200);	
		
	}
		
	@Test
	void checkResponseTime()
	{
		logger.info("***********  Checking Response Time **********");
		
		long responseTime = response.getTime(); // Getting status Line
		logger.info("Response Time is ==>" + responseTime);
		
		if(responseTime>2000)
			logger.warn("Response Time is greater than 2000");
		
		Assert.assertTrue(responseTime<10000);
		
	}
	
	@Test
	void checkstatusLine()
	{
		logger.info("***********  Checking Status Line **********");
		
		String statusLine = response.getStatusLine(); // Getting status Line
		logger.info("Status Line is ==>" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");	
	}
	
	@Test
	void checkContentType()
	{
		logger.info("***********  Checking Content Type **********");
		
		String contentType = response.header("Content-Type");
		logger.info("Content type is ==>" + contentType);
		Assert.assertEquals(contentType, "application/json;charset=utf-8");
		
	}

	@Test
	void checkserverType()
	{
		logger.info("***********  Checking Server Type **********");
		
		String serverType = response.header("Server");
		logger.info("Server Type is =>" +serverType); 
		Assert.assertEquals(serverType, "nginx/1.16.0");
		
	}

	@Test
	void checkcontentEncoding()
	{
		logger.info("***********  Checking Content Encoding**********");
		
		String contentEncoding = response.header("Content-Encoding");
		logger.info("Content Encoding is==>" +contentEncoding); 
		Assert.assertEquals(contentEncoding, "gzip");
		
	}

	@Test
	void checkContentLenght()
	{
		logger.info("***********  Checking Content Lenght**********");
		
		String contentLength = response.header("Content-Length");
		logger.info("Content Length is==>" +contentLength); 
		
		if(Integer.parseInt(contentLength)<100)
			logger.warn("Content Length is less than 100");
		
		Assert.assertTrue(Integer.parseInt(contentLength)>100);
		
	}
		
	@Test
	void checkCookies()
	{
		logger.info("***********  Checking Cookies **********");

		String cookie = response.getCookie("PHPSESSID");
		//Assert.assertEquals(cookie,"1esuvsfslcmiee2bfrsgnijtg0");
		
	}
	
	@AfterClass
	public void tearDown() {
		
		logger.info("*********  Finished Get_All_Employees **********");
	}

}
