# new feature
# Tags: optional
    
Feature: When User Add New Record
    
Scenario: Adding apple to the list
    Given user is on the angular page
    When user add new task "Apple"
    Then "Apple" should appear in the list
    And remove "Apple"


Scenario: Adding multiple records to the list
    Given user is on the angular page
    When user adds new task
    |Apple|Grape|Peach|
    Then tasks should appear in the list
    |Apple|Grape|Peach|


