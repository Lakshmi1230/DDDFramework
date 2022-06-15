package com.vcentry.lab.testBase;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vcentry.lab.Pages.HomePage;
import com.vcentry.lab.Pages.LoginPage;
import com.vcentry.lab.Pages.UserPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public LoginPage loginPage;
	public HomePage homepage;
	public UserPage users;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
	public static ExtentTest  test;
	public static Logger log=LogManager.getLogger(BaseClass.class);
	public static void initializer(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);

		}
}
        public static boolean validateTest(boolean excepted){
        	boolean result=false;
        	try{
        		
        	          	Assert.assertTrue(excepted);
        	          	result =true;
        	          	test.createNode("Assert fail,this text is Present");
        		
        	}catch(Exception e) {
        		test.createNode("Assert fail,this text is Not Present");
        		Assert.assertTrue(false);
        		
        	}
        	return result;
        	}
        
	
	public static String getCurrentDataTime(){
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_ HHmmss");  
		   LocalDateTime now = LocalDateTime.now();  
		   String date=dtf.format(now);
		   return date;
		  }    

	
    public static String Screenshot() {
    	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	String destination=System.getProperty("user.dir")+"/target/screenshot _"+getCurrentDataTime()+".png";
        try {
			FileHandler.copy(srcFile, new  File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
		return destination;
    	
    }
	
    public static void selectVisibleText(String data,WebElement element){
    	try{
    	Select s=new Select(element);
    	test.createNode(data+ "is selected");
    		
    	}catch(Exception e){
    		test.createNode(e.getMessage());
    		test.log(Status .FAIL,e.getMessage());
    		
    	}
    	
    			}
	@BeforeTest
	public void openBrowser() {
		try{
			System.out.println("beforetest");
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		initializer("chrome");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	@BeforeClass
	public void launchUrl() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage=new LoginPage(driver);
	   homepage=new HomePage(driver);
	   users =new UserPage(driver);	
	
	}

}
