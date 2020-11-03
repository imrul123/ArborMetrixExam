/**
 * 
 */
package com.Demo.TestCases;



import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Demo.Base.DemoBasePage;
import com.Demo.FactoryProvider.BrowserFactory;
import com.Demo.Pages.CourseRegistrationForm;
import com.Demo.UtilityProvider.DemoConstants;

/**
 * Description:
 * @author imrul hasan
 * Date Created : Nov 2, 2020
 * 
 */
public class VerifyCourseRegistrationForm extends DemoBasePage{
	
	
	@BeforeMethod
	public void setup() 
	{
		driver = BrowserFactory.openBrowser();
		String urlName=BrowserFactory.getparameter("url","https://www.jotform.com/form-templates/class-registration-3");
		driver.get(urlName);
	}
	
	
	// Verify student registration form.
	@Test
	public void verifyStudentRegistrationForm() throws InterruptedException
	{
		CourseRegistrationForm crf = new CourseRegistrationForm(driver);
		PageFactory.initElements(driver, crf);
		
		/* 
		 * This is the tricky part. I tried in different way to switch to the from from modal dialog box. I can verify the element in modal box like "Use Template" link.
		 * I was unable to switch the form. The below code will as expected if we can switch to the form.
		 */
		
		driver.switchTo().activeElement(); // This will not work. It's a placeholder. 
		Thread.sleep(30000);
		Assert.assertTrue(this.isElementPresent(DemoConstants.STUDENT_FIRST_NAME));
		this.enterText(DemoConstants.STUDENT_FIRST_NAME,"David");
		Assert.assertTrue(this.isElementPresent(DemoConstants.STUDENT_M_NAME));
		this.enterText(DemoConstants.STUDENT_M_NAME,"M");
		Assert.assertTrue(this.isElementPresent(DemoConstants.STUDENT_LAST_NAME));
		this.enterText(DemoConstants.STUDENT_LAST_NAME,"Luise");
		Assert.assertTrue(this.isElementPresent(DemoConstants.STUDENT_EMAIL_ADDRESS));
		this.enterText(DemoConstants.STUDENT_EMAIL_ADDRESS,"Luise@gmail.com");
		crf.dropDownValuePreset(DemoConstants.COURSES_DROPDOWN, "Math 101");
		this.clickOnLocator(DemoConstants.SUBMIT_APPLICATION);
		Thread.sleep(30000);
		/*
		 * We can use assertion or conditions to verify that Student Registration Form is present after redirect. 
		 * I use header form text  however we can chose any elements.
		 */
		String stdform=driver.findElement(By.xpath(DemoConstants.STUDENT_REG_FORM)).getText();
		System.out.println(stdform);
		
		
		if(stdform.equalsIgnoreCase(DemoConstants.STUDENT_REG_FROM_TEXT))
		{
			System.out.println("Student Registration Form is present after redirect");
		} else 
		{
			System.out.println("Hmmmm! Something went wrong, please check your code");
		}
		
		Assert.assertEquals(stdform, DemoConstants.STUDENT_REG_FROM_TEXT);
	   
	}
	
	

	@AfterMethod
	public void tearDown(ITestResult result) 
	{
		BrowserFactory.closeBrowser(driver);
	}

}
