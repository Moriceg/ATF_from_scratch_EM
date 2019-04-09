package com.atf;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features", format = {"pretty", "html:target/Destination/"}, tags = "@Run")
public class GeneralCucumberRunner {

}
