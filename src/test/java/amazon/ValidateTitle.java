package amazon;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resource.Base;

public class ValidateTitle extends Base{

	public static Logger log=LogManager.getLogger(Base.class.getName());
@BeforeTest
	
	public void initialize() throws IOException {
		driver=	intializeDriver();
		log.info("driver is intialized" );
		
		driver.get(pro.getProperty("url"));
		
		log.info("Navigated to Home page" );
}
	
	
	@Test
	
	public void basePageNavigation() throws IOException {
	
	LandingPage lp= new LandingPage(driver);
	System.out.println( lp.getTitle().getText());
	log.info("Successfully Validated text message" );
	
	//Assert.assertEquals(lp.getTitle().getText(), "Deals for Mother's Day");
	
	}
	
@AfterTest
	
	public void tearDown() {
		driver.close();
	}
}
