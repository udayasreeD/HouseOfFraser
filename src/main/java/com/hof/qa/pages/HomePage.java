package com.hof.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hof.qa.base.TestBase;
import com.hof.qa.util.TestUtil;

public class HomePage extends TestBase {
	TestUtil testutil = new TestUtil();
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccount;
	
	@FindBy(id = "txtSearch")
	WebElement search;
	
	@FindBy(xpath = "//li[@class='mmHasChild root colGroupStart hofGroupB")
	WebElement sale;
	
	@FindBy(xpath = "//a[(text()='Brands')]")
	WebElement brands;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() throws IOException {
		testutil.takeScreenShot();
		return driver.getTitle();
	}
	
	public MyAccountPage clickOnMyAccount() {
		myAccount.click();
		return new MyAccountPage();
	}
	
	public SalePage clickOnSale() {
		sale.click();
		return new SalePage();
	}
	
	public BrandsPage clickOnBrands() {
		brands.click();
		return new BrandsPage();
	}
	
	public SearchPage clickOnSearch() {
		search.click();
		return new SearchPage();
	}
	
}
