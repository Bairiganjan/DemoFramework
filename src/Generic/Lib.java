package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Lib implements IAutoConstant {

	public static String getCellValue(String sheetName, int rowNum, int cellNo) {
		String cellValue = "";

		try {
			FileInputStream fi = new FileInputStream(EXCEL_PATH);
			Workbook wb = WorkbookFactory.create(fi);
			cellValue = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNo).toString();

		} catch (Exception e) {

		}

		return cellValue;
	}

	public static String getPropertyValue(String propertyName) {
		String propertyValue = "";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(PROPERTY_PATH));
			propertyValue = prop.getProperty(propertyName);
		} catch (Exception e) {

		}

		return propertyValue;
	}

	public static void captureScreenshot(WebDriver driver, String methodName) {
		Date d = new Date();
		String currentDate = d.toString().replaceAll(":", "_");
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(SCREENSHOT_PATH);
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {

		}
	}

	public static int getRowNum(String sheetName) {
		int rowNum = 0;
		try{
		Workbook wb = WorkbookFactory.create(new FileInputStream(PROPERTY_PATH));
		rowNum = wb.getSheet(sheetName).getLastRowNum();
		
		}catch(Exception e){
	}
		return rowNum;
	}
}
