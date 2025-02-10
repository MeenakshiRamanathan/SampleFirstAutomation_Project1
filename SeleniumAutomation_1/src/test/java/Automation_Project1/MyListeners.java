//package FunctionalProject.New.Liste;
package Automation_Project1;
import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Automation_Project1.Browse;
import Automation_Project1.ExtentRepo;

public class MyListeners extends Browse implements ITestListener{
	

	ExtentTest test;
	ExtentReports extent=ExtentRepo.setUp();
	WebDriver driver;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		test=extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passes");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
		
		try
		{
			
			{
				
				driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
				 System.out.println(driver);
			}

		}
		
			 /*  Object testInstance = result.getInstance();
	        if (testInstance == null) {
	            System.out.println("Test instance is null. Cannot access WebDriver field.");
	            return;
	        }

	        // Get the test class
	   /*     Class<?> testClass = result.getTestClass().getRealClass();
	        System.out.println(testClass);

	        // Access the "driver" field
	        Field driverField = testClass.getDeclaredField("driver");
	        driverField.setAccessible(true); // Make the field accessible if it's private

	        // Retrieve the WebDriver instance
	        WebDriver driver = (WebDriver) driverField.get(testInstance);
	        System.out.println(driver);
		} */

		catch(Exception e1) {
			e1.printStackTrace();
		}
		
		
		
		String filePath=null;
		try
		{
			filePath=getScreenshot(result.getMethod().getMethodName(),driver);
			System.out.println(result.getMethod().getMethodName());
			System.out.println(filePath);
		} catch(IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
  
}
