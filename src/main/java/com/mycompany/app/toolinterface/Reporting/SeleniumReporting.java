package com.mycompany.app.toolinterface.Reporting;

import java.io.File;
import com.mycompany.app.toolinterface.Utility.DateAndTime;
import org.testng.Reporter;

public class SeleniumReporting {
	
	public void logTestResult(String result){ 	
		
		// prefix result with date and time
		result = DateAndTime.getDateTime() + " TEST INFO: "+ result;
		
		logToConsole(result);
		Reporter.log(result);
	}
	
	private void logToConsole(String result) {
		System.out.println(result);
	}
	
	public String createReportDirectory() throws Exception {
		String testExecutionStartTime = DateAndTime.getDateTime("yyyy-MM-dd HH-mm-ss");
		/* Also store the test execution time in TestParams */
		String currentDir = System.getProperty("user.dir");
		String fullReportDir = currentDir + "/reports/" + testExecutionStartTime;
		File f = new File(fullReportDir);
		/* Create the higher level report directory */
		try {
			if (f.mkdirs())
				System.out.println("NEW REPORT DIRECTORY CREATED SUCCESSFULLY");
			else
				System.out.println("REPORT DIRECTORY CREATION UNSUCCESSFUL");
		} catch (Exception e) {
			throw new Exception(e);
		}
		
//		/* Create the able log directory */
//		File f2 = new File(fullReportDir + "/logDirectory");
//		try {
//			if (f2.mkdirs())
//				System.out.println("LOG DIRECTORY CREATED SUCCESSFULLY");
//			else
//				System.out.println("LOG DIRECTORY CREATION UNSUCCESSFUL");
//		} catch (Exception e) {
//			System.out.println(e);
//			throw new Exception(e);
//		}
	
		return fullReportDir;
	}
}
