package com.anil.framework.DataDriven;

import org.testng.annotations.AfterClass;
import Utilities.ExtentReportInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_TestNG_Prioritizing {
	
	ExtentReportInit report;

	@BeforeClass
	public void beforeClass() {
		report = new ExtentReportInit("Test_TestNG_Prioritizing", false);		
		System.out.println("This is Before Class");
		report.loggingINFO("Before Class Executed");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is Before Method");
		report.loggingINFO("Before Method Executed");
	}

	@Test(priority = 4)
	public void BMW3Series() {
		System.out.println("Running test 1 - BMW3Series");
		report.loggingPASS("Test BMW3Series PASSED and PRIORITY = 4");
	}

	@Test(priority = 3)
	public void BMWX3() {
		System.out.println("Running test 2 - BMWX3");
		report.loggingPASS("Test BMWX3 PASSED and PRIORITY = 3");
	}

	@Test(priority = 2, enabled = false)
	public void AudiA6() {
		System.out.println("Running test 3 - AudiA6");
		report.loggingPASS("Test AudiA6 PASSED and PRIORITY = 2");
	}

	@Test(priority = 1)
	public void HondaAccord() {
		System.out.println("Running test 4 - HondaAccord");
		report.loggingPASS("Test HondaAccord PASSED and PRIORITY = 1");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This is After Method");
		report.loggingINFO("AFTER Method Executed");
	}

	@AfterClass
	public void afterClass() {
		System.out.println(" ");
		System.out.println("This is After Class");
		System.out.println(" ");
		report.loggingINFO("AFTER CLASS Executed");
		report.loggingFAIL("THIS IS A FAIL MESSAGE");
		report.EndReporting();
	}

}
