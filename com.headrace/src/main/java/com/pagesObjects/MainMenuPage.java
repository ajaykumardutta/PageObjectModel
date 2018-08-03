package com.pagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.initiator.Browser;

public class MainMenuPage extends Browser{
	
	
	@FindBy (xpath = "//a[contains(text(), 'People')]")
	public WebElement people_LNK;
	
	@FindBy (xpath = "//a[text()='Users']")
	public WebElement users_LNK;
	
	public MainMenuPage(){
		PageFactory.initElements(driver, this);
	}
}
