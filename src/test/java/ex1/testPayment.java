package ex1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import files.fileReader;

public class testPayment {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeMethod
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		fileReader objExcelFile = new fileReader();
		objExcelFile.fileRead("C:\\Users\\user\\workspace3\\seleniumAutomation\\src\\test\\java\\files", "input.xls", "payment");
	}

	@AfterMethod
	public void tearDown() {
		 //driver.quit();
	}
	
	@Test
	public void testOrderTicket() {
	    // 1 | open | https://www.ticketor.com/demo | 
	    driver.get("https://www.ticketor.com/demo");
	    // 2 | setWindowSize | 1260x660 | 
	    driver.manage().window().setSize(new Dimension(1260, 660));
	    // 3 | mouseOver | linkText=ENG | 
	    {
	      WebElement element = driver.findElement(By.linkText("ENG"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    // 4 | runScript | window.scrollTo(0,197) | 
	    js.executeScript("window.scrollTo(0,197)");
	    // 5 | click | linkText=Tickets | 
	    driver.findElement(By.linkText("Tickets")).click();
	    // 6 | click | linkText=Select Date | 
	    driver.findElement(By.linkText("Select Date")).click();
	    // 7 | click | css=.monthly-week:nth-child(2) > .m-d:nth-child(3) .cCalendarEventTitle | 
	    driver.findElement(By.cssSelector(".monthly-week:nth-child(2) > .m-d:nth-child(3) .cCalendarEventTitle")).click();
	    // 8 | click | css=tr:nth-child(2) .editText | 
	    driver.findElement(By.cssSelector("tr:nth-child(2) .editText")).click();
	    // 9 | select | css=tr:nth-child(2) .editText | label=1
	    {
	      WebElement dropdown = driver.findElement(By.cssSelector("tr:nth-child(2) .editText"));
	      dropdown.findElement(By.xpath("//option[. = '1']")).click();
	    }
	    // 10 | click | css=.large | 
	    driver.findElement(By.cssSelector(".large")).click();
	    // 11 | click | linkText=Proceed to checkout | 
	    driver.findElement(By.linkText("Proceed to checkout")).click();
	    // 12 | click | css=tr:nth-child(1) .checkmark | 
	    driver.findElement(By.cssSelector("tr:nth-child(1) .checkmark")).click();
	    // 13 | click | id=ctl00_CPMain_FirstName | 
	    driver.findElement(By.id("ctl00_CPMain_FirstName")).click();
	    // 14 | click | id=ctl00_CPMain_LastName | 
	    driver.findElement(By.id("ctl00_CPMain_LastName")).click();
	    // 15 | click | id=ctl00_CPMain_cCountry | 
	    driver.findElement(By.id("ctl00_CPMain_cCountry")).click();
	    // 16 | click | css=.notFastModeCredit:nth-child(4) label | 
	    driver.findElement(By.cssSelector(".notFastModeCredit:nth-child(4) label")).click();
	    // 17 | click | id=ctl00_CPMain_cAddress1 | 
	    driver.findElement(By.id("ctl00_CPMain_cAddress1")).click();
	    // 18 | mouseDown | css=.hint:nth-child(5) | 
	    {
	      WebElement element = driver.findElement(By.cssSelector(".hint:nth-child(5)"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).clickAndHold().perform();
	    }
	    // 19 | mouseUp | css=.billing tr:nth-child(5) > .col2 | 
	    {
	      WebElement element = driver.findElement(By.cssSelector(".billing tr:nth-child(5) > .col2"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).release().perform();
	    }
	    // 20 | click | css=.billing tr:nth-child(5) > .col2 | 
	    driver.findElement(By.cssSelector(".billing tr:nth-child(5) > .col2")).click();
	    // 21 | click | css=.billing tr:nth-child(5) > .col2 | 
	    driver.findElement(By.cssSelector(".billing tr:nth-child(5) > .col2")).click();
	    // 22 | doubleClick | css=.billing tr:nth-child(5) > .col2 | 
	    {
	      WebElement element = driver.findElement(By.cssSelector(".billing tr:nth-child(5) > .col2"));
	      Actions builder = new Actions(driver);
	      builder.doubleClick(element).perform();
	    }
	    // 23 | click | css=.hint:nth-child(5) | 
	    driver.findElement(By.cssSelector(".hint:nth-child(5)")).click();
	    // 24 | click | css=.hint:nth-child(5) | 
	    driver.findElement(By.cssSelector(".hint:nth-child(5)")).click();
	    // 25 | doubleClick | css=.hint:nth-child(5) | 
	    {
	      WebElement element = driver.findElement(By.cssSelector(".hint:nth-child(5)"));
	      Actions builder = new Actions(driver);
	      builder.doubleClick(element).perform();
	    }
	    // 26 | click | id=ctl00_CPMain_cAddress1 | 
	    driver.findElement(By.id("ctl00_CPMain_cAddress1")).click();
	    // 27 | type | id=ctl00_CPMain_cAddress1 | 888 Street name
	    driver.findElement(By.id("ctl00_CPMain_cAddress1")).sendKeys("888 Street name");
	    // 28 | mouseDown | id=ctl00_CPMain_cAddress2 | 
	    {
	      WebElement element = driver.findElement(By.id("ctl00_CPMain_cAddress2"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).clickAndHold().perform();
	    }
	    // 29 | mouseUp | css=.notFastModeCredit:nth-child(7) > .col2 | 
	    {
	      WebElement element = driver.findElement(By.cssSelector(".notFastModeCredit:nth-child(7) > .col2"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).release().perform();
	    }
	    // 30 | click | css=.billing > tbody | 
	    driver.findElement(By.cssSelector(".billing > tbody")).click();
	    // 31 | click | id=ctl00_CPMain_cCity | 
	    driver.findElement(By.id("ctl00_CPMain_cCity")).click();
	    // 32 | type | id=ctl00_CPMain_cCity | LA
	    driver.findElement(By.id("ctl00_CPMain_cCity")).sendKeys("LA");
	    // 33 | click | id=ctl00_CPMain_cZip | 
	    driver.findElement(By.id("ctl00_CPMain_cZip")).click();
	    // 34 | type | id=ctl00_CPMain_cZip | 12345
	    driver.findElement(By.id("ctl00_CPMain_cZip")).sendKeys("12345");
	    // 35 | click | id=ctl00_CPMain_CellPhone | 
	    driver.findElement(By.id("ctl00_CPMain_CellPhone")).click();
	    // 36 | selectFrame | index=2 | 
	    driver.switchTo().frame(2);
	    // 37 | click | name=cardnumber | 
	    driver.findElement(By.name("cardnumber")).click();
	    // 38 | type | name=cardnumber | 4111 1111 1111 1111
	    driver.findElement(By.name("cardnumber")).sendKeys("4111 1111 1111 1111");
	    // 39 | type | name=exp-date | 01 / 29
	    driver.findElement(By.name("exp-date")).sendKeys("01 / 29");
	    // 40 | type | name=cvc | 123
	    driver.findElement(By.name("cvc")).sendKeys("123");
	    // 41 | selectFrame | relative=parent | 
	    driver.switchTo().defaultContent();
	    // 42 | click | id=ctl00_CPMain_Buy | 
	    driver.findElement(By.id("ctl00_CPMain_Buy")).click();
	    // 43 | mouseOver | id=ctl00_CPMain_Buy | 
	    {
	      WebElement element = driver.findElement(By.id("ctl00_CPMain_Buy"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    // 44 | mouseOut | id=ctl00_CPMain_Buy | 
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    // 45 | click | css=.primary:nth-child(1) | 
	    driver.findElement(By.cssSelector(".primary:nth-child(1)")).click();
	    // 46 | click | css=.checkmark:nth-child(3) | 
	    driver.findElement(By.cssSelector(".checkmark:nth-child(3)")).click();
	    // 47 | mouseOver | id=ctl00_CPMain_Buy | 
	    {
	      WebElement element = driver.findElement(By.id("ctl00_CPMain_Buy"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    // 48 | click | id=ctl00_CPMain_Buy | 
	    driver.findElement(By.id("ctl00_CPMain_Buy")).click();
	    // 49 | mouseOut | id=ctl00_CPMain_Buy | 
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    // 50 | click | css=.utility:nth-child(1) | 
	    driver.findElement(By.cssSelector(".utility:nth-child(1)")).click();

	}
}

/*
Credit card number: 4111-1111-1111-1111 (without dashes)

Expiration date: 01/2029

CVC: 123

Billing Zip code: 12345

Billing Address: Any address
*/
