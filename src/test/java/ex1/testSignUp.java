package ex1;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import files.fileReader;
import pages.homePage;
import pages.loginPage;
import pages.signupPage;

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
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class testSignUp {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeMethod
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\omrim\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		fileReader objExcelFile = new fileReader();
		objExcelFile.fileRead("C:\\Users\\omrim\\OneDrive - Afeka College Of Engineering\\Programming\\Java\\seleniumAutomation\\src\\test\\java\\files\\", "input.xls", "signUp");
	
	}

	@AfterMethod
	public void tearDown() {
		 //driver.quit();
	}

	@Test
	public void testSignUp() {
		driver.get("https://www.ticketor.com/demo/default");
		driver.manage().window().setSize(new Dimension(1024, 724));

		homePage home = new homePage(driver);
		home.clickSignIn();
		loginPage login = new loginPage(driver);
		login.switchToSignUp();
		signupPage signUp = new signupPage(driver);
		
		Random rand = new Random();
		String email = "";
		String pwd ="";
		String fName = "";
		String lName = "";
		
		Sheet theSheet = fileReader.getsheet();

		int rowCount = fileReader.getRowcount();

		Row row = theSheet.getRow(0);
		email = (row.getCell(0).getStringCellValue());
		fName = (row.getCell(1).getStringCellValue());
		lName = (row.getCell(2).getStringCellValue());
		pwd = String.valueOf(row.getCell(3).getNumericCellValue());
		pwd = pwd.substring(0, 5);

		signUp.postUserMail(email + String.valueOf(rand.nextInt(10000)) + "@gmail.com");
		signUp.postUserFName(fName);
		signUp.postUserLName(lName);
		signUp.acceptAgreement();
		signUp.postUserPass(pwd);
		signUp.clickSignUp();
	}

	protected String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}
}
