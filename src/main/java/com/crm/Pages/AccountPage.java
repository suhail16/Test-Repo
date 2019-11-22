package com.crm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.TestBase.TestBase;

public class AccountPage extends TestBase {

	@FindBy(xpath = "//div[contains(@class, 'lCoei YZVTmd SmR8')]")
	WebElement selectUser;
	
	@FindBy(xpath = "//div[@class = 'qZp31e']")
	WebElement pageLogo;
	
	@FindBy(xpath = "//div[contains(text(),'Email or phone')]")
	WebElement emailTextField;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextbtn;
	
	@FindBy(xpath = "//button[contains(text(),'Forgot email?')]")
	WebElement forgotEmailLink;
	
	@FindBy(xpath = "//span[contains(text(),'Create account')]")
	WebElement createAccountLink;
	
	@FindBy(xpath = "//a[text() = 'Learn more']")
	WebElement learnMoreLink;
	
	@FindBy(xpath = "//div[contains(text(),'Enter your password')]")
	WebElement passwordtextField;
	
	@FindBy(xpath = "//input[@type = 'email']")
	WebElement phoneNumberField;
	
	@FindBy(xpath = "//div[contains(text(),'For myself')]")
	WebElement secondaryOption;
	
	@FindBy(xpath = "//h1")
	WebElement headerComparison;
	

	public AccountPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void selectUser(){
	selectUser.click();
}
	
	public boolean pageLogo(){
		return pageLogo.isDisplayed();
	}
	
	public String verifyPageTitle()
	{
		return driver.getTitle();
	}
	
	public void loginUsingEmail(String mail, String pwd)
	{
		emailTextField.sendKeys(mail);
		nextbtn.click();
		passwordtextField.sendKeys(pwd);
		
	}

	public boolean clickForgotMailLink(){
		forgotEmailLink.click();
		return phoneNumberField.isDisplayed();
	}
	
	public String clickLearnMoreLink(){
		learnMoreLink.click();
		return driver.getTitle();
	}
	
	public boolean clickCreateAccountLink(){
		createAccountLink.click();
		secondaryOption.click();
		return headerComparison.isDisplayed();
		 
	}
	
	
	
	
	
	
	
}

