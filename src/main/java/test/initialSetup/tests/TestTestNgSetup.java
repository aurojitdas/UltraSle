package test.initialSetup.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import driverManagers.InitTests;

public class TestTestNgSetup extends InitTests {
	
	WebDriver driver;
	
	
	@Test
	public void testSetup(){
		new TestTestNgSetup();
		driver = getWebDriver();
		driver.get("https:\\google.com");
	}

}
