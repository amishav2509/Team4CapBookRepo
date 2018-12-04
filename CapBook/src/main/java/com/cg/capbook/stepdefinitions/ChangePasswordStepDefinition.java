package com.cg.capbook.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.capbook.pagebeans.ChangePasswordPage;
import com.cg.capbook.pagebeans.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChangePasswordStepDefinition {
	
	private WebDriver driver;
	private ChangePasswordPage changePasswordPage;
	
	@Given("^User is in capbook change password page$")
	public void user_is_in_capbook_change_password_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("To be given");
		changePasswordPage=PageFactory.initElements(driver,ChangePasswordPage.class);
	}

	@When("^User enters valid crdentials$")
	public void user_enters_valid_crdentials() throws Throwable {
		changePasswordPage.setOldPassword("1234");
		changePasswordPage.setNewPassword("1235");
		changePasswordPage.setConfirmPassword("1235");
		changePasswordPage.clickSignIn();
	}

	@Then("^user should be able to change password$")
	public void user_should_be_able_to_change_password() throws Throwable {
		String actualTitle=driver.getTitle();
	    String expectedTitle="To be given";
	  Assert.assertEquals(expectedTitle,actualTitle);
	    driver.close();
	}

	@When("^User enters invalid crdentials$")
	public void user_enters_invalid_crdentials() throws Throwable {
		changePasswordPage.setOldPassword("1234");
		changePasswordPage.setNewPassword("1235");
		changePasswordPage.setConfirmPassword("1236");
		changePasswordPage.clickSignIn();
	}

	@Then("^user should be asked to try again$")
	public void user_should_be_asked_to_try_again() throws Throwable {
		String actualTitle=driver.getTitle();
	    String expectedTitle="To be given";
	  Assert.assertEquals(expectedTitle,actualTitle);
	    driver.close();
	}



}
