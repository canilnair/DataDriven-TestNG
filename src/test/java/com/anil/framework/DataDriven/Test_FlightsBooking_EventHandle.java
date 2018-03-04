package com.anil.framework.DataDriven;

import java.util.concurrent.TimeUnit;
import org.testng.reporters.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Page.Classes.PackageDeals;
import Page.Classes.SearchPage;
import Utilities.ExtentReportInit;
import Utilities.HandleEvents;

public class Test_FlightsBooking_EventHandle {

	WebDriver wdriver;
	String baseURL = "https://www.expedia.com/";
	ExtentReportInit report;
	EventFiringWebDriver driver;
	HandleEvents handleEvents;

	@BeforeClass
	public void MethodsetUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/anair/Documents/Software/Selenium/chromedriver");
		report = new ExtentReportInit("FlightsBooking", true);
		wdriver = new ChromeDriver();
		driver = new EventFiringWebDriver(wdriver);
		handleEvents = new HandleEvents(report);
		driver.register(handleEvents);
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@DataProvider(name="myData")
	public static Object[][] searchData() {
		return new Object[][] {{"New York", "Chicago", "10/28/2014", "10/31/2014"},
				{"New York", "Boston", "12/28/2014", "12/31/2014"}};
	}

	@Test(dataProvider = "myData")
	public void packageDealsFlyingFromSelect(String origin, String dest, String depDate, 
			String retDate) throws Exception {
		
			SearchPage.navigateToFlightsTab(driver);
			SearchPage.clearAllFields(driver);
			Thread.sleep(3000);
			SearchPage.fillOriginTextBox(driver, origin);
			SearchPage.fillDestinationTextBox(driver, dest);
			SearchPage.fillDepartureDateTextBox(driver, depDate);
			SearchPage.fillReturnDateTextBox(driver, retDate);
			Thread.sleep(3000);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
		report.test.log(LogStatus.INFO, "END OF TEST!.....");
		report.EndReporting();

	}

}
