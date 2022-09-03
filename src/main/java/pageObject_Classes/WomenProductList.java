package pageObject_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WomenProductList {
	public WebDriver driver;
	public Actions action;
	public WomenProductList(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement productName(String name) {
		return driver.findElement(By.xpath("//a[@class='product-name' and contains(text(),'"+name+"')]"));
	}
	
	public WebElement addTocartByproductName(String productName) {
		return driver.findElement(By.xpath("//a[@class='product-name' and contains(text(),'"+productName+"')]//parent::h5//following-sibling::div[2]//a[@title='Add to cart']"));
	}
	
  
	
	
	
}
