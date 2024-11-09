package demo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTest {

 
	@Test
	public void DemoTesting1() {  
		//Create the SparkReport
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReports/report.html");
		
		//Configure the SparkReport Information
		spark.config().setDocumentTitle("Regression Testing for the Learning Selenium Page");
		spark.config().setReportName("RegressionSuite||Verification of Welcome Page");
		spark.config().setTheme(Theme.DARK);
		
		//Create the Extent Report
		ExtentReports report=new ExtentReports();
		
		//Attach the Spark Report and ExtentReport
		report.attachReporter(spark);
		
		//Configure the System Information in Extent report
		report.setSystemInfo("DeviceName:", "Harry");
		report.setSystemInfo("OperatingSystem:", "WINDOWS11");
		report.setSystemInfo("Browser:", "Chrome");
		report.setSystemInfo("BrowserVersion:","chrome-128.0.6613.85");
		
		//Create the Test Information
		ExtentTest test=report.createTest("Regressiontest");
		//Steps information
		test.log(Status.INFO, "Step1: Launching The Browser Successful");
		test.log(Status.INFO, "Step2:Navigating To Application via UPL Successful");
		test.log(Status.PASS, "Step3:Verified the Webpage Successful");
		
		if("Harry".equals("Harry")) {
			test.log(Status.PASS, "Step4:Verified the WebElements is Displayed");
		}
		else {
			test.log(Status.FAIL,  "Step4:Verified the WebElements is not Displayed");
		}
		//test.log(Status.SKIP, "Step5:Element is Hidden");
		
		//Flush the Report Information
		report.flush();
	}
@Test
public void DemoTesting2() {
	
}

@Test
public void DemoTesting3() {
	
}

@Test
public void DemoTesting4() {
	
}
@Test
public void DemoTesting5() {
	
}
@Test
public void DemoTesting6() {
	
}

}
