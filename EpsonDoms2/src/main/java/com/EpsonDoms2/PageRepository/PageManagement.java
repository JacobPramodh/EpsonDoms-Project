package com.EpsonDoms2.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManagement {

	public WebDriver driver;
	public LoginPage loginpageobj;
	public RegisterPage registerpageobj;
	public WelcomePage welcomepageobj;

	// Initialization
	public PageManagement(WebDriver driver) {
		this.driver=driver;
	}

	public LoginPage initloginpage() {
		loginpageobj = new LoginPage(driver);
		return loginpageobj;
	}

	public RegisterPage initRegisterpage() {
		registerpageobj = new RegisterPage(driver);
		return registerpageobj;
	}

	public WelcomePage initWelcomepage() {
		welcomepageobj = new WelcomePage(driver);
		return this.welcomepageobj;
	}

}
