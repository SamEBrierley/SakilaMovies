Feature: Adding an Actor entry
  Scenario: Add a new Actor
    Given We have a new Actor to add
    When We add the new Actor
    Then The new Actor should be added and a saved conformation returned