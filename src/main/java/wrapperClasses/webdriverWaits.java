package wrapperClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import services.InitDriver;

public class webdriverWaits extends InitDriver{

	
	public static void waitForElementToDisplay(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElementToDisappear(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	
	

	
}
