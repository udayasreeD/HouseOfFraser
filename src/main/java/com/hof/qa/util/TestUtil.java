package com.hof.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.hof.qa.base.TestBase;

public class TestUtil extends TestBase{
  public static long PAGE_LOAD_TIMEOUT=20;
  public static  long IMPLICIT_WAIT=10;
  
  public void switchToFrame(String frameName) {
	  driver.switchTo().frame(frameName);
  }
  public void selectValueFromDropDownUsingIndex(WebElement element,int value) {
	  Select s=new Select(element);
	  s.selectByIndex(value);
  }
 public void selectValueFromDropDownUsingVisibleText(String name) {
	  Select s=new Select(driver.findElement(By.xpath("//span[text()='My Account']")));
	  s.selectByVisibleText(name);
  }
 public void selectValueFromDropDownUsingValue(WebElement element,String value) {
	  Select s=new Select(element);
	  s.selectByValue(value);
 }
 public void takeScreenShot() throws IOException {
	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 String currentDir = System.getProperty("user.dir");
	 FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
 }
}
