Feature: Viewing all countries
  Scenario: Viewing all countries
    Given There are countries available
    When The counties are requested
    Then All available countries should be returned
