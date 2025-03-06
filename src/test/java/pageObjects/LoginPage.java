package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css ="a[href='/login']")
	WebElement loginLink;
	
	@FindBy(id ="mat-input-0")
	WebElement txtUserName;
	
	@FindBy(id ="mat-input-1")
	WebElement txtPassword;
	
	@FindBy(id ="mat-input-2")
	WebElement txtCaptcha;
	
	@FindBy(xpath ="//button[contains(text(),'Login')]")
	WebElement loginButton;
	
	public void clickLoginLink() {
		loginLink.click();
	}

	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setCaptcha(String captcha) {
		txtCaptcha.sendKeys(captcha);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
}
