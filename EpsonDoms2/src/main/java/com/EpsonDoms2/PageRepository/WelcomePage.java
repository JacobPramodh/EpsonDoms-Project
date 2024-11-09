package com.EpsonDoms2.PageRepository;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WelcomePage {

	// Initialization
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration

	@FindBy(id = "name")
	private WebElement nametextfield;

	@FindBy(id = "email")
	private WebElement emailtextfield;

	@FindBy(id = "password")
	private WebElement passwordtextfield;

	@FindBy(id = "mobile")
	private WebElement MobileNotextfield;

	@FindBy(xpath = "//a[contains(text(),'Contact Us')]")
	private WebElement Contactus;

	@FindBy(xpath = "//input[@name='dob']")
	private WebElement dateofbirth;

	@FindBy(xpath = "//input[@id='male']")
	private WebElement Gendermalefield;

	@FindBy(xpath = "//input[@id='female']")
	private WebElement Genderfemalefield;

	@FindBy(xpath = "//input[@id='others']")
	private WebElement Genderothersfield;

	@FindBy(xpath = "//input[@id='bangalore']")
	private WebElement Placesbglrfield;

	@FindBy(xpath = "//input[@id='manali']")
	private WebElement Placesmnlirfield;

	@FindBy(xpath = "//input[@id='goa']")
	private WebElement Placesgoafield;

	@FindBy(xpath = "//input[@id='Kerala']")
	private WebElement PlacesKLfield;

	@FindBy(xpath = "//select[@name='country1']")
	private WebElement country;

	@FindBy(xpath = "//select[@name='country2']")
	private WebElement country2;

	@FindBy(xpath = "//textarea[@name='feedback']")
	private WebElement Feedback;

	@FindBy(xpath = "//input[@name='photo']")
	private WebElement Fileupload;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement Register;

	// Utilization
	public WebElement getNametextfield() {
		return nametextfield;
	}

	public WebElement getEmailtextfield() {
		return emailtextfield;
	}

	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}

	public WebElement getMobileNotextfield() {
		return MobileNotextfield;
	}

	public WebElement getContactus() {
		return Contactus;
	}

	public WebElement getDateofbirth() {
		return dateofbirth;
	}

	public WebElement getGendermalefield() {
		return Gendermalefield;
	}

	public WebElement getGenderfemalefield() {
		return Genderfemalefield;
	}

	public WebElement getGenderothersfield() {
		return Genderothersfield;
	}

	public WebElement getPlacesbglrfield() {
		return Placesbglrfield;
	}

	public WebElement getPlacesmnlirfield() {
		return Placesmnlirfield;
	}

	public WebElement getPlacesgoafield() {
		return Placesgoafield;
	}

	public WebElement getPlacesKLfield() {
		return PlacesKLfield;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getCountry2() {
		return country2;
	}

	public WebElement getFeedback() {
		return Feedback;
	}

	public WebElement getFileupload() {
		return Fileupload;
	}

	public WebElement getRegister() {
		return Register;
	}
}
