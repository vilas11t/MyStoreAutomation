package pageObject_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemAddedToCartWindow {

public static WebDriver driver;
	
	public ItemAddedToCartWindow(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement itemAddedsuccessIcon() {
		return driver.findElement(By.xpath("//i[@class='icon-ok']"));
	}
	public WebElement proceedToCheckoutButton() {
		return driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
	}
	
	
	
}
