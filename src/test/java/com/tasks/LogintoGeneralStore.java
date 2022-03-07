package com.tasks;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.ReadDataFromJasonFile;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
@Listeners(com.webdriver_methods.Listeners.class)
public class LogintoGeneralStore {
	

	public static AndroidDriver staticdriver;
	public  AndroidDriver driver;
	@Test
	public void verifytheproduct() throws InterruptedException, IOException, ParseException
	{
		ReadDataFromJasonFile json=new ReadDataFromJasonFile();
		String actual="Air Jordan 4 Retro";
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", json.readDataJason("deviceName"));
		dc.setCapability("automationName", json.readDataJason("automationName"));
		dc.setCapability("platformName", json.readDataJason("platformName"));
		dc.setCapability("platformVersion", json.readDataJason("platformVersion"));
		dc.setCapability("UDID", json.readDataJason("UDID"));
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("appActivity", ".SplashActivity");
		dc.setCapability("noReset", json.readDataJason("noReset"));
		
		URL url=new URL(json.readDataJason("url"));
		 driver=new AndroidDriver(url,dc);
		 staticdriver=driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		scrollToElement(driver, "text", "India");
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='India']").click();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Beerendra");
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementByXPath("//android.widget.TextView[@text='ADD TO CART']").click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		//Assert.fail();
		String text = driver.findElementById("com.androidsample.generalstore:id/productName").getText();
		
		Assert.assertEquals(text, actual);
		System.out.println(text);
		
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		
		Thread.sleep(2000);
		
		Set<String> windows = driver.getContextHandles();
		
		for(String window:windows)
		{
			System.out.println("active pplication : "+window);
		}
		
		Thread.sleep(1000);
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		driver.findElementByXPath("//input[@name='q']").sendKeys("hai");
		
	
}
	
	public static String getscreenshot(String name) throws IOException
	{
		File srcfile=((TakesScreenshot)staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile = System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File dst=new File(destfile);
		FileUtils.copyFile(srcfile, dst);
		return destfile;
	}
	
	
	public static void scrollToElement(AndroidDriver driver, String an, String av)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}
}
