package testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageobject.Login;



public class baseclass {
	public static  WebDriver driver ;
	public static Login login;
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
	 //URL
	    String baseUrl = "https://practicetestautomation.com/practice-test-login/";
	    
	  // browser
	        driver = new ChromeDriver();
//	        driver = new FirefoxDriver();
//	        driver = new EdgeDriver();
	      //Maximize the Browser window
			driver.manage().window().maximize();
			
			//delete All the cookies
//			driver.manage().deleteAllCookies();
			
			//sets an amount of time to wait for a page load to complete before throwing an error
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			//to tell webdrive to poll the DOM for a certain amount of time when trying to find an element if they are not immediately available
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	 // Launching browser 
	        driver.get(baseUrl);
//	        Thread.sleep(3000);
	        login=new Login();
	       
  }
	
	@AfterMethod
	 public void afterMethod(ITestResult result) throws IOException, InterruptedException {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getName());
        }
//        Thread.sleep(2000);
        driver.close();
    }

    public void takeScreenshot(String methodName) throws IOException {
        // Generate a timestamp for unique file naming
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

        // Take screenshot and store as a file format
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("E:\\abc\\login\\ScreenShot\\" + methodName + "_" + timestamp + ".png");
        FileUtils.copyFile(srcFile, destFile);
    }
    
    public void login() {
    	login.EnterEmailOnLoginPage("student");
    	login.EnterPasswordOnLoginPage("Password123");
    	login.ClickLoginButton();
    }

}
