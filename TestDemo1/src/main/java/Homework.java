package com.jju.TestDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import junit.framework.TestCase;


import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Homework extends TestCase {

	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		String driverPath = System.getProperty("user.dir")+"/IEDriverServer.exe";
    	System.setProperty("webdriver.ie.driver", driverPath);
		driver = new InternetExplorerDriver();
	}
	

	@Test	
	public void test_case1() throws Exception{
		
		driver.get("https://www.1905.com/");
//		driver.get("http://www.baidu.com/");
        
		Assert.assertEquals("电影网_1905.com",driver.getTitle());        
	}
	
	@Test
	public void test_case2() throws Exception{
		driver.get("https://www.1905.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("吴亦凡");
        searchBox.submit();
        Thread.sleep(2000);
       
        Set<String> windowHandles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for(String windowHandle:windowHandles) {
        	if (!currentHandle.equals(windowHandle)) {
        		driver.switchTo().window(windowHandle);
				
			}
        }
        
        System.out.println("1");
        System.out.println(driver.getTitle());
        Assert.assertEquals("搜索-电影网",driver.getTitle());
	}
	
	@Test
	public void test_case3() throws Exception{
		driver.get("https://www.1905.com/");
		WebElement loginLink = driver.findElement(By.linkText("电影号"));
        loginLink.click();
        Thread.sleep(2000);
        
        Set<String> windowHandles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for(String windowHandle:windowHandles) {
        	if (!currentHandle.equals(windowHandle)) {
        		driver.switchTo().window(windowHandle);
				
			}
        }
        
        System.out.println("2");
        System.out.println(driver.getTitle());
        Assert.assertEquals("电影资料库_1905电影网",driver.getTitle());
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Page title is:"+driver.getCurrentUrl());
		driver.quit();
	}

}
