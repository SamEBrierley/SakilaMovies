Feature: Receive Actor by ID
  Scenario: Get Actor by ID
    Given There are actors available to select from
    When The user requests a specific actor by ID
    Then The specified actor will be returned