package test.initialSetup.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import driverManagers.InitTests;

public class TestTestNgSetup extends InitTests {
	
	WebDriver driver;
	ExtentTest test;
	
	@Test
	public void testSetup(){
		
		
		try {
			//new TestTestNgSetup();
			driver = getWebDriver();
			driver.get("https:\\google.com");
			test = reports.createTest("Testing 001");
			
			if(driver.getTitle().contains("Google")) {
				
				test.log(Status.PASS, "Title Matched");
				test.log(Status.FAIL, "Title Fail");
				
			}else {
				test.log(Status.FAIL, "Title Fail");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			driver.quit();
			reports.flush();
		}
	}

}
