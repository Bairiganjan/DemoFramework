package Scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.Lib;
import PomPages.LoginPage;

public class TestValidLogin extends BaseTest{
	@Test
	public void validLogin() throws InterruptedException{
	Logger log = LogManager.getLogger(TestValidLogin.class.getName());
	log.debug("Creating an object of login page");
	LoginPage lp = new LoginPage(driver);
	log.info("Object of login page created successfully");
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
