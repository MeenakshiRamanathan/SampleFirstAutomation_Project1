package Automation_Project1;
//package FunctionalProject.New.Liste;


import org.testng.annotations.Listeners;

import org.testng.AssertJUnit;

import org.testng.annotations.Test;

//import FunctionalProject.New.Browse;

import java.io.IOException;

@Listeners(MyListeners.class)
public class ErrorValidation extends  Browse{
	

	@Test(groups= {"ErrorHandling"})
	public void submitOrder() throws IOException,InterruptedException 
	{
		
		String itemName = "qwerty";
	
		p.login("meenakshi94@gmail.com", "Meena@@@@@1994");
		p.getErrorMsg();
		AssertJUnit.assertEquals("Incorrect email or password.",p.getErrorMsg());

}

}