package com.ibm.Core;

import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;



public class CustomListener extends TestListenerAdapter{

	@Override
	public void onTestStart(ITestResult tr) {
		log("Test "+ tr.getTestName() + " Started....");
	}	
	
	public void log(Object obj){
		System.out.println(obj);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		CustomLogger.logSuccess("Test: " + tr.getMethod().getMethodName() + " PASSED");
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		CustomLogger.logSuccess("Test: " + tr.getMethod().getMethodName() + " FAILED");

	}
	
	@Override
	public void onTestSkipped(ITestResult tr) {
		CustomLogger.logSuccess("Test: " + tr.getMethod().getMethodName() + " SKIPPED");
	}
	
	private void log(String methodName) {
		System.out.println(methodName);
	}

	private void log(IClass testClass) {
		System.out.println(testClass);
	}
}
