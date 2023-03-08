package com.bcr.base;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.bcr.common.Constants;

public class BaseTest {
	
	public static WebDriver driver;
	public static XSSFSheet excelSheet;
	public static XSSFWorkbook excelWorkbook;
	public static Cell cell;
	public static XSSFRow row;

	@BeforeTest
	public void startTest() throws Exception {
		
		//System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
		String testCase = this.getClass().getSimpleName();
		logger("*****Executing " + testCase + "*****");
	}
	
	@BeforeMethod
	public void openUrl() throws Exception {
		logger("Running test in Chrome");		
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
		driver = new ChromeDriver();
		driver.get(readConfig("URL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeBrowser() {
		logger("Closing the browser");
		driver.close();
		driver.quit();
	}

	@AfterTest
	public void endTest() {
		String testCase = this.getClass().getSimpleName();
		logger("*****Terminating " + testCase + "*****");
	}

	public static void logger(String message) {
		System.out.println(message);
		Reporter.log(message);
	}

	@DataProvider(name = "testData")
	public Object[][] excelData() throws Exception {
		String filePath = System.getProperty("user.dir") + System.getProperty("excel.file.path");
		String sheetName = System.getProperty("excel.sheet.name");
		Object[][] arrObj = getExcelData(filePath, sheetName);

		return arrObj;
	}

	public static String readConfig(String parameter) throws Exception {
		FileReader reader = new FileReader(Constants.CONFIG_PROP);
		Properties configProp = new Properties();
		configProp.load(reader);
		String configParameter = configProp.getProperty(parameter);

		return configParameter;
	}

	public String[][] getExcelData(String fileName, String sheetName) {

		String[][] data = null;

		try {
			FileInputStream fis = new FileInputStream(fileName);
			excelWorkbook = new XSSFWorkbook(fis);
			excelSheet = excelWorkbook.getSheet(sheetName);
			row = excelSheet.getRow(0);

			int rowNum = excelSheet.getPhysicalNumberOfRows();
			int colNum = row.getLastCellNum();

			data = new String[rowNum - 1][colNum];

			for (int i = 1; i < rowNum; i++) {
				for (int j = 0; j < colNum; j++) {
					row = excelSheet.getRow(i);
					cell = row.getCell(j);
					DataFormatter formatter = new DataFormatter();
					String cellData = formatter.formatCellValue(cell);
					data[i - 1][j] = cellData;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

}
