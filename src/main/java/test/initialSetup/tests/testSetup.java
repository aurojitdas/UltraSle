package test.initialSetup.tests;

import org.openqa.selenium.WebDriver;

import driverManagers.InitDriver;

public class testSetup {
	
	public static void main(String[] args) {
		WebDriver driver;
		InitDriver d = new InitDriver();
		driver = d.initDriver();
		driver.get("https:\\google.com");
		
	}

}
