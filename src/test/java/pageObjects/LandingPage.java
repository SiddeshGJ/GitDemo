package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;
	
	private By search= By.xpath("//input[@type='search']");
	private By productName=By.cssSelector("h4.product-name");
	private By topDeals= By.linkText("Top Deals");
	private By increment= By.xpath("//a[text()='+']");
	private By addToCart=By.xpath("//div/button[text()='ADD TO CART']");
	
	public LandingPage(WebDriver driver) {
		this.driver= driver;
	}

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchText() {
		driver.findElement(search).getText();
	}
	
   public String getProductName() {
	return driver.findElement(productName).getText();
	}
   
   public void selectTopDealsPage() {
	   driver.findElement(topDeals).click();
   }
   
   public String getTitleLandingPage() {
	   return  driver.getTitle();
	   }
   
   public void incrementQuantity(int quantity) {
	  int i=quantity-1;
	  while(i>0) {
		  driver.findElement(increment).click();
		  i--;
	  } 	 	
   }
	  public void addToCart() {
		    driver.findElement(addToCart).click();
		   }

}
