package com.hof.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hof.qa.base.TestBase;

public class LoginPage extends TestBase{

	//List of WebElemnts
	@FindBy(xpath = "//span[text()='Sign In']")
	WebElement signInBtn;
	
	@FindBy(id = "Login_EmailAddress")
	WebElement username;
	
	@FindBy(id = "Login_Password")
	WebElement password;
	
	@FindBy(id = "LoginButton")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='LogoWrap']")
	WebElement hofLogo;
	
	//Initializing the Page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateHofImg() {
		return hofLogo.isDisplayed();
	}
	
	public HomePage login(String uname , String pword) {
		signInBtn.click();
		username.sendKeys(uname);
		password.sendKeys(pword);
		loginBtn.click();
		return new HomePage();
	}
}
