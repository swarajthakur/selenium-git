package com.mycompany.app.pageobjects.ShoppingMate;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.openqa.selenium.By;
import com.mycompany.app.toolinterface.Utility.TOTP;

public class AdminLoginPage{

	GenericPage genericpage;
	
	public AdminLoginPage(GenericPage genericpage) {
		this.genericpage = genericpage;
	}

	By username 	= By.id("input-username");
	By password 	= By.id("input-password");
	By otp 			= By.name("otp");
	By loginButton 	= By.linkText("Login");
	
	public void Login(){
		genericpage.editbox.sendKeys(username, "", "User Name");
		genericpage.editbox.sendKeys(password, "", "Password");
		genericpage.editbox.sendKeys(otp, getTOTPCode(""), "OTP");
		genericpage.editbox.submit(otp,"Login");
	}
	
	public static String getTOTPCode(String secretKey) {
	    String normalizedBase32Key = secretKey.replace(" ", "").toUpperCase();
	    Base32 base32 = new Base32();
	    byte[] bytes = base32.decode(normalizedBase32Key);
	    String hexKey = Hex.encodeHexString(bytes);
	    long time = (System.currentTimeMillis() / 1000) / 30;
	    String hexTime = Long.toHexString(time);
	    return TOTP.generateTOTP(hexKey, hexTime, "6");
	}
	
}


