package com.atf;

import com.atf.factory.DriverFactory;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import com.atf.pageobjects.LoginPageObject;
import com.atf.uimap.UiMap;
import com.atf.utilities.Constants;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes =  {com.atf.AppConfig.class})
public class LoginTest {

    private UiMap uiMap;
    private WebDriver driver;
    @Autowired
    public Constants constants;
    @Autowired
    public DriverFactory driverFactory;
    @Autowired
    public LoginPageObject loginPageObject;

    @Before
    public void setUp(){
        driverFactory.driverInitialize();
        driver = driverFactory.getDriver();
        uiMap = new UiMap(driver);
    }

    @After
    public void tearDown(){
        if(driver != null)
            driver.quit();
    }

    @Given("^I am on Tracks login page$")
    public void navigateToApp()
    {
        driver.navigate().to(constants.SYSTEM_UNDERTEST);
    }

    @When("^I enter username as \"(.*)\"$")
    public void setUsername(String username)
    {
        WebElement element = uiMap.getElement(loginPageObject.Username);
        uiMap.inputData(element, username);
    }

    @When("^I enter password as \"(.*)\"$")
    public void setPassword(String password)
    {
        WebElement element = uiMap.getElement(loginPageObject.Password);
        uiMap.inputData(element, password);
    }

    @When("^I click Login button$")
    public void clickLogin()
    {
        WebElement element = uiMap.getElement(loginPageObject.SignIn);
        uiMap.click(element);
    }

    @Then("^Login should be successful")
    public void successfulLogin() {
        Assert.assertEquals("User is not on Home Page!", "http://35.205.178.227:3000/", driver.getCurrentUrl());
    }

    @But("^Login should fail")
    public void loginFail()
    {
        Assert.assertEquals("User is logged in!", "http://35.205.178.227:3000/login", driver.getCurrentUrl());
    }

    @But("^Relogin option should be available")
    public void checkAlertMessage() {
        WebElement element = uiMap.getElement(loginPageObject.AlertMessage);
        Assert.assertEquals("Alert message is not displayed!", "Login unsuccessful.", element.getText());
    }
}
