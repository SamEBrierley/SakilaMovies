Feature: Viewing all Cities
  Scenario: Viewing all Cities
    Given There are cities available
    When The cities are requested
    Then All available cities should be returned
