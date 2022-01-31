package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	
	public ReadConfig() 
	{
		File src = new File("./Configuration/config.properties");
		 FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 pro= new Properties();
		 try {
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	}
	
	public String getApplicationUrl()
	{
		String url =pro.getProperty("baseUrl");
		return url;
	}
	public String getuserName()
	{
		String username =pro.getProperty("userName");
		return username;
	}
	public String getPassword()
	{
		String password =pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String getchrome =pro.getProperty("chromePath");
		return getchrome;
	}
	public String getfirefoxPath()
	{
		String getchrome =pro.getProperty("firefoxPath");
		return getchrome;
	}
}
