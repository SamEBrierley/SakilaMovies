Feature: Adding a new Country
  Scenario: Add a Country
    Given We have a new Country to add
    When We add the new Country
    Then The new Country should be added and a saved conformation returned