package E_Commerce.MyStore;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject_Classes.HomePage;
import pageObject_Classes.LoginPage;
import pageObject_Classes.RegistrationPage;
import pageObject_Classes.SignedInCustomerHomepage;

public class NewRegistrationTest extends Base{

	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public RegistrationPage registrationPage;
	public SignedInCustomerHomepage signedInCustomerHomepage;
	public String testEmail="mystoreuser10@getnada.com";
	public JavascriptExecutor js;
	public Map<String, String> userRegistrationData;
	
	@BeforeClass
	void beforeClass() throws IOException {
		driver=driverInitialize();
		homePage=new HomePage(driver);
		loginPage=new LoginPage(driver);
		registrationPage=new RegistrationPage(driver);
		signedInCustomerHomepage=new SignedInCustomerHomepage(driver);
		js=(JavascriptExecutor) driver;
		
		userRegistrationData=new HashMap<String, String>();
		userRegistrationData.put("title", "1");
		userRegistrationData.put("FirstName", "Rahul");
		userRegistrationData.put("LastName", "Patil");
		userRegistrationData.put("password", "Pass@12345");
		userRegistrationData.put("dayInDOB", "15");
		userRegistrationData.put("monthInDOB", "11");
		userRegistrationData.put("yearInDOB", "1994");
		userRegistrationData.put("company", "IBM");
		userRegistrationData.put("address", "Karvenagar, Pune");
		userRegistrationData.put("city", "Pune");
		userRegistrationData.put("state", "9");
		userRegistrationData.put("country", "21");
		userRegistrationData.put("pincode", "00000");
		userRegistrationData.put("mobilePhone", "1234567890");
		
		driver.get(getProperty("baseUrl"));
	}
	
	
	@Test
	void verifyUserRegistration() throws InterruptedException {
		homePage.loginButton().click();
		loginPage.registrationEmail().sendKeys(testEmail);
		loginPage.createAccountButton().click();
		registrationPage.fillRegistrationData(userRegistrationData);
		registrationPage.registerButton().click();
		waiForElementVisibility(5,signedInCustomerHomepage.userNameText());
		Assert.assertEquals(signedInCustomerHomepage.userNameText().getText(),
				userRegistrationData.get("FirstName")+" "+userRegistrationData.get("LastName"), "Actual not matches with expected");
	}
	
	
	@AfterClass
	void afterClass() {
		//driver.close();
	}
	
}
