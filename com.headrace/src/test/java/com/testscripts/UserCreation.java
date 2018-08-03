package com.testscripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.initiator.AppLogin;
import com.initiator.Browser;
import com.pagesObjects.LoginPage;
import com.pagesObjects.MainMenuPage;
import com.pagesObjects.RequestNewUserPage;
import com.pagesObjects.UsersPage;
import com.reusables.Utilities;

public class UserCreation extends Browser {

	public LoginPage loginPage;
	public MainMenuPage mainMenuPage;
	public RequestNewUserPage requestNewUserPage;
	public UsersPage usersPage;
	public AppLogin appLogin;
	public Utilities utility;
	public WebDriverWait waitObject;

	@BeforeClass
	public void objectIni() {
		loginPage = new LoginPage();
		mainMenuPage = new MainMenuPage();
		requestNewUserPage = new RequestNewUserPage();
		usersPage = new UsersPage();
		appLogin = new AppLogin();
		utility = new Utilities();
		waitObject = new WebDriverWait(driver, 15);
	}
	
	@AfterMethod
	public void closeConfig(){
		driver.close();
	}

	@Test
	public void createUser_TC1() throws Exception {
		try {
			appLogin.appLogin(prop.getProperty("invalidUser"), prop.getProperty("invalidPass"));
			Assert.assertEquals(loginPage.errorMSG_TXT.getText().toString().trim().split("\n")[2], "Sorry, unrecognized username or password.", "error msg validation");
			requestNewUserPage.requestNewPassword_LNK.click();
			utility.waitForPageLoad();
			requestNewUserPage.usernameORemailAddress_TXT.sendKeys(prop.getProperty("emailID"));
			requestNewUserPage.emailNewPassword_LNK.click();
			utility.waitForPageLoad();
			Assert.assertEquals(requestNewUserPage.emailDetails_TXT.getText().toString().trim().split("\n")[2], "Further instructions have been sent to your e-mail address.", "email details text");
			appLogin.appLogin(prop.getProperty("username"), prop.getProperty("password"));
			mainMenuPage.people_LNK.click();
			waitObject.until(ExpectedConditions.visibilityOf(mainMenuPage.users_LNK));
			mainMenuPage.users_LNK.click();
			Assert.assertEquals(usersPage.users_TXT.getText().toString().trim(), "Users", "Users text on users page validation");
			usersPage.importParticipants_LNK.click();
			utility.waitForPageLoad();
			Assert.assertEquals(usersPage.importParticipants_TXT.getText().toString().trim(), "Import Participants","Import Participants text verification");
			usersPage.browse_BTN.click();
			Process p = Runtime.getRuntime().exec(PROJECT_PATH + "\\testdata\\browseUpload.exe");
			p.waitFor();
			if(p.exitValue() == 0)
				usersPage.import_BTN.click();
			Assert.assertEquals(usersPage.updatedUser_TXT.getText().toString().trim().split("\n")[2], "Updated 1 user.", "updates user text validation");
		} catch (Exception e) {
			Assert.assertTrue(false, "== something wrong in test method ===" + e.getMessage());
		}
	}
}
