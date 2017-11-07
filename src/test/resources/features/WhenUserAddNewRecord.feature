# new feature
# Tags: optional
    
Feature: When User Add New Record
    
Scenario: Adding apple to the list
    Given user is on the angular page
    When user add new task 'Apple'
    Then 'Apple' should appear in the grid