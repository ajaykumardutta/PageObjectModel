package com.pagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.initiator.Browser;

public class RequestNewUserPage extends Browser{

	@FindBy (xpath = "//a[contains(text(), 'new password')]")
	public WebElement requestNewPassword_LNK;
	
	@FindBy (id = "edit-name")
	public WebElement usernameORemailAddress_TXT;
	
	@FindBy (id = "edit-submit")
	public WebElement emailNewPassword_LNK;
	
	@FindBy (xpath = "//div[contains(@class, 'alert-success')]")
	public WebElement emailDetails_TXT;
	
	public RequestNewUserPage(){
		PageFactory.initElements(driver, this);
	}
}
