package com.webdriver_methods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Android_keyActions {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
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
		AndroidDriver driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
		Thread.sleep(2000);
		
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_UP);
		Thread.sleep(2000);
		
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		Thread.sleep(2000);
		
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
		Thread.sleep(2000);
		
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		Thread.sleep(2000);
		
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
		Thread.sleep(2000);
		
		System.out.println(AndroidKeyCode.KEYCODE_CAMERA);
		System.out.println(AndroidKeyCode.KEYCODE_VOLUME_UP);
		System.out.println(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		System.out.println(AndroidKeyCode.KEYCODE_BACK);
		System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
	}
}
