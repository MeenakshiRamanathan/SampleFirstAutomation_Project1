package stepDefinition;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import meenakshi1_Automation.Base;
import meenakshi_Automation.GmailLandingPage;
import meenakshi_Automation.NaukriLandingPage;
import meenakshi_Automation.NaukriOTP;

public class Login_stepDefinition extends Base{
	
	
	public NaukriLandingPage ll;
	public GmailLandingPage gp;
	public NaukriOTP otp;
	GmailLandingPage gg;
	List<String> tabs;
	String value;
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() throws IOException {
		ll= launchApplication();
		
	}
	
	@When("the user enters a valid username {string} and password {string}")
	public void the_user_enters_a_valid_username_and_password(String username1,String password1) {
		//lp=new NaukriLandingPage(driver);
		//ll.acceptCookie();
		ll.clickLogin();
		ll.login(username1,password1);
		
}
	
    @Then("the user clicks the login button")
    public void the_user_clicks_the_login_button(){
    	ll.getTitle();
    	Assert.assertEquals(ll.getTitle(), "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com");
    }
    
    @When("I log in to Gmail and enter username2 {string} and password2 {string}")
    public void i_log_in_to_gmail_and_retrieve_the_otp(String username2,String password2) throws InterruptedException{
    	gp=new GmailLandingPage(getDriver());
    	tabs=gp.newWindow();
    	gp.gmailLogin(username2,password2);
    	value=gp.getOtp();
    	
    	
    }	
    @Then("Pass the otp value")
    public void pass_the_otp_value() throws UnsupportedFlavorException, IOException {
    	
    	otp=new NaukriOTP(getDriver());
    	
    	char[] otpDigits =otp.OtpToClipboard(value);
    	otp.postOtp(tabs,otpDigits);
    }
    	
 
    @And("Verify login success")
    public void verify_login_success() {
    	Assert.assertEquals(ll.getTitle(), "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com");
    }
}