package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By signin=	By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]");

	By search=By.cssSelector("#twotabsearchtextbox");
	By search_enter=By.cssSelector("[type='submit']");
	By title=By.xpath("/html/body/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/h2/span");
	By navigate=By.cssSelector("#nav-xshop > a:nth-child(3)");
	
	
	public LandingPage(WebDriver driver) {


		this.driver=driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signin);
	}

	public WebElement getSearch() {
		return driver.findElement(search);
	}

	public WebElement getSearchEnter() {
		return driver.findElement(search_enter);}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getNavigate() {
		return driver.findElement(navigate);}

}
