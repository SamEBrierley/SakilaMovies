Feature: Adding a Language entry
  Scenario: Add a language
    Given We have a language entry to add
    When We add the language entry
    Then The new language should be added to the database and we should return that the new language was saved