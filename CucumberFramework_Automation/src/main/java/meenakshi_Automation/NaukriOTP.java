package meenakshi_Automation;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class NaukriOTP extends Utility{

	WebDriver driver;

	public NaukriOTP(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="button[class='btn-large verify-button ']")
	WebElement loginButton;

	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public char[] OtpToClipboard(String otp) throws UnsupportedFlavorException, IOException
	{
		StringSelection stringSelection = new StringSelection(otp);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		String otp2 = (String) clipboard.getData(DataFlavor.stringFlavor);
		char[] otpDigits = otp2.toCharArray();
		return otpDigits;
      }


   public void postOtp(List<String> tabs,char[] otpDigits)
   {
	   driver.switchTo().window(tabs.get(0));

		// Enter the OTP digit by digit
		for (int i = 0; i < otpDigits.length; i++) {
			// Locate the OTP input field (adjust the locator as per the Naukri page)
			WebElement otpField = driver.findElement(By.xpath("//input[@id='Input_" + (i + 1) + "']")); // Example
																										// locator
			otpField.sendKeys(String.valueOf(otpDigits[i]));
		}
			loginButton.click();
		
   }
}




