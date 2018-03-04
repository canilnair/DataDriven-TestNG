package com.anil.framework.DataDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Page.Classes.SearchPageWithOutDriver;
import Utilities.ExtentReportInit;

public class TestNG_DataDriver {
	
	WebDriver driver;
	ExtentReportInit report;
	String baseURL="https://www.expedia.com";
	SearchPageWithOutDriver SP;
	
	@BeforeClass
	public void before(){
		driver = new FirefoxDriver();
		driver.get(baseURL);
		report = new ExtentReportInit("TestNG_DataDriver", true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		SP = new SearchPageWithOutDriver(driver, report);
	}
	
	@DataProvider(name = "myData")
	public Object[][] dataSet(){
		return new Object[][] {{"Chicago", "Sydney", "10/01/2016", "12/01/2016"},
			{"Sydney", "New York", "10/01/2016", "12/01/2016"}};
	}
	
	@Parameters({"origin", "dest", "depDate", "retDate"})
	@Test
	public void searchFlights(String origin, String dest,
			String depDate, String retDate) throws Exception {
		SP.navigateToFlightsTab();
		SP.fillOriginTextBox(origin);
		SP.fillDestinationTextBox(dest);
		SP.fillDepartureDateTextBox(depDate);
		SP.fillReturnDateTextBox(retDate);
		report.loggingINFO("Search Flights Test Case Completed");
		report.loggingPASS("searchFlights TEST PASSED");
	}

	@Test(dataProvider = "myData")
	public void searchFlightsWithMultiData(String origin, String dest,
			String depDate, String retDate) throws Exception {
		SP.navigateToFlightsTab();
		SP.clearAllFields();
		Thread.sleep(3000);
		SP.fillOriginTextBox(origin);
		SP.fillDestinationTextBox(dest);
		SP.fillDepartureDateTextBox(depDate);
		SP.fillReturnDateTextBox(retDate);
		Thread.sleep(3000);
		report.loggingINFO("Search Flights With Multi Data Completed");
		report.loggingPASS("Search Flights With Multi Data PASSED");
	}
	
	@AfterClass
	public void after(){
		driver.quit();
		report.EndReporting();
	}

	

}
