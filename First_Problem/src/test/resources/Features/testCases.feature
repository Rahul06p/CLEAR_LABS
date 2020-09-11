Feature: feature to test search functionality

  Scenario: check search funcationality
    Given user is on Home Page
    When user search for hotels
    And user enters San Francisco in search bar
    Then user sees website logo
    And user sees support in header
    And user sees login option in header
    And user closes browser
