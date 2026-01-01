package com.TestCases;

import org.testng.annotations.Test;

import com.BaseClass.TimeSolv_BaseClass;
import com.Pages.LoginPage;

public class Login_TestCase extends TimeSolv_BaseClass {

	@Test (enabled=false)
	public void invalidLogin() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.invalid_Cred();
		Thread.sleep(5000);
	}

	@Test (enabled=true , priority=1 , description="To test the login functionality of App ")
	public void Validlogin() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.valid_Cred();
		Thread.sleep(5000);
	}

}
