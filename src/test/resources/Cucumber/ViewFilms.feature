Feature: Viewing all Films
  Scenario: Viewing all Films
    Given There are films available
    When The films are requested
    Then All available films should be returned