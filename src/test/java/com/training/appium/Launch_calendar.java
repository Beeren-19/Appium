package com.training.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xddf.usermodel.text.UnderlineType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Launch_calendar {

	@Test
	public void launchcalendar() throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "Redmi 9 Prime");
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10");
		dc.setCapability("UDID", "b8afcac90408");
		dc.setCapability("appPackage", "com.xiaomi.calendar");
		dc.setCapability("appActivity", "com.android.calendar.homepage.AllInOneActivity");
		dc.setCapability("noReset", true);
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElementById("android:id/button1").click();
		//driver.findElementById("com.xiaomi.calendar:id/change_language").click();
		driver.findElementByAccessibilityId("8 September 2021 ( according to lunar calendar).Wednesday");
		
		
	}
}

