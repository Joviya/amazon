package amazon;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resource.Base;

public class ValidateTitle extends Base{

@BeforeTest
	
	public void initialize() throws IOException {
		driver=	intializeDriver();
		
		
		driver.get(pro.getProperty("url"));
}
	
	
	@Test
	
	public void basePageNavigation() throws IOException {
	
	LandingPage lp= new LandingPage(driver);
	//System.out.println( lp.getTitle().getText());
	
	//Assert.assertEquals(lp.getTitle().getText(), "Deals for Mother's Day");
	
	}
	
@AfterTest
	
	public void tearDown() {
		driver.close();
	}
}
