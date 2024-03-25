package stepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutStepDefinition {

	 public WebDriver driver;
	 public String landingPageProductName;
	 public String offerPageProductName;
	 TestContextSetup testContextSetup;
	public  CheckoutPage checkoutPage;
	 
	 public CheckoutStepDefinition(TestContextSetup testContextSetup) {
		 this.testContextSetup=testContextSetup;
			this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
	}
	 

@Then("Verify user has ability to enter promo code and place the order")
public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
	Assert.assertTrue(checkoutPage.VerifyPromoButton());
	Assert.assertTrue(checkoutPage.VerifyPlaceOrderButton());
}
	
	@Then ("^User proceeds to checkout and validate the (.+) Items in checkout page$")
		public void User_proceeds_to_checkout(String name) throws InterruptedException {
		checkoutPage.CheckOutItems();
	}
}
	
	