package amazon;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resource.Base;

public class SearchValidate extends Base{

	public static Logger log=LogManager.getLogger(Base.class.getName());
@BeforeTest
	
	public void initialize() throws IOException {
		driver=	intializeDriver();
		log.info("driver is intialized");
		
		driver.get(pro.getProperty("url"));
		log.info("Navigated to Home page" );
}
	
	@Test

	public void basePageNavigation() throws IOException {
		

		LandingPage lp= new LandingPage(driver);

		// hard coded
		lp.getSearch().sendKeys("Applie phone");


		lp.getSearchEnter().click();

		//Click the first search result item title

		WebElement firstItemTitleElement = driver.findElement(By.className("s-access-title"));
		String firstItemTitle = firstItemTitleElement.getText();
		firstItemTitleElement.click();

		//Verify product title

		assert (driver.findElement(By.id("productTitle")).getText().equals(firstItemTitle));

		//Click 'Add to cart' button
		driver.findElement(By.id("add-to-cart-button")).click();



		//Navigate to 'Cart' page

		driver.findElement(By.id("nav-cart")).click();



		//Verify item is displayed on Shopping Cart list
	//	assert (driver.findElement(By.className("a-list-item")).getText().contains(firstItemTitle));


	}
@AfterTest
	
	public void tearDown() {
		driver.close();
	}

}
