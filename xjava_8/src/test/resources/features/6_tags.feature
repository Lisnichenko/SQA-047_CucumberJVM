@web
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

#  add  required tag to cucummber options
#  Tags = { "~@wip","~@notImplemented","@sanity" },
#    or
#  If we want to run the Scenarios which are Tagged sanity and regression both
#   mvn test -Dcucumber.options="--tags @sanity --tags @regression"

#  If we want to run, the Scenarios which are Tagged either sanity or regression
#  mvn test -Dcucumber.options="--tags @regression,@sanity"

#  The ~ special character in front of any Tag tells Cucumber to ignore all the Scenarios associated with that Tag