package com.webdriver_methods;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Logs {

	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AppiumDriverLocalService service= AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
		.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
		.usingPort(4723)
		.withLogFile(new File("..\\Appium\\Logs.txt")));
		
		service.start();

		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "Redmi 9 Prime");
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10");
		dc.setCapability("UDID", "b8afcac90408");
		dc.setCapability("appPackage", "com.android.camera");
		dc.setCapability("appActivity", ".Camera");
		dc.setCapability("noReset", true);
		
		URL url=new URL("http://localhost:4723/wd/hub");
		driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		service.stop();
		
	}
}