package com.webdriver_methods;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Screenshots {

	 AndroidDriver driver;
	public static AndroidDriver staticdriver;
	@Test
	public void screenshot() throws InterruptedException, IOException
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
		driver=new AndroidDriver(url,dc);
		staticdriver=driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.findElementByAccessibilityId("App").click();
	 getscreenshot("screenshot");
	
		
}
	
	public static String getscreenshot(String name) throws IOException
	{
		File srcfile=((TakesScreenshot)staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile = System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File dst=new File(destfile);
		FileUtils.copyFile(srcfile, dst);
		return destfile;
	}
}

