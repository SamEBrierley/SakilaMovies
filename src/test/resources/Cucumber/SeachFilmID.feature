Feature: Receive Film by ID
Scenario: Get Film by ID
  Given There are films available to select from
  When The user requests a specific film
  Then The specified film will be returned
