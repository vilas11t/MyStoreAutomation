package pageObject_Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public static WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	
	public List<WebElement> HomePageMenu() {
		return driver.findElements(By.xpath("//div[@id='block_top_menu']/ul[1]/li/a"));
	}
	
	public List<WebElement> signInMenu() {
		return driver.findElements(By.xpath("//div[@id='block_top_menu']/ul[1]/li/a"));
	}
	
	public WebElement searchBox() {
		return driver.findElement(By.id("search_query_top"));
	}
	
	public WebElement loginButton() {
		return driver.findElement(By.xpath("//a[@class='login']"));
	}
	
	
	
	
}
