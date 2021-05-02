package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
public WebDriver driver;
By signin =By.linkText("Login");
By title = By.className("text-center");
By navBar = By.cssSelector("nav.navbar-collapse");
public Landingpage(WebDriver driver) {
	this.driver=driver;
}
public loginPage getLogin() {
	
//return	driver.findElement(signin);
	driver.findElement(signin).click();
	loginPage lP =new loginPage(driver);
	return lP;
}
public WebElement getTitle() {
	return driver.findElement(title);
}
public WebElement navigationBar() {
	return driver.findElement(navBar);
}
}