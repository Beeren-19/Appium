package com.training.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class SwipeAction {

	@Test
	public void swipeaction() throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "Redmi 9 Prime");
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10");
		dc.setCapability("UDID", "b8afcac90408");
		dc.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
		dc.setCapability("appActivity", ".TouchScreenTestActivity");
		dc.setCapability("noReset", true);
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.swipe(443, 412, 450, 1889, 500);
		driver.swipe(65, 1122, 943, 1118, 500);
		//driver.swipe(startx, starty, endx, endy, duration);
		
		Dimension size=driver.manage().window().getSize();
		int ht = size.getHeight();
		int wd = size.getWidth();
		System.out.println("height of phone is="+ht);
		System.out.println("width of phone is="+wd);
		
		/**
		 * Swipe action horizontally
		 */
		
		driver.swipe((int)(wd*0.1),(int)(ht*0.8),(int)(wd*0.9),(int)(ht*0.8),500);
		
		driver.swipe((int)(wd*0.1),(int)(ht*0.2),(int)(wd*0.9),(int)(ht*0.2),500);
		
		driver.swipe((int)(wd*0.1),(int)(ht*0.5),(int)(wd*0.9),(int)(ht*0.5),500);
		
		/**
		 * Swipe action vertically
		 */
		driver.swipe((int)(wd*0.1),(int)(ht*0.2),(int)(wd*0.1),(int)(ht*0.8),500);
		
		driver.swipe((int)(wd*0.5),(int)(ht*0.2),(int)(wd*0.5),(int)(ht*0.8),500);
		
		driver.swipe((int)(wd*0.9),(int)(ht*0.2),(int)(wd*0.9),(int)(ht*0.8),500);
}
	
	
}
