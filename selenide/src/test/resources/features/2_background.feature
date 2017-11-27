
Feature: When User Add New Record
    As a user I want to add taske to TODO list
    In order to not forget anything

  # Background is run before each Scenario, but after the BeforeScenario Hooks
  Background: loading the page
    Given user is on the angular page

  Scenario: Adding apple to the list
    When user add new task "Apple"
    Then "Apple" should appear in the list
    And remove "Apple"

  Scenario: Adding multiple records to the list
    When user adds new task
      |Apple|Grape|Peach|
    Then tasks should appear in the list
      |Apple|Grape|Peach|
