package com.hof.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hof.qa.base.TestBase;
import com.hof.qa.pages.HomePage;
import com.hof.qa.pages.LoginPage;
import com.hof.qa.pages.MyAccountPage;

public class MyAccountPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	MyAccountPage myaccountpage ;
	public MyAccountPageTest() {
		super();
	}
	@BeforeClass
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		myaccountpage = new MyAccountPage();
	}
	
	@Test(priority = 1)
	 public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 2)
	public void verifyAccountDetailsTitleTest() throws IOException {
		String accountDetailsTitle = myaccountpage.verifyAccountDetailTitle();
		System.out.println(accountDetailsTitle);
		Assert.assertEquals(accountDetailsTitle, "House of Fraser > Account Information","Expected title is not matching");
	}
	
	@Test(priority = 3 )
	public void verifyAccountDetailsLinkTest() {
		String EmailVerify = myaccountpage.clickOnAccountDetails("Account Details");
		Assert.assertEquals(EmailVerify, prop.getProperty("username"),"email is not matching");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
