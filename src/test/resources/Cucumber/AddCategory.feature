Feature: Adding a new Category
  Scenario: Add a Category
    Given We have a new Category to add
    When We add the new Category
    Then The new Category should be added and a saved conformation returned