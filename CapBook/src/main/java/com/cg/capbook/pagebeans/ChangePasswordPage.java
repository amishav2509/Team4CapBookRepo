package com.cg.capbook.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChangePasswordPage {

	
	@FindBy(how=How.ID,id="email")
	private WebElement oldPassword;
	
	@FindBy(how=How.ID,id="password")
	private WebElement newPassword;
	
	@FindBy(how=How.ID,id="password")
	private WebElement confirmPassword;
	
	@FindBy(className="btn")
	private WebElement button;
	
	public ChangePasswordPage() {
		super();
	}

	public String getOldPassword() {
		return oldPassword.getAttribute("value");
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword.sendKeys(oldPassword);
	}

	public String getNewPassword() {
		return newPassword.getAttribute("value");
	}

	public void setNewPassword(String newPassword) {
		this.newPassword.sendKeys(newPassword);
	}

	public String getConfirmPassword() {
		return confirmPassword.getAttribute("value");
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword.sendKeys(confirmPassword);
	}

	public void clickSignIn() {
		button.submit();
	}
	

	
}
