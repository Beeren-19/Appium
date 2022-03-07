package com.training.appium;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;



public class Launch_calculator {

	@Test
	public void launchcalculator() throws MalformedURLException
	{
	    String expect="= 10";

		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "Redmi 9 Prime");
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10");
		dc.setCapability("UDID", "b8afcac90408");
		dc.setCapability("appPackage", "com.miui.calculator");
		dc.setCapability("appActivity", ".cal.AllInOneCalculatorActivity");
		dc.setCapability("noReset", true);
		URL url=new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver=new AndroidDriver(url,dc);

		//IOSDriver<WebElement>

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement seven = driver.findElementById("com.miui.calculator:id/btn_7_s");
		taponElements(driver, seven);
		WebElement plus = driver.findElementById("com.miui.calculator:id/btn_plus_s");
		taponElements(driver, plus);
		WebElement three = driver.findElementById("com.miui.calculator:id/btn_3_s");
		taponElements(driver, three);
		WebElement equals = driver.findElementById("com.miui.calculator:id/btn_equal_s");
		taponElements(driver, equals);
		String result = driver.findElementById("com.miui.calculator:id/result").getText();
		Assert.assertEquals(result, expect);
		System.out.println(result);
	}
	
	public void taponElements(AndroidDriver driver,WebElement element)
	{
		driver.tap(1, element, 500);
	}
}
