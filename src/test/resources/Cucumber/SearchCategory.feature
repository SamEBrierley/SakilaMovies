Feature: Receive Category by ID
  Scenario: Get Category by ID
    Given There are categories available to select from
    When The user requests a specific category by ID
    Then The specified category will be returned