package com.mycompany.app.manager;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.app.toolinterface.Reporting.SeleniumReporting;
import com.mycompany.app.toolinterface.Reporting.TestListener;
import org.testng.ITestListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class MainScript {

	public static void main(String[] args) throws Exception{
		
		SeleniumReporting seleniumreporting = new SeleniumReporting();
		
		TestParams.logDirectory = seleniumreporting.createReportDirectory();
				
		XmlSuite suite = new XmlSuite();
		suite.setName("Test Suite");
		 
		XmlTest test = new XmlTest(suite);
		test.setName("Test");
		
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("com.mycompany.app.testscripts.ShoppingMate.Search"));
		test.setXmlClasses(classes) ;
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG testng = new TestNG();
		testng.setVerbose(0);
		testng.setXmlSuites(suites);
		
		testng.setUseDefaultListeners(false);
		testng.setListenerClasses(getReportingListenersList());
		System.setProperty("org.uncommons.reportng.title", "Automated Test Run");
		System.setProperty("org.uncommons.reportng.escape-output", "true");
		List<ITestListener> listeners = getTestListeners();
		for(ITestListener testListener : listeners) {
			testng.addListener(testListener);
		}
		
		testng.setOutputDirectory(TestParams.logDirectory);
		testng.run();
		
	    //FileAccess.loadBrowser("file:///" + TestParams.logDirectory + "/html/index.html");
	    
	}
	

	protected static List<ITestListener> getTestListeners() {
		List<ITestListener> listeners = new ArrayList<ITestListener>();
		// Add our extended listener
		listeners.add(new TestListener());
		return listeners;
	}

	@SuppressWarnings("rawtypes")
	protected static List<Class> getReportingListenersList() {
		List<Class> reportngListeners = new ArrayList<Class>();
		reportngListeners.add(org.uncommons.reportng.JUnitXMLReporter.class);
		reportngListeners.add(org.uncommons.reportng.HTMLReporter.class);
		return reportngListeners;
	}

}
