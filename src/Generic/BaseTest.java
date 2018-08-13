package Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant{
	public static WebDriver driver;
	static{
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
	}
	@BeforeMethod
	public void launchBrowser(){
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		String url = Lib.getPropertyValue("URL");
		driver.get(url);
	}
	@AfterMethod
	public void closeBrowser(ITestResult res){
		if(ITestResult.FAILURE==res.getStatus()){
			Lib.captureScreenshot(driver, res.getName());
		}
	}
}
