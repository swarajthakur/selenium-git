package com.mycompany.app.toolinterface.Reporting;

import com.mycompany.app.toolinterface.Reporting.SeleniumReporting;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter{
	private SeleniumReporting seleniumreporting = new SeleniumReporting();
	
	public void onStart(ITestContext testContext) {
		seleniumreporting.logTestResult("LISTENER REPORTS: STARTING SUITE RUN");
	}
	
	public void onTestStart(ITestResult tr) {
		seleniumreporting.logTestResult("LISTENER REPORTS: TEST STARTED");
	}
  
	public void onTestFailure(ITestResult tr) {
		seleniumreporting.logTestResult("LISTENER REPORTS: FAILED");;
	}
	
	public void onTestSkipped(ITestResult tr) {
		seleniumreporting.logTestResult("LISTENER REPORTS: SKIPPED");
	}
	
	public void onTestSuccess(ITestResult tr) {
		seleniumreporting.logTestResult("LISTENER REPORTS: PASSED");
	}
}
