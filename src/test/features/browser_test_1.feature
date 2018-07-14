@browser
Feature: Navigation 2
  This is the description for navigating to Google Search page

  Scenario: Verify I can go to Google Search page
    Given I am on the Google Search page
    And I search for BitCoin
    Then we pass