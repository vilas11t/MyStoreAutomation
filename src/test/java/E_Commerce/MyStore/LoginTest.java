package E_Commerce.MyStore;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject_Classes.HomePage;
import pageObject_Classes.LoginPage;
import pageObject_Classes.SignedInCustomerHomepage;

public class LoginTest extends Base{
	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public SignedInCustomerHomepage signedInCustomerHomepage;
	public String userFirstName="Rahul";
	public String userLastName="Patil";
	public String userLoggnedInHomepageTitle="My account - My Store";
	@BeforeClass
	void beforeClass() throws IOException {
		driver=driverInitialize();
		homePage=new HomePage(driver);
		loginPage=new LoginPage(driver);
		signedInCustomerHomepage=new SignedInCustomerHomepage(driver);
		driver.get(getProperty("baseUrl"));
	}
	
	@Test()
	void verifyLoginWithValidUser() throws IOException {
		homePage.loginButton().click();
		loginPage.login(getProperty("user1"),getProperty("user1Password"));
		waiForElementVisibility(5,signedInCustomerHomepage.userNameText());
		Assert.assertEquals(driver.getTitle(), userLoggnedInHomepageTitle, "Loggned in User Home page title not matches");;
		Assert.assertEquals(signedInCustomerHomepage.userNameText().getText(),
				userFirstName+ " " +userLastName, "User not loggned in successfully");
	}
	
	
	@AfterClass
	void afterClass() {
		driver.close();
	}
	


}
