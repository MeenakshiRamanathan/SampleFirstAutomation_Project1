package meenakshi.POM_Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.ReusuableFunctionalities;

public class CheckoutPage extends ReusuableFunctionalities {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By cartSection = By.xpath("//div[@class=\"cartSection\"]");

	By disapper = By.xpath("//div[@id=\"toast-container\"]");

	By show = By.xpath("//li[@class=\"totalRow\"]/button");

	By inputList = By.cssSelector("div input");

	By msgText = By.cssSelector(".mt-1.ng-star-inserted");

	By result = By.cssSelector(".ta-results");

	By elementClick = By.cssSelector("a");

	By spin = By.cssSelector("ngx-spinner");
	
	By cartBut=By.cssSelector("button[routerlink='/dashboard/cart']");
	
	

	@FindBy(css = "div h3")
	List<WebElement> listOfItemsInCart;

	@FindBy(css = ".mt-1.ng-star-inserted")
	WebElement message;

	@FindBy(css = "li[class='totalRow'] button")
	WebElement submitButton;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement text1;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement text2;

	@FindBy(xpath = "//input[@name='coupon']")
	WebElement text3;

	@FindBy(css = "button[type='submit']")
	WebElement text4;

	@FindBy(css = ".ta-item")
	List<WebElement> rst;
	
	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cartButton;

	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	WebElement sub;

	public List<WebElement> waitInCartToShow() {
		clickableElement(cartBut);
		cartButton.click();
		waitToAppear(cartSection);
		return listOfItemsInCart;
	}

	public boolean matchInCartPage(String itemName) {
		boolean cartMatch = waitInCartToShow().stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(itemName));
		return cartMatch;
	}

	public void clickOnSubmit() {
		waitToAppear(show);
		submitButton.click();
	}

	public void listOfDetails(String a) {
		waitToAppear(inputList);
		text1.sendKeys(a);
		text4.click();
	}

	public void listOfDetails2(String b) {
		waitToAppear(inputList);

		text2.sendKeys(b);

		text4.click();
	}

	public void listOfDetails3(String c) {
		waitToAppear(inputList);

		text3.sendKeys(c);
		text4.click();
	}

	public String getMsg() {
		waitToAppear(msgText);
		String s = message.getText();
		invisibilityOfElement(spin);
		return s;

	}

	public void selectCountry(String text) {

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), text).build().perform();
		waitToAppear(result);

		List<WebElement> options = rst;
		for (WebElement opt : options) {
			if (opt.getText().equalsIgnoreCase(text)) {
				opt.click();
				break;
			}
		}

	}

	public void submit() {
		clickableElement(elementClick);

		sub.click();
	}

}
