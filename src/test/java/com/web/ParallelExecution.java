package com.web;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class ParallelExecution{

	
	@Parameters({"deviceName","platformVersion","UDID","port"})
	@Test
	public void parallelexecution(String deviceName,String platformVersion,String UDID,String port) throws MalformedURLException
	{


		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", deviceName);
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", platformVersion);
		dc.setCapability("UDID", UDID);
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("appActivity", ".SplashActivity");
		dc.setCapability("noReset", true);
		

		URL url=new URL("http://localhost:"+port+"/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
