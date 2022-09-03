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
	
	public WebElement loginEmailId() {
		return driver.findElement(By.xpath("//input[@id='email']"));
	}
	
	public WebElement password() {
		return driver.findElement(By.xpath("//input[@id='passwd']"));
	}
	
	public WebElement signInSubmitButton() {
		return driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
	}
	
	
	public void login(String userEmail,String password) {
		loginEmailId().sendKeys(userEmail);
		password().sendKeys(password);
		signInSubmitButton().click();
	}

	
	

	
	
}
