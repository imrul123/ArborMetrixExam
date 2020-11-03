package com.Demo.Base;


import java.awt.Robot;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;






/**
 * Description:
 * @author imrul hasan
 * Date Created : Nov 2, 2020
 * 
 */


public class DemoBasePage {
	
	
	public WebDriver driver;
	public WebElement element;
	public WebDriverWait wait;
	public Actions action;
	public Select select;
	public Robot robot;
	public Date date;
	public DateFormat dateFormat;
	public By by;
	

	
	public DemoBasePage() {}; 
	
	
	public DemoBasePage(WebDriver driver) 
	{
		this.driver = driver;
	
	}
	
	
	// To enter text of an element
	public void enterText(String locator, String text) 
	{
		driver.findElement(By.xpath(locator)).sendKeys(text);	
	}
	
	
	
	// To click on any locator
	public void clickOnLocator(String locator) 
	{
		driver.findElement(By.xpath(locator)).click();	
	}
	
	
	// To find an specific element of a page.
	public boolean isElementPresent(String locator)
	{
		int webElement = driver.findElements(By.xpath(locator)).size();
		if(webElement==0)
		{
			System.out.println("Element is not present");
			return false;
		}
		else
		{
			System.out.println("Element is present");
			return true;
		}	
	}
	
	
	// To get a test on an element
	public String getElementText(String locator) 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.findElement(By.xpath(locator)).getText();	
	}
	


}
