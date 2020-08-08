package com.hof.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hof.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
public TestBase(){
	try {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Udaya\\Selenium\\HOF\\src\\main\\java\\com\\hof\\qa\\config\\config.properties");
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}	
}
public static void initialization() {
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Udaya\\Softwares\\Selenium_Software\\chrome\\chromedriver_win32 (2)\\chromedriver.exe");
		driver=new ChromeDriver();
	}else if(browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver","C:\\Udaya\\Softwares\\Selenium_Software\\gecko\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
}
}
