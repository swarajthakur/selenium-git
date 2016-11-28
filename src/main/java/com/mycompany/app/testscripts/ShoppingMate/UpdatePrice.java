package com.mycompany.app.testscripts.ShoppingMate;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import com.mycompany.app.manager.TestParams;
import com.mycompany.app.pageobjects.ShoppingMate.GenericPage;
import com.mycompany.app.pageobjects.ShoppingMate.AdminHomePage;
import com.mycompany.app.pageobjects.ShoppingMate.AdminLoginPage;
import com.mycompany.app.pageobjects.ShoppingMate.admin.catalog.ProductsPage;

public class UpdatePrice {
	WebDriver driver;
	File profileDir;
	FirefoxProfile profile;
	GenericPage genericpage;
	AdminHomePage adminhomepage;
	AdminLoginPage adminloginpage;
	ProductsPage productspage;
	
  @BeforeClass
  public void beforeClass() {
	  profile = new FirefoxProfile();
	  //profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53");
	  driver = new FirefoxDriver(profile);
	  driver.manage().timeouts().implicitlyWait(TestParams.Timeout, TimeUnit.SECONDS);
	  
	  genericpage 		= new GenericPage (driver);
	  adminloginpage   	= new AdminLoginPage(genericpage);
	  adminhomepage		= new AdminHomePage(genericpage);
	  productspage 		= new ProductsPage(genericpage);	  
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @Test()
  public void openSomething() throws Exception{
	
	  genericpage.getURL(TestParams.adminUrl);
	  
	  adminloginpage.Login();
           
	  adminhomepage.openProductsPage();
	  
	  productspage.updatePrices();
	  
  }
}
