package com.inetBanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass
{
	
	@Test
	public void addCustomer() throws InterruptedException
	{
     LoginPage lp= new LoginPage(driver);
     Thread.sleep(1000);
      lp.setUserName(userName);
      lp.setPassword(password);
      lp.clickSubmit();

      AddCustomerPage addcust = new AddCustomerPage(driver);
      addcust.AddNewCustomerLink();
      addcust.setCustomerName("Ram");
      addcust.SetGender();
      addcust.Dob("10","10","90");
      Thread.sleep(1000);
      addcust.setCustomerAddress("Address");
      addcust.setCustomerCity("Atlanta");
      addcust.setCustomerstate("GA");
      addcust.setCustomerPin("123753");
      addcust.setCustomerMobno("1234567890");
      addcust.setCustomerEmail(custemail);
      addcust.setCustomerpassword("13135456");
      addcust.ClickSubmit();
boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
if(res==true)
	System.out.println("success message");


	else
	{
		System.out.println("Failure message");

	}
	}
 	String custemail=randomstring()+"@gmail.com";
	
 	public String randomstring()
 	{
 		String generatedString=RandomStringUtils.randomAlphabetic(8);
 		return generatedString;
 	}
}

