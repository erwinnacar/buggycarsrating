package com.bcr.test;

import org.testng.annotations.Test;

import com.bcr.base.BaseTest;
import com.bcr.pageobjects.HomePage;
import com.bcr.pageobjects.ProfilePage;

public class BCR_Test_UpdateProfile extends BaseTest{
	
	String fileName = System.setProperty("excel.file.path", "\\src\\com\\bcr\\testdata\\BuggyCarsRatingData.xlsx");
	String sheetName = System.setProperty("excel.sheet.name", "BCR_Test_UpdateProfile");

	@Test(dataProvider = "testData", dataProviderClass = BaseTest.class)
	public void updateUserProfile(String userName, String password, String firstName, String lastName, String age, String hobby, String newPassword) throws InterruptedException {
		HomePage homeActions = new HomePage(driver);
		ProfilePage profileActions = new ProfilePage(driver);
		
		//Login as an existing user
		homeActions.enterUsername(userName);
		homeActions.enterPassword(password);
		homeActions.clickLogin();
		
		//Click Profile
		homeActions.clickProfile();
		
		//Update profile
		profileActions.enterFirstName(firstName);
		profileActions.enterLastName(lastName);
		profileActions.enterAge(age);
		profileActions.selectHobby(hobby);
		profileActions.enterPassword(password, newPassword);
		profileActions.clickSave();
		
	}

}
