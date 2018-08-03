package com.initiator;

import org.testng.Assert;

import com.pagesObjects.LoginPage;
import com.reusables.Utilities;

public class AppLogin extends LoginPage{
	
	
	public LoginPage lPage;
	public Utilities utility;
	
	public AppLogin(){
		lPage = new LoginPage();
		utility =  new Utilities();
	}
	
	
	public void appLogin(String username, String password) throws Exception{
		try{
			driver.get(prop.getProperty("APP_URL"));
			username_TXT.sendKeys(username);
			password_TXT.sendKeys(password);
			logIn_BTN.click();
			utility.waitForPageLoad();
//			Assert.assertTrue(loggedInUser_TXT.isDisplayed(), "=== logged in user is not displayed");
		}
		
		catch(Exception e){
			Assert.assertTrue(false, "== something wrong in login method, please check the error ==" + e.getMessage());
		}
	}

}
