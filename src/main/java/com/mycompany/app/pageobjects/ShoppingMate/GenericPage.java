package com.mycompany.app.pageobjects.ShoppingMate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mycompany.app.toolinterface.Controls.Button;
import com.mycompany.app.toolinterface.Controls.CheckBox;
import com.mycompany.app.toolinterface.Controls.EditBox;
import com.mycompany.app.toolinterface.Controls.GenericControls;
import com.mycompany.app.toolinterface.Controls.HTMLLink;
import com.mycompany.app.toolinterface.Controls.Label;
import com.mycompany.app.toolinterface.Reporting.SeleniumReporting;

public class GenericPage extends SeleniumReporting{
	public WebDriver driver;
	public EditBox editbox;
	public Button button;
	protected GenericControls genericcontrol;
	public HTMLLink htmllink;
	public CheckBox checkbox;
	public Label label;
	
	By searchbox = By.name("search");
	By searchbutton = By.cssSelector("div.button-search > button[type=\"button\"]");
	
	public GenericPage(WebDriver webdriver) {
		// TODO Auto-generated constructor stub
		this.driver = webdriver; 
		this.genericcontrol = new GenericControls(driver);
		this.button = new Button(this.genericcontrol);
		this.editbox = new EditBox(this.genericcontrol);
		this.htmllink = new HTMLLink(this.genericcontrol);
		this.checkbox = new CheckBox(this.genericcontrol);
		this.label = new Label(this.genericcontrol);
	}

	public void getURL(String url){
		driver.get(url);
		logTestResult("URL "+url+" loaded successfully");
	}
	
	public void Search(String searchTerm){
		editbox.sendKeys(searchbox,searchTerm, "Search");
		button.click(searchbutton, "Search");
		genericcontrol.assertTextExists("Products meeting the search criteria");
	}
}
