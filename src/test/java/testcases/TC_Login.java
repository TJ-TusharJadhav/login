package testcases;

import org.testng.annotations.Test;

import testbase.baseclass;

public class TC_Login extends baseclass {
	@Test
	public void Valid_Login() {
		login();
	    login.VerifysuccessfullyMessage();
  }
	@Test
	public void Invalid_Login() {
		login.EnterEmailOnLoginPage("asstudent1");
    	login.EnterPasswordOnLoginPage("Psfdassword12345");
    	login.ClickLoginButton();
        login.VerifyunsuccessfullyMessage();
  }
	@Test
	public void Blank_Login() {
		login.ClickLoginButton();
        login.VerifyunsuccessfullyMessage();
	
  }

}
