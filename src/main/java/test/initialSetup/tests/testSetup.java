package test.initialSetup.tests;

import org.openqa.selenium.WebDriver;

import services.InitTests;

public class testSetup {
	
	public static void main(String[] args) {
		WebDriver driver;
		InitTests d = new InitTests();
		driver = d.getWebDriver();
		driver.get("https:\\google.com");
		
	}

}
