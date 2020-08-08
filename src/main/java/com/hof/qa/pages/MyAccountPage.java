package com.hof.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hof.qa.base.TestBase;
import com.hof.qa.util.TestUtil;

public class MyAccountPage extends TestBase {
	TestUtil testutil = new TestUtil();
	HomePage homepage =new HomePage();
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccount;
	
	@FindBy(id = "txtEmailAddress")
	WebElement email;
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyAccountDetailTitle() throws IOException {
		System.out.println(driver.getTitle());
		testutil.takeScreenShot();
		return driver.getTitle();
	}
	public String clickOnAccountDetails(String name) {
		testutil.selectValueFromDropDownUsingVisibleText(name);
		return email.getText();
	}
	
}

