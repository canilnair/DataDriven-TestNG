
package Page.Classes;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExtentReportInit;

public class SearchPageWithOutDriver {
		WebDriver driver;
		WebElement element = null;
		Logger log = Logger.getLogger(SearchPageWithOutDriver.class);
		ExtentReportInit report;
		
		public SearchPageWithOutDriver(WebDriver driver, ExtentReportInit report){
			this.driver = driver;
			this.report = report;
		}
		
		/**
		 * Clear all the fields on the Search page
		 * @param driver
		 */
		public void clearAllFields() {
			driver.findElement(By.id("flight-origin")).clear();
			driver.findElement(By.id("flight-destination")).clear();
			driver.findElement(By.id("flight-departing")).clear();
			driver.findElement(By.id("flight-returning")).clear();
		}
		/**
		 * Returns the flight origin text box element
		 * @param driver
		 * @return
		 */
		public WebElement originTextBox() {
			element = driver.findElement(By.id("flight-origin"));
			log.info("Origin text box element found");
			report.loggingINFO("Origin text box element found");
			return element;
		}
		
		/**
		 * Fill origin city in origin text box
		 * @param driver
		 * @param origin
		 */
		public void fillOriginTextBox(String origin) {
			element = originTextBox();
			element.sendKeys(origin);
			log.info("Enter origin city as " + origin);
			report.loggingINFO("Enter origin city as " + origin);
		}

		/**
		 * Returns the flight destination text box element
		 * @param driver
		 * @return
		 */
		public WebElement destinationTextBox() {
			element = driver.findElement(By.id("flight-destination"));
			log.info("Destination text box element found");
			report.loggingINFO("Destination text box element found");
			return element;
		}
		
		/**
		 * Fill destination city in destination text box
		 * @param driver
		 * @param origin
		 */
		public void fillDestinationTextBox(String destination) {
			element = destinationTextBox();
			element.sendKeys(destination);
			log.info("Enter destination city as " + destination);
			report.loggingINFO("Enter destination city as " + destination);
		}

		/**
		 * Returns the departure date text box element
		 * @param driver
		 * @return
		 */
		public WebElement departureDateTextBox() {
			element = driver.findElement(By.id("flight-departing"));
			return element;
		}
		
		/**
		 * Fill departure date in departure date text box
		 * @param driver
		 * @param date
		 */
		public void fillDepartureDateTextBox(String date) {
			element = departureDateTextBox();
			element.sendKeys(date);
			log.info("Enter departure date as " + date);
			report.loggingINFO("Enter departure date as " + date);
		}

		/**
		 * Returns the return date text box element
		 * @param driver
		 * @return
		 */
		public WebElement returnDateTextBox() {
			element = driver.findElement(By.id("flight-returning"));
			return element;
		}
		
		/**
		 * Fill return date in return date text box
		 * @param driver
		 * @param date
		 */
		public void fillReturnDateTextBox(String date) {
			element = returnDateTextBox();
			element.clear();
			element.sendKeys(date);
			log.info("Enter return date as " + date);
			report.loggingINFO("Enter return date as " + date);
		}

		/**
		 * Returns the search button box element
		 * @param driver
		 * @return
		 */
		public WebElement searchButton() {
			element = driver.findElement(By.id("search-button"));
			return element;
		}

		/**
		 * Click on search button
		 * @param driver
		 */
		public void clickOnSearchButton() {
			element = searchButton();
			element.click();
		}
		
		/**
		 * Navigate to flights tab
		 * @param driver
		 */
		public void navigateToFlightsTab() {
			element = driver.findElement(By.id("header-account-menu"));
			element.click();
			element = driver.findElement(By.id("tab-flight-tab"));
			element.click();
			log.info("Navigate to flights tab");
			report.loggingINFO("Navigate to flights tab");
		}
		/**
		 * Click on Advanced Options link
		 * @param driver
		 */
		public void clickOnAdvancedLink() {
			element = driver.findElement(By.id("advanced-options"));
			element.click();
			log.info("Clicked on Advanced Options link");
			report.loggingINFO("Clicked on Advanced Options link");
		}
		/**
		 * Click non-stop check box
		 * @param driver
		 */
		public void clickNonStopCheckBox() {
			element = driver.findElement(By.id("advanced-flight-nonstop"));
			element.click();
			log.info("Clicked non-stop check box");
			report.loggingINFO("Clicked non-stop check box");
		}
		/**
		 * Select flight class
		 * @param driver
		 */
		public void selectFlightClass(String flightClass) {
			Select options = new Select(driver.findElement(By.id("flight-advanced-preferred-class")));
			options.selectByValue(flightClass);
			log.info("Select flight class as " + flightClass);
			report.loggingINFO("Select flight class as " + flightClass);
		}
		/**
		 * Click on Morning check box to filter the results
		 * @param driver
		 */
		public void clickMorningFlight() {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			
			WebElement xx = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='departureTimeList']//span[contains(text(), 'Morning')]//preceding-sibling::input"))); 
			xx.click();
			log.info("Clicked on Morning Time to filter the results");
			report.loggingINFO("Clicked on Morning Time to filter the results");
		}
		
}
