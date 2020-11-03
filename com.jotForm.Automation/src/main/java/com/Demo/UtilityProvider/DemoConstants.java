package com.Demo.UtilityProvider;

import com.Demo.Base.DemoBasePage;


/**
 * Description:
 * @author imrul hasan
 * Date Created : Nov 2, 2020
 * 
 */


public class DemoConstants extends DemoBasePage {
	
	
	//************************************************* URLS ****************************************************//

	// URL's
	public static final String URLS="https://www.jotform.com/form-templates/class-registration-3";
	
	
	
	
	//************************************************* PATHS ***************************************************//
	
	// Driver 
	public static final String GET_CHROME_PATH =".//Driver//chromedriver.exe";
	public static final String GET_IE_PATH= ".//Driver//IEDriverServer32.exe";
	public static final String GET_GECKO_PATH=".//Driver//geckodriver.exe";
	public static final String GET_PHANTOM_JS="";
	
	// Screen Shots
	public static final String GET_SCREEN_SHOT_PATH =".//ScreenShot//";
	

	
	//************************************************* LOCATORS ******************************************************//
	
	//************************************************* Course Registration Form *****************************************************//
	
	public static final String STUDENT_REG_FORM="//*[@id='header_1']";
	public static final String STUDENT_FIRST_NAME="//*[@id='first_4']";
	public static final String STUDENT_M_NAME="//*[@id='middle_4']";
	public static final String STUDENT_LAST_NAME="//*[@id='last_4']";
	public static final String STUDENT_EMAIL_ADDRESS="//*[@id='input_6']";
	public static final String COURSES_DROPDOWN="//*[@id='input_46']";
	public static final String SUBMIT_APPLICATION="//*[@id='input_20']";
	public static final String STUDENT_REG_FROM_TEXT="Student Registration Form";
		
}
