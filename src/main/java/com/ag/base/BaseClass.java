package com.ag.base;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ag.dataprovider.ConfigUtility;
import com.ag.factory.BrowserFactory;

public class BaseClass {
	
  public WebDriver driver; //as the driver is used in all methods, we write this class wise
                     //when we dont provide any access modifier, it will take default and default is accessible only within same package
	                  // but we need to access in different package com.ag.testcase, so make it public
	@BeforeClass
	public void setup()
	{
		System.out.println("LOG:INFO-Running Before Class");
		String browserName = ConfigUtility.readProperty("browser");
		String url = ConfigUtility.readProperty("qaurl");
		driver = BrowserFactory.startBrowser(browserName, url+"/login");
		System.out.println("LOG:INFO-Browser is up and running");
	}
	@AfterClass
	public void teardown()
	{
		System.out.println("LOG:INFO-Running After Class");
		driver.quit();
		System.out.println("LOG:INFO-Session Closed");
	}

}
