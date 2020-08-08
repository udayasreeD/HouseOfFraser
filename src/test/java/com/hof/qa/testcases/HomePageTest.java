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

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	MyAccountPage myaccountpage;
	public HomePageTest() {
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
	public void verifyHomePageTitleTest() throws IOException {
	String homePageTitle = homepage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle, "House of Fraser - Gifts, Fashion, Beauty, Home, Furniture & Garden","Expected title is not matching");
	}
	
	@Test(priority = 3)
	public void verifyMyAccountLinkTest() {
		myaccountpage = homepage.clickOnMyAccount();
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
