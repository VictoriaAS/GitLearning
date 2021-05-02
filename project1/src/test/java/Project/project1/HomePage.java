package Project.project1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.Landingpage;
import pageObjects.loginPage;



public class HomePage extends base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		//driver.get(prop.getProperty("url"));
		log.info("browser is started");
	}
	@Test (dataProvider="getData")
	public void homePageNavig(String email, String password,String text) throws IOException {

		driver.get(prop.getProperty("url"));
		log.info("site landing page is open");
Landingpage l = new Landingpage(driver);
//lP.getLogin().click();
//loginPage logP = new loginPage(driver);
loginPage lP =l.getLogin();
log.info("login page is oen");
lP.enterEmail().sendKeys(email);
lP.enterPassword().sendKeys(password);
lP.clickLlogIn().click();
log.info(text);

ForgotPassword fp =lP.forgotPassword();
fp.getEmail().sendKeys("test");
fp.sendMeInstructions().click();

}
	@DataProvider
	public Object[][] getData() {
		
		//row stands for how many different data type the test should run
		//column stands for how many values per test
		
		//0row
		Object[] [] data =new Object[2] [3];
		data[0] [0]="nonrestricted@email";
		data[0] [1]="pass";
		data[0] [2]="nonrestricteduser";
		//1st row
		data[1] [0]="restricted@email";
		data[1] [1]="restpass";
		data[1] [2]="restuser";	
		
		return data;
	}
		@AfterTest
		public void closeTest () {
			driver.close();
		}
}