package com.EpsonDoms2.GenericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.EpsonDoms2.ExcelFileLibrary.ReadExcelFile;
import com.EpsonDoms2.PageRepository.PageManagement;
import com.EpsonDoms2.PropertyFileLibrary.ReadPropertyFile;
import com.EpsonDoms2.WebDriverLibrary.WebDriverUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
* This Class Is Used To Configure All The PreCondition And PostCondition For Test Script
* It Also Initializes All The Library-Utility Class
* 
* 
* @author LENOVO
*  */
public class BaseTest {

	public String username;
	public PageManagement pagemanagementobj;
	public WebDriverUtility webdriverobj;
	public ReadExcelFile excelutilityobj;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public 	ReadPropertyFile propertyfileobj;

	@BeforeSuite
	public void suiteSetup() {

		// Create the SparkReport
		spark = new ExtentSparkReporter("./AdvanceReports/report.html");

		// Configure the SparkReport Information
		spark.config().setDocumentTitle("Regression Testing for the Learning Selenium Page");
		spark.config().setReportName("RegressionSuite||Verification of Welcome Page");
		spark.config().setTheme(Theme.STANDARD);

		// Create the Extent Report
		report = new ExtentReports();

		// Attach the Spark Report and ExtentReport
		report.attachReporter(spark);

		// Configure the System Information in Extent report
		report.setSystemInfo("DeviceName:", "Harry");
		report.setSystemInfo("OperatingSystem:", "WINDOWS11");
		report.setSystemInfo("Browser:", "Chrome");
		report.setSystemInfo("BrowserVersion:", "chrome-128.0.6613.85");
	}

	@AfterSuite
	public void suiteTerminateSetup() {
		// Flush the Report Information
		report.flush();
	}

	@Parameters({ "browsername", "weburl" })
	@BeforeClass
	public void browserSetup(String browser, String url) throws InterruptedException {

		// Create Object for all the repository/utility
		createObjects();

		// fetch the user name from excel file
		username = excelutilityobj.readSingleData("RegisterData", 1, 1);

		// step1:Launch the browser
		webdriverobj.launchBrowser(browser);
		Reporter.log("Step1: Launch the browser success", true);
		/*
		 * switch (browser) { case "Chrome": WebDriverManager.chromedriver().setup();
		 * driver = new ChromeDriver(); break;
		 * 
		 * case "Firefox": WebDriverManager.firefoxdriver().setup(); driver = new
		 * FirefoxDriver(); break;
		 * 
		 * case "Edge": WebDriverManager.edgedriver().setup(); driver = new
		 * EdgeDriver(); break; default:
		 * System.out.println("You Have Entered incorrect Browser Nmae"); break; }
		 */
		// Reporter.log("Step1:Browser launched succesfully",true);

		// Maximize the Browser
		webdriverobj.maximizeTheBrowser();
		Reporter.log("Step1.1: Maximized browser success", true);
		
		// Step2:Navigating to application via URL
		// String url=ReadPropertyFile.readData("weburl");
		//String url2 = "file:///C:/Users/DELL/Desktop/QSP_Automation_testing/com.DomsEpson/src/main/resources/Softwares/webpage.html";
		
		webdriverobj.NavigateToApplication(url);
		Reporter.log("Step2:Navigating to application via URL succesfully", true);
	}

	@AfterClass
	public void terminatebrowser() {
		// Step10:Close the browser
		webdriverobj.closeAllBrowsers();
		Reporter.log("Step10:Browser closed succesfully", true);
	}

	public void createObjects() {
		webdriverobj = new WebDriverUtility();
		excelutilityobj = new ReadExcelFile();
		propertyfileobj=new ReadPropertyFile();
	}

}