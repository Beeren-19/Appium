package com.tasks;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import generic.ReadDataFromPropertyFile;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class CalculatorOperation {

	@Test
	public void calculatoroperation() throws IOException
	{
		String expected = "= 115";
		ReadDataFromPropertyFile prop=new ReadDataFromPropertyFile();
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName",prop.readDataPropertyFile("deviceName"));
		dc.setCapability("automationName", prop.readDataPropertyFile("automationName"));
		dc.setCapability("platformName", prop.readDataPropertyFile("platformName"));
		dc.setCapability("platformVersion", prop.readDataPropertyFile("platformVersion"));
		dc.setCapability("UDID", prop.readDataPropertyFile("UDID"));
		dc.setCapability("appPackage", "com.miui.calculator");
		dc.setCapability("appActivity", ".cal.AllInOneCalculatorActivity");
		dc.setCapability("noReset", prop.readDataPropertyFile("noReset"));
		
		URL url=new URL("http://localhost:4724/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		WebElement eight = driver.findElementById("com.miui.calculator:id/btn_8_s");
		taponelement(driver, eight);
		WebElement five = driver.findElementById("com.miui.calculator:id/btn_5_s");
		taponelement(driver, five);
		WebElement plus = driver.findElementByAccessibilityId("plus");
		taponelement(driver, plus);
		WebElement three = driver.findElementById("com.miui.calculator:id/btn_3_s");
		taponelement(driver, three);
		WebElement zero = driver.findElementById("com.miui.calculator:id/btn_0_s");
		taponelement(driver, zero);
		WebElement equals = driver.findElementByAccessibilityId("equals");
		taponelement(driver, equals);
		String result = driver.findElementById("com.miui.calculator:id/result").getText();
		Assert.assertEquals(expected, result);
		System.out.println(result);
		
	}
	
	public void taponelement(AndroidDriver driver,WebElement element)
	{
		driver.tap(1, element, 500);
	}
}
