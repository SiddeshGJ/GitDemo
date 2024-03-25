package stepDefinitions;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

	 public WebDriver driver;
	 public String landingPageProductName;
	 public String offerPageProductName;
	 TestContextSetup testContextSetup;
	 LandingPage landingpage;
	 
	 public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		 this.testContextSetup=testContextSetup;
		 this.landingpage=testContextSetup.pageObjectManager.getLandingPage();
	 }
	 
	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(landingpage.getTitleLandingPage().contains("GreenKart"));
	}
		
	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void user_serached_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		landingpage.searchItem(shortName);
	    Thread.sleep(5000);
	    testContextSetup.landingPageProductName=landingpage.getProductName().split("-")[0].trim();
	    System.out.println(landingPageProductName + " is extracted from Home page");
	    }
	
	@When ("Added {string} items of the selected product to cart")
	public void Added_Items_of_the_selected_product_to_cart(String quantity) {
		landingpage.incrementQuantity(Integer.parseInt(quantity));
		landingpage.addToCart();
	}
}
	
	