Feature: Deleting a member of Staff
  Scenario: Delete a member of Staff
    Given There are staff members to select from
    When A staff member is selected for deletion
    Then The staff member should be deleted