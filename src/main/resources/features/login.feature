@UI
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
   Scenario Outline:
      When I enter username as "<username>"
      And I enter password as "<password>"
      When I click Login button
      Then Login should fail
      But Relogin option should be available

      Examples:
         | username | password |
         | TOM      | Jerry    |
         |          | pass1    |
         | test     | test     |

