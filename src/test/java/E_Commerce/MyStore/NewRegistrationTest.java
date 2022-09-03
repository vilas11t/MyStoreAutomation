package E_Commerce.MyStore;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject_Classes.HomePage;
import pageObject_Classes.LoginPage;
import pageObject_Classes.RegistrationPage;

public class NewRegistrationTest extends Base{

	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public RegistrationPage registrationPage;
	public String testEmail="mystoreuser1@getnada.com";
	public JavascriptExecutor js;
	public Map<String, String> userRegistrationData;
	
	@BeforeClass
	void beforeClass() throws IOException {
		driver=driverInitialize();
		homePage=new HomePage(driver);
		loginPage=new LoginPage(driver);
		registrationPage=new RegistrationPage(driver);
		js=(JavascriptExecutor) driver;
		userRegistrationData=new HashMap<String, String>();
		userRegistrationData.put("title", "1");
		userRegistrationData.put("FirstName", "Rahul");
		userRegistrationData.put("LastName", "Patil");
		userRegistrationData.put("State", "Florida");
		
		driver.get(getProperty("baseUrl"));
	}
	
	
	@Test
	void verifyUserRegistration() throws InterruptedException {
		homePage.loginButton().click();
		loginPage.registrationEmail().sendKeys(testEmail);
		loginPage.createAccountButton().click();
		registrationPage.fillRegistrationData(userRegistrationData);
	}
	
	
	
	
	
	@AfterClass
	void afterClass() {
		//driver.close();
	}
	
}
