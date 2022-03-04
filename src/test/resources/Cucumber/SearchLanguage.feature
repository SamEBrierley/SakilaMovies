Feature: Is it Spanish?
  As a consumer
  I Want to check if a movie is in spanish
  So that I can follow the movie.
  Scenario: Language is not Spanish
    Given I have selected a film
    When Film is not in "Spanish"
    Then I would like to see all available languages





