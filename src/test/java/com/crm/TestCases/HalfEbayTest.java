package com.crm.TestCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.TestBase.TestBase;
import com.crm.TestUtils.TestUtil;

public class HalfEbayTest extends TestBase {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\Auto self\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.com/reg/PartialReg?rv4=1");
	}
	
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testdata = TestUtil.getDataFromExcel();
		return testdata.iterator();
	}
	
	@Test(dataProvider = "getTestData")
	public void ebayUserDetails(String firstName, String lastName, String email, String password){
		
	
		driver.findElement(By.xpath("//label[text()='First name']")).clear();
		driver.findElement(By.xpath("//label[text()='First name']")).sendKeys(firstName);
		
		driver.findElement(By.xpath("//label[text()='Last name']")).clear();
		driver.findElement(By.xpath("//label[text()='Last name']")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//label[text()='Email']")).clear();
		driver.findElement(By.xpath("//label[text()='Email']")).sendKeys(email);
		
		driver.findElement(By.xpath("//label[text()='Password']")).clear();
		driver.findElement(By.xpath("//label[text()='Password']")).sendKeys(password);
	}
	
	
	
	
	
	@AfterMethod
	public void close(){
		driver.quit();
	}
	

}
