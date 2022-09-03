package pageObject_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressUpdatePage {
	
	public static WebDriver driver;
	public static Select select;
	public AddressUpdatePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement addressSelection() {
		return driver.findElement(By.xpath("//select[@id='id_address_delivery']"));
	}
	
	void selectMyAddress() {
		select=new Select(addressSelection());
		select.selectByValue("741875");
	}
	
	public WebElement proceedToCheckou() {
		return driver.findElement(By.xpath("//button[@name='processAddress']"));
	}
	
	
}
