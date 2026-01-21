package com.ag.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigUtility {
	
	public static String readProperty(String KeyName) //dont want to create multiple objects of config file
	{
		System.out.println("LOG:INFO - Reading" + " "+ KeyName+ " "+ "From Config File");
		String value = null;
		try
		{
		File src = new File(System.getProperty("user.dir")+"/Configuration/config.properties"); 
		FileInputStream fis = new FileInputStream(src);
		Properties pro = new Properties();
		pro.load(fis);
		 value = pro.getProperty(KeyName);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Failed to locate config file" +e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("Failed to load/read config file" +e.getMessage());
		}
		return value;
		
	}
	
	public static String readProperty(String KeyName, String configName) //dont want to create multiple objects of config file
	{
		
		String value = null;
		try
		{
		File src = new File(System.getProperty("user.dir")+"/Configuration/"+configName+".properties"); 
		FileInputStream fis = new FileInputStream(src);
		Properties pro = new Properties();
		pro.load(fis);
		 value = pro.getProperty(KeyName);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Failed to locate config file" +e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("Failed to load/read config file" +e.getMessage());
		}
		return value;
		
	}

}
