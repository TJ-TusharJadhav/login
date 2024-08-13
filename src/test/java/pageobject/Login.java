package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.baseclass;

public class Login extends baseclass{
	@FindBy (xpath="//*[@id=\"username\"]")
	WebElement emailOnLogin;

	@FindBy (xpath="//*[@id=\"password\"]")
	WebElement passwordOnLogin;

	@FindBy (xpath="//*[@id=\"submit\"]")
	WebElement loginButton;

	@FindBy (xpath="//*[@id=\"loop-container\"]/div/article/div[1]/h1")
	WebElement successfullyMessage;
	
	@FindBy (xpath="//*[@id=\"error\"]")
	WebElement unsuccessfullyMessage;

	public Login() {
		PageFactory.initElements(driver, this);
	}

	public void EnterEmailOnLoginPage(String email) {
		emailOnLogin.sendKeys(email);
	}
	public void EnterPasswordOnLoginPage(String pass) {
		passwordOnLogin.sendKeys(pass);
	}
	public void ClickLoginButton() {
		loginButton.click();
	}
	public void VerifysuccessfullyMessage() {
		if (successfullyMessage.isDisplayed()) {
	        System.out.println("successfullyMessage is displayed.");
	    } else {
	        throw new AssertionError("successfullyMessage not displayed.");
	    }
	}
	public void VerifyunsuccessfullyMessage() {
		if (unsuccessfullyMessage.isDisplayed()) {
	        System.out.println("unsuccessfullyMessage is displayed.");
	    } else {
	        throw new AssertionError("unsuccessfullyMessage not displayed.");
	    }
	}
}
