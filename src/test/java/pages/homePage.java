package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
	WebDriver driver;

	public homePage(WebDriver driver) {
		this.driver = driver;
	}

	// Locator for login button
	By LoginBtn = By.className("fa-sign-in-alt");
	By danceEventBtn = By.xpath("//*[@id=\"ctl00_CPMain_cGallery_Repeater1_ctl00_Div1\"]/a");
	
	// Method to click login button
	public void clickSignIn() {
		driver.findElement(LoginBtn).click();
	}
	
	public void clickDanceEvent() {
		driver.findElement(danceEventBtn).click();
	}

}
