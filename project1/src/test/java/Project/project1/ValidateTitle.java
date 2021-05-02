package Project.project1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Landingpage;

public class ValidateTitle extends base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void getbrowser() throws IOException {
		driver = initializeDriver();
		log.info("driver is  started");
		
		driver.get(prop.getProperty("url"));
		log.info("site landing page is open");
		
	}
	@Test 
	public void homePageNavig() throws IOException {


Landingpage lP = new Landingpage(driver);
//compare the actual text with expected
Assert.assertEquals(lP.getTitle().getText(), "FEATURED COURSES");
log.info("title is present");
	}
@AfterTest
public void closeTest() {
	driver.close();
	log.info("getTitle test is completed");


}
}