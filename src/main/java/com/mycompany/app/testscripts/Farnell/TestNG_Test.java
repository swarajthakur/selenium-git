package com.mycompany.app.testscripts.Farnell;

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
import com.mycompany.app.pageobjects.Farnell.GenericPage;
import com.mycompany.app.pageobjects.Farnell.HomePage;
import com.mycompany.app.pageobjects.Farnell.ProductDetailsPage;
import com.mycompany.app.pageobjects.Farnell.ProductListPage;
import com.mycompany.app.pageobjects.Farnell.SubCategoryPage;

public class TestNG_Test {
	WebDriver driver;
	File profileDir;
	FirefoxProfile profile;
	GenericPage genericpage;
	HomePage homepage;
	SubCategoryPage subcategorypage;
	ProductListPage productlistpage;
	ProductDetailsPage pdppage;
	
  @BeforeClass
  public void beforeClass() {
	  //profileDir = new File("C:\\Users\\Swaraj\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\ste21ssj.Selenium");
	  //profile = new FirefoxProfile(profileDir);
	  profile = new FirefoxProfile();
	  profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53");
	  driver = new FirefoxDriver(profile);
	  driver.manage().timeouts().implicitlyWait(TestParams.Timeout, TimeUnit.SECONDS);
	  
	  genericpage		= new GenericPage (driver);
	  subcategorypage   = new SubCategoryPage(genericpage);
	  productlistpage	= new ProductListPage(genericpage);
	  pdppage 			= new ProductDetailsPage(genericpage);	  
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
	
	  genericpage.getURL(TestParams.nwpUSAUrl);
           
      genericpage.Search("fuse");
      
      subcategorypage.ShowAllProducts();
      
      productlistpage.pdpPage();
      
      pdppage.isProductDetails();
      
  }
}
