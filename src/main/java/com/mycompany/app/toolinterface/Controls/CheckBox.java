package com.mycompany.app.toolinterface.Controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox{
	
	private GenericControls genericcontrol;
	private WebDriver driver;

	public CheckBox(GenericControls genericcontrol) {
		// TODO Auto-generated constructor stub
		this.driver = genericcontrol.driver;
		this.genericcontrol = genericcontrol;
	}

	public void click(By element, String name){
		genericcontrol.assertElementExists(element, name);
		driver.findElement(element).click();
		genericcontrol.logTestResult("CheckBox \""+name+"\" clicked");
	}
}
