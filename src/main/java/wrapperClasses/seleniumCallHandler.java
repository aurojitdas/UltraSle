package wrapperClasses;

import static wrapperClasses.webdriverWaits.waitForElementToBeClickable;
import static wrapperClasses.webdriverWaits.waitForElementToDisplay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import services.InitDriver;

public class seleniumCallHandler extends InitDriver{
	
	public static void click(WebElement element) {
		
		
		try {
			waitForElementToDisplay(element);
			waitForElementToBeClickable(element);
			element.click();
			
		} catch (Exception e) {
			System.out.println("Error in clicking the element"+ element.toString()) ;
		}
		
	}
	
	public static void setText(WebElement element,String text) {
		
		try {
			waitForElementToDisplay(element);
			element.click();
			element.clear();
			element.sendKeys(text);
			
			
		} catch (Exception e) {
			System.out.println("Error doing sendkeys to element " + element.toString());
			e.printStackTrace();
		}
		
	}
	
	public static void selectbyIndex(WebElement element,int index) {
		try {
			waitForElementToDisplay(element);
			Select select = new Select(element);
			select.selectByIndex(index);
		} catch (Exception e) {
			
			System.out.println("Error in selecting : " + element.toString());
			e.printStackTrace();
		}
		
	}
	
	public static void selectElebyVisibleText(WebElement element,String text) {
		try {
			waitForElementToDisplay(element);
			Select select = new Select(element);
			select.selectByVisibleText(text);;
		} catch (Exception e) {
			
			System.out.println("Error in selecting : " + element.toString());
			e.printStackTrace();
		}
		
	}
	
	public static void selectElebyValue(WebElement element,String value) {
		try {
			waitForElementToDisplay(element);
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (Exception e) {
			
			System.out.println("Error in selecting : " + element.toString());
			e.printStackTrace();
		}
		
	}
	
	public static void  scrollToElement(WebElement element,WebDriver driver) {
		Actions action =  new Actions(driver);
		action.moveToElement(element);
		action.perform();
		
		
	}
	
	public static void hoverAndClick(WebElement parent,WebElement child,WebDriver driver) {
		Actions action =  new Actions(driver);
		action.moveToElement(parent);
		action.perform();
		click(child);
	}
	
	
	
	
	
}
