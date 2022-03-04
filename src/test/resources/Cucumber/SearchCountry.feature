Feature: Receive Country by ID
  Scenario: Get Country by ID
    Given There are countries available to select from
    When The user requests a specific country by ID
    Then The specified country will be returned