package com.ag.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.ag.base.BaseClass;
import com.ag.dataprovider.DataProviders;
import com.ag.pages.DashboardPage;
import com.ag.pages.LoginPage;

public class LoginTest extends BaseClass //this will inherit driver, setup and teardown

{
	
	@Test(description = "This test will check valid user login functionality",dataProvider = "logindata", dataProviderClass = DataProviders.class)
	//give me class where u have data provider
	public void validLogin(String uname, String pass) throws InterruptedException
	{
		LoginPage login = new LoginPage(driver); //this driver coming from Base class
		
		DashboardPage dashboard = login.loginToApplication(uname, pass); //will return DashboardPage object
		String WelcomeText = dashboard.getWelcomeMessage();
		Assert.assertTrue(WelcomeText.contains("Welcome"),"Login Message didnt appear");
		dashboard.signoutFromApplication();
		Assert.assertTrue(login.isHeaderPresent(),"Logout Failed - Sign In Is Not Present");
		
	    
	}
	
	
	
	
	
}
