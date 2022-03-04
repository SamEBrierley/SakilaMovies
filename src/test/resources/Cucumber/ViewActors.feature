Feature: Viewing all Actors
    Scenario: Viewing all Films
        Given There are actors available
        When The actors are requested
        Then All available actors should be returned
