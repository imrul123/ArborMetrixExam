package com.Demo.Pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.Demo.Base.DemoBasePage;




/**
 * Description:
 * @author ihasan
 * Date Created : Feb 7, 2018
 * 
 */


public class CourseRegistrationForm extends DemoBasePage{
	
	
	public CourseRegistrationForm(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);		
	}
	
	
	// Verify that a drop down value is present.
	
	public void dropDownValuePreset(String dropdownLocator, String value) 
	{
		try {
			wait = new WebDriverWait(driver, 30);
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownLocator)));
			//element.click();
			select = new Select(element);
			List<WebElement> sspLink=select.getOptions();
			for(WebElement ssp:sspLink) {
				String values=ssp.getText();
				System.out.println("Values : " + values);
				if(ssp.getText().equals(value)) {
					//ssp.click();
					System.out.println("Math 101 is present");
					break;
				}
			}
		} catch (Exception exp) {
			System.out.println("The error is : " +exp);
		}
	}
	

}
