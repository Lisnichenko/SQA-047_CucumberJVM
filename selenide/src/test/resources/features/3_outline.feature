Feature: When User Add New Record
  As a user I want to add taske to TODO list
  In order to not forget anything

  Scenario Outline:  Adding apple to the list
    Given user is on the angular page
    When user add new task "<Task>"
    Then "<Task>" should appear in the list
    And remove "<Task>"

  Examples:
  |Task|
  |Apple|
  |Grape|
  |Peach|
