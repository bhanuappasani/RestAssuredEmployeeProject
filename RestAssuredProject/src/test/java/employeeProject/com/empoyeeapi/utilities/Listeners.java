package employeeProject.com.empoyeeapi.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReport;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext) {
		
		//Specify location of the report
		htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		
		//Title of the Report
		htmlReport.config().setDocumentTitle("Automation Report");
		//Name of the Report
		htmlReport.config().setReportName("Rest API Test Report");
		//Theme of the Report
		htmlReport.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("Project Name","Employee Database API");
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","bhanu");
			
	}
	
	public void onTestSuccess(ITestResult result) {
		
		//test = extent.createTest(result.getClass().getName());
		//test.createNode(result.getName());
		//create new entry in the report
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case Passed is: "+result.getName());
		
	}
	
	public void onTestFailuer(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed is: "+result.getName());
		test.log(Status.FAIL, "Test Case Failed is: "+result.getThrowable()); // to add error/exception in extent report
		
	}
	
	public void onTestSkipped(ITestResult result) {
		
		test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
	}
	
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
    }
	
}
