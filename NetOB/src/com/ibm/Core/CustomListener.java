package com.ibm.Core;

import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;




public class CustomListener extends TestListenerAdapter{

	@Override
	public void onTestStart(ITestResult tr) {
		log("Test Started....");
	}	
	
	public void log(Object obj){
		System.out.println(obj);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println(".................................................");
		CustomLogger.logSuccess("Test: " + tr.getMethod().getMethodName() + " PASSED");
		System.out.println(".................................................");
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println(".................................................");
		log("Test '" + tr.getClass().getName() + tr.getName() + "' FAILED");
		log("Priority of this method is " + tr.getMethod().getPriority());
		System.out.println(".....");
	}
	
	@Override
	public void onTestSkipped(ITestResult tr) {
		log("Test '" + tr.getName() + "' SKIPPED");
		System.out.println(".....");
	}
	
	private void log(String methodName) {
		System.out.println(methodName);
	}

	private void log(IClass testClass) {
		System.out.println(testClass);
	}
}
