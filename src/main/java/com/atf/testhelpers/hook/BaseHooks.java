package com.atf.testhelpers.hook;

import com.atf.testhelpers.ScenarioContext;
import com.atf.utilities.DatabaseUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;
import java.io.IOException;

public class BaseHooks {

    @Autowired
    ScenarioContext scenarioContext;

    @Autowired
    @Qualifier("localDataSource")
    private DataSource localDataSource;

    private final String cleanupScript = "scripts/cleanup.sql";

    private final String testDataScript = "scripts/testdata.sql";

    @Before(order = 1, timeout = 2 * 60 * 1000)
    public void setUp(Scenario scenario){
        //TODO set scenario
        scenarioContext.setCurrentTestEvidencePath();

    }

    @Before(order = 2, timeout = 2 * 60 * 1000)
    public void insertTestData() throws IOException {
        DatabaseUtils.executeScript(localDataSource, cleanupScript);
        DatabaseUtils.executeScript(localDataSource, testDataScript);
    }

    @After(order = 1)
    public void tearDown(){
        //TODO
    }

}
