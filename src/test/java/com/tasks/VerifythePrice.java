package com.tasks;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import generic.ReadDataFromPropertyFile;
import io.appium.java_client.android.AndroidDriver;

public class VerifythePrice {

	@Test
	public void verifytheproduct() throws InterruptedException, IOException
	{
	
		ReadDataFromPropertyFile prop=new ReadDataFromPropertyFile();
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName",prop.readDataPropertyFile("deviceName"));
		dc.setCapability("automationName",prop.readDataPropertyFile("automationName"));
		dc.setCapability("platformName", prop.readDataPropertyFile("platformName"));
		dc.setCapability("platformVersion", prop.readDataPropertyFile("platformVersion"));
		dc.setCapability("UDID", prop.readDataPropertyFile("UDID"));
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("appActivity", ".SplashActivity");
		dc.setCapability("noReset", prop.readDataPropertyFile("noRest"));
		
		URL url=new URL(prop.readDataPropertyFile("url"));
		AndroidDriver driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		scrollToElement(driver, "text", "India");
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='India']").click();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Beerendra");
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementByXPath("//android.widget.TextView[@text='ADD TO CART']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='ADD TO CART']").click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		String price1 = driver.findElementByXPath("//android.widget.TextView[@text='$160.97']").getText();
		System.out.println(price1);
		String price2 = driver.findElementByXPath("//android.widget.TextView[@text='$120.0']").getText();
		System.out.println(price2);
//		Assert.fail();
//		String[] arr=price1.split(" ");
//		String d1=arr[0];
//		String p1=arr[1];
//		System.out.println(p1);
//		
//		String[] arr1=price2.split(" ");
//		String d2=arr1[0];
//		String p2=arr1[1];
//		System.out.println(p2);
}
	
	public static void scrollToElement(AndroidDriver driver, String an, String av)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}
}
