package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signupPage {
	WebDriver driver;

	public signupPage(WebDriver driver) {
		this.driver = driver;
	}
	By UserMailLocator = By.name("username");
	By firstName = By.name("LoginFirstName");
	By lastName = By.name("LoginLastName");
	By passwordLocator = By.id("cLoginPassword");
	By agreementLocator = By.xpath("//*[@id=\"ctl00_CPMain_cDeliveryMethods_ctl01_DeliveryMethod1_cDeliveryMethods\"]/tbody/tr[1]/td/span/label/div/span[1]");
	By signUpLocator = By.name("signUp");


	public void postUserMail(String userMail) {
		driver.findElement(UserMailLocator).sendKeys(userMail);
	}

	public void postUserFName(String name) {
		driver.findElement(firstName).sendKeys(name);

	}
	
	public void postUserLName(String name) {
		driver.findElement(lastName).sendKeys(name);

	}
	
	public void postUserPass(String password) {
		driver.findElement(passwordLocator).sendKeys(password);

	}

	public void acceptAgreement() {
		driver.findElement(agreementLocator).click();

	}
	
	public void clickSignUp() {
		driver.findElement(signUpLocator).click();

	}


}