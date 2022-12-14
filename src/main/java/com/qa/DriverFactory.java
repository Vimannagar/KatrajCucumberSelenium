package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


public WebDriver initDriver(String browser)
{
	if(browser.equals("Chrome"))
	{
		tlDriver.set(new ChromeDriver());
	}
	else if(browser.equals("Firefox"))
		{
		tlDriver.set(new FirefoxDriver());
		}
	
	else
	{
		System.out.println("Please check the name of browser");
	}
	
	getDriver().manage().window().maximize();
	
	return getDriver();
	
}


public static synchronized WebDriver getDriver()
{
	return tlDriver.get();
}
	





}
