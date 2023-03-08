package com.bcr.test;

import org.testng.annotations.Test;

import com.bcr.base.BaseTest;
import com.bcr.pageobjects.HomePage;
import com.bcr.pageobjects.RegistrationPage;

public class BCR_Test_RegisterNewUser extends BaseTest{
	
	
	String fileName = System.setProperty("excel.file.path", "\\src\\com\\bcr\\testdata\\BuggyCarsRatingData.xlsx");
	String sheetName = System.setProperty("excel.sheet.name", "BCR_Test_RegisterNewUser");

	@Test(dataProvider = "testData", dataProviderClass = BaseTest.class)
	public void registerNewUser(String userName, String firstName, String lastName, String password) throws InterruptedException {
		HomePage homeActions = new HomePage(driver);
		RegistrationPage regActions = new RegistrationPage(driver);
		
		//Click Register button from home page
		homeActions.clickRegister();
		
		//Enter registration details
		regActions.enterUsername(userName);
		regActions.enterFirstName(firstName);
		regActions.enterLastName(lastName);
		regActions.enterPassword(password);
		
		//Click Register button
		regActions.clickRegister();
	}
	
}
