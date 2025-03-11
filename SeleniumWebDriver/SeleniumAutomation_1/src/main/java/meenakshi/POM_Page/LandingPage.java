package meenakshi.POM_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import Automation_Project1.Testcase1;
import utils.ReusuableFunctionalities;

public class LandingPage extends ReusuableFunctionalities {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement username;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement loginButton;
	

	@FindBy(css = "[class*='flyInOut']")
	WebElement errMsg;

	public LandingPage login(String username1, String password1) {
		username.sendKeys(username1);
		password.sendKeys(password1);
		loginButton.click();
		return null;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String getErrorMsg()
	{
		waitToAppearWebElement(errMsg);
		String msg=errMsg.getText();
		return msg;
	}
}
