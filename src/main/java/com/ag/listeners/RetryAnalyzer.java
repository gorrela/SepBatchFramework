package com.ag.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.ag.dataprovider.ConfigUtility;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int retryCount =0;
	private int maxRetryCount = Integer.parseInt(ConfigUtility.readProperty("retry"));
	public boolean retry(ITestResult result) // result will have all the info whether pass or fail
	{
		if (retryCount<maxRetryCount)
		{
			retryCount ++;
			return true;
			
		}
				
		return false;
	}

}

//if test method is sucess it willnt execute, if result failed automatically
//RetryAnalyzer will execute, return true means it will execute one more time
// if pass it willnt execute suppose failed
