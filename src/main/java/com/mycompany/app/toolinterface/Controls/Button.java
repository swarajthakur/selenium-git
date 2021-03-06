package com.mycompany.app.toolinterface.Controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button{
	WebDriver driver;
	GenericControls genericcontrol;
	
	public Button(GenericControls genericcontrol) {
		// TODO Auto-generated constructor stub
		this.driver = genericcontrol.driver;
		this.genericcontrol = genericcontrol;
	}

	public void click(By element, String name){
		genericcontrol.assertElementExists(element, name);
		driver.findElement(element).click();
		genericcontrol.logTestResult("Button \""+name+"\" clicked");
	}
	
	public boolean checkButtonExist(By element){
		if(genericcontrol.checkElementExists(element)){
			return true;
		}else{
			return false;
		}
		
	}
}
