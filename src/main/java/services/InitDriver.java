package services;

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
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitDriver {

	
	WebDriver driver;
	FileReader reader;
	Properties p;
	String browser;
	String currentDir;
	String configFilePath;
	String extentReportPath;
	public String BASEURL;
	public String USERNAME;
	public String PASSWORD;
	protected static WebDriverWait wait;
	public static ExtentReports reports;
	ExtentSparkReporter sparkreporter;
	EventHandlers handler;
	String configFileDir;
	String userFilePath;
	int time;
	String testEnv;
	EventFiringWebDriver edriver;
	public InitDriver() {
		
		 try {
			 //Setting the path for config files
			currentDir = System.getProperty("user.dir");
			configFileDir = currentDir +File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"config"+File.separator;
			configFilePath =configFileDir+"conf.properties";
			reader=new FileReader(configFilePath);
			p=new Properties();  
			p.load(reader);  
			browser = p.getProperty("Browser");
			//Setting the Extent Reporter
			String reportName= System.getProperty("suiteXmlFile");			
			reportName=reportName.substring(0,reportName.length()-4);
			extentReportPath = currentDir +File.separator+"src"+File.separator+"Reports"+File.separator+reportName+".html";
			reports = new ExtentReports();
			sparkreporter = new ExtentSparkReporter(extentReportPath);
			reports.attachReporter(sparkreporter);
			//initialising drivers and setting the wait
			time = Integer.parseInt(p.getProperty("Timeout"));
			driver = getWebDriver();
			wait = new WebDriverWait(driver,time);
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Config file not found. Check if file is present.");
			e.printStackTrace();
		} catch (IOException e) {
			
			System.out.println("Error loading Config details check the config file.");
		}  
	}
	
	public  WebDriver getWebDriver() {
		
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
	
	public EventFiringWebDriver getEventFiringWebDriver(ExtentTest test) {
		
		edriver = new EventFiringWebDriver(driver);
		handler = new EventHandlers(test);
		edriver.register(handler);
		
		return edriver;
	}
	
	public void getUserdata(String appName) {
		
		testEnv = System.getProperty("env");
		Properties props = new Properties();
		
		switch (testEnv) {
		case "QA":
			try {
				userFilePath = configFileDir +"qa.properties";
				reader=new FileReader(userFilePath);
				props.load(reader);
				BASEURL = props.getProperty(appName+"_baseurl");
				USERNAME = props.getProperty(appName+"_username");
				PASSWORD = props.getProperty(appName+"_password");
			} catch (FileNotFoundException e) {				
				System.out.println("Config file not found. Check if file is present.");
				e.printStackTrace();
			} catch (IOException e) {				
				System.out.println("Error loading Config details check the config file.");
			}  
			break;
			
		case "UAT":
			try {
				userFilePath = configFileDir +"uat.properties";
				reader=new FileReader(userFilePath);
				props.load(reader);
				BASEURL = props.getProperty(appName+"_baseurl");
				USERNAME = props.getProperty(appName+"_username");
				PASSWORD = props.getProperty(appName+"_password");
			} catch (FileNotFoundException e) {				
				System.out.println("Config file not found. Check if file is present.");
				e.printStackTrace();
			} catch (IOException e) {				
				System.out.println("Error loading Config details check the config file.");
			}  
			break;
			
		case "PROD":
			try {
				userFilePath = configFileDir +"prod.properties";
				reader=new FileReader(userFilePath);
				props.load(reader);
				BASEURL = props.getProperty(appName+"_baseurl");
				USERNAME = props.getProperty(appName+"_username");
				PASSWORD = props.getProperty(appName+"_password");
			} catch (FileNotFoundException e) {				
				System.out.println("Config file not found. Check if file is present.");
				e.printStackTrace();
			} catch (IOException e) {				
				System.out.println("Error loading Config details check the config file.");
			}  
			break;

		default:
			try {
				userFilePath = configFileDir +"qa.properties";
				reader=new FileReader(userFilePath);
				props.load(reader);
				BASEURL = props.getProperty(appName+"_baseurl");
				USERNAME = props.getProperty(appName+"_username");
				PASSWORD = props.getProperty(appName+"_password");
			} catch (FileNotFoundException e) {				
				System.out.println("Config file not found. Check if file is present.");
				e.printStackTrace();
			} catch (IOException e) {				
				System.out.println("Error loading Config details check the config file.");
			}  
			
			break;
		}
		
		driver.get(BASEURL);
		
	}
	
	
}
