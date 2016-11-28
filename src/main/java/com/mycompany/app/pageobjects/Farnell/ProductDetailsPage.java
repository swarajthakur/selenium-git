package com.mycompany.app.pageobjects.Farnell;

import org.openqa.selenium.By;
import com.mycompany.app.toolinterface.Controls.GenericControls;

public class ProductDetailsPage{

	private GenericControls genericcontrol;
	
	public ProductDetailsPage(GenericPage genericpage) {
		this.genericcontrol = genericpage.genericcontrol;
		
	}

	By pdpDescription = By.id("pinfo-section");
	
	public void isProductDetails(){
		genericcontrol.assertElementExists(pdpDescription,"PDP Description");
		genericcontrol.logTestResult("Product Details page loaded successfully");
	}
}
