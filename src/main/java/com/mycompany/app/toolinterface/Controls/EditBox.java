package com.mycompany.app.toolinterface.Controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditBox{
	WebDriver driver;
	GenericControls genericcontrol;
	
	public EditBox(GenericControls genericcontrol) {
		// TODO Auto-generated constructor stub
		this.driver = genericcontrol.driver;
		this.genericcontrol = genericcontrol;
	}

	public void sendKeys(By element, String text, String name){
		genericcontrol.assertElementExists(element, name);
		driver.findElement(element).sendKeys(text);
		genericcontrol.logTestResult("\""+text+"\""+" entered in \"" +name+"\" box");
	}
	
	public void submit(By element, String name){
		genericcontrol.assertElementExists(element, name);
		driver.findElement(element).submit();
		genericcontrol.logTestResult("Form \""+name+"\" sumbmitted successfully!");
	}
}
