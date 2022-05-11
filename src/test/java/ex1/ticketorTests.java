package ex1;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.homePage;
import pages.ticketPage;
public class ticketorTests {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	Logger logger=LogManager.getLogger(ticketorTests.class);
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\omrim\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		driver.get("https://www.ticketor.com/demo/default");
		driver.manage().window().setSize(new Dimension(1024, 724));

	}
	

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

	@Test
	public void testOrderTicket() throws InterruptedException {
		logger.info("opening webiste");
		homePage home = new homePage(driver);
		home.clickDanceEvent();
		logger.info("clicking on event");
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
	}
}
