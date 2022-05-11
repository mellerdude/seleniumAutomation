package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class paymentPage {
	WebDriver driver;

	public paymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By eTicketLocator = By.xpath("//*[@id=\"ctl00_CPMain_cDeliveryMethods_ctl01_DeliveryMethod1_cDeliveryMethods\"]/tbody/tr[1]/td/span/label/div/span[1]");
	By adressLocator = By.id("ctl00_CPMain_cAddress1");
	By cityLocator = By.id("ctl00_CPMain_cCity");
	By zipLocator = By.id("ctl00_CPMain_cZip");
	By cNameLocator = By.id("ctl00_CPMain_cCardHolderName");
	By cNumLocator = By.xpath("//*[@id=\"root\"]/form/div/div[2]/span[1]/span[2]/div/div[2]/span");
	By cExpLocator = By.name("exp-date");
	By cDigitsLocator = By.name("cvc");


	public void acceptEticket() {
		driver.findElement(eTicketLocator).click();
	}
	
	public void postAddress(String address) {
		driver.findElement(adressLocator).sendKeys(address);
	}

	public void postCity(String city) {
		driver.findElement(cityLocator).sendKeys(city);

	}
	
	public void postZip(String zip) {
		driver.findElement(zipLocator).sendKeys(zip);

	}
	
	public void postCName(String cName) {
		driver.findElement(cNameLocator).sendKeys(cName);

	}

	public void postCNum(String cNum) {
		driver.findElement(cNumLocator).sendKeys(cNum);;

	}
	
	public void postCExp(String exp) {
		driver.findElement(cExpLocator).sendKeys(exp);;

	}
	
	public void postCDigits(String digits) {
		driver.findElement(cDigitsLocator).sendKeys(digits);;

	}
	

	
//	public void clickSignUp() {
//		driver.findElement(signUpLocator).click();
//
//	}


}