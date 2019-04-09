Feature: Database test design


  Scenario: Update an item in Sales table
    Given create new order in database
    When order inserted exists in database
    Then update the order with following details
    And validate that changes were applied

  @Run
  Scenario Outline: Update all orders were quantity more than <orderQuantity>
    Given get orders were quantity exceed <orderQuantity>
    Examples:
      | orderQuantity |
      | 3             |
