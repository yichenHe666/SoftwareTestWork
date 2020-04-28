package com.pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
	public ResultPage() {
		PageFactory.initElements(AltoroPage.getDriver(), this);		
	}
	
	@SuppressWarnings("deprecation")
	public void checkKeyWord() {
		WebDriver driver = AltoroPage.getDriver(); 
		String content = "Congratulations! ";	
		double status = 0;  
	    try {  
	        driver.findElement(By.xpath("//*[contains(.,'" + content + "')]"));  
	        System.out.println(content + " is appeard!");  
	        status = 1;  
	    } catch (Exception e) {  	        
	        System.out.println("'" + content + "' doesn't exist!");  
	    }
	    Assert.assertEquals(1, status);
	}
}
