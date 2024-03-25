package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OffersPageStepDefinition {

	public  WebDriver driver;
	 public String landingPageProductName;
	 public String offerPageProductName;
	 TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	 
	
	 public OffersPageStepDefinition(TestContextSetup testContextSetup) {
		 this.testContextSetup=testContextSetup;
	 }
	 
	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
	
		switchToOffersPage();
		OffersPage offerspage=testContextSetup.pageObjectManager.offersPage();
	   offerspage.searchItem(shortName);
	   Thread.sleep(5000);
	    offerPageProductName=offerspage.getProductName(); 
	}
	
	public void switchToOffersPage() {
//		if switched to offerspage->skip the below part
//		if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"));
		
//		pageObjectManager=new PageObjectManager(testContextSetup.driver);
	   LandingPage landingpage=testContextSetup.pageObjectManager.getLandingPage();
	   landingpage.selectTopDealsPage();
	   testContextSetup.genericUtils.SwitchToWindowToChild();
		
		 
	}
	
	@Then("Validate product name in offerspage matches with Landing page")
	public void Validate_product_name_in_offerspage_matches_with_Landing_page() {
	Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}
}