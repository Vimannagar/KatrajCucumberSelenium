package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProducts {
	
	private WebDriver driver;

	private By searchtextbox = By.xpath("//*[@id='twotabsearchtextbox']");

	private By searchbutton = By.xpath("//*[@id='nav-search-submit-button']");

	

	
	
	public SearchProducts(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void enterText(String text)
	{
		driver.findElement(searchtextbox).sendKeys(text);
		
		driver.findElement(searchbutton).click();
	}
	
	
	public String titleOfPage()
	{
		String titleofpage = driver.getTitle();
		return titleofpage;
		
	}
	
	
	
}
