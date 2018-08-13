package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic.BaseTest;
import Generic.Lib;
import PomPages.ActiTIMEHomePage;
import PomPages.LoginPage;

public class VeifyActiTIMEproductVersion extends BaseTest{
	@Test
	public void verifyActiTIMEProductVersion() throws InterruptedException{
		LoginPage lp = new LoginPage(driver);
		String username = Lib.getCellValue("ValidCredentials", 1, 0);
		String password = Lib.getCellValue("ValidCredentials", 1, 1);
		lp.setUserName(username);
		lp.setPassword(driver, 10, password);
		lp.clickLogin();
		ActiTIMEHomePage act = new ActiTIMEHomePage(driver);
		act.clickHelp();
		
		act.clickAboutActiTIME();
		WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(3000);
		String actualProductVersionText = act.getProductVersionText();
		String ExpectedText = Lib.getPropertyValue("PRODUCTVERSIONTEXT");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualProductVersionText, ExpectedText);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/img/default/support/about/close.gif?hash=1692528820']")));
		act.closeButtonClick();
		act.clickLogout();
		sa.assertAll();
		
	}
}
