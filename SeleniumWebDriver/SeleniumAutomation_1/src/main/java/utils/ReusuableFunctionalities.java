package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusuableFunctionalities  {

	private WebDriver driver;

	public ReusuableFunctionalities(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}

	public void clickableElement(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}

	public void invisibilityOfElement(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void waitToAppearWebElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOf(ele));
	}

}
