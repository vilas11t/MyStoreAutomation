package E_Commerce.MyStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
public static WebDriver driver;
public static File file;
public static FileInputStream fis;
public static Properties pos;
	
	public static WebDriver driverInitialize(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	public static String getProperty(String propertyName) throws IOException {
		file=new File(System.getProperty("user.dir")+"\\config.properties");
		fis=new FileInputStream(file);
		pos=new Properties();
		pos.load(fis);
		return pos.getProperty(propertyName);
	}

	
	
	
	
	
}
