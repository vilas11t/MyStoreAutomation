package E_Commerce.MyStore;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject_Classes.AddressUpdatePage;
import pageObject_Classes.CartSummary;
import pageObject_Classes.HomePage;
import pageObject_Classes.ItemAddedToCartWindow;
import pageObject_Classes.LoginPage;
import pageObject_Classes.PaymentPage;
import pageObject_Classes.ShippingPage;
import pageObject_Classes.SignedInCustomerHomepage;
import pageObject_Classes.WomenProductList;

public class EndToEndProductOrderTest extends Base {

	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public SignedInCustomerHomepage signedInCustomerHomepage;
	public ItemAddedToCartWindow itemAddedToCartWindow;
	public CartSummary cartSummary;
	public AddressUpdatePage addressUpdatePage;
	public WomenProductList womenProductList;
	public ShippingPage shippingPage;
	public PaymentPage paymentPage;
	public String userLoggnedInHomepageTitle="My account - My Store";
	public String productName="Printed Dress";
	public Actions action;
	public Select select;
	
	@BeforeClass
	void beforeClass() throws IOException {
		driver=driverInitialize();
		homePage=new HomePage(driver);
		loginPage=new LoginPage(driver);
		womenProductList=new WomenProductList(driver);
		itemAddedToCartWindow=new ItemAddedToCartWindow(driver);
		signedInCustomerHomepage=new SignedInCustomerHomepage(driver);
		cartSummary=new CartSummary(driver);
		addressUpdatePage=new AddressUpdatePage(driver);
		shippingPage=new ShippingPage(driver);
		paymentPage=new PaymentPage(driver);
		driver.get(getProperty("baseUrl"));
		action=new Actions(driver); 
	}
	
	@Test()
	void verifyAddProductToCart() throws IOException {
			homePage.loginButton().click();
			loginPage.login(getProperty("user1"),getProperty("user1Password"));
			waiForElementVisibility(5,signedInCustomerHomepage.userNameText());
			Assert.assertEquals(driver.getTitle(), userLoggnedInHomepageTitle, "Loggned in User Home page title not matches");;
		
			//Signed in
			signedInCustomerHomepage.productMenu("Women").click();
			waiForElementVisibility(5, womenProductList.productName(productName));
			
			//Add product to cart
			action.moveToElement(womenProductList.productName(productName)).build().perform();
			waiForElementVisibility(5, womenProductList.addTocartByproductName(productName));
			womenProductList.addTocartByproductName(productName).click();
			waiForElementVisibility(5, itemAddedToCartWindow.itemAddedsuccessIcon());
			Assert.assertTrue(itemAddedToCartWindow.itemAddedsuccessIcon().isDisplayed(), "product not added to cart");
			itemAddedToCartWindow.proceedToCheckoutButton().click();
			
			//Cart Summary-proceed to checkout
			cartSummary.proceedToCheckoutButton().click();
			
			//Address Selection
			addressUpdatePage.addressSelection();
			addressUpdatePage.proceedToCheckou().click();
			
			//shipping- accept terms of service
			shippingPage.termsOfServiceCheckbox().click();
			shippingPage.proceedToCheckout().click();
			
			// Payment
			paymentPage.payByBank().click();
			paymentPage.confirmOrderButton().click();
			Assert.assertTrue(paymentPage.orderConfirmationheader().isDisplayed(), "Order not completed successfully");
			Assert.assertTrue(paymentPage.orderCompleteConfirmationMessage().isDisplayed(), "Order Completed success message not display");
	}
	
	@AfterClass
	void afterClass() {
		driver.close();
	}
	
	

}
