package com.initiator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Browser {
	
	
	public static WebDriver driver;
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static Properties prop;
	public FileInputStream propFile;
	
	
	@BeforeSuite @Parameters(value = "browser")
	public void browserConfig(String browser) throws IOException{
		
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", PROJECT_PATH + "\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		prop = new Properties();
		propFile = new FileInputStream(PROJECT_PATH + "\\config\\AppConfigDetails.properties");
		prop.load(propFile);
	}

	
	@AfterSuite
	public void closeConfig(){
		driver.quit();
	}
	
	
}
