package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.lang3.RandomStringUtils;

public class AddCustomerPage {
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	//@FindBy(xpath="//a[contains(text(),'New Customer']")
	@FindBy(linkText="New Customer")
	WebElement addNewCutomerLink;
	
	@FindBy(name="name")
	WebElement txtCutomerName;
	
	@FindBy(xpath="//input[@value='f']")
	WebElement selectGender;
	
	
	@FindBy(name="dob")
	WebElement Dob;
	
	@FindBy(name="addr")
	WebElement Addr;
	
	@FindBy(name="city")
	WebElement City;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pin;
	
	@FindBy(name="telephoneno")
	WebElement mobilenumber;
	
	@FindBy(name="emailid")
	WebElement Emailid;
	

	@FindBy(name="password")
	WebElement password;

	@FindBy(name="sub")
	WebElement Submit;
	
	public void AddNewCustomerLink()
	{addNewCutomerLink.click();}
	
	public void setCustomerName(String custname)
	{txtCutomerName.sendKeys(custname);}
	
	public void SetGender()
	{selectGender.click();}

	public void Dob(String mm,String dd,String yy)
	{
		Dob.sendKeys(mm);
		Dob.sendKeys(dd);
		Dob.sendKeys(yy);
		}
	public void setCustomerAddress(String addr)
	{Addr.sendKeys(addr);}
	public void setCustomerCity(String city)
	{City.sendKeys(city);}
	public void setCustomerstate(String State)
	{state.sendKeys(State);}
	public void setCustomerPin(String pinno)
	{pin.sendKeys(String.valueOf(pinno));}
	
	public void setCustomerMobno(String mobno)
	{mobilenumber.sendKeys(String.valueOf(mobno));}
	
	public void setCustomerEmail(String email)
	{Emailid.sendKeys(email);}
	public void setCustomerpassword(String Password)
	{password.sendKeys(Password);}
	public void ClickSubmit()
	{Submit.click();}
	
	

	
}


