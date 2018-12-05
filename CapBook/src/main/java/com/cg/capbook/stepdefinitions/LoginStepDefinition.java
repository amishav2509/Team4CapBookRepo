package com.cg.capbook.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.capbook.pagebeans.LoginPage;
import com.cg.capbook.pagebeans.RegistrationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {

	
	private WebDriver driver;
	private LoginPage loginPage;
	
	@Given("^User is in capbook login page$")
	public void user_is_in_capbook_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("To be given");
		loginPage=PageFactory.initElements(driver,LoginPage.class);
	}

	@When("^User enters correct emailId and User enters correct  password$")
	public void user_enters_correct_emailId_and_User_enters_correct_password() throws Throwable {
		loginPage.setEmailID("abc@gmail.com");
		loginPage.setPassword("abcd123");
		loginPage.clickSignIn();
	}

	@Then("^user should be able to login in capbook acount$")
	public void user_should_be_able_to_login_in_capbook_acount() throws Throwable {
		String actualTitle=driver.getTitle();
	    String expectedTitle="To be given";
	  Assert.assertEquals(expectedTitle,actualTitle);
	    driver.close();
	}

	@When("^User enters incorrect emailId or password$")
	public void user_enters_incorrect_emailId_or_password() throws Throwable {
		loginPage.setEmailID("abcgmail.com");
		loginPage.setPassword("abcd123");
		loginPage.clickSignIn();
	}

	@Then("^user should be asked to login again$")
	public void user_should_be_asked_to_login_again() throws Throwable {
		String actualTitle=driver.getTitle();
	    String expectedTitle="To be given";
	  Assert.assertEquals(expectedTitle,actualTitle);
	    driver.close();
	}


}
