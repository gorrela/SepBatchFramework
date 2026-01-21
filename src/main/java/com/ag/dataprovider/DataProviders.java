package com.ag.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="logindata") //testng data provider annotation whose name is logindata, if u dont provide providername we can use method name
	public static Object[][] getLoginData() //if we keep dataprovider in seperate class, it shd be static
	{
		System.out.println("LOG:INFO-Loading Data From Excel");
		Object[][] arr = ExcelUtility.getData("LoginDetails");//LoginDetails is excel sheet name and will return object array
		System.out.println("LOG:INFO-Test Data Is Ready");
		return arr;
		
	}

}
