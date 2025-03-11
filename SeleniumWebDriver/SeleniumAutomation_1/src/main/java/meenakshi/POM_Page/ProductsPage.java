package meenakshi.POM_Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ReusuableFunctionalities;

public class ProductsPage extends ReusuableFunctionalities {

	private WebDriver driver;

	public ProductsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

//	@FindBy(css = "button[routerlink='/dashboard/cart']")
//	WebElement cartButton;

	@FindBy(css = "b")
	By prod;

	By addToCartButton = By.cssSelector(".card-body button:last-of-type");

	By productsBy = By.cssSelector(".mb-3");

	By disapper = By.cssSelector("ngx-spinner");

	By toastMsg = By.xpath("//div[@id=\"toast-container\"]");

	public List<WebElement> showListOfProducts() {
		waitToAppear(productsBy);
		return products;
	}

	public WebElement getMatch(String itemName) {
		WebElement first = showListOfProducts().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(itemName))
				.findFirst().orElse(null);
		return first;
	
	}

	public void clickOnItem(String itemName) {
		WebElement first = getMatch(itemName);
		first.findElement(addToCartButton).click();
		waitToAppear(toastMsg);
		invisibilityOfElement(disapper);
		//cartButton.click();
	}

}
