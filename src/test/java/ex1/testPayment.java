package ex1;

import java.io.IOException;
import org.apache.logging.log4j.*;
import pages.homePage;
import pages.loginPage;
import pages.ticketPage;
import pages.paymentPage;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
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
	Logger logger=LogManager.getLogger(testPayment.class);

	@BeforeMethod
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\omrim\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		fileReader objExcelFile = new fileReader();
		objExcelFile.fileRead(
				"C:\\Users\\omrim\\OneDrive - Afeka College Of Engineering\\Programming\\Java\\seleniumAutomation\\src\\test\\java\\files\\",
				"input.xls", "login");
		Logger logger=LogManager.getLogger(testPayment.class);

		driver.get("https://www.ticketor.com/demo/default");
		driver.manage().window().setSize(new Dimension(1024, 724));
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

	@Test
	public void testPayment() throws InterruptedException {
//	    // 1 | open | https://www.ticketor.com/demo | 
//	    driver.get("https://www.ticketor.com/demo");
//	    // 2 | setWindowSize | 1260x660 | 
//	    driver.manage().window().setSize(new Dimension(1260, 660));
//	    // 3 | mouseOver | linkText=ENG | 
//	    {
//	      WebElement element = driver.findElement(By.linkText("ENG"));
//	      Actions builder = new Actions(driver);
//	      builder.moveToElement(element).perform();
//	    }
//	    // 4 | runScript | window.scrollTo(0,197) | 
//	    js.executeScript("window.scrollTo(0,197)");
//	    // 5 | click | linkText=Tickets | 
//	    driver.findElement(By.linkText("Tickets")).click();
//	    // 6 | click | linkText=Select Date | 
//	    driver.findElement(By.linkText("Select Date")).click();
//	    // 7 | click | css=.monthly-week:nth-child(2) > .m-d:nth-child(3) .cCalendarEventTitle | 
//	    driver.findElement(By.cssSelector(".monthly-week:nth-child(2) > .m-d:nth-child(3) .cCalendarEventTitle")).click();
//	    // 8 | click | css=tr:nth-child(2) .editText | 
//	    driver.findElement(By.cssSelector("tr:nth-child(2) .editText")).click();
//	    // 9 | select | css=tr:nth-child(2) .editText | label=1
//	    {
//	      WebElement dropdown = driver.findElement(By.cssSelector("tr:nth-child(2) .editText"));
//	      dropdown.findElement(By.xpath("//option[. = '1']")).click();
//	    }
//	    // 10 | click | css=.large | 
//	    driver.findElement(By.cssSelector(".large")).click();
//	    // 11 | click | linkText=Proceed to checkout | 
//	    driver.findElement(By.linkText("Proceed to checkout")).click();
//	    // 12 | click | css=tr:nth-child(1) .checkmark | 
//	    driver.findElement(By.cssSelector("tr:nth-child(1) .checkmark")).click();
//	    // 13 | click | id=ctl00_CPMain_FirstName | 
//	    driver.findElement(By.id("ctl00_CPMain_FirstName")).click();
//	    // 14 | click | id=ctl00_CPMain_LastName | 
//	    driver.findElement(By.id("ctl00_CPMain_LastName")).click();
//	    // 15 | click | id=ctl00_CPMain_cCountry | 
//	    driver.findElement(By.id("ctl00_CPMain_cCountry")).click();
//	    // 16 | click | css=.notFastModeCredit:nth-child(4) label | 
//	    driver.findElement(By.cssSelector(".notFastModeCredit:nth-child(4) label")).click();
//	    // 17 | click | id=ctl00_CPMain_cAddress1 | 
//	    driver.findElement(By.id("ctl00_CPMain_cAddress1")).click();
//	    // 18 | mouseDown | css=.hint:nth-child(5) | 
//	    {
//	      WebElement element = driver.findElement(By.cssSelector(".hint:nth-child(5)"));
//	      Actions builder = new Actions(driver);
//	      builder.moveToElement(element).clickAndHold().perform();
//	    }
//	    // 19 | mouseUp | css=.billing tr:nth-child(5) > .col2 | 
//	    {
//	      WebElement element = driver.findElement(By.cssSelector(".billing tr:nth-child(5) > .col2"));
//	      Actions builder = new Actions(driver);
//	      builder.moveToElement(element).release().perform();
//	    }
//	    // 20 | click | css=.billing tr:nth-child(5) > .col2 | 
//	    driver.findElement(By.cssSelector(".billing tr:nth-child(5) > .col2")).click();
//	    // 21 | click | css=.billing tr:nth-child(5) > .col2 | 
//	    driver.findElement(By.cssSelector(".billing tr:nth-child(5) > .col2")).click();
//	    // 22 | doubleClick | css=.billing tr:nth-child(5) > .col2 | 
//	    {
//	      WebElement element = driver.findElement(By.cssSelector(".billing tr:nth-child(5) > .col2"));
//	      Actions builder = new Actions(driver);
//	      builder.doubleClick(element).perform();
//	    }
//	    // 23 | click | css=.hint:nth-child(5) | 
//	    driver.findElement(By.cssSelector(".hint:nth-child(5)")).click();
//	    // 24 | click | css=.hint:nth-child(5) | 
//	    driver.findElement(By.cssSelector(".hint:nth-child(5)")).click();
//	    // 25 | doubleClick | css=.hint:nth-child(5) | 
//	    {
//	      WebElement element = driver.findElement(By.cssSelector(".hint:nth-child(5)"));
//	      Actions builder = new Actions(driver);
//	      builder.doubleClick(element).perform();
//	    }
//	    // 26 | click | id=ctl00_CPMain_cAddress1 | 
//	    driver.findElement(By.id("ctl00_CPMain_cAddress1")).click();
//	    // 27 | type | id=ctl00_CPMain_cAddress1 | 888 Street name
//	    driver.findElement(By.id("ctl00_CPMain_cAddress1")).sendKeys("888 Street name");
//	    // 28 | mouseDown | id=ctl00_CPMain_cAddress2 | 
//	    {
//	      WebElement element = driver.findElement(By.id("ctl00_CPMain_cAddress2"));
//	      Actions builder = new Actions(driver);
//	      builder.moveToElement(element).clickAndHold().perform();
//	    }
//	    // 29 | mouseUp | css=.notFastModeCredit:nth-child(7) > .col2 | 
//	    {
//	      WebElement element = driver.findElement(By.cssSelector(".notFastModeCredit:nth-child(7) > .col2"));
//	      Actions builder = new Actions(driver);
//	      builder.moveToElement(element).release().perform();
//	    }
//	    // 30 | click | css=.billing > tbody | 
//	    driver.findElement(By.cssSelector(".billing > tbody")).click();
//	    // 31 | click | id=ctl00_CPMain_cCity | 
//	    driver.findElement(By.id("ctl00_CPMain_cCity")).click();
//	    // 32 | type | id=ctl00_CPMain_cCity | LA
//	    driver.findElement(By.id("ctl00_CPMain_cCity")).sendKeys("LA");
//	    // 33 | click | id=ctl00_CPMain_cZip | 
//	    driver.findElement(By.id("ctl00_CPMain_cZip")).click();
//	    // 34 | type | id=ctl00_CPMain_cZip | 12345
//	    driver.findElement(By.id("ctl00_CPMain_cZip")).sendKeys("12345");
//	    // 35 | click | id=ctl00_CPMain_CellPhone | 
//	    driver.findElement(By.id("ctl00_CPMain_CellPhone")).click();
//	    // 36 | selectFrame | index=2 | 
//	    driver.switchTo().frame(2);
//	    // 37 | click | name=cardnumber | 
//	    driver.findElement(By.name("cardnumber")).click();
//	    // 38 | type | name=cardnumber | 4111 1111 1111 1111
//	    driver.findElement(By.name("cardnumber")).sendKeys("4111 1111 1111 1111");
//	    // 39 | type | name=exp-date | 01 / 29
//	    driver.findElement(By.name("exp-date")).sendKeys("01 / 29");
//	    // 40 | type | name=cvc | 123
//	    driver.findElement(By.name("cvc")).sendKeys("123");
//	    // 41 | selectFrame | relative=parent | 
//	    driver.switchTo().defaultContent();
//	    // 42 | click | id=ctl00_CPMain_Buy | 
//	    driver.findElement(By.id("ctl00_CPMain_Buy")).click();
//	    // 43 | mouseOver | id=ctl00_CPMain_Buy | 
//	    {
//	      WebElement element = driver.findElement(By.id("ctl00_CPMain_Buy"));
//	      Actions builder = new Actions(driver);
//	      builder.moveToElement(element).perform();
//	    }
//	    // 44 | mouseOut | id=ctl00_CPMain_Buy | 
//	    {
//	      WebElement element = driver.findElement(By.tagName("body"));
//	      Actions builder = new Actions(driver);
//	      builder.moveToElement(element, 0, 0).perform();
//	    }
//	    // 45 | click | css=.primary:nth-child(1) | 
//	    driver.findElement(By.cssSelector(".primary:nth-child(1)")).click();
//	    // 46 | click | css=.checkmark:nth-child(3) | 
//	    driver.findElement(By.cssSelector(".checkmark:nth-child(3)")).click();
//	    // 47 | mouseOver | id=ctl00_CPMain_Buy | 
//	    {
//	      WebElement element = driver.findElement(By.id("ctl00_CPMain_Buy"));
//	      Actions builder = new Actions(driver);
//	      builder.moveToElement(element).perform();
//	    }
//	    // 48 | click | id=ctl00_CPMain_Buy | 
//	    driver.findElement(By.id("ctl00_CPMain_Buy")).click();
//	    // 49 | mouseOut | id=ctl00_CPMain_Buy | 
//	    {
//	      WebElement element = driver.findElement(By.tagName("body"));
//	      Actions builder = new Actions(driver);
//	      builder.moveToElement(element, 0, 0).perform();
//	    }
//	    // 50 | click | css=.utility:nth-child(1) | 
//	    driver.findElement(By.cssSelector(".utility:nth-child(1)")).click();
//
//	}
		String email = "";
		String password = "";

		Sheet theSheet = fileReader.getsheet();

		int rowCount = fileReader.getRowcount();

		Row row = theSheet.getRow(0);
		email = (row.getCell(0).getStringCellValue());
		logger.info("aquired email");
		password = String.valueOf(row.getCell(1).getNumericCellValue());
		password = password.substring(0, 5);
		logger.info("aquired password");

		//login
		logger.info("opening website");
		homePage home = new homePage(driver);
		home.clickSignIn();
		logger.info("clicked sign in");
		loginPage login = new loginPage(driver);
		login.postUserMail(email);
		logger.info("entered email");
		login.postUserPass(password);
		logger.info("entered password");
		login.clickLogin();
		logger.info("clicked login");
		//*[@id="ctl00_CPMain_cDeliveryMethods_ctl01_DeliveryMethod1_cDeliveryMethods"]/tbody/tr[1]/td/span/label/div/span[1]
		Thread.sleep(2000);

		//find event
		home.clickDanceEvent();
		ticketPage ticket = new ticketPage(driver);
		ticket.skipNextMonth();
		logger.info("skipping to next month events");
		ticket.pressEventTime();
		logger.info("pressing event time selected");
		Thread.sleep(1000);
		ticket.clickNumTickets(1);
		logger.info("selecting number of tickets");
		ticket.clickAddToCart();
		logger.info("adding ticket to cart");
		Thread.sleep(2000);
		ticket.clickProceedToPay();
		//pay for event
		paymentPage pay = new paymentPage(driver);
		//pay.acceptAgreement();
		pay.acceptEticket();
		pay.postAddress("Your House 1");
		pay.postCity("Tel Aviv");
		pay.postZip("12345");
		Thread.sleep(1000);
		pay.postCName("name names");
		Thread.sleep(1000);
		driver.manage().window().setSize(new Dimension(1260, 660));
		driver.switchTo().frame(2);
		Thread.sleep(1000);
	    // 20 | click | name=cardnumber | 
	    driver.findElement(By.name("cardnumber")).click();
	    Thread.sleep(1000);
	    // 21 | type | name=cardnumber | 1232 1312 3123 123
	    driver.findElement(By.name("cardnumber")).sendKeys("1232 1312 3123 123");
	    Thread.sleep(1000);
	    // 22 | click | name=exp-date | 
	    driver.findElement(By.name("exp-date")).click();
	    Thread.sleep(1000);
	    // 23 | type | name=exp-date | 11 / 11
	    driver.findElement(By.name("exp-date")).sendKeys("11 / 11");
	    Thread.sleep(1000);
	    // 24 | click | name=cvc | 
	    driver.findElement(By.name("cvc")).click();
	    Thread.sleep(1000);
	    // 25 | type | name=cvc | 112
	    driver.findElement(By.name("cvc")).sendKeys("112");
	    Thread.sleep(1000);
//		driver.switchTo().frame(2);
//		Thread.sleep(1000);
//		pay.postCNum("411111111111111");
//		Thread.sleep(1000);
//		pay.postCExp("01/29");
//		Thread.sleep(1000);
//		pay.postCDigits("123");
		
	}
}
/*
 * Credit card number: 4111-1111-1111-1111 (without dashes)
 * 
 * Expiration date: 01/2029
 * 
 * CVC: 123
 * 
 * Billing Zip code: 12345
 * 
 * Billing Address: Any address
 */
