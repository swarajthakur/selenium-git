package com.mycompany.app.pageobjects.ShoppingMate.admin.catalog;

import org.openqa.selenium.By;
import com.mycompany.app.pageobjects.ShoppingMate.GenericPage;

public class ProductsPage{
	
	private GenericPage genericpage;
		
	By selectAll			= By.cssSelector("input[type=\"checkbox\"]");
	By importUpdatePrice 	= By.id("button-submit");
	By amazonButton			= By.xpath("//div[@id='content']/div/div/div/a[2]/i");
	By clickNext			= By.linkText(">");
	By updateStatus			= By.cssSelector("div.alert.alert-success");

	public ProductsPage(GenericPage genericpage) {
		this.genericpage = genericpage;
	}
	
	public void OpenAmazonPlugin (){
		genericpage.button.click(amazonButton,"Amazon button");
	}
	
	public void SelectAll(){
		genericpage.checkbox.click(selectAll,"Select All");
	}
	
	public void ImportUpdatePrices(){
		genericpage.button.click(importUpdatePrice,"Import/Update Price");
	}
	
	public void ClickNext(){
		genericpage.button.click(clickNext,"Next");
	}
	
	public void updatePrices(){
		OpenAmazonPlugin();
		do{
			SelectAll();
			ImportUpdatePrices();
			genericpage.label.checkLabelText(updateStatus,"Success: You have modified products!");
			ClickNext();
		}while(genericpage.button.checkButtonExist(clickNext));
	}
}


