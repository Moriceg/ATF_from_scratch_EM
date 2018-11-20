package com.atf;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features", format = {"pretty", "html:target/Destination/"})
public class LoginRegression {

}
