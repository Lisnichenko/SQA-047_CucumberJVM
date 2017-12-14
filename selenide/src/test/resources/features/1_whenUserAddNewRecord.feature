Feature: When User Add New Record

  Scenario: Adding apple to the list
    Given user is on the angular page
    When user adds new task "Apple"
    Then "Apple" should appear in the list
    And remove "Apple"

  Scenario: User adds an apple
    Given user is on the angular page
    When user adds tasks
      |Apple|64|
      |Grape|34|
    Then tasks from table appears in the list
      |Apple|64|
      |Grape|34|

  Scenario: Adding multiple records to the list
    Given user is on the angular page
    When user adds new list of tasks "Apple,Grape"
    Then tasks should appear in the list
      | Apple | Grape | Peach |


