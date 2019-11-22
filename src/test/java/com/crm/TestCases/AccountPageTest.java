package com.crm.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.Pages.AccountPage;
import com.crm.TestBase.TestBase;

public class AccountPageTest extends TestBase {
	
	AccountPage accountPage;
	public AccountPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp(){
		initialize();
		accountPage = new AccountPage();
		
	}
	
	/*@Test
	public void selectUserTest()
	{
		accountPage.selectUser();
	}*/
	
	@Test
	public void pageLogoTest()
	{
		Boolean b = accountPage.pageLogo();
		Assert.assertTrue(b);
	}
	
	@Test
	public void verifyPageTitleTest(){
		String title = accountPage.verifyPageTitle();
		Assert.assertEquals(title, "Gmail");
	}
	
	@Test
	public void loginUsingEmailTest(){
		accountPage.loginUsingEmail(pro.getProperty("username"), pro.getProperty("password"));
	}
	
	@Test
	public void clickForgotMailLinkTest(){
		boolean field = accountPage.clickForgotMailLink();           
		Assert.assertTrue(field);
	}
	
	@Test
	public void clickLearnMoreLinkTest(){
		String learntitle = accountPage.clickLearnMoreLink();
		Assert.assertEquals(learntitle, "Browse Chrome as a guest - Computer - Google Chrome Help");
	}
	
	@Test
	public void clickCreateAccountLinkTest()
	{
		Boolean head = accountPage.clickCreateAccountLink();
		Assert.assertTrue(head);
		
	}
	
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
