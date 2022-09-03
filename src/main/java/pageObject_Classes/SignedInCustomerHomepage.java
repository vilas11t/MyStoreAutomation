package pageObject_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignedInCustomerHomepage {
	
	public WebDriver driver;
	public SignedInCustomerHomepage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement userNameText() {
		return driver.findElement(By.xpath("//a[@title='View my customer account']//span"));
	}
	
	public WebElement productMenu(String MenuName) {
		return driver.findElement(By.xpath("//a[@title='"+MenuName+"']"));
	}
	
	

}
