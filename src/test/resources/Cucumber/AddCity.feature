Feature: Adding a new City
  Scenario: Add a City
    Given We have a new City to add
    When We add the new city
    Then The new city should be added and a saved conformation returned