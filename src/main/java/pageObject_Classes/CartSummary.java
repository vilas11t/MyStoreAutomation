package pageObject_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartSummary {
public static WebDriver driver;
	
	public CartSummary(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement cartItem(String itemName) {
		return driver.findElement(By.xpath("//table[@id='cart_summary']//a[contains(text(),'"+itemName+"')]"));
	}
	public WebElement proceedToCheckoutButton() {
		return driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']"));
	}
	
}
