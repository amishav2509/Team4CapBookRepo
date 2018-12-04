package com.cg.capbook.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	@FindBy(how=How.ID,id="email")
	private WebElement email;
	
	@FindBy(how=How.ID,id="password")
	private WebElement password;
	
	@FindBy(className="btn")
	private WebElement button;
	

public LoginPage() {
		super();
	}
public String getEmail() {
		return email.getAttribute("value");
	}
	public void setEmail(String email) {
		this.email.sendKeys(email);
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
