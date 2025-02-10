package Automation_Project1;


import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Browse {
	
	WebDriver driver;
	





	LandingPage p;
	String jsonContent;
	List<HashMap<String,String>> data;
	
	
	public WebDriver initialize() throws IOException
	{
		
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream("/Users/ramumeena/eclipse-workspace/New/src/test/java/Global/GlobalData.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	
	
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	}
	
/*	if(browserName.equalsIgnoreCase("FireFox"))
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
	}
	*/
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/client/");
	return driver;
}
	
	
	

	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		driver=initialize();
		 p = new LandingPage(driver);
		p.goTo();
		return p;
	}
	
	
	 public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException
	  {
		  
		  
		 jsonContent= FileUtils.readFileToString(new File( filePath)
	, StandardCharsets.UTF_8);
		  
	   
	     ObjectMapper mapper=new ObjectMapper();
	     
	    
		 data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() { });   
	     return data;
	     
	       
	}
	 

		public static ExtentReports setUp() {
	        // Initialize ExtentReports and attach the Spark reporter
			String path=System.getProperty("user.dir")+"//reports//index.html";
			 ExtentReports extent = new ExtentReports();
	        ExtentSparkReporter spark = new ExtentSparkReporter(path);
	        spark.config().setReportName("Results");
	        spark.config().setDocumentTitle("Test Results");
	        extent.attachReporter(spark);
	        
	        extent.setSystemInfo("Tester", "Meenakshi");
	        return extent;
	}
	 
	 
	 
	 
	 public String getScreenshot(String testCaseName,WebDriver driver) throws IOException 
	 { 
		  
	            // Cast the driver to TakesScreenshot
	            TakesScreenshot ts = (TakesScreenshot)driver;

	            // Capture the screenshot as a file

	            File source = ts.getScreenshotAs(OutputType.FILE);
	            // Define the destination path
	            String destinationPath = System.getProperty("user.dir") +"//reports//"+testCaseName+".png";

	            // Copy the file to the destination
	            FileUtils.copyFile(source, new File(destinationPath));
	            
	            return System.getProperty("user.dir") + "/screenshots/screenshot.png";

	            
		 
	 }
	 
	
   @AfterMethod(alwaysRun=true)
   public void tearDown()
   {
	   driver.close();
   }
}
