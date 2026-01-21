package com.ag.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ag.dataprovider.ConfigUtility;
import com.ag.factory.BrowserFactory;
import com.ag.helper.Utility;
import com.aventstack.chaintest.plugins.ChainTestListener;

public class MyTestNGListeners implements ITestListener{
	
	//These are unimplemented methods from ITestListeners interface and we are overriding some of them, by default
	//they are default and we are making public and now we are implementing
	public  void onTestSuccess(ITestResult result) //result varibale will have all the info about the results
	{
		
		ChainTestListener.log("LOG:INFO - Test Passed " +result.getMethod().getMethodName());
		if(ConfigUtility.readProperty("screenshotOnSuccess").equalsIgnoreCase("true"))
		{
			String base64 = Utility.capturescreenshot(BrowserFactory.getDriver(), "base64");
			ChainTestListener.embed(base64, "image/png");
		}
	}
	public  void onTestFailure(ITestResult result)
	{
		ChainTestListener.log("LOG:INFO - Test Failed" +result.getMethod().getMethodName());
		ChainTestListener.log("LOG:INFO - Exceptions" +result.getThrowable().getMessage());
		if(ConfigUtility.readProperty("screenshotOnFailure").equalsIgnoreCase("true"))
		{
			String base64 = Utility.capturescreenshot(BrowserFactory.getDriver(), "base64");
			ChainTestListener.embed(base64, "image/png");
		}
		
		
	}
	public  void onTestSkipped(ITestResult result)
	{
		ChainTestListener.log("LOG:INFO - Test Skipped" +result.getMethod().getMethodName());
		ChainTestListener.log("LOG:INFO - Exceptions" +result.getThrowable().getMessage());
		if(ConfigUtility.readProperty("screenshotOnSkip").equalsIgnoreCase("true"))
		{
			String base64 = Utility.capturescreenshot(BrowserFactory.getDriver(), "base64");
			ChainTestListener.embed(base64, "image/png");
		}
	}

}
