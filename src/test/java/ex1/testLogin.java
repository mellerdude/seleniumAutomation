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

public class testLogin {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeMethod
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		fileReader objExcelFile = new fileReader();

		objExcelFile.fileRead("C:\\Users\\user\\workspace3\\seleniumAutomation\\src\\test\\java\\files", "input.xls", "login");
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
		password = String.valueOf(row.getCell(1).getNumericCellValue());
		password = password.substring(0, 5);
		Thread.sleep(3000);

		driver.findElement(By.className("fa-sign-in-alt")).click();
		driver.findElement(By.id("cLoginEmail")).sendKeys(email);
		driver.findElement(By.id("cLoginPassword")).sendKeys(password);

		driver.findElement(By.name("Login")).click();

	}
}