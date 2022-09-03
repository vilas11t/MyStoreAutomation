package pageObject_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement registrationEmail() {
		return driver.findElement(By.xpath("//input[@id='email_create']"));
	}
	
	public WebElement createAccountButton() {
		return driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
	}

	
	
}
