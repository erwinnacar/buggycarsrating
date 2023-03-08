package com.bcr.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bcr.common.Constants;

public abstract class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	/** Description: To find element in the webpage */
	public WebElement findElement(String elementId, String locType) {
		WebElement element = null;

		try {
			if (locType.equalsIgnoreCase("id")) {
				return new WebDriverWait(driver, Constants.FIND_ELEMENT_TIMEOUT)
						.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));

			} else if (locType.equalsIgnoreCase("name")) {
				return new WebDriverWait(driver, Constants.FIND_ELEMENT_TIMEOUT)
						.until(ExpectedConditions.visibilityOfElementLocated(By.name(elementId)));

			} else if (locType.equalsIgnoreCase("linktext")) {
				return new WebDriverWait(driver, Constants.FIND_ELEMENT_TIMEOUT)
						.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(elementId)));

			} else if (locType.equalsIgnoreCase("partiallinktext")) {
				return new WebDriverWait(driver, Constants.FIND_ELEMENT_TIMEOUT)
						.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(elementId)));

			} else if (locType.equalsIgnoreCase("css")) {
				return new WebDriverWait(driver, Constants.FIND_ELEMENT_TIMEOUT)
						.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementId)));

			} else if (locType.equalsIgnoreCase("class")) {
				return new WebDriverWait(driver, Constants.FIND_ELEMENT_TIMEOUT)
						.until(ExpectedConditions.visibilityOfElementLocated(By.className(elementId)));

			} else if (locType.equalsIgnoreCase("tagName")) {
				return new WebDriverWait(driver, Constants.FIND_ELEMENT_TIMEOUT)
						.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(elementId)));
			} else {
				return new WebDriverWait(driver, Constants.FIND_ELEMENT_TIMEOUT)
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementId)));
			}
		} catch (Exception e) {
			return element;
		}
	}
	
	/** Description: Enter a value or text in the element */
	public void enterText(String locator, String locatorType, String value) {
		WebElement element = findElement(locator, locatorType);
		element.clear();
		element.sendKeys(value);
	}

	/** Description: Click an element on the screen */
	public void click(String locator, String locatorType) {
		
		WebElement element = findElement(locator, locatorType);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		element.click();
	}
	
	/** Description: Validate if the expected matches the actual value */
	public void verifyText(String locator, String locatorType, String expectedValue) {
		WebElement element = findElement(locator, locatorType);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String actualValue = element.getText();
		if (expectedValue.trim().equals(actualValue.trim())) {
			BaseTest.logger("Expected value " + expectedValue + " is EQUALS to actual value " + actualValue);
		} else {
			BaseTest.logger("Expected value " + expectedValue + " is NOT EQUALS to actual value " + actualValue);
		}
	}
	
	
	/** Description: Select value from list */
	public void selectFromList(String locator, String locatorType, String value) {
		WebElement element = findElement(locator, locatorType);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(value);
	}
	

}
