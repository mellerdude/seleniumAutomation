package ex1;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.Select;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ticketorTests {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\omrim\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterMethod
	public void tearDown() {
		 //driver.quit();
	}
	
	@Test
	public void testOrderTicket() throws InterruptedException {
		driver.get("https://www.ticketor.com/demo/default");
		driver.manage().window().setSize(new Dimension(1024, 724));

		driver.findElement(By.xpath("//*[@id=\"ctl00_CPMain_cGallery_Repeater1_ctl00_Div1\"]/a")).click();
		driver.findElement(By.className("monthly-next")).click();
		driver.findElement(By.xpath("//*[@id=\"cCalendar\"]/div[3]/div[2]/div[3]/div[2]/a/div/p[1]")).click();
		
	    {
	      WebElement element = driver.findElement(By.cssSelector(".monthly-week:nth-child(2) > .m-d:nth-child(3) .cCalendarEventTitle"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    // 8 | mouseOut | css=.clearfix:nth-child(2) > .cCalendarEventTitle | 
	    
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    Thread.sleep(3000);
	    // 10 | click | css=tr:nth-child(2) .editText | 
	    driver.findElement(By.cssSelector("tr:nth-child(2) .editText")).click();
	    // 11 | select | css=tr:nth-child(2) .editText | label=1
	    {
	      WebElement dropdown = driver.findElement(By.cssSelector("tr:nth-child(2) .editText"));
	      dropdown.findElement(By.xpath("//option[. = '1']")).click();
	    }
	    // 12 | click | css=.large | 
	    driver.findElement(By.cssSelector(".large")).click();
	    // 13 | mouseOver | css=.large | 
	    {
	      WebElement element = driver.findElement(By.cssSelector(".large"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    // 14 | mouseOut | css=.large | 
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }

	}
}
