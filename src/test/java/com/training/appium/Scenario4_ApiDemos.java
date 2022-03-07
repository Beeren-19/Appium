package com.training.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Scenario4_ApiDemos {
	@Test
	public void scenario4() throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "Redmi 9 Prime");
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10");
		dc.setCapability("UDID", "b8afcac90408");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		dc.setCapability("noReset", true);
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
		//driver.findElementById("android:id/button1").click();
		driver.findElementByAccessibilityId("Views").click();
		driver.findElementByAccessibilityId("Controls").click();
		driver.findElementByAccessibilityId("2. Dark Theme").click();
		driver.hideKeyboard();
		driver.findElementById("io.appium.android.apis:id/spinner1").click();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Earth']").click();
		driver.findElementById("io.appium.android.apis:id/spinner1").click();
		List<WebElement> planets = driver.findElementsByClassName("android.widget.CheckedTextView");
		for(WebElement option:planets)
		{
			System.out.println(option.getText());
			
			
			
		}
		

	}

}
