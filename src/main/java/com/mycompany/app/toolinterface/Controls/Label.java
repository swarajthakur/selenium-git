package com.mycompany.app.toolinterface.Controls;

import org.openqa.selenium.By;

public class Label{
	private GenericControls genericcontrol;
	
	public Label(GenericControls genericcontrol) {
		// TODO Auto-generated constructor stub
		this.genericcontrol = genericcontrol;
	}

	public void checkLabelText(By element, String value){
		genericcontrol.assertTextExists(element, value);
	}
	
	public boolean checkLabelExist(By element){
		if(genericcontrol.checkElementExists(element)){
			return true;
		}else{
			return false;
		}
		
	}
}
