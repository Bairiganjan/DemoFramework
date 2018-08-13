package PomPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTIMEHomePage {
	WebDriver driver;
	@FindBy(xpath="//span[text()='Help & Support']")
	WebElement helpBtn;
	
	@FindBy(xpath="//div[contains(text(),'About actiTIME')]")
	WebElement aboutActiTime;
	
	@FindBy(xpath="//td[text()='3.1 (build 15563), Auto-installation package']")
	WebElement productVersion;
	
	@FindBy(xpath="//img[@src='/img/default/support/about/close.gif?hash=1692528820']")
	WebElement closeButton;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logOutButton;
	
	public ActiTIMEHomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void clickHelp(){
		helpBtn.click();
	}
	public void clickAboutActiTIME(){
		aboutActiTime.click();
	}
	public String getProductVersionText(){
		String productVesionText = productVersion.getText();
		
		return productVesionText;
	}
	
	public void closeButtonClick(){
	closeButton.click();
	}
	
	public void clickLogout(){
		logOutButton.click();
	}
	
}
