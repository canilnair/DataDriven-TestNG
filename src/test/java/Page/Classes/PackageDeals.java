package Page.Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

public class PackageDeals {
	WebDriver driver;
	ExtentTest test;

	public PackageDeals(WebDriver driver) {
		this.driver = driver;
	}

	public void enterFlyingFrom(String fromCity) {
		WebElement from = driver.findElement(By.id("package-origin"));
		from.sendKeys(fromCity);
		WebElement flyingFrom = driver.findElement(By.cssSelector(".display-group-results"));

		List<WebElement> fromList = flyingFrom.findElements(By.xpath("//div[@class='display-group-results']/li//a"));

		for (int i = 0; i < fromList.size(); i++) {
			WebElement value = fromList.get(i);
			String Airport = value.getAttribute("data-value");
			System.out.println("Airport value : " + Airport);
			if (Airport.contains(fromCity)) {
				value.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			} else {
				System.out.println("Airport " + fromCity + " not found!");
			}

		}

	}

	public void enterFlyingTo(String toCity) throws Exception {
		WebElement input = driver.findElement(By.id("package-destination"));
		input.sendKeys(toCity);
		Thread.sleep(1000);
		List<WebElement> fromList = driver.findElements(By.xpath("//div[@class='display-group-results']/li/a"));

		for (int i = 0; i < fromList.size(); i++) {
			String value = fromList.get(i).getAttribute("data-value");
			System.out.println("To City found were: " + value);
			if (value.contains(toCity)) {
				fromList.get(i).click();
				break;
			} else {
				System.out.println("To City " + toCity + " not found!");
			}
		}

	}

}
