package com.atf.stepdefinitions;

import com.atf.jdbc.model.Sales;
import com.atf.jdbc.service.GenericService;
import com.atf.jdbc.service.ServiceImpl;
import com.atf.testhelpers.ScenarioContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class DatabaseStepDef {

    @Autowired
    private ScenarioContext context;

    @Autowired
    private ServiceImpl serviceImpl;


    @Given("^create new order in database$")
    public void addNewOrder() {

    }

    @When("^order inserted exists in database$")
    public void validateOrderExists() {

    }

    @Then("^update the order with following details$")
    public void updateOrder() {

    }

    @Then("^validate that changes were applied$")
    public void validateOrderFromDatabase() {

    }

    @When("^get orders were quantity exceed (.+)$")
    public void selectOrdersByQuantityNumber(Integer quantity) {
        List<Sales> oe = serviceImpl.getSalesByQuantity(quantity);
        oe.forEach(sale -> System.out.println(sale.getOrderQty()));
    }
}
