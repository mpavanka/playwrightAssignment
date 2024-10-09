@test1
Feature: Search for the language details in playwright portal

  Scenario: search for language
  Given open the site "https://playwright.dev/"
  When In dropdown select "Java"
  Then Click on Search link and enter any topic "Locators" in the search box.
  And Validate the topic