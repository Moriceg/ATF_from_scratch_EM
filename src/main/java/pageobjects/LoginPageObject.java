package pageobjects;

import org.springframework.stereotype.Component;

@Component("loginPageObject")
public class LoginPageObject {

    public String Username = ".//*[@id='user_login']";
    public String Password = ".//*[@id='user_password']";
    public String SignIn = ".//*[@value='Sign in']";
    public String AlertMessage = ".//*[@class='alert warning']";

}
