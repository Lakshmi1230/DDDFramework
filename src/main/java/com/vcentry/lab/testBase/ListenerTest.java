package com.vcentry.lab.testBase;

import javax.naming.spi.DirStateFactory.Result;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerTest extends BaseClass implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
		log.info("******************Execution End*******************");
		
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		log.info("******************Execution Start*******************");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		test.log(Status. FAIL,"Test Failed "+arg0.getThrowable());
	  test.addScreenCaptureFromPath(Screenshot());
	  log.error(arg0.getName()+"is Failed");
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		test.log(Status. SKIP,"Test Skipped");
		log.info(arg0.getName()+"is Skipped");
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		test=extent.createTest(arg0.getName());
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		test.log(Status. PASS,"Test Passed");
		log.info(arg0.getName()+"is passed");

	
	}

}
	


