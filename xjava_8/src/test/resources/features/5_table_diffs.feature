Feature: When User Add New Record
  As a user I want to add task to TODO list
  In order to not forget anything

  Scenario: Adding multiple records to the list
    Given user is on the angular page
    When user adds new task
      | Apple | Grape | Peach |
    Then following task table should appear in the list
      | Apple | Grape | Tomato |