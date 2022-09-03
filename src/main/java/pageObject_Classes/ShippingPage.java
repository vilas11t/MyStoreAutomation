package pageObject_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPage {

public WebDriver driver;
	
	public ShippingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement termsOfServiceCheckbox() {
		return driver.findElement(By.xpath("//input[@type='checkbox']"));
	}
	
	public WebElement proceedToCheckout() {
		return driver.findElement(By.xpath("//button[@name='processCarrier']"));
	}
	
	
	
	
}
