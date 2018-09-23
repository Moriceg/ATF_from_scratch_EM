package login;

import cucumber.api.java.After;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageobjects.LoginPageObject;
import utilities.Constants;

public class LoginTest extends BaseTest {

    public LoginPageObject loginPage;
    public LoginTest()
    {
        loginPage = new LoginPageObject();
        initialize();
    }

    @After
    public void tearDown()
    {
        if(driver != null)
            driver.quit();
    }

    @Given("^I am on Tracks login page$")
    public void navigateToApp()
    {
        driver.navigate().to(Constants.SYSTEM_UNDERTEST);
    }

    @When("^I enter username as \"(.*)\"$")
    public void setUsername(String username)
    {
        WebElement element = uiMap.getElement(loginPage.Username);
        uiMap.inputData(element, username);
    }

    @When("^I enter password as \"(.*)\"$")
    public void setPassword(String password)
    {
        WebElement element = uiMap.getElement(loginPage.Password);
        uiMap.inputData(element, password);
    }

    @When("^I click Login button$")
    public void clickLogin()
    {
        WebElement element = uiMap.getElement(loginPage.SignIn);
        uiMap.click(element);
    }

    @Then("^Login should be successful")
    public void successfulLogin() throws InterruptedException {
        Assert.assertEquals("User is not on Home Page!", "http://35.205.178.227:3000/", driver.getCurrentUrl());
    }

    @But("^Login should fail")
    public void loginFail()
    {
        Assert.assertEquals("User is logged in!", "http://35.205.178.227:3000/login", driver.getCurrentUrl());
    }

    @But("^Relogin option should be available")
    public void checkAlertMessage()
    {
        WebElement element = uiMap.getElement(loginPage.AlertMessage);
        Assert.assertEquals("Alert message is not displayed!", "Login unsuccessful.", element.getText());
    }

}
