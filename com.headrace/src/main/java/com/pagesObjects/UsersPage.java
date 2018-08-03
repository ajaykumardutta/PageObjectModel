package com.pagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.initiator.Browser;

public class UsersPage extends Browser{
	
	@FindBy (xpath = "//div[@id='body-container']/descendant::h1[text()='Users']")
	public WebElement users_TXT;
	
	@FindBy (xpath = "//a[contains(@href, 'import-participants')]")
	public WebElement importParticipants_LNK;
	
	@FindBy (xpath = "//div[@id='body-container']/descendant::h1[text()='Import Participants']")
	public WebElement importParticipants_TXT;
	
	@FindBy (id = "edit-submit")
	public WebElement import_BTN;
	
	@FindBy (xpath = "//div[contains(@class, 'alert-success')]")
	public WebElement updatedUser_TXT;
	
	@FindBy (id = "edit-feeds-feedsfilefetcher-upload")
	public WebElement browse_BTN;
	
	@FindBy (xpath = "//input[contains(@class, 'btn-file-text')]")
	public WebElement participants_TXT;
	
	
	public UsersPage(){
		PageFactory.initElements(driver, this);
	}
	
	

}


