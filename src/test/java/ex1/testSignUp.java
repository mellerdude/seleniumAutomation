package ex1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import files.fileReader;
import pages.homePage;
import pages.loginPage;
import pages.signupPage;
public class testSignUp {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	Logger logger=LogManager.getLogger(testSignUp.class);
	@BeforeMethod
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\omrim\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		fileReader objExcelFile = new fileReader();
		
		objExcelFile.fileRead("C:\\Users\\omrim\\OneDrive - Afeka College Of Engineering\\Programming\\Java\\seleniumAutomation\\src\\test\\java\\files\\", "input.xls", "signUp");
		driver.get("https://www.ticketor.com/demo/default");
		driver.manage().window().setSize(new Dimension(1024, 724));
	}

	@AfterMethod
	public void tearDown() {
		 //driver.quit();
	}

	@Test
	public void testSignUp() {
		logger.info("aquired email");
		homePage home = new homePage(driver);
		home.clickSignIn();
		logger.info("clicked sign in");
		loginPage login = new loginPage(driver);
		login.switchToSignUp();
		logger.info("switched to sign up");
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
		logger.info("aquired email");
		fName = (row.getCell(1).getStringCellValue());
		logger.info("aquired fname");
		lName = (row.getCell(2).getStringCellValue());
		logger.info("aquired lname");
		pwd = String.valueOf(row.getCell(3).getNumericCellValue());
		pwd = pwd.substring(0, 5);
		logger.info("aquired password");

		signUp.postUserMail(email + String.valueOf(rand.nextInt(10000)) + "@gmail.com");
		logger.info("entered user email");
		signUp.postUserFName(fName);
		logger.info("entered user first name");
		signUp.postUserLName(lName);
		logger.info("entered user last name");
		signUp.acceptAgreement();
		logger.info("accepted agreement");
		signUp.postUserPass(pwd);
		logger.info("entered user password");
		signUp.clickSignUp();
		logger.info("clicked sign up");
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
