package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	public WebDriver driver;
	
	private By cartBag= By.xpath("//img[@alt='Cart']");
	private By checkOutButton=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	private By promoButton= By.xpath("//button[text()='Apply']");
	private By placeOrderButton=By.xpath("//button[contains(text(),'Place Order')]");
	
	public CheckoutPage(WebDriver driver) {
		this.driver= driver;
	}

	public void CheckOutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public Boolean VerifyPromoButton() {
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public Boolean VerifyPlaceOrderButton() {
		return driver.findElement(placeOrderButton).isDisplayed();
	}
	
}