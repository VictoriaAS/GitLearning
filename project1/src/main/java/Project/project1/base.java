package Project.project1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.apache.maven.shared.utils.io.FileUtils;
public class base {
	WebDriver driver;
	Properties prop;
public WebDriver initializeDriver() throws IOException{
	 prop = new Properties();
	FileInputStream fis =new FileInputStream("C:\\Users\\PC\\eclipse-workspace\\project1\\src\\main\\java\\Project\\project1\\data.properties");
prop.load(fis);
String browserName =prop.getProperty("browser");
if (browserName.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver", "C:\\SeleniumTraining\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
}
else if (browserName.equals("firefox")){
	System.setProperty("webdriver.geckodriver.driver", "‪C:\\SeleniumTraining\\geckodriver.exe");
	 driver = new FirefoxDriver();
}
else if (browserName.equals("IE")) {
	System.setProperty("webdriver.IEdriver.driver", "C:\\SeleniumTraining\\IEDriverServer.exe");
	 driver = new InternetExplorerDriver();

}
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
driver.manage().window().maximize();

return driver;

}
public String getScreenshot(String testcasename,WebDriver driver) throws IOException {
	/*String screenName =System.currentTimeMillis()+".png";
	File ts =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
		FileHandler.copy(ts,new File(System.getProperty("user.dir")+"\\target\\screenshots\\"+screenName+""));
	}
	catch (IOException e) {
		System.out.println(e.getMessage());
	}
	//File source = ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
	
	//FileUtils.copyFile(ts,new File(destinationFile));*/
	TakesScreenshot ts =(TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;
}}