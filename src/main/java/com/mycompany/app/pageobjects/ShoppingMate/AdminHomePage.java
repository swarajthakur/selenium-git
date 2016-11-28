package com.mycompany.app.pageobjects.ShoppingMate;

import org.openqa.selenium.By;

public class AdminHomePage{
	private GenericPage genericpage;
	
	By products	= By.linkText("Products");
	By catalog	= By.linkText("Catalog");
	By drawer	= By.xpath("//a[@id='button-menu']/i");
	
	
	public AdminHomePage(GenericPage genericpage) {
		this.genericpage = genericpage;
	}
	
	public void openProductsPage(){
		genericpage.button.click(drawer,"Drawer");
		genericpage.htmllink.click(catalog,"Catalog");
		genericpage.htmllink.click(products,"Products");
		
	}
}


