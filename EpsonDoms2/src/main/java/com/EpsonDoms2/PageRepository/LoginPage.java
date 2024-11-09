package com.EpsonDoms2.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
