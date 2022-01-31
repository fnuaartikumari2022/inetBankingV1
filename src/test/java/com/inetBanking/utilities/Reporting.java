package com.inetBanking.utilities;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetBanking.testCases.BaseClass;

public class Reporting extends BaseClass implements ITestListener{
	
	//ExtentReports extent;
		ExtentTest test;
		
		static ExtentReports extent=Reporting.getReportObject();
		//ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
		
		
		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			test= extent.createTest(result.getMethod().getMethodName());
			//extentTest.set(test);
			
		}

		@Override
		public void onTestFailure(ITestResult result) {
		
			test.fail(result.getThrowable());
			//extentTest.get().fail(result.getThrowable());
		//	WebDriver driver =null;
			String testMethodName =result.getMethod().getMethodName();
			
//			try {
//				driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//			} catch(Exception e)
//			{
//				e.printStackTrace();
//			}
			try {
				//extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
				test.addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
       public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			extent.flush();
		}

	@BeforeTest
	public static ExtentReports getReportObject()

	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timestamp+".html";
	//String path =System.getProperty("user.dir")+"/test-output/reports.html";
		String path =System.getProperty("user.dir")+"/test-output/"+repName;
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
reporter.config().setReportName("Web Automation Results");
reporter.config().setDocumentTitle("Test Results");
extent =new ExtentReports();
extent.attachReporter(reporter);
extent.setSystemInfo("Tester", "Aarti Kumari");
extent.setSystemInfo("Project Name", "Net Banking");
return extent;

	}

	/*	@Test

	public void initialDemo()

	{

	ExtentTest test= extent.createTest("Initial Demo");

	System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

	WebDriver driver =new ChromeDriver();

	driver.get("https://rahulshettyacademy.com");

	System.out.println(driver.getTitle());

	driver.close();


	}
	*/


}
