package com.EpsonDoms2.WelcomeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EpsonDoms2.GenericLibrary.BaseTest;
import com.EpsonDoms2.JavaLibrary.JavaUtility;
import com.EpsonDoms2.PageRepository.PageManagement;
import com.aventstack.extentreports.Status;

public class VerifyWelcomePageTest extends BaseTest {

	@Test(priority = 1)
	public void verifyWelcomepageWithValidInput() {

		// Create the Test Information
		test = report.createTest("verifyWelcomepageWithValidInput");
		
		// Steps information
		test.log(Status.INFO, "<<---Execution started Successful---->");

		// Execute the Precondition---->1.Launch the Browser,2.Navigate to URL
		test.log(Status.INFO, "Step1: Launching the browser successful>");
		
		// Implicit wait
		webdriverobj.WaitImplicitly(20);

		// Verify the Welcome Page Using title
		Assert.assertEquals("Learning Selenium",webdriverobj.driver.getTitle());
		test.log(Status.PASS, "Title Verified");

		// Create object of the Welcome Page

		// Create an object for PageManager
		pagemanagementobj = new PageManagement(webdriverobj.driver);

		// ---------------------------------------------------------------------------------------------------------------------------------//
		// Verify the Name TextField--
		boolean result = pagemanagementobj.initWelcomepage().getNametextfield().isDisplayed();

		Assert.assertTrue(result);
		test.log(Status.PASS, "Element verified: Name TextField is Displayed");

		// Step3:Perform Action--Clear
		pagemanagementobj.initWelcomepage().getNametextfield().clear();
		test.log(Status.PASS, "Step3:Clear Action done succesfully-NameTextField");

		// Step4:Perform Action--SendKeys
		pagemanagementobj.initWelcomepage().getNametextfield().sendKeys(username);
		test.log(Status.PASS, "Step4:SendKeys Action done succesfully-NameTextField");
		
		//See the execution
		JavaUtility.pause(3000);

		// Soft Assert statement
		SoftAssert softassertobj = new SoftAssert();

		//Step5: Verify the Contact us hyperlink
		softassertobj.assertEquals("Contact Us", pagemanagementobj.initWelcomepage().getContactus().getText());
		test.log(Status.PASS, "Step4: Verified text successfully-Contact Us Hyperlink");

		softassertobj.assertAll();
		
		
		test.log(Status.INFO, "Execution completed");

		/* --------------------------------------------------------------------------------------------------------------------------//
		// Verify the EmailTextField
		boolean result1 = pagemanagementobj.initWelcomepage().getEmailtextfield().isDisplayed();
		if (result1) {
			test.log(Status.PASS, "Email TextField is Displayed");
		} else {
			test.log(Status.PASS, "Email TextField is not Displayed");
		}
		// Step5:Perform Action--SendKeys
		pagemanagementobj.initWelcomepage().getEmailtextfield().sendKeys("prashanthchinthalapati@gmail.com");
		test.log(Status.PASS, "Step5:SendKeys Action done succesfully-EmailTextField");
		// ---------------------------------------------------------------------------------------------------------------------------//
		// Verify the PasswordTextField
		boolean result2 = pagemanagementobj.initWelcomepage().getPasswordtextfield().isDisplayed();
		if (result2) {
			Reporter.log("Password TextField is Displayed", true);
		} else {
			Reporter.log("Password TextField is not Displayed", true);
		}
		// Step6:Perform Action--SendKeys
		pagemanagementobj.initWelcomepage().getPasswordtextfield().sendKeys("Prashanth@25");
		Reporter.log("Step6:SendKeys Action done succesfully-PasswordTextField", true);
		// See the execution
		JavaUtility.pause(3000);
		// ---------------------------------------------------------------------------------------------------------------------------//
		// Verify the PasswordTextField
		boolean result3 = pagemanagementobj.initWelcomepage().getMobileNotextfield().isDisplayed();
		if (result3) {
			Reporter.log("Mobilenum TextField is Displayed", true);
		} else {
			Reporter.log("Mobilenum TextField is not Displayed", true);
		}
		// Step7:Perform Action--SendKeys
		pagemanagementobj.initWelcomepage().getMobileNotextfield().sendKeys("8464944599");
		Reporter.log("Step7:SendKeys Action done succesfully-MobileTextField", true);
		// --------------------------------------------------------------------------------------------------------------------------//
		// Verify the GenderField
		boolean result4 = pagemanagementobj.initWelcomepage().getGendermalefield().isDisplayed();
		if (result4) {
			Reporter.log("GenderField is Displayed", true);
		} else {
			Reporter.log("GenderField is not Displayed", true);
		}

		// Step8:Perform Action--Click
		pagemanagementobj.initWelcomepage().getGendermalefield().click();
		Reporter.log("Step8:Click Action done succesfully-GenderField", true);

		// -------------------------------------------------------------------------------------------------------------------------------//
		// Verify the PlacesField
		boolean result5 = pagemanagementobj.initWelcomepage().getPlacesbglrfield().isDisplayed();
		if (result5) {
			Reporter.log("PlaceField is Displayed", true);
		} else {
			Reporter.log("PlaceField is not Displayed", true);
		}

		// Step9:Perform Action--Undo click
		pagemanagementobj.initWelcomepage().getPlacesgoafield().click();
		Reporter.log("Step9:Undo Click Action done succesfully-GoaPlaceField", true);
		// Step10:Perform Action--Click
		pagemanagementobj.initWelcomepage().getPlacesbglrfield().click();
		Reporter.log("Step10:Click Action done succesfully-BanglorePlaceField", true);
		// -------------------------------------------------------------------------------------------------------------------------------//
		// Verify the CountryField
		boolean result6 = pagemanagementobj.initWelcomepage().getCountry().isDisplayed();
		if (result6) {

			Reporter.log("Country is Displayed", true);
		} else {
			Reporter.log("Country is not Displayed", true);
		}

		// Step11:Create Select object reference for country
		Select s1 = new Select(pagemanagementobj.initWelcomepage().getCountry());
		if (!s1.isMultiple()) {
			s1.selectByVisibleText("INDIA");
			Reporter.log("Step11:INDIA option is selected successfully", true);
		}
		// ---------------------------------------------------------------------------------------------------------------------------//
		// Verify the CountryField2
		boolean result7 = pagemanagementobj.initWelcomepage().getCountry2().isDisplayed();
		if (result7) {

			Reporter.log("Country2 is Displayed", true);
		} else {
			Reporter.log("Country2 is not Displayed", true);
		}

		// Step12:Create Select object reference for country2
		s1 = new Select(pagemanagementobj.initWelcomepage().getCountry2());
		if (s1.isMultiple()) {
			s1.selectByVisibleText("INDIA");
			s1.selectByVisibleText("AUSTRALIA");
			s1.selectByVisibleText("USA");
			Reporter.log("Step12:Options is selected successfully", true);
		}
		// ---------------------------------------------------------------------------------------------------------------------------//
		// Verify the FeedbackTextField
		boolean result8 = pagemanagementobj.initWelcomepage().getFeedback().isDisplayed();
		if (result8) {
			Reporter.log("Feedback Field is Displayed", true);
		} else {
			Reporter.log("Feedback Field is not Displayed", true);
		}

		// Step13:Perform Action--SendKeys
		pagemanagementobj.initWelcomepage().getFeedback().sendKeys("Prashanth is a good boy");
		Reporter.log("Step13:Perform Action done succesfully-FeedbackField", true);

		// ---------------------------------------------------------------------------------------------------------------------------//
		// Verify the FileuploadField
		boolean result9 = pagemanagementobj.initWelcomepage().getFileupload().isDisplayed();
		if (result9) {
			Reporter.log("Fileupload is Displayed", true);
		} else {
			Reporter.log("Fileupload is not Displayed", true);
		}

		// Step14:Perform Action--SendKeys
		pagemanagementobj.initWelcomepage().getFileupload()
				.sendKeys("C:/Users/DELL/Downloads/Chinthalapati_Prashanth_Resume.pdf");
		Reporter.log("Step14:Perform Action done succesfully-Fileupload", true);
		// -----------------------------------------------------------------------------------------------//
		// see the Execution
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// --------------------------------------------------------------------------------------------------------------------------//
		// Verify the DOBField
		boolean result10 = pagemanagementobj.initWelcomepage().getDateofbirth().isDisplayed();
		if (result10) {
			Reporter.log("DOB is Displayed", true);
		} else {
			Reporter.log("DOB is not Displayed", true);
		}

		// Step15:Perform Action--SendKeys
		pagemanagementobj.initWelcomepage().getDateofbirth().sendKeys("25-07-2000 / 22:10");
		Reporter.log("Step15:Perform Action done succesfully-DOB", true);

		// --------------------------------------------------------------------------------------------------------------------------//
		// Verify the RegisterField
		boolean result11 = pagemanagementobj.initWelcomepage().getRegister().isDisplayed();
		if (result11) {
			Reporter.log("Register is Displayed", true);
		} else {
			Reporter.log("Register is not Displayed", true);
		}

		// Step16:Perform Action--Click
		pagemanagementobj.initWelcomepage().getRegister().click();
		Reporter.log("Step16:Click Action done succesfully-Register", true);
		// --------------------------------------------------------------------------------------------------------------------------//
		// see the Execution
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// See the execution
		JavaUtility.pause(3000);
		*/

		// Execution Log or Status
		test.log(Status.PASS, "<----Execution completed succesfully--->");

	}

	@Test(priority = 2, invocationCount = 2, dependsOnMethods = "verifyWelcomepageWithValidInput")
	public void verifyWelcomepageWithInvalidInput() {

		// Create the Test Information
		test = report.createTest("verifyWelcomepageWithInValidInput");

		// Steps information
		test.log(Status.INFO, "Test Execution started successfully");

		// Execute the Precondition---->1.Launch the Browser,2.Navigate to URL
		test.log(Status.PASS, "<----Execution Starts succesfully-Test-2-->");

		// Implicit wait
		webdriverobj.WaitImplicitly(20);

		// Verify the Welcome Page Using title
		String exptitle = "Learning Selenium";
		String acttitle = webdriverobj.driver.getTitle();

		Assert.assertEquals(acttitle, exptitle);
		test.log(Status.PASS, "Title Verified" + acttitle);

		// Create an object for PageManager
		pagemanagementobj = new PageManagement(webdriverobj.driver);

		// ---------------------------------------------------------------------------------------------------------------------------------//
		// Verify the Name TextField--
		boolean result = pagemanagementobj.initWelcomepage().getNametextfield().isDisplayed();

		Assert.assertTrue(result);
		test.log(Status.PASS, "Element verified: Name TextField is Displayed");

		// Step3:Perform Action--Clear
		pagemanagementobj.initWelcomepage().getNametextfield().clear();
		test.log(Status.PASS, "Step3:Clear Action done succesfully-NameTextField");

		// Step4:Perform Action--SendKeys
		pagemanagementobj.initWelcomepage().getNametextfield().sendKeys("Pramodh");
		test.log(Status.PASS, "Step4:SendKeys Action done succesfully-NameTextField");

		// See the execution
		JavaUtility.pause(3000);

		// To make the explicit TestScript fail
		// Assert.fail();

		// Execute Post condition-->Terminate the browser
		// Execution Log or Status
		test.log(Status.PASS, "<----Execution completed succesfully--Testcase pass-->");

	}

}
