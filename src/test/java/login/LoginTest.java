package login;

import cucumber.api.java.After;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import factory.DriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import pageobjects.LoginPageObject;
import uimap.UiMap;
import utilities.Constants;

import javax.annotation.PostConstruct;

@Component
public class LoginTest{

    public UiMap uiMap;
    public Constants constants;
    public WebDriver driver;
    public DriverFactory driverFactory;
    private LoginPageObject loginPageObject;

    public LoginTest(){}

    @Autowired
    public LoginTest(LoginPageObject loginPageObject, UiMap uiMap, DriverFactory driverFactory, Constants constants)
    {
        this.loginPageObject = loginPageObject;
        this.uiMap = uiMap;
        this.driverFactory = driverFactory;
        this.constants = constants;
    }

    @Before
    public void setUp(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
        driverFactory = (DriverFactory) context.getBean("driverFactory");
    }

    @After
    public void tearDown(){
        if(driver != null)
            driver.quit();
    }

    @Given("^I am on Tracks login page$")
    public void navigateToApp()
    {
        driver = driverFactory.getDriver();
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
