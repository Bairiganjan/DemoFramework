package Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.Lib;
import PomPages.LoginPage;

public class TestInvalidLogin extends BaseTest{
	@Test
	public void invalidLogin(){
		LoginPage lp = new LoginPage(driver);
		int rowCount = Lib.getRowNum("InvalidCredentials");
		for (int i = 1; i <= rowCount; i++) {
		String userName = Lib.getCellValue("InvalidCredentials", i, 0);
		String passWord = Lib.getCellValue("InvalidCredentials", i, 1);
		lp.setUserName(userName);
		lp.setPassword(driver, 10, passWord);
		lp.clickLogin();
		
		
	}
	}
}
