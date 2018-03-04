package com.anil.framework.DataDriven;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Page.Classes.SearchPageWithOutDriver;
import Utilities.ExtentReportInit;

public class TestNG_DataDriver2 {
	
	WebDriver driver;
	ExtentReportInit report;
	String baseURL="https://www.expedia.com";
	SearchPageWithOutDriver SP;
	
	@Parameters("browserType")
	@BeforeClass
	public void before(String browser){
		if(browser.equalsIgnoreCase("Firefox")){
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/anair/Documents/Software/Selenium/chromedriver");
			driver = new ChromeDriver();
		}
		driver.get(baseURL);
		report = new ExtentReportInit("TestNG_DataDriver", false);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		SP = new SearchPageWithOutDriver(driver, report);
	}
	
	@DataProvider(name = "myData")
	public Object[][] inputdata(){
		return new Object[][] {{"Chicago", "Sydney", "10/01/2016", "12/01/2016"},
			{"Sydney", "New York", "10/01/2016", "12/01/2016"}};
	}
	
	@Test(dataProvider = "myData")
	public void searchFlightsWithMultiData(String origin, String dest,
			String depDate, String retDate) throws Exception {
		report.loggingINFO("Thread " + Thread.currentThread().getId() + " Has Started");
		SP.navigateToFlightsTab();
		SP.clearAllFields();
		Thread.sleep(3000);
		SP.fillOriginTextBox(origin);
		SP.fillDestinationTextBox(dest);
		SP.fillDepartureDateTextBox(depDate);
		SP.fillReturnDateTextBox(retDate);
		Thread.sleep(3000);
		report.loggingINFO("Search Flights With Multi Data Passed");
		report.loggingINFO("thread " + Thread.currentThread().getId() + " Has Finished");
	}
	
	@AfterClass
	public void after(){
		driver.quit();
		report.EndReporting();
	}

	

}
