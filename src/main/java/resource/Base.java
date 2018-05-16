package resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public Properties pro;
	
	public WebDriver intializeDriver() throws IOException {
		
		pro=new Properties();
		FileInputStream fis=new FileInputStream("data.properties");
		pro.load(fis);
		
		String browserName=	pro.getProperty("browser");
	//	System.out.println(browserName);
		
		if(browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver","D:\\Selenium_Training\\chromedriver.exe ");
			driver= new ChromeDriver();

		}else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","D:\\Selenium_Training\\geckoDriver\\geckodriver.exe ");
			driver= new FirefoxDriver();
		}

		else if(browserName.equals("IE")) {
			//System.setProperty("webdriver.gecko.driver","D:\\Selenium_Training\\geckoDriver\\geckodriver.exe ");

		}
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
}
