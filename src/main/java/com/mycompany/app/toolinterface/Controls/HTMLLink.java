package com.mycompany.app.toolinterface.Controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HTMLLink{
	WebDriver driver;
	private GenericControls genericcontrol;
	
	public HTMLLink(GenericControls genericcontrol) {
		// TODO Auto-generated constructor stub
		this.driver = genericcontrol.driver;
		this.genericcontrol = genericcontrol;
	}

	public void click(By link, String name){
		genericcontrol.assertElementExists(link,name);
		driver.findElement(link).click();
		genericcontrol.logTestResult("Link \""+name+"\" clicked successfully");
	}

}
