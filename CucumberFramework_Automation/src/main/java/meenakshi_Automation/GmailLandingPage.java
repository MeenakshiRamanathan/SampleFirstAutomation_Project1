package meenakshi_Automation;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import utils.Utility;

public class GmailLandingPage extends Utility {
	WebDriver driver;

	public GmailLandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='acceptance-btn']")
	WebElement cookie;

	
	By email = By.cssSelector("input[type='email']");
	
	By emailNext = By.cssSelector("//div[@class='O1Slxf']//span[@jsname='V67aGc'])[1]");
	
	By searchBox=By.name("q");
	
	@FindBy(css="input[type='email']")
	WebElement emailId;
	
	@FindBy(xpath="(//div[@class='O1Slxf']//span[@jsname='V67aGc'])[1]")
	WebElement emailIdNext;
	

	@FindBy(css="input[type='password']")
	WebElement pswd;
	
	@FindBy(xpath="(//div[@class='O1Slxf']//span[@jsname='V67aGc'])[1]")
	WebElement pswdNext;
	
	@FindBy(name="q")
	WebElement searchBox2;
	
	@FindBy(xpath="((//div)[35]//tbody//tr[7])[1]")
	WebElement text;
	
	@FindBy(xpath="(//div[@class='Cp']//span[@name='naukri'])[2]")
	WebElement firstRow;
	
	@FindBy(xpath="(//tbody/tr/td[4]//span[1])[4]")
	WebElement firstRow1;
//	(//div)[35]//tbody//td[4]
	
	public List<String> newWindow()
	{
		((JavascriptExecutor) driver).executeScript("window.open()");

		List<String> tabs = List.copyOf(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://mail.google.com");
		return tabs;
	}
	
	public void gmailLogin(String username2,String password2)
	{
		emailId.sendKeys(username2);
		emailIdNext.click();
		waitToAppearWebElement(pswd);
		pswd.sendKeys(password2);
		pswdNext.click();
		
	}
	
	public String getOtp() throws InterruptedException
	{
		waitToAppear(searchBox);
		searchBox2.sendKeys("OTP from Naukri" + Keys.ENTER);
		waitToAppearWebElement(firstRow1);
		Thread.sleep(1000);
		firstRow1.click();
		String otp =text.getText();
		return otp;
	}


}











