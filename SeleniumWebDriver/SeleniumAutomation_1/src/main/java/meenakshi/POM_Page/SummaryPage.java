package meenakshi.POM_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.ReusuableFunctionalities;

public class SummaryPage extends ReusuableFunctionalities {

	private WebDriver driver;

	public SummaryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "h1[class='hero-primary']")
	WebElement msg2;

	By visibilityOfOrder = (By.cssSelector("table[class='order-summary']"));

	public String confirmation() {
		waitToAppear(visibilityOfOrder);
		String message = msg2.getText();
		return message;
	}

}
