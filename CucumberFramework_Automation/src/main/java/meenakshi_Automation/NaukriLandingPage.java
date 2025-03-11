package meenakshi_Automation;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Utility;

public class NaukriLandingPage extends Utility {

	WebDriver driver;

	public NaukriLandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='acceptance-btn']")
	WebElement cookie;
	
	@FindBy(xpath="//div[@class='nI-gNb-log-reg']/a[@id='login_Layer']")
	WebElement login;
	
	@FindBy(xpath="//div[@class='form-row']/input[@placeholder='Enter your active Email ID / Username']")
	WebElement email;
	
	@FindBy(xpath="//div[@class='form-row']/input[@placeholder='Enter your password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;

// 	input[id='user-name']
//	input[id='password']
//  input[id='login-button']
	public NaukriLandingPage acceptCookie()
	{
		//waitToAppearWebElement(cookie);
		if(cookie.isDisplayed());
		{
		cookie.click();
		}
		return null;
	}
	public String getTitle()
	{
		return driver.getTitle();
	}
	public void goTo() {
		driver.get("https://www.naukri.com");
	}
	
	public NaukriLandingPage clickLogin()
	{
		waitToAppearWebElement(login);
		login.click();
		return null;
	}
	
	public NaukriLandingPage login(String usname,String pswd)
	{
		waitToAppearWebElement(email);
		email.sendKeys(usname);
		password.sendKeys(pswd);
		loginButton.click();
		return null;
	}
}
