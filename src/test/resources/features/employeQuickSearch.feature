@test
Feature: Search for the employee details in talent portal

  Scenario: search for the employee
    Given login to talent portal
    Then Click on Global links
    And Click on Corporate Directory
    Then In Quick Search, enter any name and click on Search button
    And Capture Mail Id and Phone number from the results and print the same.
    And Close browser window