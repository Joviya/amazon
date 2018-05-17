package amazon;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resource.Base;

public class HomePage extends Base{
	public static Logger log=LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest

	public void initialize() throws IOException {
		
		
		driver=	intializeDriver();

	}


	@Test(dataProvider="getData")

	public void basePageNavigation(String Username,String password) throws IOException {

		driver.get(pro.getProperty("url"));
		log.info("driver is intialized" );

		LandingPage lp= new LandingPage(driver);
		lp.getLogin().click();
		//lp.getSearch().findElements("searc");

		LoginPage l= new LoginPage(driver);


		l.getEmail().sendKeys(Username);
		l.getPassword().sendKeys(password);

		log.info(Username);
		
		l.getLogin().click();
	}

	@AfterTest

	public void tearDown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="ValidUser.com";
		data[0][1]="123424443";

		// 2nd row
		data[1][0]="RestrictedUser.com";
		data[1][1]="gdttgggfd";

		return data;
	}



}
