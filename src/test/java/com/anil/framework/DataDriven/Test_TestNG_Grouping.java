package com.anil.framework.DataDriven;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_TestNG_Grouping {

	@BeforeTest
	public void beforeTest() {
		System.out.println("This is Before Test");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("This is Before Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is Before Method");
	}

	@Test(groups = { "Sedan", "BMW" })
	public void BMW3Series() {
		System.out.println("Running test - BMW3Series");
	}

	@Test(groups = { "SUV", "BMW" })
	public void BMWX3() {
		System.out.println("Running test - BMWX3");
	}

	@Test(dependsOnGroups = { "BMW" }, groups = { "Sedan", "Audi" })
	public void AudiA6() {
		System.out.println("Running test - AudiA6");
	}

	@Test(groups = { "Sedan", "Honda" })
	public void HondaAccord() {
		System.out.println("Running test - HondaAccord");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This is After Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This is After Class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("This is After Test");
	}

}
