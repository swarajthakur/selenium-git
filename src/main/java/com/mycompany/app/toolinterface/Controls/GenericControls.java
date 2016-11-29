package com.mycompany.app.toolinterface.Controls;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.mycompany.app.toolinterface.Reporting.SeleniumReporting;
import org.testng.Assert;

public class GenericControls extends SeleniumReporting{

	public WebDriver driver;
	
	public GenericControls(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void assertElementExists(By element, String name){
		try{
			driver.findElement(element).getTagName();
			//logTestResult("Element "+element+" found on page");
		}catch(NoSuchElementException e){
			logTestResult("Element \""+name +"\" not found");
			Assert.fail("Element \""+name +"\" not found");
		}
	}
	
	public void assertTextExists(By element, String value){
		try{
			String text = driver.findElement(element).getText();
			if(text.contains(value)){
				logTestResult("Text \""+value +"\" found");
			}else{
				logTestResult("Text \""+value +"\" found");
				Assert.fail("Text \""+value +"\" found");
			}
			
			//logTestResult("Element "+element+" found on page");
		}catch(NoSuchElementException e){
			logTestResult("Element \""+value +"\" not found");
			Assert.fail("Element \""+value +"\" not found");
		}
	}
	
	public void assertTextExists(String value){
			if(driver.getPageSource().contains(value)){
				logTestResult("Text \""+value +"\" found");
			}else{
				logTestResult("Text \""+value +"\" not found");
				Assert.fail("Text \""+value +"\" not found");
			}
	}
	
	public boolean checkElementExists(By element){
		try{
			driver.findElement(element).getTagName();
			return true;
		}catch(NoSuchElementException e){
			return false;
		}
	}
	
//	public void assertText(By element){
//		Assert.assertEquals(driver.findElement(element).getText(),"compose button","Login was unsuccessful");
//	}
}
