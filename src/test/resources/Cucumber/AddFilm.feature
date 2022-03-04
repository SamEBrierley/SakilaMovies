Feature: Add a new film
  Scenario: Add a Film
  Given We have a new Film to add
  When We add the new Film
  Then The new Film should be added and a saved conformation returned