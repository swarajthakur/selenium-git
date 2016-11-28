package com.mycompany.app.pageobjects.Farnell;

import org.openqa.selenium.By;
import com.mycompany.app.pageobjects.Farnell.GenericPage;


public class SubCategoryPage {
	private GenericPage genericpage;
	
	public SubCategoryPage(GenericPage genericpage) {
		this.genericpage = genericpage;
	}
	
	By showAllProducts = By.className("show-all-results");
		
	public void ShowAllProducts(){
		genericpage.button.click(showAllProducts,"Show All Products");
	}
}