package com.cg.capbook.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	@FindBy(how=How.ID,id="emailID")
	private WebElement emailID;
	
	@FindBy(how=How.ID,id="password")
	private WebElement password;
	
	@FindBy(className="btn")
	private WebElement button;
	

public LoginPage() {
		super();
	}
public String getEmailID() {
		return emailID.getAttribute("value");
	}

	public void setEmailID(String emailID) {
		this.emailID.sendKeys(emailID);
	}



public String getPassword() {
		return password.getAttribute("value");
	}
public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickSignIn() {
		button.submit();
	}
	

}
