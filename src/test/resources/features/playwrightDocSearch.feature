@test1
Feature: Playwright topic validation

  Scenario: Searching for topic in playwright portal
    Given open the site "https://playwright.dev/"
    When In dropdown select "Java"
    Then Click on Search link and enter any topic "Locators" in the search box.
    And Validate the topic