package pageObject_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {

public WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement payByBank() {
		return driver.findElement(By.xpath("//a[@title='Pay by bank wire']"));
	}
	
	public WebElement totalPrice() {
		return driver.findElement(By.xpath("//span[@id='total_price']"));
	}
	
	public WebElement paymentType() {
		return driver.findElement(By.xpath("//h3[@class='page-subheading']"));
	}
	
	public WebElement finalPrice() {
		return driver.findElement(By.xpath("//span[@id='amount']"));
	}
	
	public WebElement confirmOrderButton() {
		return driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']"));
	}
	
	public WebElement orderConfirmationheader() {
		return driver.findElement(By.xpath("//h1[contains(text(),'Order confirmation')]"));
	}
	
	public WebElement orderCompleteConfirmationMessage() {
		return driver.findElement(By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]"));
	}
	

	public WebElement backToOrder() {
		return driver.findElement(By.xpath("//a[@title='Back to orders']"));
	}
	
	
	
	
	
	
	
	
	
}
