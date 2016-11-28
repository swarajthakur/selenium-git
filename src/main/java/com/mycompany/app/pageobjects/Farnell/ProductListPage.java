package com.mycompany.app.pageobjects.Farnell;

import org.openqa.selenium.By;
import com.mycompany.app.pageobjects.Farnell.GenericPage;


public class ProductListPage {

	private GenericPage genericpage;
	
	public ProductListPage(GenericPage genericpage) {
		this.genericpage = genericpage;
	}
	
	By pdpLink = By.xpath("//*[@id=\"product-list\"]/li[1]/div/div[1]/div[1]/div[2]/h2/a/span[2]");
	
	public void pdpPage(){
		genericpage.htmllink.click(pdpLink,"PDP Lister");
	}
	
}
