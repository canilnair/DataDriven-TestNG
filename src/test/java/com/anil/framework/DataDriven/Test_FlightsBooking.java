package com.anil.framework.DataDriven;

import java.util.concurrent.TimeUnit;
import org.testng.reporters.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Page.Classes.PackageDeals;
import Utilities.ExtentReportInit;

public class Test_FlightsBooking {

	WebDriver driver;
	String baseURL = "https://www.expedia.com.au/";
	ExtentReportInit report;

	@BeforeClass
	public void MethodsetUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/anair/Documents/Software/Selenium/chromedriver");
		report = new ExtentReportInit("FlightsBooking", false);
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		report.loggingINFO("Browser started and page loaded...");
		report.test.log(LogStatus.INFO, "Browser started and page loaded...");
		Reporter.log("Before Class Run");

	}

	@Test
	public void packageDealsFlyingFromSelect() throws Exception {
		PackageDeals pD = new PackageDeals(driver);
		pD.enterFlyingFrom("New york");
		Thread.sleep(3000);
		report.loggingPASS("packageDealsFlyingFromSelect test method HAS PASSED");
		report.test.log(LogStatus.INFO, "packageDealsFlyingFromSelect test method is completed");
		Reporter.log("Test Method packageDealsFlyingFromSelect executed");

	}

	@Test
	public void packageDealsFlyingToSelect() throws Exception {
		PackageDeals PD = new PackageDeals(driver);
		PD.enterFlyingTo("sydney");
		Thread.sleep(2000);
		report.test.log(LogStatus.PASS, "packageDealsFlyingToSelect PASSED");
		report.test.log(LogStatus.INFO, "packageDealsFlyingToSelect test method is completed");
		Reporter.log("Test method packageDealsFlyingToSelect test method is completed");

	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
		report.test.log(LogStatus.INFO, "END OF TEST!.....");
		report.EndReporting();
		Reporter.log("Tear down method has been executed");
	}

}
