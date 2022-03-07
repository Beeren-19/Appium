package com.webdriver_methods;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tasks.LogintoGeneralStore;

public class Listeners implements ITestListener{

	ExtentHtmlReporter reporter; // This class is used to set path and do some config
	ExtentReports reports; //Attach the reporter and set system info
	ExtentTest test; //To create the entries in the class

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		reports.flush();
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		//Java_Utility jv=new Java_Utility();
		//String date = jv.date();
		//String time = jv.time();
		reporter=new ExtentHtmlReporter("../Appium/ExtentReports/screen.html");
		reporter.config().setDocumentTitle("Appium-19");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Smoke");
		
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("BuildNo", "1.2");
		reports.setSystemInfo("Env", "QA");
		reports.setSystemInfo("Platform", "Windows");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		
	}
	

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.FAIL, result.getName()+"is Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		
		try
		{
			String path = LogintoGeneralStore.getscreenshot(result.getName());
			test.addScreenCaptureFromPath(path);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getMethod().getMethodName()+"Skipped");
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=reports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getMethod().getMethodName()+"is Passed");
	}

	
}
