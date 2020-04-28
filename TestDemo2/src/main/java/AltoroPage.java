package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AltoroPage{
	private final String url = "http://www.testfire.net/login.jsp";
	private static WebDriver driver;
	/*
	 * Define input username
	 */
	@FindBy(id="uid")
	@CacheLookup
	private WebElement ALT_INPUT_NAME;	
	/*
	 * Define input password	 
	 */
	@FindBy(id="passw")
	@CacheLookup
	private WebElement ALT_INPUT_PASSW;
	
	/*
	 * Define submit button	
	 */
	@FindBy(name="btnSubmit")
	@CacheLookup
	private WebElement ALT_BUTTON_SUBMIT;
	
	public static WebDriver getDriver(){
        
        return driver;
    }
	
	public void Altoropage() {
		String driverPath = System.getProperty("user.dir")+"/IEDriverServer.exe";
    	System.setProperty("webdriver.ie.driver", driverPath);
		driver = new InternetExplorerDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void close() {
		driver.quit();
	}
	
	public void openUrl() {
		driver.get(url);
	}
	
	public ResultPage login() {
		ALT_INPUT_NAME.sendKeys("admin");
		ALT_INPUT_PASSW.sendKeys("admin");
		ALT_BUTTON_SUBMIT.click();
		return new ResultPage();
	}
}
