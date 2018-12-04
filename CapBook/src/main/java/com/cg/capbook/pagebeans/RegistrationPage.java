package com.cg.capbook.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {
	
	@FindBy(how=How.ID,id="email")
	private WebElement email;
	
	@FindBy(how=How.ID,id="email")
	private WebElement firstName;
	
	@FindBy(how=How.ID,id="email")
	private WebElement lastName;
	
	@FindBy(how=How.ID,id="email")
	private WebElement gender;
	
	@FindBy(how=How.ID,id="email")
	private WebElement dob;
	
	@FindBy(how=How.ID,id="password")
	private WebElement password;
	
	@FindBy(className="btn")
	private WebElement button;
	

	public RegistrationPage() {
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
public String getFirstName() {
	return firstName.getAttribute("value");
}

public void setFirstName(String firstName) {
	this.firstName.sendKeys(firstName);
}

public String getLastName() {
	return lastName.getAttribute("value");
}

public void setLastName(String lastName) {
	this.lastName.sendKeys(lastName);
}

public String getGender() {
	return gender.getAttribute("value");
}

public void setGender(String gender) {
	this.gender.sendKeys(gender);
}

public String getDob() {
	return dob.getAttribute("value");
}

public void setDob(String dob) {
	this.dob.sendKeys(dob);
}

	public void clickSignIn() {
		button.submit();
	}
	

}