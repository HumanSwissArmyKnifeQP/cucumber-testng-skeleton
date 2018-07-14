@browser
Feature: Navigation
  This is the description for navigating to Google Search page

  Scenario: Verify I can go to Google Search page
    Given I am on the Google Search page
    And I search for cheese
    Then we pass

  Scenario: Verify I can go to Google Search page
    Given I am on the Google Search page
    And I search for pizza
    Then we pass