package com.bcr.pageobjects;

import org.openqa.selenium.WebDriver;

import com.bcr.base.BasePage;
import com.bcr.base.BaseTest;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterUsername(String username) {
		enterText("username", "id", username);
		BaseTest.logger("Enter username");
	}
	
	public void enterFirstName(String firstName) {
		enterText("firstName", "id", firstName);
		BaseTest.logger("Enter first name");
	}
	
	public void enterLastName(String lastName) {
		enterText("lastName", "id", lastName);
		BaseTest.logger("Enter last name");
	}
	
	public void enterPassword(String password) {
		enterText("password", "id", password);
		enterText("confirmPassword", "id", password);
		BaseTest.logger("Enter and confirm password");
	}
	
	public void clickRegister() {
		click("//div/div/form/button", "xpath");
		BaseTest.logger("Click Register button");
	}

}
