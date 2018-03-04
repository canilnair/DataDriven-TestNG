package com.anil.framework.DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.ExtentReportInit;

public class multithreaded_anil {
	
	WebDriver driver;
	ExtentReportInit report;
	String url1 = "http://www.google.com";
	
	@Parameters("browserType")
	@BeforeClass()
	public void before(String browser){
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrom.driver", "/Users/anair/Documents/Software/Selenium/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		} else {
			System.out.println("No Brower Type Specified");
		}
		
		report = new ExtentReportInit("multithreaded", false);
	}
	
	@Test
	public void googleTest() throws Exception{
		report.loggingINFO("Thread " + Thread.currentThread().getId() + " has started");
		report.loggingINFO("Google Test Has STARTED");
		driver.get(url1);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".gb_Ic.gb_Zc")).click();
		driver.findElement(By.cssSelector("#sb_ifc0")).click();
		driver.findElement(By.cssSelector("#lst-ib")).sendKeys("Java multi-threading");
		Thread.sleep(2000);
		report.loggingINFO("Google Test has FINISHED");
		report.loggingINFO("Thread " + Thread.currentThread().getId() + "has Ended");
	}
	
	@AfterClass
	public void after(){
		driver.quit();
		report.EndReporting();
	}

}
