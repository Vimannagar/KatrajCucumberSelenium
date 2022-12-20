package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {

	private WebDriver driver;

	private By hoverelement = By.xpath("//*[@id='nav-link-accountList']");

	private By hoversignin = By.xpath("//*[@id='nav-flyout-ya-signin']//*[@class='nav-action-button']");

	private By username = By.xpath("//*[@id='ap_email']");

	private By continuebutton = By.xpath("//*[@type='submit']");

	private By password = By.xpath("//*[@id='ap_password']");

	private By finalsigninbutton = By.xpath("//*[@id='signInSubmit']");
	
	
	private By orderslink = By.xpath("//*[@id='nav-orders']");
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public boolean isOrdersDisplayed()
	{
		WebElement element = driver.findElement(orderslink);
		
		return element.isDisplayed();
	}
	
	
	public void enterUsername()
	{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(hoverelement)).perform();
		
		driver.findElement(hoversignin).click();
		
		driver.findElement(username).sendKeys("8176867662");
		
		driver.findElement(continuebutton).click();
		
	}
	
	public void enterPassword()
	{
		driver.findElement(password).sendKeys("123456");
				
	}
	
	public void clickOnSignin()
	{
		driver.findElement(finalsigninbutton).click();
	}
	
	
	public SearchProducts doLogin(String un, String pwd)
	{
//		entering username
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(hoverelement)).perform();
		
		driver.findElement(hoversignin).click();
		
		driver.findElement(username).sendKeys(un);
		
		driver.findElement(continuebutton).click();
		
//		enter the password
		
		driver.findElement(password).sendKeys(pwd);
		
		
//		click on signin button
		
		driver.findElement(finalsigninbutton).click();
		
		
		return new SearchProducts(driver);
		
		
	}
	
	
	
}
