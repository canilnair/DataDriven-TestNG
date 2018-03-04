package com.anil.framework.DataDriven;

import java.lang.reflect.Method;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Page.Classes.SearchPage;

public class TestNG_MultiBrowserAndParallelTest {
	
	protected WebDriver driver;
	protected String baseURL = "https://www.expedia.com";
	StopWatch watch = new StopWatch();
	
	
	@Parameters("browserType")
	@BeforeClass
	public void before(String browserType){
		if(browserType.equalsIgnoreCase("Firefox")){
			driver = new FirefoxDriver();
		} else if (browserType.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/anair/Documents/Software/Selenium/chromedriver");
			driver = new ChromeDriver();
		} else {
			System.out.println("NO BROSWER TYPE Set");
		}	
	}
	
	
	@DataProvider(name="myData")
	public static Object[][] searchData() {
		return new Object[][] {{"New York", "Chicago", "10/28/2014", "10/31/2014"},
				{"New York", "Boston", "12/28/2014", "12/31/2014"}};
	}
	
	@Test(dataProvider="myData")
	public void searchFlightsWithMultiData(Method name, String origin, String dest,
			String depDate, String retDate) throws Exception {
		watch.start();
		driver.get(baseURL);	
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.clearAllFields(driver);
		Thread.sleep(3000);
		SearchPage.fillOriginTextBox(driver, origin);
		SearchPage.fillDestinationTextBox(driver, dest);
		SearchPage.fillDepartureDateTextBox(driver, depDate);
		SearchPage.fillReturnDateTextBox(driver, retDate);
		Thread.sleep(3000);
		double time =((double)watch.getTime()/1000)-6;
		watch.reset();
		System.out.println("Total time taken in seconds is : " + time +" to run " + name.getName());
	}

	@AfterClass
	public void quit(){
		driver.quit();
	}
	
	

}
