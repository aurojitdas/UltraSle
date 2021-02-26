package test.initialSetup.tests;

import static wrapperClasses.seleniumCallHandler.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import services.InitTests;

public class TestTestNgSetup extends InitTests {
	
	WebDriver driver;
	ExtentTest test;
	
	@Test(enabled=true)
	public void testSetup(){
		
		
		try {
			//new TestTestNgSetup();			
			test = reports.createTest("Testing 001");
			test.assignCategory("Test Category");
			driver = getEventFiringWebDriver(test);
			
			driver.get("https:\\google.com");
			
			
			click(driver.findElement(By.xpath("//a[contains(text(),'About')]")));
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
	
	@Test(enabled=false)
	public void testSetupParrel(){
		
		
		try {
			//new TestTestNgSetup();
			driver = getWebDriver();
			test = reports.createTest("Testing 002");
			test.assignCategory("Test Category");
			driver = getEventFiringWebDriver(test);
			
			driver.get("https:\\google.com");
			//driver.findElement(By.name("q")).sendKeys("Test Keys");;
			driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
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
