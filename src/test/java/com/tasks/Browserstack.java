package com.tasks;


	
	

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
	      
	public class Browserstack {

	  public static void main(String[] args) throws MalformedURLException, InterruptedException {
	    
	      DesiredCapabilities caps = new DesiredCapabilities();
	      
	      // Set your access credentials
	      caps.setCapability("browserstack.user", "beerendrakumargk_3SIdef");
	      caps.setCapability("browserstack.key", "vKXGVaPsJpECrRCdNAv8");
	      
	      // Set URL of the application under test
	      caps.setCapability("app", "bs://cd5661410851cab6df117a9b504e1e81bad010ac");
	      
	      // Specify device and os_version for testing
	      caps.setCapability("device", "Google Pixel 3");
	      caps.setCapability("os_version", "9.0");
	        
	      // Set other BrowserStack capabilities
	      caps.setCapability("project", "First Java Project");
	      caps.setCapability("build", "Java Android");
	      caps.setCapability("name", "first_test");
	        
	      
	      // Initialise the remote Webdriver using BrowserStack remote URL
	      // and desired capabilities defined above
	        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
	            new URL("http://hub.browserstack.com/wd/hub"), caps);
	        
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
			//driver.findElementById("android:id/button1").click();
			driver.findElementByAccessibilityId("Views").click();
			List<AndroidElement> eles = driver.findElementsByClassName("android.widget.TextView");
			
			for(int i=0;i<eles.size();i++)
			{
				String options = eles.get(i).getText();
				System.out.println(options);
			}
			
			driver.closeApp();
	  }

}
	  
