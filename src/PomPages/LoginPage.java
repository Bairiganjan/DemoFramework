package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	@FindBy(name="username")
	WebElement unObj;
	
	@FindBy(name="pwd")
	WebElement pwdObj;
	
	@FindBy(id="loginButton")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un){
		unObj.sendKeys(un);
	}
	
	public void setPassword(WebDriver driver,int timeout , String pwd){
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(pwdObj));
		pwdObj.sendKeys(pwd);
	}
	
	public void clickLogin(){
		loginBtn.click();
	}
	
}

