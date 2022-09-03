package pageObject_Classes;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
	public WebDriver driver;
	public static Select select;
	
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
	
	public WebElement password() {
		return driver.findElement(By.id("passwd"));
	}
	
	public WebElement dayInDate() {
		return driver.findElement(By.xpath("//select[@id='days']"));
	}
	
	public WebElement monthInDate() {
		return driver.findElement(By.xpath("//select[@id='months']"));
	}
	public WebElement yearInDate() {
		return driver.findElement(By.xpath("//select[@id='years']"));
	}
	public WebElement company() {
		return driver.findElement(By.id("company"));
	}
	
	public WebElement address() {
		return driver.findElement(By.id("address1"));
	}
	
	public WebElement city() {
		return driver.findElement(By.id("city"));
	}
	
	public WebElement phoneMobile() {
		return driver.findElement(By.id("phone_mobile"));
	}
	
	public WebElement registerButton() {
		return driver.findElement(By.id("submitAccount"));
	}
	
	public WebElement stateDropdown() {
		return driver.findElement(By.xpath("//select[@id='id_state']"));
	}
	
	
	public WebElement countryDropdown() {
		return driver.findElement(By.xpath("//select[@id='id_country']"));
	}
	
	public WebElement postCode() {
		return driver.findElement(By.id("postcode"));
	}
	
	public void fillRegistrationData(Map<String,String> userdata) {
		titleCheckBox(userdata.get("title")).click();
		firstName().sendKeys(userdata.get("FirstName"));
		lastName().sendKeys(userdata.get("LastName"));
		password().sendKeys(userdata.get("password"));
		
		select=new Select(dayInDate());
		select.selectByValue(userdata.get("dayInDOB"));
		select=new Select(monthInDate());
		select.selectByValue(userdata.get("monthInDOB"));
		select=new Select(yearInDate());
		select.selectByValue(userdata.get("yearInDOB"));
		
		company().sendKeys(userdata.get("company"));
		address().sendKeys(userdata.get("address"));
		city().sendKeys(userdata.get("city"));
		
		select=new Select(stateDropdown());
		select.selectByValue(userdata.get("state"));
		
		select=new Select(countryDropdown());
		select.selectByValue(userdata.get("country"));

		postCode().sendKeys(userdata.get("pincode"));
		phoneMobile().sendKeys(userdata.get("mobilePhone"));
		
		
	}
	
	
	
	
	
	
	
	
}
