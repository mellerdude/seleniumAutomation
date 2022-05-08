package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ticketPage {
	WebDriver driver;

	public ticketPage(WebDriver driver) {
		this.driver = driver;
	}

	By skipBtn = By.className("monthly-next");
	By danceEventBtn = By.xpath("//*[@id=\"cCalendar\"]/div[3]/div[2]/div[3]/div[2]/a/div/p[1]");

	By findDropDown = By.cssSelector("tr:nth-child(2) .editText");
	By addToCart = By.cssSelector(".large");
	
	By proceedToPay = By.xpath("//*[@id=\"cAddedToCartPopup\"]/div[2]/a[1]");
	public void skipNextMonth() {
		driver.findElement(skipBtn).click();
	}

	public void pressEventTime() {
		driver.findElement(danceEventBtn).click();
	}

	public void clickNumTickets(int num) {
		String number = "'" + num + "'";
		driver.findElement(findDropDown).click();
		WebElement dropdown = driver.findElement(findDropDown);
		dropdown.findElement(By.xpath("//option[. = " + number + "]")).click();
	}
	
	public void clickAddToCart() {
		driver.findElement(addToCart).click();
	}
	
	public void clickProceedToPay() {
		driver.findElement(proceedToPay).click();
	}

}
