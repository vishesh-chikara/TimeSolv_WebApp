package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.BaseClass.TimeSolv_BaseClass;

public class LoginPage extends TimeSolv_BaseClass {
	// private static final WebElement InvalidPassword = null;

	@FindBy(id = "RichWidgets_wt91_block_wtMainContent_wtUserNameInput")
	WebElement Username;

	@FindBy(id = "RichWidgets_wt91_block_wtMainContent_wtPasswordInput")
	WebElement password;

	@FindBy(id = "RichWidgets_wt91_block_wtMainContent_wtLoginButton")
	WebElement Login_Button;

	@FindBy(xpath = "//span[@class='Feedback_Message_Text']")
	WebElement ErrorDisplayed;
	
	

	// Creating a constructor to initialize the value in another class


	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Login with invalid credentials
	public void invalid_Cred() throws InterruptedException {
		Username.sendKeys("vish12345@gmail.com");
		password.sendKeys("123456789");
		Login_Button.click();

		
		Assert.assertTrue(ErrorDisplayed.isDisplayed(),"Invalid username or password.");
		Thread.sleep(8000);
	}

	public void valid_Cred() throws InterruptedException {
		Username.sendKeys("Vishesh-Kumar-QA-Firm");
		password.sendKeys("Test@12345678");
		Login_Button.click();
		Thread.sleep(8000);
	}
}
