package E_Commerce.MyStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject_Classes.HomePage;

public class HomePageTest extends Base {
	
	public WebDriver driver;
	public HomePage homePage;
	
	
	@BeforeClass
	void beforeClass() throws IOException {
		driver=driverInitialize();
		homePage=new HomePage(driver);
		driver.get(getProperty("baseUrl"));
	}
	
	@Test()
	void verifyHomePageMenuTest() {
		List<String> HomePageMenu=new ArrayList<String>();
		HomePageMenu.add("WOMEN");
		HomePageMenu.add("DRESSES");
		HomePageMenu.add("T-SHIRTS");
		
		List<WebElement> Menus=homePage.HomePageMenu();
		
		for (int i = 0; i <Menus.size() ; i++) {
			Assert.assertEquals(Menus.get(i).getText(), HomePageMenu.get(i),"Menu is not as expected");
		}
		
	}
	
	@AfterClass
	void afterClass() {
		driver.close();
	}
	

}
