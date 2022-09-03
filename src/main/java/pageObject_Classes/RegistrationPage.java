package pageObject_Classes;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	
	public WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement titleCheckBox(String title) {
		// Note- To select Mr. - pass title 1 and to select Mrs pass title 2.
		return driver.findElement(By.xpath("//input[@id='id_gender1' and @value='"+title+"']"));
	}
	
	public WebElement firstName() {
		return driver.findElement(By.id("customer_firstname"));
	}
	
	public WebElement lastName() {
		return driver.findElement(By.id("customer_lastname"));
	}
	

	public WebElement stateDropdown() {
		return driver.findElement(By.xpath("//select[@id='id_state']"));
	}
	
	public void fillRegistrationData(Map<String,String> userdata) {
		titleCheckBox(userdata.get("title")).click();
		firstName().sendKeys(userdata.get("FirstName"));
		lastName().sendKeys(userdata.get("LastName"));
	}
	
	
	
	
	
	
	
	
}
