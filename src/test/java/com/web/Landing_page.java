package com.web;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Landing_page {

	AndroidDriver driver;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private MobileElement country_DD;

	public MobileElement getCountry_DD() {
		return country_DD;
	}

	@FindBy(id="com.androidsample.generalstore:id/nameField")
	private MobileElement nametxtfld;

	public MobileElement getNametxtfld() {
		return nametxtfld;
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private MobileElement maleradio;

	public MobileElement getMaledropdown() {
		return maleradio;
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private MobileElement femaleradio;

	public MobileElement getFemaledropdown() {
		return femaleradio;
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private MobileElement letsshopbtn;

	public MobileElement getLetsshopbtn() {
		return letsshopbtn;
	}
	
	//constructor
	public Landing_page(AndroidDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void logintoapp()
	{
		nametxtfld.sendKeys("beerendra");
		maleradio.click();
		letsshopbtn.click();	
	}
	
	public void loginapp(String name)
	{
		//getCountry_DD().click();
		getNametxtfld().sendKeys(name);
		getMaledropdown().click();
		getLetsshopbtn().click();
		
	}
}
