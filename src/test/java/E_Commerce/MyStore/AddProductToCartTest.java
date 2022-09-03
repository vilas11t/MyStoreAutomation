package E_Commerce.MyStore;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject_Classes.HomePage;
import pageObject_Classes.ItemAddedToCartWindow;
import pageObject_Classes.LoginPage;
import pageObject_Classes.SignedInCustomerHomepage;
import pageObject_Classes.WomenProductList;

public class AddProductToCartTest extends Base {
	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public SignedInCustomerHomepage signedInCustomerHomepage;
	public ItemAddedToCartWindow itemAddedToCartWindow;
	public WomenProductList womenProductList;
	public String userLoggnedInHomepageTitle="My account - My Store";
	public String productName="Printed Dress";
	public Actions action;
	
	@BeforeClass
	void beforeClass() throws IOException {
		driver=driverInitialize();
		homePage=new HomePage(driver);
		loginPage=new LoginPage(driver);
		womenProductList=new WomenProductList(driver);
		itemAddedToCartWindow=new ItemAddedToCartWindow(driver);
		signedInCustomerHomepage=new SignedInCustomerHomepage(driver);
		driver.get(getProperty("baseUrl"));
		action=new Actions(driver); 
	}
	
	@Test()
	void verifyAddProductToCart() throws IOException {
			homePage.loginButton().click();
			loginPage.login(getProperty("user1"),getProperty("user1Password"));
			waiForElementVisibility(5,signedInCustomerHomepage.userNameText());
			Assert.assertEquals(driver.getTitle(), userLoggnedInHomepageTitle, "Loggned in User Home page title not matches");;
		
			signedInCustomerHomepage.productMenu("Women").click();
			waiForElementVisibility(5, womenProductList.productName(productName));
			action.moveToElement(womenProductList.productName(productName)).build().perform();
			waiForElementVisibility(5, womenProductList.addTocartByproductName(productName));
			womenProductList.addTocartByproductName(productName).click();
			waiForElementVisibility(5, itemAddedToCartWindow.itemAddedsuccessIcon());
			Assert.assertTrue(itemAddedToCartWindow.itemAddedsuccessIcon().isDisplayed(), "product not added to cart");
		
	}
	
	
	
	@AfterClass
	void afterClass() {
		//driver.close();
	}
	

}
