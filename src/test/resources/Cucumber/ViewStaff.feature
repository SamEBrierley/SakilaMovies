Feature: Viewing all Staff members
  Scenario: Viewing all Staff members
    Given There are staff members available
    When The staff members are requested
    Then All available staff members should be returned
