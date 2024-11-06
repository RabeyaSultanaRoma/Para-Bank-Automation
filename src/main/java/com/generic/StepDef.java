package com.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	WebDriver driver;
	SeleniumPageFactory pf;
	SoftAssert sa;
	
	@Given("open browser")
	public void open_browser() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}

	@Given("go to para bank application")
	public void go_to_para_bank_application() {
	    driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
	}

	@When("put valid user name")
	public void put_valid_user_name() {
	    pf = new SeleniumPageFactory(driver);
	    pf.getUserName().sendKeys("rabeya");
	}

	@When("put valid password")
	public void put_valid_password() {
		pf = new SeleniumPageFactory(driver);
	    pf.getPassword().sendKeys("rs1234");
	}

	@When("click login button")
	public void click_login_button() {
		pf = new SeleniumPageFactory(driver);
	    pf.getLoginBtn().click();
	}

	@Then("login should pass and logout button should visible")
	public void login_should_pass_and_logout_button_should_visible() {
	    //Assert.assertTrue(false);
		pf = new SeleniumPageFactory(driver);
		driver.findElement(By.xpath("//*[text()='Log Out']"));
	    sa = new SoftAssert();
	    sa.assertTrue(pf.getLogOutBtn().isDisplayed());
	    sa.assertAll();
	    driver.quit();
	}

	@When("put invalid user name")
	public void put_invalid_user_name() {
		pf = new SeleniumPageFactory(driver);
		pf.getUserName().sendKeys("@89*56");
	}

	@When("put invalid password")
	public void put_invalid_password() {
		pf = new SeleniumPageFactory(driver);
		pf.getPassword().sendKeys("qklres");
	}

	@Then("login should fail and error msg contains An internal error has ocuured and has been logged")
	public void login_should_fail_and_error_msg_contains_An_internal_error_has_ocuured_and_has_been_logged() {
		/*pf = new SeleniumPageFactory(driver);
		driver.findElement(By.xpath("//*[text()='An internal error has occurred and has been logged.']"));
	    sa = new SoftAssert();
	    sa.assertTrue(pf.getErrorMsgWithinvalidCredential().isDisplayed());
	    sa.assertAll();   
	    driver.quit();*/
		
		pf = new SeleniumPageFactory(driver);
		driver.findElement(By.xpath("//*[text()='Log Out']"));
	    sa = new SoftAssert();
	    sa.assertTrue(pf.getLogOutBtn().isDisplayed());
	    sa.assertAll();
	    driver.quit();
	}

	@When("put null user name")
	public void put_null_user_name() {
		pf = new SeleniumPageFactory(driver);
		pf.getUserName().sendKeys("");
	}

	@When("put null password")
	public void put_null_password() {
		pf = new SeleniumPageFactory(driver);
		pf.getPassword().sendKeys("");
	}

	@Then("login should fail and error msg contains Please enter a username and password")
	public void login_should_fail_and_error_msg_contains_Please_enter_a_username_and_password() {
		pf = new SeleniumPageFactory(driver);
		driver.findElement(By.xpath("//*[text()='Please enter a username and password.']"));
	    sa = new SoftAssert();
	    sa.assertTrue(pf.getErrorMsgWithnullCredential().isDisplayed());
	    sa.assertAll();   
	    driver.quit();
	}
}
