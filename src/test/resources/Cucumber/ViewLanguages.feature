Feature: Adding a new Language
Scenario: Get Languages
  Given There are languages available
  When The languages are requested
  Then All available languages should be returned
