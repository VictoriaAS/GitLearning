package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
public WebDriver driver;

By email =By.id("user_email");
By password= By.id("user_password");
By logButton = By.name("commit");
By forgotPassword =By.cssSelector("[href*='password/new']");


public loginPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
}
public ForgotPassword forgotPassword() {
	driver.findElement(forgotPassword).click();
	return new ForgotPassword(driver);
}
public WebElement enterEmail() {
	return driver.findElement(email);
}
public WebElement enterPassword() {
	return driver.findElement(password);
}


public WebElement clickLlogIn() {
	return driver.findElement(logButton);
}
}