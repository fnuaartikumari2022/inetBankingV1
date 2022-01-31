package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass
{
@Test
public void loginTest() throws InterruptedException
{
	
	log.info("url open");
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(userName);
	log.info("username entered");
	Thread.sleep(1000);
	lp.setPassword(password);
	log.info("password entered");
	lp.clickSubmit();
	
	System.out.println(driver.getTitle());
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	{
		Assert.assertTrue(true);
		
	}else
	{
		Assert.assertTrue(false);
	}
	
}



	
	
	
	
}
