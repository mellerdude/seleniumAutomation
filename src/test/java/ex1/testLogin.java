package ex1;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import files.fileReader;

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
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import pages.homePage;
import pages.loginPage;
import org.apache.logging.log4j.*;
public class testLogin {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	Logger logger=LogManager.getLogger(testLogin.class);

	@BeforeMethod
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\omrim\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		fileReader objExcelFile = new fileReader();

		objExcelFile.fileRead("C:\\Users\\omrim\\OneDrive - Afeka College Of Engineering\\Programming\\Java\\seleniumAutomation\\src\\test\\java\\files\\", "input.xls", "login");
		driver.get("https://www.ticketor.com/demo/default");
		driver.manage().window().setSize(new Dimension(1024, 724));
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

	@Test
	public void testLogin() throws InterruptedException {

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
		Thread.sleep(1000);
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

	}
}