Feature: login
#This is how background can be used to eliminate duplicate steps

Background:
#User navigates to Tracks
   Given I am on Tracks login page

#Scenario positive login
Scenario:
   When I enter username as "Eugeniu"
   And I enter password as "eugeniu"
   When I click Login button
   Then Login should be successful

#Scenario negative login
   Scenario:
      When I enter username as "TOM"
      And I enter password as "Jerry"
      When I click Login button
      Then Login should fail
      But Relogin option should be available

