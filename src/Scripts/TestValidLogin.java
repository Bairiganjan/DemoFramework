package Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.Lib;
import PomPages.LoginPage;

public class TestValidLogin extends BaseTest{
	@Test
	public void validLogin() throws InterruptedException{
	
	LoginPage lp = new LoginPage(driver);
	
	String userName = Lib.getCellValue("ValidCredentials", 1, 0);
	String passWord = Lib.getCellValue("ValidCredentials", 1, 1);
	
	//Enter valid username
	lp.setUserName(userName);
	
	//Enter valid password
	lp.setPassword(driver, 10, passWord);
	
	//Click on login
	lp.clickLogin();
	Thread.sleep(2000);
	
	
	
	}
}
