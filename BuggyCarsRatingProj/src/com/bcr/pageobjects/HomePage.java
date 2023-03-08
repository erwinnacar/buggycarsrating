package com.bcr.pageobjects;

import org.openqa.selenium.WebDriver;

import com.bcr.base.BasePage;
import com.bcr.base.BaseTest;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterUsername(String userName) {
		enterText("login", "name", userName);
		BaseTest.logger("Enter username");
		
	}
	
	public void enterPassword(String password) {
		enterText("password", "name", password);
		BaseTest.logger("Enter password");
	}
	
	public void clickLogin() {
		click("//button[@type='submit']", "xpath");
		BaseTest.logger("Click login");
	}
	
	public void clickRegister() {
		click("Register", "linkText");
		BaseTest.logger("Click register button");
	}
	
	public void clickProfile() {
		click("Profile", "linkText");
		BaseTest.logger("Click profile");
	}
	
}
