package login;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features", format = {"pretty", "html:target/Destination/"})

public class LoginRegression {

}
