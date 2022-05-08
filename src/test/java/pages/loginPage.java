package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	// Locator for user mail textbox
	By UserMailLocator = By.id("cLoginEmail");
	
	// Locator for password mail textbox
	By passwordLocator = By.id("cLoginPassword");
	
	By loginLocator = By.name("Login");
	
	By switchToSignUp = By.className("cSwitchToSignUp");

	// Method to write user mail
	public void postUserMail(String userMail) {
		driver.findElement(UserMailLocator).sendKeys(userMail);
	}

	// Method to write user password
	public void postUserPass(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
		
	}
	
	// Method to write user password
	public void clickLogin() {
		driver.findElement(loginLocator).click();
		
	}
	
	public void switchToSignUp() {
		driver.findElement(switchToSignUp).click();
		
	}

}