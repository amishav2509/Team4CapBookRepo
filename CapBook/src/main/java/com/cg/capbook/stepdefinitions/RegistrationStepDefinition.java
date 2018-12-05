package com.cg.capbook.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.capbook.pagebeans.RegistrationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class RegistrationStepDefinition {
	
	private WebDriver driver;
	private RegistrationPage registrationPage;


	@Given("^User is on CapBook Registration Page$")
	public void user_is_on_CapBook_Registration_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("To be given");
		registrationPage=PageFactory.initElements(driver,RegistrationPage.class);
	}

	@When("^User submits valid details$")
	public void user_submits_valid_details() throws Throwable {
		registrationPage.setEmailID("abc@gmail.com");
		registrationPage.setPassword("abcd123");
		registrationPage.setFirstName("Aparajita");
		registrationPage.setLastName("Singh");
		registrationPage.setGender("Female");
		registrationPage.setDob("23-09-1995");
		registrationPage.clickSignIn();
	}

	@Then("^Register the user$")
	public void register_the_user() throws Throwable {
		String actualTitle=driver.getTitle();
	    String expectedTitle="To be given";
	  Assert.assertEquals(expectedTitle,actualTitle);
	    driver.close();
	}

	@When("^User submits invalid details$")
	public void user_submits_invalid_details() throws Throwable {
		registrationPage.setEmailID("abcgmail.com");
		registrationPage.setPassword("abcd123");
		registrationPage.setFirstName("Aparajita");
		registrationPage.setLastName("Singh");
		registrationPage.setGender("Female");
		registrationPage.setDob("23-09-1995");
		registrationPage.clickSignIn();
	}

	@Then("^Ask to fill correct details$")
	public void ask_to_fill_correct_details() throws Throwable {
		String actualTitle=driver.getTitle();
	    String expectedTitle="To be given";
	  Assert.assertEquals(expectedTitle,actualTitle);
	    driver.close();
	}
}
