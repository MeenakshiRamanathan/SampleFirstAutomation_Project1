package meenakshi1_Automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.edge.EdgeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import meenakshi_Automation.NaukriLandingPage;

public class Base {
	protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	String jsonContent;
	List<HashMap<String, String>> data;
	NaukriLandingPage lp;

	public WebDriver initialize() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/ramumeena/eclipse-workspace/CucumberFramework_Automation/src/test/java/resources/config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		} else {
			throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}

		driver.get().manage().window().maximize();

		driver.get().get("https://www.naukri.com");
		System.out.println("Page loaded successfully");

		System.out.println("Page is fully loaded");
		driver.get().manage().deleteAllCookies();

		return getDriver();
	}

	@BeforeMethod(alwaysRun = true)
	public NaukriLandingPage launchApplication() throws IOException {

		WebDriver driver = initialize();
		lp = new NaukriLandingPage(driver);
		lp.goTo();
		return lp;

	}

	public WebDriver getDriver() {
		return driver.get();
	}

	@AfterMethod
	public void quitBrowser()
	{
	driver.get().quit();
	}
	public String getScreenshot(String testName, WebDriver driver) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/reports/" + testName + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}

	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
		jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});
	}

	public ExtentReports getReporterObject() {
		String reportPath = System.getProperty("user.dir") + "/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Amtrak Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ramu Meena");
		return extent;
	}

}
