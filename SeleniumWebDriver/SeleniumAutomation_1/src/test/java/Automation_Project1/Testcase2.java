package Automation_Project1;
//package FunctionalProject.New.Liste;


import org.testng.annotations.Listeners;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import org.testng.annotations.Test;

import Global.MyListeners;

//import FunctionalProject.New.Browse;

import java.io.IOException;

@Listeners(MyListeners.class)
public class Testcase2 extends  Base{
	

	@Test(groups= {"ErrorHandling"})
	public void submitOrder() throws IOException,InterruptedException 
	{
		
		String itemName = "qwerty";
	
		p.login("meenakshi94@gmail.com", "Meena@@@@@1994");
		p.getErrorMsg();
		AssertJUnit.assertEquals("Incorrect email or password.",p.getErrorMsg());

}

}