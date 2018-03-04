package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class HandleEvents implements WebDriverEventListener {
	
	ExtentReportInit report;
	
	public HandleEvents(ExtentReportInit report){
		this.report=report;
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("After Value Change of Element: "+element.toString());
		//report.loggingINFO("Value of Element " + element.toString() + " has been changed");
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Going to click on " + element.toString());
		//report.loggingINFO("Element " + element.toString() + " has been clicked");
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("After FindBy: ");
		//report.loggingINFO("Element " + element.toString() + " has been found");
		
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Before Chaging Value for: "+ element.toString());
		//report.loggingINFO("Element " + element.toString() + " value will now be changed");
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Before Click On: "+element.toString());
		//report.loggingINFO("Element " + element.toString() + " will be clicked now");
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Before FindBy: ");
		//report.loggingINFO("Element " + element.toString() + " will be searched and located now");
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		report.loggingINFO("Error has occured " + throwable.getMessage());
		
	}

}
