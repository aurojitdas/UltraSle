package driverManagers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitDriver {

	
	WebDriver driver;
	FileReader reader;
	Properties p;
	String browser;
	String currentDir;
	String configFilePath;
	public InitDriver() {
		 try {
			currentDir = System.getProperty("user.dir");
			System.out.println(currentDir); 
			configFilePath = currentDir +File.separator+"src"+File.separator+"main";
			File f = new File(configFilePath);
			String[] a = f.list();
			for(String b: a) {
				System.out.println(b);
			}
			
			reader=new FileReader(configFilePath);
			p=new Properties();  
			p.load(reader);  
			browser = p.getProperty("Browser");
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Config file not found. Check if file is present.");
			e.printStackTrace();
		} catch (IOException e) {
			
			System.out.println("Error loading Config details check the config file.");
		}  
	      
	   
	}
	
	public  WebDriver initDriver() {
		
		switch (browser) {
		case "CHROME":
			
			 ChromeOptions chromeOptions = new ChromeOptions();
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(chromeOptions);			
			 break;
			
		case "FF":
			
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();			
			 break;
			
		case "IE":	
			
			 WebDriverManager.iedriver().setup();
			 driver = new InternetExplorerDriver();			
			 break;
		case "EDGE":	
			
			 WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();			
			 break;

		default:
			break;
		}
		
		
		
		
		return driver;
	}
	
	
	
}