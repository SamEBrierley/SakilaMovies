Feature: Deleting a Film
  Scenario: Delete a film
    Given There are film to select from
    When A film is selected for deletion
    Then The film should be deleted