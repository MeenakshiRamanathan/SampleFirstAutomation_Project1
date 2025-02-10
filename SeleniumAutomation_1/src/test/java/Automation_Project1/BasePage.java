package Automation_Project1;

import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*; 

//import FunctionalProject.NewOne.Browse;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(MyListeners.class)
public class BasePage extends Browse {

	

	
	
	@Test(groups= {"ErrorHandling"})
	public void submitOrder() throws IOException,InterruptedException 
	{
		
		String itemName = "QWERTY";
	  //  p.login(data1.get("username1"),data1.get("password1"));
		p.login("meenakshi94@gmail.com", "Meena@1994");

		// Products Page

		ProductsPage pp = new ProductsPage(driver);

		List<WebElement> products = pp.showListOfProducts();

		System.out.println(products);
		// pp.getMatch(itemName);

		pp.clickOnItem(itemName);

		// Checkout Page

		CheckoutPage cp = new CheckoutPage(driver);

		List<WebElement> cartProducts = cp.waitInCartToShow();

		Boolean set = cp.matchInCartPage(itemName);
		Assert.assertTrue(set);

		cp.clickOnSubmit();

		cp.listOfDetails("123");

		cp.listOfDetails2("Meenakshi");

		cp.listOfDetails3("offer");

		String msg = cp.getMsg();

		cp.selectCountry("India");

		cp.submit();

		// Order Summary Page

		SummaryPage s = new SummaryPage(driver);
		String confirmationMsg = s.confirmation();
		AssertJUnit.assertTrue(confirmationMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	

	}
	
	
	@DataProvider(name="getData")
	public Object[][] getData() throws IOException
			{
		
		List<HashMap<String,String>> data1 =getJsonDataToMap((System.getProperty("/Users/ramumeena/eclipse-workspace/New/src/test/java/Global/data.json")));
				return new Object[][] {{data1.get(0)},{data1.get(1)}};
		
		
			}
	}

