package com.ag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class DashboardPage {
	
WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver= driver;
		
	}
	
	private By sideMenu = By.xpath("//img[@alt='menu']");
	private By signout = By.xpath("//button[text()='Sign out']");
	private By welcomeMsg = By.className("welcomeMessage");
	
	
	public String getWelcomeMessage()
	{
		String welcomeText = driver.findElement(welcomeMsg).getText();
		return welcomeText;
	}
	
	
	
	public void signoutFromApplication() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(sideMenu).click();
		driver.findElement(signout).click();
	}

}



