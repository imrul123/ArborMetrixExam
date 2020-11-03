package com.Demo.FactoryProvider;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.Demo.UtilityProvider.DemoConstants;




/**
 * Description:
 * @author imrul hasan
 * Date Created : Nov 2, 2020
 * 
 */


public class BrowserFactory {
	
	
	
	public BrowserFactory(String param) {};
	
	static WebDriver driver;			
	private static String browserType=System.getProperty("browser", "chrome");
	
	
	public static WebDriver openBrowser() 
	{
		switch (browserType) 
		{
		case "firefox":
			
			System.setProperty("webdriver.gecko.driver", DemoConstants.GET_GECKO_PATH);
			driver = new FirefoxDriver();
			break;
		case "chrome":
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			System.setProperty("webdriver.chrome.driver", DemoConstants.GET_CHROME_PATH);
			driver = new ChromeDriver(options);
			break;
		case "ie":
			
			System.setProperty("webdriver.ie.driver", DemoConstants.GET_IE_PATH);
			driver = new InternetExplorerDriver();
			break;
		default:
			
			System.setProperty("webdriver.ie.driver", DemoConstants.GET_IE_PATH);
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	
	public static String getparameter(String value, String defaultValue)
	{
		String realValue=defaultValue;
		if(System.getProperty(value) !=null) 
		{
			realValue=System.getProperty(value);
		}
		return realValue;
	}
		

	
	public static void closeBrowser (WebDriver rdriver) 
	{
		driver.quit();
	}


}
