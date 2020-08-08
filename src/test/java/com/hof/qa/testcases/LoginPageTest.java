package com.hof.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hof.qa.base.TestBase;
import com.hof.qa.pages.HomePage;
import com.hof.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest(){
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
	String title = loginpage.validateLoginPageTitle();
	Assert.assertEquals(title, "House of Fraser - Gifts, Fashion, Beauty, Home, Furniture & Garden");
	}
	
	@Test(priority = 2)
	public void hofLogoImgTest() {
	Boolean flag = loginpage.validateHofImg();
	Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	 public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
