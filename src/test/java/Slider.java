
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Slider {
	@Test
	public void slider() throws Exception{
		System.setProperty("webdriver.chrome.driver", "/Users/anair/Documents/Software/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.anz.com.au/personal/personal-loans/calculators-tools/repayments/");
		
		Actions slide = new Actions(driver);
		
		WebElement sliderbutton = driver.findElement(By.xpath(".//*[@id='loan']/div/div/div"));
		
		slide.dragAndDropBy(sliderbutton, 120, 0).perform();
		
		Thread.sleep(3000);
		
		WebElement loantype = driver.findElement(By.xpath("html/body/main/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/select"));
		
		Select select = new Select(loantype);
		
		List<WebElement> option = select.getOptions();
		
		for (int i=0;i<option.size();i++) {
			select.selectByIndex(i);
			Thread.sleep(2000);
		}
		
	}

}
