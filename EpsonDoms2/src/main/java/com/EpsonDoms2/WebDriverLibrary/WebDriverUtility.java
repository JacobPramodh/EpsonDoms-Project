package com.EpsonDoms2.WebDriverLibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;




/**
 * This Class provides the Reusable Method To Perform All Browser Related Actions
 * 
 * 
 * @author LENOVO*/



public class WebDriverUtility {

	public static WebDriver driver_static;
	public WebDriver driver;
	public Select selectobj;
	public Actions actionobj;
	public Robot robotobj;
	public WebDriverWait wait;
	
	/**
	 * This Method Used To Launch The Specific Browser
	 * 
	 *@param Browser Name
	 *@return void*/
	public void launchBrowser(String browser) throws InterruptedException {
		Scanner s=new Scanner(System.in);
		
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver_static=driver;
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver_static=driver;
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver_static=driver;
			break;
			default:
				System.out.println("You have entered incorrect browser name");
				break;
			}
		}
				
/**
 * @param String url
 * @return void
 * This Method Is Used To Navigate To Particular Web Application*/
public  void NavigateToApplication(String url) {

driver.get(url);
}


/**
* @return void
* This Method Is Used To Maximize The Web Browser*/
public void maximizeTheBrowser() {
	driver.manage().window().maximize();
	
	
}


/**
* @return void
* This Method Is Used To Close All The Browsers*/
public void closeAllBrowsers() {
	driver.quit();
}


/**
* @param long duration
* @return void
* This Method Is Used For Implicitly Wait*/
public void WaitImplicitly(long duration) {
	driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
}


/**
* @param long duration
* @param WebElement element
* @return void
* This Method Is Used For Explicitly Wait*/

public  void waitExplicitly(long duration,WebElement element) {
	wait=new WebDriverWait(driver,duration);
	wait.until(ExpectedConditions.visibilityOf(element));
	}



/**
* @param WebElement element
* @param int index
* @return void
* This Method Is Used To Select The Option In DropDown */
public void selectOptioninDropdown(WebElement element,int index) {
	selectobj.selectByIndex(index);
}


/**
* @param WebElement element
* @param String VisibleText
* @return void
* This Method Is Used To Select The Option In DropDown */
public void selectOptioninDropdown(WebElement element,String visibletext) {
	selectobj.selectByVisibleText(visibletext);
}

/**
* String value
* @param WebElement element
* @return void
* This Method Is Used To Select The Option In DropDown */
public void selectOptioninDropdown(String value,WebElement element) {
selectobj.selectByValue(value);
}

/**
* @param WebElement element
* @return void
* This Method Is Used To Hover The Mouse To Particular WebElement */
public void mouseHovering(WebElement element) {
actionobj.moveToElement(element).perform();
}

/**
* @return void
* This Method Is Used To Perform Keyboard Action KeyPress On PageDown Key*/
public void pressTheKey() {
robotobj.keyPress(KeyEvent.VK_PAGE_DOWN);
}

/**
* @return void
* This Method Is Used To Perform Keyboard Action KeyRelease On PageDown Key*/
public void ReleaseTheKey() {
robotobj.keyRelease(KeyEvent.VK_PAGE_DOWN);
}


/**
* @return void
* This Method Is Used To Accept The Alert PoPuP */
public void alertPopupAccept() {
driver.switchTo().alert().accept();	
}

/**
* @return void
* This Method Is Used To Dismiss The Alert PoPuP */
public void alertPopupDismiss() {
driver.switchTo().alert().dismiss();
}

/**
* @return void
* @param int index
* This Method Is Used To Switch The Control TO Another Frame By Giving Index Value*/
public void switchControlToFrame(int index) {
driver.switchTo().frame(0);
}

/**
* @return void
* @param WebElement Element
* This Method Is Used To Switch The Control TO Another Frame By Giving WebElement Reference*/
public void switchControlToFrame(WebElement element) {
driver.switchTo().frame(element);
}

/**
* @return void
* This Method Is Used To Switch The Control TO Another Main Window Frame*/
public void switchBackControlToMain() {
driver.switchTo().defaultContent();
}

/**
* @return void
* @param String WindowAddress
* This Method Is Used To Switch The Control TO Another Window By Giving WindowId*/
public void switchControlToWindow(String windowaddress) {
driver.switchTo().window(windowaddress);
}

}
