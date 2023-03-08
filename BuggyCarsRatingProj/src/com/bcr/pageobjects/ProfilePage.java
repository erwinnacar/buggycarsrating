package com.bcr.pageobjects;

import org.openqa.selenium.WebDriver;

import com.bcr.base.BasePage;
import com.bcr.base.BaseTest;

public class ProfilePage extends BasePage {

	public ProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterFirstName(String firstName) {
		enterText("firstName", "id", firstName);
		BaseTest.logger("Update first name");
	}
	
	public void enterLastName(String lastName) {
		enterText("lastName", "id", lastName);
		BaseTest.logger("Update last name");
	}

	public void enterGender(String gender) {
		enterText("gender", "id", gender);
		BaseTest.logger("Update gender");
	}
	
	public void enterAge(String age) {
		enterText("age", "id", age);
		BaseTest.logger("Update age");
	}
	
	public void enterAddress(String address) {
		enterText("address", "id", address);
		BaseTest.logger("Update address");
	}
	
	public void enterPhone(String phone) {
		enterText("phone", "id", phone);
		BaseTest.logger("Update phone number");
	}
	
	public void selectHobby(String hobby) {
		selectFromList("hobby", "id", hobby);
		BaseTest.logger("Update hobby");
	}
	
	public void enterPassword(String currentPassword, String newPassword) {
		enterText("currentPassword", "id", currentPassword);
		enterText("newPassword", "id", newPassword);
		enterText("newPasswordConfirmation", "id", newPassword);
		BaseTest.logger("Update password");
	}
	
	public void clickSave() {
		click("//button[@type='submit']", "xpath");
		BaseTest.logger("Click Save");
	}


}
