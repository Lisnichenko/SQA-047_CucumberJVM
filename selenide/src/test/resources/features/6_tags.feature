@priority1
Feature: When User Add New Record
  As a user I want to add task to TODO list
  In order to not forget anything

  @sanity
  Scenario: Adding task to the list
    Given user is on the angular page
    When user adds new task "Apple"
    Then "Apple" should appear in the list
    And remove "Apple"

  @sanity @regression
  Scenario: Adding multiple records to the list
    Given user is on the angular page
    When user adds new task
      | Apple | Grape | Peach |
    Then following task table should appear in the list
      | Apple | Grape | Tomato |

#   add line below to vm options to trigger tag
#  -Dcucumber.options="--tags @regression"