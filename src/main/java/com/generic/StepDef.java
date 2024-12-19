package com.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.excel.read.ExcelManager;
import com.util.BaseConfig;
import com.util.HandleExampleTableData;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	WebDriver driver;
	SeleniumPageFactory pf;
	SoftAssert sa;
	BaseConfig bc = new BaseConfig();
	
	@Given("open browser")
	public void open_browser() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}

	@Given("go to para bank application")
	public void go_to_para_bank_application() throws Exception {
		//driver.navigate().to(bc.getConfig("URL"));
	    driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}

	@When("put valid user name")
	public void put_valid_user_name() throws Exception {
	    pf = new SeleniumPageFactory(driver);
	    pf.getUserName().sendKeys("rabeya");
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(pf.getUserName()));
	    //pf.getUserName().sendKeys(bc.getConfig("Valid_User"));
	}

	@When("put valid password")
	public void put_valid_password() throws Exception {
		pf = new SeleniumPageFactory(driver);
	    pf.getPassword().sendKeys("rs1234");
		//pf.getPassword().sendKeys(bc.getConfig("Valid_Password"));
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
	    //driver.quit();
	}

	@When("put invalid user name")
	public void put_invalid_user_name() throws Exception {
		pf = new SeleniumPageFactory(driver);
		pf.getUserName().sendKeys("@89*56");
		//pf.getPassword().sendKeys(bc.getConfig("Invalid_User"));
	}

	@When("put invalid password")
	public void put_invalid_password() throws Exception {
		pf = new SeleniumPageFactory(driver);
		pf.getPassword().sendKeys("qklres");
		//pf.getPassword().sendKeys(bc.getConfig("Invalid_Password"));
	}

	@Then("login should fail and error msg contains An internal error has ocuured and has been logged")
	public void login_should_fail_and_error_msg_contains_An_internal_error_has_ocuured_and_has_been_logged() {
		pf = new SeleniumPageFactory(driver);
		driver.findElement(By.xpath("//*[text()='The username and password could not be verified.']"));
	    sa = new SoftAssert();
	    sa.assertTrue(pf.getErrorMsgWithinvalidCredential().isDisplayed());
	    sa.assertAll();   
	    //driver.quit();
		
		/*pf = new SeleniumPageFactory(driver);
		driver.findElement(By.xpath("//*[text()='Log Out']"));
	    sa = new SoftAssert();
	    sa.assertTrue(pf.getLogOutBtn().isDisplayed());
	    sa.assertAll();
	    driver.quit();*/
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
	    //driver.quit();
	}
	/*@When("put valid user name {string}")
	public void put_valid_user_name(String user) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    pf = new SeleniumPageFactory(driver);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(pf.getUserName()));
	    HandleExampleTableData obj = new HandleExampleTableData();
	    int row = obj.getActualRow(user);
		int col = obj.getActualCol(user);
	    ExcelManager em = new ExcelManager();
	    em.getReadExcelData(row, col);
	    pf.getUserName().sendKeys(em.getReadExcelData(row, col));
	    
	}

	@When("put valid password {string}")
	public void put_valid_password(String pass) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		pf = new SeleniumPageFactory(driver);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(pf.getPassword()));
	    HandleExampleTableData obj = new HandleExampleTableData();
	    int row = obj.getActualRow(pass);
		int col = obj.getActualCol(pass);
	    ExcelManager em = new ExcelManager();
	    em.getReadExcelData(row, col);
	    pf.getPassword().sendKeys(em.getReadExcelData(row, col));
	}*/
}
