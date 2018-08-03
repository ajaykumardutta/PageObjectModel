package com.pagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.initiator.Browser;

public class LoginPage extends Browser{
	
	@FindBy (id = "edit-name")
	public WebElement username_TXT;
	
	@FindBy (id = "edit-pass")
	public WebElement password_TXT;
	
	@FindBy (id = "edit-submit")
	public WebElement logIn_BTN;
	
	@FindBy (xpath = "//div[contains(@class, 'alert-danger')]")
	public WebElement errorMSG_TXT;
	
	@FindBy (xpath = "//a[@class='dropdown-toggle' and contains(text(), 'Tech')]")
	public WebElement loggedInUser_TXT;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

}
